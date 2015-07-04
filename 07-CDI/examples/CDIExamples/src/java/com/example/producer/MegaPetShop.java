package com.example.producer;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@Alternative
public class MegaPetShop {   
    @Produces @MyPreferred @RequestScoped @Named
    public static Dog getDog() {
        Dog d = new Poodle("Fedo");
        d.setWeight(420);
        return d;
    }
}