/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.beans.Cliente;

import com.tienda.Operaciones.OperProducto;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author georg
 */
public class Caja {
    
    private int codigo;
    
    public String facturar()
    {
        if(codigo != 100)
            return null;
        
        FacesContext faces = FacesContext.getCurrentInstance();
        boolean facturado = false;
        try
        {
            Carrito car = (Carrito)faces.getExternalContext().getSessionMap().get("carrito");
            if(car != null)
            {
                ArrayList<CarritoProducto> productos = car.getProductos();
                productos.forEach((pro) -> {
                    new OperProducto().ReducirCantidad(pro.getProducto().getProducto_Id(), pro.getCantidad());
                });
                facturado = true;
            }
        } 
        catch(Exception ex)
        {
            Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(facturado)
            faces.getExternalContext().getSessionMap().replace("carrito", new Carrito());  
        return "confirmacion";
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
