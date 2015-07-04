/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beans;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
@Named
@RequestScoped

public class Customer implements Serializable
{
 

private String firstName;
private String lastName;

 public Customer() {
    }
public String getFirstName()
{
return firstName;
}
public void setFirstName(String firstName)
{
this.firstName = firstName;
}
public String getLastName()
{
return lastName;
}
public void setLastName(String lastName)
{
this.lastName = lastName;
}

}