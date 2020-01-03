/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Venda.Model;

import br.com.Conexao.JDBC.ModuloConexao;
import br.com.Produto.Model.ProdutoDTO;
import br.com.Venda.Model.vendaDTO;
import br.com.Venda.Model.VendaDao;

/**
 *
 * @author T69779848134
 */
public class vendaBLL {

     VendaDao dao = new VendaDao();
    vendaDTO dto = new vendaDTO();
    ProdutoDTO pto = new ProdutoDTO();

    public void Salvar_vendaCarrinho(int codPro, String nome, String descricao, int qtd, String total, String vfinal, String vItem) {
        dto.setNome(nome);
        dto.setDescricao(descricao);
        dto.setQtd(qtd);
        dto.setTotal(vItem);
        dto.setValorItem(total);
        dto.setVsubtotal(vfinal);
        dto.setCodproduto(codPro);

        dao.salvarVendaCarrinho(dto);
    }

    public void ExcluirVenda(int id) {
        dto.setId(id);       
        dao.ExcluirVenda(dto);
    }
    
    // METODO PARA MOVER A DIFERENÇA DA COLUNA ESTOQUE PARA REPOSITOR 
    public void BaixaEstoque(int id, int ProdCodi){
        dto.setId(id);
        dto.setCodproduto(ProdCodi);
        
        dao.baixa_Estoque(dto);
    }
    
    // METODO PARA MOVER O NOVO VALOR DA COLUNA REPOSITOR PARA ESTOQUE 
     public void BaixaEstoque2(int ProdCodi){
       dto.setCodproduto(ProdCodi);
        
        dao.baixa_Estoque2(dto);
    }
     
     
     
    public void SalvaCarrinho(String cob) {
        int x = 1;
        while (x < 10) {

            dto.setCboCont(cob + x++);

            dao.salvarCarrinho(dto);
        }

    }
}
