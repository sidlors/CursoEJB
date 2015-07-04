/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ejb.Stateful;

import com.example.StatefulHelloWorldBeanRemote;
import com.example.GreetingRequest;
import javax.ejb.Stateful;
import javax.ejb.EJB;
import javax.ejb.Remove;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
/**
 *
 * @author Administrator
 */
@Stateful
public class StatefulHelloWorldBean implements StatefulHelloWorldBeanRemote {

     @EJB
    private TimeBasedHelloWorldBean timeBasedHelloWorldBean;
    private List<GreetingRequest> greetingRequests;

    public StatefulHelloWorldBean() {
        greetingRequests = new ArrayList<GreetingRequest>();
    }

  
    @Override
    public GreetingRequest sayHello() {
        String greeting = timeBasedHelloWorldBean.sayHello();
        GreetingRequest request = new GreetingRequest(greeting);
        greetingRequests.add(request);
        return request;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
    @Override
    @Remove
    public GreetingRequest[] sayGoodBye() {

        return greetingRequests.toArray(new GreetingRequest[]{});


    }
private void printList() {
System.out.println("helloworld.beans.StatefulHelloWorldBean:greetingRequests.size - " + greetingRequests.size());
for(GreetingRequest gr : greetingRequests) {
System.out.println("helloworld.beans.StatefulHelloWorldBean: " + gr);
}
}
 @PrePassivate
  private void deinitialize() {
    System.out.println("helloworld.beans.StatefulHelloWorldBean: @PrePassivate");
    printList();
  }


  @PreDestroy
  private void destroy() {
    System.out.println("helloworld.beans.StatefulHelloWorldBean: @PreDestroy");
  }

  @PostConstruct
  @PostActivate
  private void initialize() {
    System.out.println("helloworld.beans.StatefulHelloWorldBean: @PostConstruct or @PostActivate");
    printList();
  }



} 
    



