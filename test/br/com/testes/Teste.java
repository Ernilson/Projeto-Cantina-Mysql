/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.testes;

import br.com.Produto.Model.ProdutoDTO;
import br.com.Venda.Model.VendaDao;
import br.com.Venda.Model.vendaDTO;

/**
 *
 * @author s60254831168
 */
public class Teste {

    public static void main(String[] args) {
        vendaDTO v = new vendaDTO();
        VendaDao vdao = new VendaDao();
        ProdutoDTO p = new ProdutoDTO();
//        try {
//            v.setId(1);
//            p.setEstoque("100");
//            vdao.baixa_Estoque(v, p);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            p.setCodproduto(200);
            v.setId(1);
            
//            vdao.baixa_Estoque(v, p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
