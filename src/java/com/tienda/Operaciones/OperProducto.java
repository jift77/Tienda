/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.Operaciones;

import com.tienda.Interfaces.IOperProducto;
import com.tienda.entidades.Categoria;
import com.tienda.entidades.Producto;
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
public class OperProducto extends TiendaDBManager implements IOperProducto {
    
    @Override
    public ArrayList<Producto> ConsultarProductos() {
        ArrayList<Producto> result = new ArrayList<>();
        
        try {
            conectarse();
            if(con != null)
            {
                PreparedStatement ps = con.prepareStatement("select p.*,c.NombreCat,c.Impuesto from Producto p inner join Categoria c on p.Categoria_id = c.Categoria_id");
                ResultSet rta = ps.executeQuery();
                while(rta.next())
                {   
                    Producto p = new Producto(
                            rta.getInt("producto_Id"), 
                            rta.getString("nombre"), 
                            rta.getString("descripcion"),
                            rta.getLong("valor"),
                            rta.getInt("cantidad"),
                            new Categoria(
                                    rta.getInt("categoria_id"), 
                                    rta.getString("nombreCat"), 
                                    rta.getDouble("impuesto") 
                            )
                    );
                    result.add(p);
                }
                desconectarse();
            }
        } catch (SQLException ex) {
                Logger.getLogger(OperProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        return result;
    }

    @Override
    public Producto ConsultarProducto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ActualizarProducto(Producto pro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EliminarProducto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void InsertarProducto(Producto pro) {
        try {
            conectarse();
            if(con != null)
            {
                PreparedStatement ps = con.prepareStatement("INSERT INTO producto (Nombre, Descripcion, Valor, Cantidad, Categoria_id) values (?, ? ,?, ?, ?)");
                ps.setString(1, pro.getNombre());
                ps.setString(2, pro.getDescripcion());
                ps.setLong(3, pro.getValor());
                ps.setInt(4, pro.getExistencias());
                ps.setInt(5, pro.getCategoria().getCategoria_Id());
                ps.executeUpdate();
            }
            desconectarse();
        } catch (SQLException ex) {
            Logger.getLogger(OperProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ReducirCantidad(int idPro, int cantidad) {
        try {
            conectarse();
            if(con != null)
            {
                PreparedStatement ps = con.prepareStatement("UPDATE producto SET cantidad = cantidad - ? WHERE producto_id = ?");
                ps.setInt(1, cantidad);
                ps.setInt(2, idPro);
                ps.executeUpdate();
            }
            desconectarse();
        } catch (SQLException ex) {
            Logger.getLogger(OperProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
