/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ejb.Remote;

/**
 *
 * @author Administrator
 */
@Remote
public interface SingletonHelloWorldBeanRemote {
   GreetingRequest sayHello();

    GreetingRequest[] auditRequests();  
}
