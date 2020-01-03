/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Produto.Model;
import br.com.Produto.Model.ProdutoDTO;
import br.com.Produto.Model.ProdutoDAO;

/**
 *
 * @author ernil
 */
public class ProdutoBLL {
    ProdutoDAO dao = new ProdutoDAO();
    ProdutoDTO dto = new ProdutoDTO();
    
    public void salvaProduto(int codProduto, String descricao, String estoque, String preco, String repositor){
        dto.setCodproduto(codProduto);
        dto.setDescricao(descricao);
        dto.setEstoque(estoque);
        dto.setPreco(preco);
        dto.setRepositor(codProduto);
        
        dao.salvarProduto(dto);
    }
    
    public void AterarProduto(int id_pro, String descricao, String estoque, String preco){
        dto.getId_pro();
        dto.setDescricao(descricao);
        dto.setEstoque(estoque);
        dto.setPreco(preco);
        
        dao.alterar(dto);
    }
    public void ExcluirProduto(int id_pro, String descricao, String estoque, String preco){
        dto.setId_pro(id_pro);
        dto.setDescricao(descricao);
        dto.setEstoque(estoque);
        dto.setPreco(preco);
        
        dao.ExcluirProduto(dto);
    }
    
    public void EstornoVenda(int id, int codProduto, String descricao, String estoque, String preco, String repositor){
        dto.setId_pro(id);
        dto.setCodproduto(codProduto);
        dto.setDescricao(descricao);
        dto.setEstoque(estoque);
        dto.setPreco(preco);
        dto.setRepositor(codProduto);
        
        dao.EstornoVenda(dto);
        dao.EstornoComplemento(dto);
        dao.ExcluirVenda(dto);
    }
    
}
