/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.interfaces;
import java.sql.ResultSet;

/**
 *
 * @author vilson.moro
 */
public interface DaoInterface {
   public boolean salvar(); 
   public boolean editar();
   public ResultSet getAll();
   public Object getById(int id);
}
