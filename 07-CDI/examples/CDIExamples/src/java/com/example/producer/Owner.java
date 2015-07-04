package com.example.producer;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Owner {
    
    private Dog dog;
    
    @Inject
    public Owner(@MyPreferred Dog dog) {
        this.dog = dog;
    }
    
    public Dog getDog() {
        return dog;
    }
    
}