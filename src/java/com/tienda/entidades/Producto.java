/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.entidades;

import java.io.Serializable;

/**
 *
 * @author georg
 */
public class Producto implements Serializable {
    
    private int Producto_Id;
    private String Nombre;
    private String Descripcion;
    private double Valor;
    private Categoria Categoria;
    
    public Producto()
    {}
    
    public Producto(int producto_id, String nombre, String descripcion, double valor, Categoria categoria)
    {
        this.Producto_Id = producto_id;
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Valor = valor;
        this.Categoria = categoria;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the Valor
     */
    public double getValor() {
        return Valor;
    }

    /**
     * @param Valor the Valor to set
     */
    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    /**
     * @return the Categoria
     */
    public Categoria getCategoria() {
        return Categoria;
    }

    /**
     * @param Categoria the Categoria to set
     */
    public void setCategoria(Categoria Categoria) {
        this.Categoria = Categoria;
    }

    /**
     * @return the Producto_Id
     */
    public int getProducto_Id() {
        return Producto_Id;
    }

    /**
     * @param Producto_Id the Producto_Id to set
     */
    public void setProducto_Id(int Producto_Id) {
        this.Producto_Id = Producto_Id;
    }
    
}
