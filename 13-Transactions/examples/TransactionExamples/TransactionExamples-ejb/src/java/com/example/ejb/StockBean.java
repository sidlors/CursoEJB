/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ejb;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author admin
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class StockBean implements StockBeanLocal {
    @Resource UserTransaction ut;

    public void updateStock(String symbol, double price) throws Exception {


  try {

ut.begin();
//Query q=em.createNamedQuery(“UpdateStockPrice”);
//q.setParameter(“symbol”,”AOL”);
//Stock stock = q.getSingleResult();
// stock.setPrice(40);
  }catch (Exception ex){}
 try {
  ut.commit();
  
    ut.rollback();
  } catch (SystemException syex) {
      throw new EJBException ("Rollback failed: "+ syex.getMessage());
  }


  }
}