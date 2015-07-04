/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.Date;

import javax.ejb.*;


@Singleton
@LocalBean
public class DummyTimer {

    @Schedules({
    @Schedule(hour="*", minute="*", second="*/10"),
    @Schedule(hour="*", minute="*", second="*/45")
  })
  public void printTime(Timer timer) {
    System.out.println(getClass().getName() + ": " + new Date()+timer.getInfo());
  }
}

