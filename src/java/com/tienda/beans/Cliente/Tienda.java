/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.beans.Cliente;

import com.tienda.entidades.Producto;
import com.tienda.entidades.Carrito;
import com.tienda.entidades.Categoria;
import com.tienda.operaciones.OperProducto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.PostConstruct;

/**
 *
 * @author georg
 */
public class Tienda implements Serializable{
    
    private ArrayList<Producto> productos;
    private Carrito carrito;
    private int Cuantity;
    
    @PostConstruct
    public void init()
    {
        this.productos = new OperProducto().ConsultarProductos();
        this.carrito = new Carrito();
    }
    
    public int getCuantity()
    {
        return Cuantity;
    }

    /**
     * @return the Productos
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    public void setAgregarProducto(Producto prod)
    {
        this.Cuantity++;
        System.out.println(this.Cuantity);
        this.carrito.AgregarProducto(prod);
    }
    
    public void setRemoverProducto(Producto prod)
    {
        this.carrito.EliminarProducto(prod);
    }
    
    public int getProductosCantidad()
    {
        System.out.println(this.carrito.getCantidad());
        return this.carrito.getCantidad();
    }
    
    public ArrayList<Categoria> getCategorias()
    {
        HashMap<Integer, Categoria> categorias = new HashMap<>();
        this.productos.forEach((prod) -> {
            Categoria cat = categorias.get(prod.getCategoria().getCategoria_Id());
            if (cat == null) {
                categorias.put(prod.getCategoria().getCategoria_Id(), prod.getCategoria());
            }
        });
        return new ArrayList<>(categorias.values());
    }

    /**
     * @return the carrito
     */
    public Carrito getCarrito() {
        return carrito;
    }

    /**
     * @param carrito the carrito to set
     */
    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
}
