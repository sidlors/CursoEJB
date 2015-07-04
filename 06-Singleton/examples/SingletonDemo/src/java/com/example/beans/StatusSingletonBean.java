/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beans;

import javax.ejb.*;

/**
 *
 * @author admin
 */
@ConcurrencyManagement(javax.ejb.ConcurrencyManagementType.CONTAINER)
@AccessTimeout(value=120000)
@Singleton
@LocalBean
public class StatusSingletonBean {

    private String status;
    
 

   @Lock(javax.ejb.LockType.READ)
      public String getState() {
          return status;
         }
    
 @Lock(javax.ejb.LockType.WRITE)
     public void setState(String newStatus) {
           status = newStatus;
          }


@Lock(javax.ejb.LockType.WRITE)
@AccessTimeout(value=360000)
public void doLongRunningOperation(){
    // some operation that takes time
}
}


