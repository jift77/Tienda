/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.TestOperaciones;

import com.tienda.Interfaces.IOperProducto;
import com.tienda.entidades.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author georg
 */
public class OperProducto implements IOperProducto, Serializable{

    private static OperProducto instancia = null;
    
    HashMap<Integer, Producto> productos;
    
    protected OperProducto()
    {
        OperCategoria cat = OperCategoria.ObtenerInstancia();
        
        /*productos = new HashMap<>();
        productos.put(1,new Producto(1,"Confeti", "Producto para celebrar", 12000, cat.ConsultarCategoria(2)));
        productos.put(2,new Producto(2,"Televisor", "Producto para perder el tiempo", 12000, cat.ConsultarCategoria(4)));
        productos.put(3,new Producto(3,"Camisa", "Producto para vestirse", 12000, cat.ConsultarCategoria(3)));
        productos.put(4,new Producto(4,"Casa", "Producto para habitar", 12000, cat.ConsultarCategoria(1)));
        productos.put(5,new Producto(5,"Radio", "Producto para escuchar musica", 12000, cat.ConsultarCategoria(4)));*/
    }
    
    public static OperProducto ObtenerInstancia()
    {
        if(instancia == null)
            instancia = new OperProducto();   
        return instancia;
    }
    
    @Override
    public ArrayList<Producto> ConsultarProductos() {
        return new ArrayList<>(productos.values());
    }

    @Override
    public Producto ConsultarProducto(int id) {
        return this.productos.get(id);
    }

    @Override
    public void ActualizarProducto(Producto producto) {
        this.productos.replace(producto.getProducto_Id(), producto);
    }

    @Override
    public void EliminarProducto(int id) {
        this.productos.remove(id);
    }

    @Override
    public void InsertarProducto(Producto pro) {
        int id = this.productos.values().size() + 1;
        pro.setProducto_Id(id);
        this.productos.put(id, pro);
    }
}
