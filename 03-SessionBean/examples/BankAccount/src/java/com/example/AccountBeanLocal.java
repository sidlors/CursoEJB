/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ejb.Local;

/**
 *
 * @author anshenoy
 */
@Local
public interface AccountBeanLocal {
    public float deposit(float amount);
     public float withdraw(float amount);
}
