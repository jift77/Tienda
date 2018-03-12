/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.beans.Cliente;

import com.tienda.entidades.Producto;
import com.tienda.operaciones.OperProducto;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author georg
 */
@ManagedBean
public class ListaProductos {
    
    private ArrayList<Producto> Productos;
    
    public ListaProductos()
    {
        this.Productos = new OperProducto().ConsultarProductos();
    }

    /**
     * @return the Productos
     */
    public ArrayList<Producto> getProductos() {
        return Productos;
    }
}
