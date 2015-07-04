/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ejb.Stateful;

/**
 *
 * @author anshenoy
 */
@Stateful
public class AccountBean implements AccountBeanLocal {
float balance = 0;

  public float deposit(float amount){
  balance += amount;
  return balance;
  }
  public float withdraw(float amount){
  balance -= amount;
  return balance;
  }
   
}
