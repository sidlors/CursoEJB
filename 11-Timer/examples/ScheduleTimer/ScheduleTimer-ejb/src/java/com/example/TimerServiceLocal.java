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
public interface TimerServiceLocal {
     public void doWork();
}
