/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import DAO.interfaces.DaoInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.ConectaDB;

/**
 *
 * @author vilson.moro
 */
public class Itens implements DaoInterface{
   private int iditem;
   private int idproduto;
   private int idvenda;
   private float qtde;
   private float precoItem;

    public Itens() {
    }

    public Itens(int iditem, int idproduto, int idvenda, float qtde, float precoItem) {
        this.iditem = iditem;
        this.idproduto = idproduto;
        this.idvenda = idvenda;
        this.qtde = qtde;
        this.precoItem = precoItem;
    }

   
    public int getIditem() {
        return iditem;
    }

    public void setIditem(int iditem) {
        this.iditem = iditem;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public float getQtde() {
        return qtde;
    }

    public void setQtde(float qtde) {
        this.qtde = qtde;
    }

    public float getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(float precoItem) {
        this.precoItem = precoItem;
    }

    @Override
    public boolean salvar() {
        try {
            //conectar ao banco
            Connection con = ConectaDB.getConexao();
            //montar sql
            String sql = "insert into itens(idproduto, idvenda, qtde, precoitem)"
                    + "values(?,?,?,?)";
            //envia sql para o banco de dados
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, this.getIdproduto());
            stm.setInt(2, this.getIdvenda());
            stm.setFloat(3, this.getQtde());
            stm.setFloat(4, this.getPrecoItem());
            stm.execute();            
        } catch (SQLException ex) {
           throw new RuntimeException("Erro ao salvar itens: " + ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean editar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getAll(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
}
