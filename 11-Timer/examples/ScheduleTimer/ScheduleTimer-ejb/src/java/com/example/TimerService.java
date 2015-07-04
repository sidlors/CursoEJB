
package com.example;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;




@Singleton
public class TimerService implements TimerServiceLocal {

  @EJB
    HelloServiceLocal helloService;
  
   @Schedule(second="*/1", minute="*",hour="*")
   public void doWork(){
        System.out.println("timer: " + helloService.sayHello());
    }
}

    

