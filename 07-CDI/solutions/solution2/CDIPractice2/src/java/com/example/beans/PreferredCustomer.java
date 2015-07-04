/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beans;
import com.example.qualifiers.Preferred;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
@Preferred
public class PreferredCustomer extends Customer{
    private int prefCode;
    public int getPrefCode()
    {
        return this.prefCode;
    }
    public void setPrefCode(int prefcode)
    {
        this.prefCode=prefcode;
    }
}
