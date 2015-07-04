/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author admin
 */
public class EmployeeAudit {
     @AroundInvoke 
  private Object logMethod(InvocationContext ic) throws Exception { 
    System.out.println(ic.getTarget().toString()+"  "+ ic.getMethod().getName()); 
    try { 
      return ic.proceed(); 
    } finally { 
      System.out.println(" exiting"+ ic.getTarget().toString()+"  "+ ic.getMethod().getName()); 
    } 
  } 
}
