/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ejb.Stateless;

@Stateless
public class SayHelloSessionBean implements SayHelloSessionBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
   public String sayHello(String name) {
        return "Hello  " + name;
    } 
    
}

