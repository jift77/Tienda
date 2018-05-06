/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.Interfaces;

import com.tienda.entidades.Producto;
import java.util.ArrayList;

/**
 *
 * @author georg
 */
public interface IOperProducto {
    ArrayList<Producto> ConsultarProductos();
    Producto ConsultarProducto(int id);
    void ActualizarProducto(Producto pro);
    void EliminarProducto(int id);
    void InsertarProducto(Producto pro);
    void ReducirCantidad(int idPro, int cantidad);
}
