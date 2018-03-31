/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.rest;

import com.tienda.Operaciones.OperCategoria;
import com.tienda.Operaciones.OperProducto;
import com.tienda.entidades.Producto;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertarProducto(Producto prod)
    {
        new OperProducto().InsertarProducto(prod);
    }
    
    @Path("calcular")
    @GET
    public double calcularValor(@QueryParam("valor") double valor, @QueryParam("categoria") int categoria_id)
    {
        double impuesto = new OperCategoria().ConsultarCategoria(categoria_id).getImpuesto();
        return valor * (1 + impuesto);
    }
}
