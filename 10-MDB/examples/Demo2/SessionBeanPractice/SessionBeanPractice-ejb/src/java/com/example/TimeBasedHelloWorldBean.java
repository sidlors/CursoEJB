/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import  java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class TimeBasedHelloWorldBean {
public String sayHello() {
        String greeting = "Zzzzzzz";
        Calendar cal = Calendar.getInstance();
        int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
        if (hourOfDay > 6 && hourOfDay < 12) {
            greeting = "Good Morning";
        } else if (hourOfDay >= 12 && hourOfDay < 16) {
            greeting = "Good Afternoon";
        } else if (hourOfDay >= 16 && hourOfDay < 19) {
            greeting = "Good Evening";
        } else if (hourOfDay >= 19 && hourOfDay < 22) {
            greeting = "Good Night";
        }
        return greeting;
    }
@PostConstruct
private void postConstruct() {
System.out.println("TimeBasedHelloWorldBean.postConstruct");
}
}

