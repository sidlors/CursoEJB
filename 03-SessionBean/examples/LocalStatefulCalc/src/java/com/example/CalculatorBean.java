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
public class CalculatorBean implements CalculatorBeanLocal {
int result=0;
     
public int add(int a) {
 result= result+a;
  return result;
 }

public int subtract(int a) {
 result=result-a;
return result;
  }

    
}
