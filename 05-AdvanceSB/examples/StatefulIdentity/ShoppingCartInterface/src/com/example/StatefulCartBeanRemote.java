/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author Administrator
 */
@Remote
public interface StatefulCartBeanRemote {
     public void addBook(String title);
   public void removeBook(String title);
   public ArrayList getContents();
   public void checkout();
}
