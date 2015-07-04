package com.example;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CallerBean {
    
    @Inject RestrictedSessionBean rsb;
    
    public String getResult() {
        return rsb.test();
    }
    
}