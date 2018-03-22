/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.entidades;

import com.tienda.beans.Cliente.TarjetaCredito;

/**
 *
 * @author georg
 */
public class Cliente {
    private String Nombres;
    private String Direccion;
    private String Email;
    private String Telefono;
    private TarjetaCredito TarjetaCredito;

    /**
     * @return the Nombres
     */
    public String getNombres() {
        return Nombres;
    }

    /**
     * @param Nombres the Nombres to set
     */
    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    /**
     * @return the Direccion
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the TarjetaCredito
     */
    public TarjetaCredito getTarjetaCredito() {
        return TarjetaCredito;
    }

    /**
     * @param TarjetaCredito the TarjetaCredito to set
     */
    public void setTarjetaCredito(TarjetaCredito TarjetaCredito) {
        this.TarjetaCredito = TarjetaCredito;
    }
    
}
