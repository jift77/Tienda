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
public class Administrador {
    
    private static final String USER = "admin";
    private static final String PASS = "laclave";
    
    public static boolean Autenticar(String login, String password)
    {
        return (login.equals(USER) && password.equals(PASS));
    }
}
