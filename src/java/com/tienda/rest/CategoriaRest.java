/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.rest;

import com.tienda.Operaciones.OperCategoria;
import com.tienda.entidades.Categoria;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author georg
 */
@Path("categoria")
public class CategoriaRest {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Categoria> getCategorias()
    {
        return new OperCategoria().ConsultarCategorias();     
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void InsertarCategoria(Categoria cat)
    {
        new OperCategoria().InsertarCategoria(cat);
    }
}
