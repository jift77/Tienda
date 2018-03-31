/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.beans.Admin;

import com.tienda.Operaciones.OperUser;
import com.tienda.entidades.User;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author georg
 */
public class Logon implements Serializable{
    private String usuario;
    private String clave;
    
    public String sigin()
    {
        boolean res = true;

        User admin = new User();
        admin.setClave(clave);
        admin.setLogin(usuario);
        
        if(!new OperUser().autenticar(admin))
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "usuario o clave incorrectos"));
            res = false;
        }
            
        if(res)
            return "productos";
        
        return null;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
}
