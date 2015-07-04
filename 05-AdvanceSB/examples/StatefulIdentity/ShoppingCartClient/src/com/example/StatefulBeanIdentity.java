/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 *
 * @author Administrator
 */
public class StatefulBeanIdentity {
  private static StatefulCartBeanRemote Cart1;
   private static StatefulCartBeanRemote Cart2;
    public static void main(String args[])
    {
        
   String jndiPath = "java:global/ShoppingCartDemo/ShoppingCartDemo-ejb/StatefulCartBean"; 
 try {
   final Context cxt = getInitialContext();

 System.out.println( "looking up bean at: " + jndiPath);
  Cart1= (StatefulCartBeanRemote) cxt.lookup(jndiPath);
 Cart2= (StatefulCartBeanRemote) cxt.lookup(jndiPath);
 

   boolean result= Cart1.equals(Cart2);
System.out.println("Equality of Cart1 and Cart2 is: "+result);

}
 
 catch (Exception e)
 {
 System.err.println(" Could not find CartBeanRemote");
            System.err.println(" JNDI path used for lookup: " + jndiPath);
            e.printStackTrace();
        }
    }

 private static InitialContext getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://localhost:7001");
        return new InitialContext(env);
    }  
}
