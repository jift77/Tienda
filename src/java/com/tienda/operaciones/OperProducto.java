/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.operaciones;

import com.tienda.Interfaces.IOperProducto;
import com.tienda.entidades.Categoria;
import com.tienda.entidades.Producto;
import java.util.ArrayList;

/**
 *
 * @author georg
 */
public class OperProducto implements IOperProducto{

    @Override
    public ArrayList<Producto> ConsultarProductos() {
        
        ArrayList<Producto> result = new ArrayList<>();
        
        result.add(new Producto("Confeti", "Producto para celebrar", 12000, new Categoria(1, "Otro", 0.15)));
        result.add(new Producto("Televisor", "Producto para perder el tiempo", 12000, new Categoria(1, "Tecnolgia", 0.15)));
        result.add(new Producto("Camisa", "Producto para vestirse", 12000, new Categoria(1, "Ropa", 0.15)));
        result.add(new Producto("Casa", "Producto para habitar", 12000, new Categoria(1, "Finza Raiz", 0.15)));
        result.add(new Producto("Radio", "Producto para escuchar musica", 12000, new Categoria(1, "Tecnologia", 0.15)));
               
        return result;
    }
    
}
