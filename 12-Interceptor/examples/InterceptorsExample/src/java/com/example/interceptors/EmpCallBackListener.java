/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.interceptors;

import javax.annotation.PreDestroy;
import javax.interceptor.InvocationContext;

/**
 *
 * @author admin
 */

public class EmpCallBackListener {
    public EmpCallBackListener() {} // public no-arg constructor
 // callback interceptor method				 Interceptor class
 @PreDestroy
 private void endEmployee(InvocationContext ic) throws Exception {
try { 
       ic.proceed(); 

} finally { 
      System.out.println(" exiting     :"+ ic.getTarget().toString()+"  "+ ic.getMethod().getName()); 
    } 
}
    
}
