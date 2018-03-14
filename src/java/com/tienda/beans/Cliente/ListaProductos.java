/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.beans.Cliente;

import com.sun.faces.util.CollectionsUtils;
import com.tienda.entidades.Producto;
import com.tienda.entidades.Carrito;
import com.tienda.entidades.Categoria;
import com.tienda.operaciones.OperProducto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author georg
 */
@ManagedBean(name = "productos")
@Scope("session")
public class ListaProductos implements Serializable{
    
    private ArrayList<Producto> productos;
    private Carrito carrito;
    
    @PostConstruct
    public void init()
    {
        this.productos = new OperProducto().ConsultarProductos();
        this.carrito = new Carrito();
    }

    /**
     * @return the Productos
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    public void setAgregarProducto(Producto prod)
    {
        this.carrito.AgregarProducto(prod);
    }
    
    public void RemoverProducto(Producto prod)
    {
        this.carrito.EliminarProducto(prod);
    }
    
    public int getProductosCantidad()
    {
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
    
    public String verCarrito()
    {
        return "carrito";
    }
}
