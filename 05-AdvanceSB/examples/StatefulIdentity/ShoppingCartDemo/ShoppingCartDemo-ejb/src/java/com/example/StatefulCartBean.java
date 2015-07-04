/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.ArrayList;
import javax.annotation.*;
import javax.ejb.*;


/**
 *
 * @author Administrator
 */
@Stateful
public class StatefulCartBean implements StatefulCartBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
public ArrayList cart; 

@PostConstruct 
public void initialize()
{
  cart=new ArrayList();
  System.out.print("\n"+"PostConstruct has been invoked" +"\n");
}
   
   public void addBook(String title) {
      cart.add(title);
   }

    
   public void removeBook(String title) 
   {
      boolean result = cart.remove(title);
      if (result == false) {
         System.out.println("not in cart.");
      }
   }

   public ArrayList getContents() {
      return cart;
   }  
  
   @PreDestroy
  public void exit()
  {
     System.out.print(" Predestroy has been called"+ "\n") ;
  }
   
  
   @Remove 
   public void checkout()
    {
          System.out.print("Remove  has been called" +"\n") ;
    }
    
}
