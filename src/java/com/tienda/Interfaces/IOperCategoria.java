/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.Interfaces;

import com.tienda.entidades.Categoria;
import java.util.ArrayList;

/**
 *
 * @author georg
 */
public interface IOperCategoria {
    
    ArrayList<Categoria> ConsultarCategorias();
    Categoria ConsultarCategoria(int id);
    void ActualizarCategoria(Categoria cat);
    void InsertarCategoria(Categoria cat);
}
