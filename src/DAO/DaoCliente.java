/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.ConectaDB;

/**
 *
 * @author vilson.moro
 */
public  class DaoCliente {
   public static ResultSet getAll(){
        ResultSet rs = null;
        try {
            String sql = "select * from cliente";
            Connection con = ConectaDB.getConexao();
            PreparedStatement stm = con.prepareStatement(sql);
            rs =  stm.executeQuery();
        } catch (SQLException ex) {
           System.out.println("Erro: " + ex.getMessage());
        }
        return rs;
    } 
}
