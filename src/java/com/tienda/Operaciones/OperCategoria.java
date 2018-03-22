/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.Operaciones;

import com.tienda.Interfaces.IOperCategoria;
import com.tienda.entidades.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author georg
 */
public class OperCategoria extends TiendaDBManager implements IOperCategoria {

    @Override
    public ArrayList<Categoria> ConsultarCategorias() {
        ArrayList<Categoria> result = new ArrayList<>();
        try {
            conectarse();
            if(con != null)
            {     
                PreparedStatement ps = con.prepareStatement("SELECT * FROM Categoria");
                ResultSet rta = ps.executeQuery();
                while(rta.next())
                {   
                    Categoria c = new Categoria(
                            rta.getInt("Categoria_Id"), 
                            rta.getString("NombreCat"), 
                            rta.getDouble("Impuesto")
                    );
                    result.add(c);
                }
                desconectarse();
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(OperProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Categoria ConsultarCategoria(int id) {
        Categoria result = null;
        try {
            conectarse();
            if(con != null)
            {     
                PreparedStatement ps = con.prepareStatement("SELECT * FROM Categoria WHERE Categoria_Id = ?");
                ps.setInt(1, id);
                ResultSet rta = ps.executeQuery();
                while(rta.next())
                {   
                    result = new Categoria(
                            rta.getInt("Categoria_Id"), 
                            rta.getString("NombreCat"), 
                            rta.getDouble("Impuesto")
                    );
                }
                desconectarse();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public void ActualizarCategoria(Categoria cat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void InsertarCategoria(Categoria cat) {
        try {
            conectarse();
            if(con != null)
            {
                PreparedStatement ps = con.prepareStatement("INSERT INTO Categoria (NombreCat, Impuesto) values (?, ?)");
                ps.setString(1, cat.getNombre());
                ps.setDouble(2, cat.getImpuesto());
                ps.executeUpdate();
            }
            desconectarse();
        } catch (SQLException ex) {
            Logger.getLogger(OperProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
