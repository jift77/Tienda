/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.entidades;

import java.io.Serializable;

/**
 *
 * @author georg
 */
public class CarritoProducto implements Serializable{
    private Producto Producto;
    private int Cantidad;

    public CarritoProducto(Producto prod)
    {
        this.Producto = prod;
        Cantidad = 1;
    }
    
    /**
     * @return the Producto
     */
    public Producto getProducto() {
        return Producto;
    }

    /**
     * @param Producto the Producto to set
     */
    public void setProducto(Producto Producto) {
        this.Producto = Producto;
    }

    /**
     * @return the Cantidad
     */
    public int getCantidad() {
        return Cantidad;
    }
    
    public void IncrementarCantidad()
    {
        this.Cantidad++;
    }
    
    public void ReducirCantidad()
    {
        this.Cantidad--;
    }
}
