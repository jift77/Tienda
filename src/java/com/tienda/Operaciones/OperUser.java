/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.Operaciones;

import com.tienda.entidades.User;

/**
 *
 * @author georg
 */
public class OperUser {
    
    private static final String LOGIN = "admin";
    private static final String PASS = "laclave";
    
    public boolean autenticar(User user)
    {
        return user.getLogin().equals(LOGIN) && user.getClave().equals(PASS);
    }
}
