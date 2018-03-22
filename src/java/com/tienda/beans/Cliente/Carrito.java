/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.beans.Cliente;

import com.tienda.entidades.Producto;
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
   private long Total;

    public Carrito() {
        this.Productos = new HashMap<>();
        this.Cantidad = 0;
        this.Total = 0;
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
        this.Total += prod.getTotal();
    }
    
    public void setRemoverProducto(Producto prod)
    {
        CarritoProducto carItem = Productos.get(prod.getProducto_Id());
        if(carItem != null && carItem.getCantidad() > 1)
            carItem.ReducirCantidad();
        else
            Productos.remove(prod.getProducto_Id());
        this.Cantidad--;
        this.Total -= prod.getTotal();
    }
    
    public int getCantidad()
    {
        return this.Cantidad;
    }

    /**
     * @return the Total
     */
    public long getTotal() {
        return this.Total;
    }
    
    public int getCantidadProducto(int producto_id)
    {
        CarritoProducto prod = this.Productos.get(producto_id);
        if(prod != null)
            return prod.getCantidad();
        else
            return 0;
    }
}
