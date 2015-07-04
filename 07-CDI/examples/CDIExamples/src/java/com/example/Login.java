/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;


import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author admin
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {
    @Inject private UserToken utoken; 

    /**
     * Creates a new instance of Login
     */
    public Login() {
    }
    public String checkUser(){
        String message;
// check email id and password
        

   return "verified";
}

}
