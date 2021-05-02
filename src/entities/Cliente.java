/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utils.ConectaDB;

/**
 *
 * @author gravacao
 */
public class Cliente {
   private int idcliente;
   private String nome;
   private String fone;
   private String email;
   
   public boolean salvar(){
        try {
            //conectar ao banco
            Connection con = ConectaDB.getConexao();
            //montar sql
            String sql = "insert into cliente(nome, fone, email)"
                    + "values(?,?,?)";
            //envia sql para o banco de dados
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.nome);
            stm.setString(2, this.fone);
            stm.setString(3, this.email);
            stm.execute();            
        } catch (SQLException ex) {
           throw new RuntimeException("Erro ao salvar cliente: " + ex.getMessage());
        }
        return true;
    }

    public Cliente() {
    }

    public Cliente(String nome, String fone, String email) {
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }

    public Cliente(int idcliente, String nome, String fone, String email) {
        this.idcliente = idcliente;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }

   
    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
   
}
