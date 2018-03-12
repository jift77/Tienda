/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.entidades;

/**
 *
 * @author georg
 */
public class TarjetaCredito {
    private String Nombre;
    private String Numero;
    private String FechaVencimiento;
    private String CSV;

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
     * @return the Numero
     */
    public String getNumero() {
        return Numero;
    }

    /**
     * @param Numero the Numero to set
     */
    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    /**
     * @return the FechaVencimiento
     */
    public String getFechaVencimiento() {
        return FechaVencimiento;
    }

    /**
     * @param FechaVencimiento the FechaVencimiento to set
     */
    public void setFechaVencimiento(String FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    /**
     * @return the CSV
     */
    public String getCSV() {
        return CSV;
    }

    /**
     * @param CSV the CSV to set
     */
    public void setCSV(String CSV) {
        this.CSV = CSV;
    }
    
    
}
