/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.entidades;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author georg
 */
public class Orden {
    private Cliente Cliente;
    private Date fecha;
    private double Total;
    private ArrayList<OrdenProductos> Productos;
    private Estado Estado;
    
    public Orden(Cliente cliente, Carrito carrito) throws Exception
    {
        this.Cliente = cliente;
        this.fecha = new Date();
        Facturar(carrito);
        
    }
    
    private void Facturar(Carrito carrito) throws Exception
    {
        if(carrito == null || carrito.getProductos().size() < 1)
            throw new Exception("El carrito no puede ser nulo o estar vacio");
        
        this.Productos = new ArrayList<>();
        for (CarritoProducto prod : carrito.getProductos()) {
            OrdenProductos ordProd = new OrdenProductos();
            ordProd.setCantidad(prod.getCantidad());
            ordProd.setProducto(prod.getProducto());
            this.getProductos().add(ordProd);
            this.Total += ordProd.getValor();
        }
    }

    /**
     * @return the Cliente
     */
    public Cliente getCliente() {
        return Cliente;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @return the Total
     */
    public double getTotal() {
        return Total;
    }

    /**
     * @return the Productos
     */
    public ArrayList<OrdenProductos> getProductos() {
        return new ArrayList<>(this.Productos);
    }

    /**
     * @return the Estado
     */
    public Estado getEstado() {
        return Estado;
    }
}
