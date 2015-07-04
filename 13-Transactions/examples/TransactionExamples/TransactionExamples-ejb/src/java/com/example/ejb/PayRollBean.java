/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author admin
 */
@Stateless
public class PayRollBean implements PayRollBeanLocal {

   @TransactionAttribute(TransactionAttributeType.MANDATORY)
  public void setBenefitsDeduction(int empId, double  deduction) {}
 @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public double getBenefitsDeduction(int empId) {
 return 128;
 }

public double getSalary(int empid) {
return 5678;
}

@TransactionAttribute(TransactionAttributeType.MANDATORY)
 public void setSalary(int empId, double salary) {}
}

