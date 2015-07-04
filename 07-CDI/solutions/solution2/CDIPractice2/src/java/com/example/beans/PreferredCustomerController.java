/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beans;
import com.example.qualifiers.Preferred;
import java.util.Random;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
@Named (value = "preferredCustomerController")
@RequestScoped
public class PreferredCustomerController {

@Inject
@Preferred
private Customer customer;
public String saveCustomer() {
PreferredCustomer preferredCustomer = (PreferredCustomer) customer;
preferredCustomer.setPrefCode(generatePrefCode());


// save
//customer data to the database here.
return "welcome1";
}
public Integer generatePrefCode()
{
return new Random().nextInt(100000);
}
}