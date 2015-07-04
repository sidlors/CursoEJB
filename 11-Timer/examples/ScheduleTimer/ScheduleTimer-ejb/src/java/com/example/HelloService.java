/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ejb.Stateless;

/**
 *
 * @author anshenoy
 */
@Stateless
public class HelloService implements HelloServiceLocal {

  
    public String sayHello(){
        return "Hello from control: " + System.currentTimeMillis();
    }

}
