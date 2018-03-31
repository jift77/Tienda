/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.rest;

import com.tienda.Operaciones.OperUser;
import com.tienda.entidades.User;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sun.misc.BASE64Decoder;

/**
 *
 * @author georg
 */
@Path("user")
public class UserRest {
    
    @Path("autenticar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response autenticar(User user)
    {
        boolean result = new OperUser().autenticar(user);
        return Response.status(200).entity(result).build();
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String datos(@HeaderParam("authorization") String authString)
    {
        return isUserAuthenticated(authString);
    }
    
    private String isUserAuthenticated(String authString){
         
        String decodedAuth = "";
        // Header is in the format "Basic 5tyc0uiDat4"
        // We need to extract data before decoding it back to original string
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];
        // Decode the data back to original string
        byte[] bytes = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(authInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        decodedAuth = new String(bytes);
        System.out.println(decodedAuth);
         
        /**
         * here you include your logic to validate user authentication.
         * it can be using ldap, or token exchange mechanism or your 
         * custom authentication mechanism.
         */
        // your validation code goes here....
         
        return decodedAuth;
    }
}
