/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.beans.Cliente;

import com.tienda.Operaciones.OperProducto;
import com.tienda.entidades.Producto;
import com.tienda.entidades.Categoria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

/**
 *
 * @author georg
 */
public class Tienda implements Serializable{
    
    private ArrayList<Producto> productos;
    private int FiltroCat;
    
    @PostConstruct
    public void init()
    {
        this.productos = new OperProducto().ConsultarProductos();
    }

    /**
     * @return the Productos
     */
    public ArrayList<Producto> getProductos() {
        Carrito car = (Carrito)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("carrito");
        if(car != null)
        {
            this.productos.forEach((prod) -> {
                prod.setDisponible(prod.getExistencias() > car.getCantidadProducto(prod.getProducto_Id()));
            });
        }
        
        if(FiltroCat == 0)
        {
            return productos;
        }
        else
        {
            ArrayList<Producto> prod = new ArrayList<>();
            productos.stream().filter((p) -> (p.getCategoria().getCategoria_Id() == FiltroCat)).forEachOrdered((p) -> {
                prod.add(p);
            });
            return prod;
        }
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
     * @param FiltroCat the FiltroCat to set
     */
    public void setFiltroCat(int FiltroCat) {
        this.FiltroCat = FiltroCat;
    }
}
