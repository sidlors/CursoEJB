/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ejb.Stateless;

/**
 *
 * @author Administrator
 */
@Stateless
public class CalculatorBean implements CalculatorBeanRemote {

     public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
}
