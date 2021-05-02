/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author gravacao
 */
public class Produto {
    private int idproduto;
    private String descricao;
    private float preco;
    private float estoque;

    public Produto() {
    }

    public Produto(String descricao, float preco, float estoque) {
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto(int idproduto, String descricao, float preco, float estoque) {
        this.idproduto = idproduto;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }   
    
    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getEstoque() {
        return estoque;
    }

    public void setEstoque(float estoque) {
        this.estoque = estoque;
    }
    
    
}
