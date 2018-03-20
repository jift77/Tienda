/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.beans.Cliente;

import com.tienda.Interfaces.IOperProducto;
import com.tienda.entidades.Producto;
import com.tienda.entidades.Categoria;
import com.tienda.TestOperaciones.OperProducto;
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
    private IOperProducto oper;
    
    @PostConstruct
    public void init()
    {
        oper = OperProducto.ObtenerInstancia();
        this.productos = oper.ConsultarProductos();
    }

    /**
     * @return the Productos
     */
    public ArrayList<Producto> getProductos() {
        oper.ConsultarProductos().forEach((prod) -> {
            System.out.println(prod.getNombre() +" "+ prod.getProducto_Id());
        });
        return oper.ConsultarProductos();
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
}
