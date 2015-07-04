/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.ArrayList;
import javax.ejb.Remove;
import javax.ejb.Stateless;

/**
 *
 * @author Administrator
 */
@Stateless
public class CartBean implements CartBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

 ArrayList cart=new ArrayList();

   


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
   
    
   @Remove 
   public void checkout()
    {
        
    }
}
