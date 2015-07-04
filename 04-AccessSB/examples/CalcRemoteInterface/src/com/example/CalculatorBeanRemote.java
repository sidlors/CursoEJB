/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ejb.Remote;

/**
 *
 * @author Administrator
 */
@Remote
public interface CalculatorBeanRemote {
 public int add(int a, int b);
 public int subtract(int a, int b);
}
