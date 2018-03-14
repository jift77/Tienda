/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.beans.Cliente;

import com.tienda.entidades.Producto;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author georg
 */
@ManagedBean(name = "carrito")
@Scope("session")
public class Carrito {
    
    private Carrito carrito;
    
    public ArrayList<Producto> getProductos()
    {
        return carrito.getProductos();
    }
}
