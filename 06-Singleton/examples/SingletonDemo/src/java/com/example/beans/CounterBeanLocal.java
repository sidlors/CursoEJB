/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beans;

import javax.ejb.Local;

/**
 *
 * @author anshenoy
 */
@Local
public interface CounterBeanLocal {
    public int getHits();
}
