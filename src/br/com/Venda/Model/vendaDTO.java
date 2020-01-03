/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Venda.Model;

import br.com.Produto.Model.ProdutoDTO;

/**
 *
 * @author T69779848134
 */
public class vendaDTO {

    private int id;
    private String nome;
    private String descricao;
    private int qtd;
    private String total;
    private String cboCont;
    private String valorItem;
    private String vsubtotal;
    private int codproduto;
   

    public vendaDTO() {
    }

    public vendaDTO(int id, String nome, String descricao, int qtd, String total, String cboCont, String valorItem, String vsubtotal, int codproduto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.qtd = qtd;
        this.total = total;
        this.cboCont = cboCont;
        this.valorItem = valorItem;
        this.vsubtotal = vsubtotal;
        this.codproduto = codproduto;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
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
     * @return the qtd
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * @param qtd the qtd to set
     */
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @return the cboCont
     */
    public String getCboCont() {
        return cboCont;
    }

    /**
     * @param cboCont the cboCont to set
     */
    public void setCboCont(String cboCont) {
        this.cboCont = cboCont;
    }

    /**
     * @return the valorItem
     */
    public String getValorItem() {
        return valorItem;
    }

    /**
     * @param valorItem the valorItem to set
     */
    public void setValorItem(String valorItem) {
        this.valorItem = valorItem;
    }

    /**
     * @return the vsubtotal
     */
    public String getVsubtotal() {
        return vsubtotal;
    }

    /**
     * @param vsubtotal the vsubtotal to set
     */
    public void setVsubtotal(String vsubtotal) {
        this.vsubtotal = vsubtotal;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
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
        final vendaDTO other = (vendaDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vendaDTO{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", qtd=" + qtd + ", total=" + total + ", cboCont=" + cboCont + ", valorItem=" + valorItem + ", vsubtotal=" + vsubtotal + ", codproduto=" + codproduto + '}';
    }   
   
  }