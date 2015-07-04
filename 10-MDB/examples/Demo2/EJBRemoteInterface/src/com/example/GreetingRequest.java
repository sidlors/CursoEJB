/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;
    
 import java.util.Calendar;
 import java.text.SimpleDateFormat;
 import java.io.Serializable;
/**
 *
 * @author Administrator
 */
public class GreetingRequest implements Serializable {
    private Calendar requestTime;
 private String greeting;

 public GreetingRequest(String greet) {
requestTime = Calendar.getInstance();
 greeting = greet;
 }
 public String toString() {
SimpleDateFormat dateFormat = new SimpleDateFormat();
 String dateAsStr = dateFormat.format(requestTime.getTime());
 return "com.example.GreetingRequest [requestTime="+ dateAsStr+ ",greeting="+greeting+"]";
 }

}
