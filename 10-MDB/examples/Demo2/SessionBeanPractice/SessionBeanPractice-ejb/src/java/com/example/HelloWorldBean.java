/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Administrator
 */
@Stateless
public class HelloWorldBean implements HelloWorldBeanRemote {

    @EJB private TimeBasedHelloWorldBean timeBasedHelloWorldBean;  
  
    @Override
    public String sayHello() {
       return timeBasedHelloWorldBean.sayHello();
                
    }
     
    
    
    
  
}

    
