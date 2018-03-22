/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.beans.Admin;

import com.tienda.Interfaces.IOperCategoria;
import com.tienda.Interfaces.IOperProducto;
import com.tienda.Operaciones.OperCategoria;
import com.tienda.Operaciones.OperProducto;
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
    
    private ArrayList<Categoria> categorias;
    
    @PostConstruct
    public void Init()
    {
        categorias = new OperCategoria().ConsultarCategorias();
    }

    /**
     * @return the categorias
     */
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }
    
    public Categoria ConsultarCategoria(int id)
    {
        for(Categoria cat : categorias)
        {
            if(cat.getCategoria_Id() == id)
                return cat;
        }
        return null;
    }
    
    public void setGuardarProducto(Producto producto)
    {
        new OperProducto().InsertarProducto(producto);
    }
}
