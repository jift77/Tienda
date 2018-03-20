/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.TestOperaciones;

import com.tienda.Interfaces.IOperCategoria;
import com.tienda.entidades.Categoria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author georg
 */
public class OperCategoria implements IOperCategoria, Serializable{
    
    private static OperCategoria instancia = null;
    private HashMap<Integer, Categoria> Categorias;
    
    protected OperCategoria()
    {
        Categorias = new HashMap<>();
        
        Categorias.put(1, new Categoria(1, "Finca Raiz", 0.15));
        Categorias.put(2, new Categoria(2, "Otro", 0.15));
        Categorias.put(3, new Categoria(3, "Ropa", 0.15));
        Categorias.put(4, new Categoria(4, "Tecnologia", 0.15));
    }
    
    public static OperCategoria ObtenerInstancia()
    {
        if(instancia == null)
            instancia = new OperCategoria();
        
        return instancia;
    }
    
    
    @Override
    public ArrayList<Categoria> ConsultarCategorias() {
        return new ArrayList<>(this.Categorias.values());
    }

    @Override
    public Categoria ConsultarCategoria(int id) {
        return this.Categorias.get(id);
    }

    @Override
    public void ActualizarCategoria(Categoria categoria) {
        this.Categorias.replace(categoria.getCategoria_Id(), categoria); 
    }

    @Override
    public void InsertarCategoria(Categoria cat) {
        int id = this.Categorias.values().size() + 1;
        cat.setCategoria_Id(id);
        this.Categorias.put(id, cat);
    }
}
