/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Produto.Model;

import br.com.Venda.Model.vendaDTO;

/**
 *
 * @author ernil
 */
public class ProdutoDTO {

    private int id_pro;
    private int codproduto;
    private String descricao;
    private String estoque;
    private String preco;
    private String data;
    private int repositor;
    private vendaDTO venda;

    public ProdutoDTO() {
    }

    public ProdutoDTO(int id_pro, int codproduto, String descricao, String estoque, String preco, String data, int repositor, vendaDTO venda) {
        this.id_pro = id_pro;
        this.codproduto = codproduto;
        this.descricao = descricao;
        this.estoque = estoque;
        this.preco = preco;
        this.data = data;
        this.repositor = repositor;
        this.venda = venda;
    }

    /**
     * @return the id_pro
     */
    public int getId_pro() {
        return id_pro;
    }

    /**
     * @param id_pro the id_pro to set
     */
    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    /**
     * @return the codproduto
     */
    public int getCodproduto() {
        return codproduto;
    }

    /**
     * @param codproduto the codproduto to set
     */
    public void setCodproduto(int codproduto) {
        this.codproduto = codproduto;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the estoque
     */
    public String getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(String estoque) {
        this.estoque = estoque;
    }

    /**
     * @return the preco
     */
    public String getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(String preco) {
        this.preco = preco;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the repositor
     */
    public int getRepositor() {
        return repositor;
    }

    /**
     * @param repositor the repositor to set
     */
    public void setRepositor(int repositor) {
        this.repositor = repositor;
    }

    /**
     * @return the venda
     */
    public vendaDTO getVenda() {
        return venda;
    }

    /**
     * @param venda the venda to set
     */
    public void setVenda(vendaDTO venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id_pro;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProdutoDTO other = (ProdutoDTO) obj;
        if (this.id_pro != other.id_pro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProdutoDTO{" + "id_pro=" + id_pro + ", codproduto=" + codproduto + ", descricao=" + descricao + ", estoque=" + estoque + ", preco=" + preco + ", data=" + data + ", repositor=" + repositor + ", venda=" + venda + '}';
    }

}
