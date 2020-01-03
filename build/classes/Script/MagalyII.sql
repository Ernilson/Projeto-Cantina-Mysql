
create database bronse;

use bronse;

CREATE TABLE `clientes` (
  `id_c` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `ender` varchar(200) NOT NULL,
  `fone` varchar(200) NOT NULL,  
  `estatus` varchar(200) NOT NULL,
   primary key (id_c)
) ENGINE=InnoDB DEFAULT CHARSET= utf8;


create table acesso(
id_Ac int auto_increment primary key,
login varchar(60) not null,
senha varchar(60) not null,
perfil varchar(60) null,
clientes int,
foreign key(clientes) references clientes(id_c) 
)default charset = utf8;

create table venda(
id_v int auto_increment,
codvenda int not null,
nome varchar(100)not null,
descricao varchar(150) not null,
qtdp varchar(80),
valor_item varchar(80),
valor_sub_total varchar(80),
valor_total varchar(80), -- Valor Total
forma_pg varchar(20),
clientes int,
dataq timestamp default current_timestamp,
primary key (id_v)    
);

create table carrinho(
id_cr int auto_increment,
codvenda int not null,
nome varchar(100)not null,
descricao varchar(150) not null,
qtdp varchar(80),
valor_item varchar(80),
valor_sub_total varchar(80),
valor_total varchar(80), -- Valor Total
forma_pg varchar(20),
dataq timestamp default current_timestamp,
    primary key (id_cr)
);

create table teste(
id_t int auto_increment,
    forma_pg varchar(80),
    venda int,
    carrinho int,
    primary key (id_t)
);


create table produtos(
id_pro int(11) auto_increment primary key,
CodProduto int not null,
descricao_p varchar(200),
estoque int null,
repositor varchar(80) null,
preco varchar(200),  -- por unidade (valor item)
dataq timestamp default current_timestamp
);


insert into acesso(login, senha, perfil) values ('admin','admin','Adminstrador');
--------------------------------------------------------------------------------------------------------------
------------------------------------------------METODO PRCEDURE PARA BAIXA DE ESTOQUE ------------------------
--------------------------------------------------------------------------------------------------------------
DELIMITER //
    CREATE PROCEDURE Baixa_Estoque(    
    IN varCod varchar(80),
    IN varId int
   -- IN varQtde int(11)
  --  IN varValor decimal(10,2)
      )
    BEGIN 
--    IF (varCod <=> 100) THEN 
     update produtos set repositor = (
	select (select estoque where CodProduto = varCod) - (select qtdp from carrinho where id_cr = varId ));    
	UPDATE produtos SET  estoque = repositor  WHERE produtos.CodProduto = varCod;  
    
 -- END IF; 
    END
    
    //
    
Call Baixa_Estoque(100,2);
-------------------------------------METODO PARA BAIXA DA COLUNA ESTOQUE DA TABELA PRODUTOS ------------------------------------------------------------------
use bronse;

update produtos set repositor = (
		select  (select estoque where codProduto = 100) - (select qtdp from carrinho where id_cr = 1));            
update produtos set estoque = repositor where codproduto = 100;
select * from produtos;


-------------------------------------METODO PARA ESTORNO DA VENDA ------------------------------------------------------------------
use bronse;

update produtos set repositor = (
		select  (select estoque where codProduto = 100) + (select qtdp from venda where id_v = 1));            
update produtos set estoque = repositor where codproduto = 100;
delete from venda where id_v = 1;
select * from produtos;

-------------------------------------------------------------------------------------------------------
-- select Cad.nome,estatus,
-- Vend.id_v, descricao, valor -- Tabela Cadastro com Tabela Venda;
-- from venda as Vend
-- inner join cadastro as Cad
-- on (Cad.id_cad = Vend.id_cad);
--------------------------------------------------------------------------------------------------------
-- select Vend.descricao,valor,nome, Prod.descricao,qtd,preco from venda as Vend inner join produtos as Prod on (Prod.id_pro = Vend.id_v);
-- select Vend.nome,valor, Prod.descricao_p,qtd,preco from venda as Vend inner join produtos as Prod on (Prod.id_pro = Vend.id_v);
-- select Vend.nome,qtd, valor, Prod.descricao_p,preco from venda as Vend inner join produtos as Prod on (Prod.id_pro = Vend.id_v);



-- select Vend.descricao,valor,nome, Prod.descricao,qtd,preco from venda as Vend inner join produtos as Prod on (Prod.id_pro = Vend.id_v) where descricao like "%"g%"";