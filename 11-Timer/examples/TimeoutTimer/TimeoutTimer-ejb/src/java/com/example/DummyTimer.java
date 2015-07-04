/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;


/**
 *
 * @author anshenoy
 */
@Singleton
@Startup
public class DummyTimer implements DummyTimerLocal {

    
  @Resource TimerService timerService;
 
  @PostConstruct
  public void initTimer() {
    if (timerService.getTimers() != null) {
      for (Timer timer : timerService.getTimers()) {
        if (timer.getInfo().equals("dummyTimer1") ||
            timer.getInfo().equals("dummyTimer2")) 
          timer.cancel();
      }
    }
    
     ScheduleExpression expression = new ScheduleExpression();
        expression.second("*/10").minute("*").hour("*");
        timerService.createCalendarTimer(expression,new TimerConfig("dummyTimer1", true));
        
               
       ScheduleExpression expression1 = new ScheduleExpression();
        expression1.second("*/45").minute("*").hour("*");
        timerService.createCalendarTimer(expression,new TimerConfig("dummyTimer2", true));
           
     
     
    
  }
  @Timeout
  public void timeout(Timer timer) {
    System.out.println(getClass().getName() + ": " + new Date());
  }
}

