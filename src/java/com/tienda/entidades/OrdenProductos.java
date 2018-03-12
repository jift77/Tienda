/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.entidades;

/**
 *
 * @author georg
 */
public class OrdenProductos {
    private Producto Producto;
    private int Cantidad;

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

    /**
     * @param Cantidad the Cantidad to set
     */
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    /**
     * @return the Valor
     */
    public double getValor() {
        return this.Producto.getValor() * (1 + this.Producto.getCategoria().getImpuesto())  * this.Cantidad;
    }
    
    
}
