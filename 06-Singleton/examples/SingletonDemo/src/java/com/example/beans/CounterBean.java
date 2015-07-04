/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beans;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;


/**
 * CounterBean is a simple singleton session bean that records the number
 * of hits to a web page.
 */
@Singleton

public class CounterBean implements CounterBeanLocal {

   private int hits = 1;

    // Increment and return the number of hits
    @Lock(LockType.READ)
    public int getHits() {
        
        return hits++;
    }
}
    

