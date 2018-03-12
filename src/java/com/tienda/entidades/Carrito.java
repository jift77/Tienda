/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author georg
 */
public class Carrito {
    
   private HashMap<Integer, CarritoProducto> Productos;

    public Carrito() {
        this.Productos = new HashMap<>();
    }

    /**
     * @return the Productos
     */
    public ArrayList<CarritoProducto> getProductos() {
        return new ArrayList<>(this.Productos.values());
    }
    
    public void AgregarProducto(Producto prod)
    {
        CarritoProducto carItem = Productos.get(prod.getProducto_Id());
        if(carItem != null)
            carItem.IncrementarCantidad();
        else
            Productos.put(prod.getProducto_Id(),new CarritoProducto(prod));
    }
    
    public void EliminarProducto(Producto prod)
    {
        CarritoProducto carItem = Productos.get(prod.getProducto_Id());
        if(carItem != null)
            carItem.ReducirCantidad();
        else
            Productos.remove(prod.getProducto_Id());
    }
}
