/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.beans.Admin;

import com.tienda.Interfaces.IOperCategoria;
import com.tienda.Interfaces.IOperProducto;
import com.tienda.TestOperaciones.OperCategoria;
import com.tienda.TestOperaciones.OperProducto;
import com.tienda.entidades.Categoria;
import com.tienda.entidades.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;

/**
 *
 * @author georg
 */
public class Bodega implements Serializable{
    
    private IOperProducto operProducto;
    private IOperCategoria operCategoria;
    private ArrayList<Categoria> categorias;
    
    @PostConstruct
    public void Init()
    {
        operCategoria = OperCategoria.ObtenerInstancia();
        operProducto = OperProducto.ObtenerInstancia();
        categorias = operCategoria.ConsultarCategorias();
    }

    /**
     * @return the categorias
     */
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }
    
    public Categoria ConsultarCategoria(int id)
    {
        return operCategoria.ConsultarCategoria(id);
    }
    
    public void setGuardarProducto(Producto producto)
    {
        operProducto.InsertarProducto(producto);
        operProducto.ConsultarProductos().forEach((prod) -> {
            System.out.println(prod.getNombre() +" "+ prod.getProducto_Id());
        }); //return "bodega";
    }
}
