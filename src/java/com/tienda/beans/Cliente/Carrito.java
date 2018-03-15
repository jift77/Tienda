/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.beans.Cliente;

import com.tienda.entidades.Producto;
import java.util.ArrayList;

/**
 *
 * @author georg
 */
public class Carrito {
    
    private Carrito carrito;
    
    public ArrayList<Producto> getProductos()
    {
        return carrito.getProductos();
    }
}
