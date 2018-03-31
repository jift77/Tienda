/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.rest;

import com.tienda.Operaciones.OperProducto;
import com.tienda.entidades.Producto;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author georg
 */
@Path("producto")
public class ProductoRest {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Producto> getProductos()
    {
        return new OperProducto().ConsultarProductos();
    }
}
