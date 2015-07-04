/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ejb.Singleton;
import com.example.SingletonHelloWorldBeanRemote;
import com.example.GreetingRequest;
import javax.ejb.Singleton;
import javax.ejb.Singleton;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import javax.ejb.*;

/**
 *
 * @author Administrator
 */


@Singleton
@DependsOn("TimeBasedHelloWorldBean")
public class SingletonHelloWorldBean implements SingletonHelloWorldBeanRemote {

    @EJB
    private TimeBasedHelloWorldBean timeBasedHelloWorldBean;
    private List<GreetingRequest> greetingRequests;

    public SingletonHelloWorldBean() {
        greetingRequests = new ArrayList<GreetingRequest>();
    }

    public GreetingRequest sayHello() {
        String greeting = timeBasedHelloWorldBean.sayHello();
        GreetingRequest request = new GreetingRequest(greeting);
        greetingRequests.add(request);
        return request;
    }

    public GreetingRequest[] auditRequests() {
        return greetingRequests.toArray(new GreetingRequest[]{});
    }

    @PreDestroy
    private void destroy() {
        System.out.println("helloworld.beans.SingletonHelloWorldBean: @PreDestroy");
        for (GreetingRequest gr : greetingRequests) {
            System.out.println(gr);
        }
        greetingRequests = null;
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("SingletonHelloWorldBean.postConstruct");
    }
    
}
