package com.example.producer;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class PetShop {   
    @Produces @MyPreferred @RequestScoped @Named
    public static Dog getDog() {
        Dog d = new Poodle("Fido");
        d.setWeight(42);
        return d;
    }
}