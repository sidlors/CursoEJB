/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;

@Singleton
@LocalBean
@Startup
public class PeriodicTimer {

    @Resource
    TimerService timerService;

    @PostConstruct
    public void initialize() {
        ScheduleExpression expression = new ScheduleExpression();
        expression.second("*/1").minute("*").hour("*");
        timerService.createCalendarTimer(expression);
    }

    @Timeout
    public void execute() {
        System.out.println("invoked"+ System.currentTimeMillis());
    }
}
