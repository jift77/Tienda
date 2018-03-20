/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author georg
 */
public class Carrito implements Serializable {
    
   private HashMap<Integer, CarritoProducto> Productos;
   private int Cantidad;

    public Carrito() {
        this.Productos = new HashMap<>();
        this.Cantidad = 0;
    }

    /**
     * @return the Productos
     */
    public ArrayList<CarritoProducto> getProductos() {
        return new ArrayList<>(this.Productos.values());
    }
    
    public void setAgregarProducto(Producto prod)
    {
        CarritoProducto carItem = Productos.get(prod.getProducto_Id());
        if(carItem != null)
            carItem.IncrementarCantidad();
        else
            Productos.put(prod.getProducto_Id(),new CarritoProducto(prod));
        this.Cantidad++;
    }
    
    public void setRemoverProducto(Producto prod)
    {
        CarritoProducto carItem = Productos.get(prod.getProducto_Id());
        if(carItem != null && carItem.getCantidad() > 1)
            carItem.ReducirCantidad();
        else
            Productos.remove(prod.getProducto_Id());
        this.Cantidad--;
    }
    
    public int getCantidad()
    {
        return this.Cantidad;
    }
}
