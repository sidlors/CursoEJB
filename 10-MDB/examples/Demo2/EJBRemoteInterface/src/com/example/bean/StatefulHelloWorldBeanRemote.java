/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bean;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import java.util.*;

/**
 *
 * @author Administrator
 */
@Remote
public interface StatefulHelloWorldBeanRemote {
    

    GreetingRequest sayHello();

    GreetingRequest[] sayGoodBye();
    
}
