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
public class Categoria implements Serializable{
    private int Categoria_Id;
    private String Nombre;
    private double Impuesto;
    
    public Categoria(int categoria_id, String nombre, double impuesto)
    {
        this.Categoria_Id = categoria_id;
        this.Nombre = nombre;
        this.Impuesto = impuesto;
    }

    /**
     * @return the Categoria_Id
     */
    public int getCategoria_Id() {
        return Categoria_Id;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @return the Impuesto
     */
    public double getImpuesto() {
        return Impuesto;
    }
}
