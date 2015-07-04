/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Schedule;
import javax.ejb.Timer;

/**
 *
 * @author anshenoy
 */
@Singleton
@LocalBean
public class TimerBean {
private int count = 0;
  private List<String> list = new ArrayList<String>();
  
  /**
   * This method is executed by automated timer schedule.
   * It will be executed since this bean is instantiated, 
   * and it will be executed only 5 times, then terminate by itself.
   */
  @Schedule(hour = "*", minute = "*", second = "*/1", info = "called by automated timer schedule!")
  public void timedWork(Timer t) {
    
    //This scheduled method will be invoked only 5 times
    if (count < 5) {
      ++count;
      list.add("Timeout at " + new Date() + " for the " + 
        count + ((count>1) ? " times " : " time ") + t.getInfo());
    }
    else t.cancel();       /* stop the scheduled work */
  }
  
  public List<String> getList() {
    return list;
  }


    
}
