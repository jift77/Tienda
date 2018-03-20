/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.beans.Admin;

import com.tienda.TestOperaciones.OperCategoria;
import com.tienda.entidades.Categoria;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author georg
 */
@FacesConverter("categoriaConverter")
public class CategoriaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0)
        {
            try
            {
                Bodega bod = (Bodega)fc.getExternalContext().getSessionMap().get("bodega");
                return bod.ConsultarCategoria(Integer.parseInt(value));
            }
            catch(NumberFormatException e)
            {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion error", "Not a valid categoria"));
            }
        }
        return null; 
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o != null)
            return String.valueOf(((Categoria)o).getCategoria_Id());
        else
            return null;
    }
}
