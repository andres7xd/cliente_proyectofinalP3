/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.cliente_aeropuerto.Service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import org.una.cliente_aeropuerto.DTO.AuthenticationRequest;
import org.una.cliente_aeropuerto.Utils.ConnectionUtils;

/**
 *
 * @author Andres
 */
public class UsuarioService {
    private final String urlstringLogin = "http://localhost:8098/authentication/login";
    
    
     public void Login(AuthenticationRequest object) throws InterruptedException, ExecutionException, IOException {
        ConnectionUtils.ObjectToConnectionLogin(urlstringLogin, object);

    }
     
      public static UsuarioService getInstance() {
        return UsuarioServiceHolder.INSTANCE;
    }
      
         private static class UsuarioServiceHolder {

        private static final UsuarioService INSTANCE = new UsuarioService();
    }

}
