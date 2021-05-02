/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Cliente;
import entities.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.ConectaDB;

/**
 *
 * @author gravacao
 */
public class DaoProduto {
    
    public static boolean salvar(Produto prod){
        try {
            //conectar ao banco
            Connection con = ConectaDB.getConexao();
            //montar sql
            String sql = "insert into produto(descricao, preco, estoque)"
                    + "values(?,?,?)";
            //envia sql para o banco de dados
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, prod.getDescricao());
            stm.setFloat(2, prod.getPreco());
            stm.setFloat(3, prod.getEstoque());
            stm.execute();            
        } catch (SQLException ex) {
           throw new RuntimeException("Erro ao salvar produto: " + ex.getMessage());
        }
        return true;
    }
    
    public static ResultSet getAll(){
        ResultSet rs = null;
        try {
            String sql = "select * from produto";
            Connection con = ConectaDB.getConexao();
            PreparedStatement stm = con.prepareStatement(sql);
            rs =  stm.executeQuery();
        } catch (SQLException ex) {
           System.out.println("Erro: " + ex.getMessage());
        }
        return rs;
    } 
    
    public static Produto getById(int id){
       ResultSet rs = null;
       Produto produto = new Produto();
        try {
            String sql = "select * from produto where idproduto = ?";
            Connection con = ConectaDB.getConexao();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs =  stm.executeQuery();
            if(rs.next()){
               produto.setIdproduto(rs.getInt("idproduto"));
               produto.setDescricao(rs.getString("descricao"));
               produto.setPreco(rs.getFloat("preco"));
               produto.setPreco(rs.getFloat("estoque"));
            }
        } catch (SQLException ex) {
           System.out.println("Erro: " + ex.getMessage());
        }
        return produto;
    }
}
