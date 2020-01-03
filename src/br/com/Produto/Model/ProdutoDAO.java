/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Produto.Model;

import java.sql.*;
import br.com.Conexao.JDBC.ModuloConexao;
import javax.swing.JOptionPane;
import br.com.Produto.Model.ProdutoDTO;
import br.com.Venda.Model.vendaDTO;

/**
 *
 * @author ernil
 */
public class ProdutoDAO {

    ModuloConexao conexao = new ModuloConexao();

    public void salvarProduto(ProdutoDTO dto) {

        String sql = "insert into produtos (codproduto, descricao_p, estoque, preco, repositor )value (?,?,?,?,?)";
        conexao.conector();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement(sql);
            pst.setInt(1, dto.getCodproduto());
            pst.setString(2, dto.getDescricao());
            pst.setString(3, dto.getEstoque());
            pst.setString(4, dto.getPreco());
            pst.setInt(5, dto.getRepositor());

            if (dto.getDescricao().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrgatórios");
            } else {
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ExcluirProduto(ProdutoDTO dto) {
        conexao.conector();
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from produtos where id_pro = ?";
            try {
                PreparedStatement pst = conexao.conn.prepareStatement(sql);
                pst.setInt(1, dto.getId_pro());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erro");

            }
        }
    }

    public void alterar(ProdutoDTO dto) {
        String sql = "update produtos set codproduto=?, descricao_p=?, qtd=?, preco=? where id_pro=?";
        conexao.conector();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement(sql);
            pst.setInt(1, dto.getCodproduto());
            pst.setString(2, dto.getDescricao());
            pst.setString(3, dto.getEstoque());
            pst.setString(4, dto.getPreco());
            pst.setInt(5, dto.getId_pro());

            if (dto.getDescricao().isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrgatórios");
            } else {
                pst.executeUpdate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void EstornoVenda(ProdutoDTO pto) {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este Venda?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "update produtos set repositor = (select (select estoque where codProduto = ?) + (select qtdp from venda where id_v = ?));";
            conexao.conector();
            try {
                PreparedStatement pst = conexao.conn.prepareStatement(sql);
                pst.setInt(1, pto.getCodproduto());
                pst.setInt(2, pto.getId_pro());

                if (pto.getDescricao().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos obrgatórios");
                } else {
                    pst.executeUpdate();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }      
    }

    public void EstornoComplemento(ProdutoDTO dto) {
        String sql = "update produtos set estoque = repositor where codproduto = ?;";
        conexao.conector();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement(sql);
            pst.setInt(1, dto.getCodproduto());

            if (dto.getDescricao().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrgatórios");
            } 
             pst.executeUpdate();               
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ExcluirVenda(ProdutoDTO dto) {
        conexao.conector();
        String sql = "delete from venda where id_v = ?";
        try {
            PreparedStatement pst = conexao.conn.prepareStatement(sql);
            pst.setInt(1, dto.getId_pro());
            int apagado = pst.executeUpdate();
            if (apagado > 0) {
                JOptionPane.showMessageDialog(null, "Venda Estornada com sucesso!!!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro");

        }
    }
}
