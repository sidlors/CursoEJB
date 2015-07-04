package com.example.producer;

public class Poodle implements Dog {
    
    private String name;
    private int weight;
    
    public Poodle(String name) {
        this.name = name;
    }
    
    @Override
    public void setWeight(int w) {
        this.weight = w;
    }
    
    @Override
    public int getWeight() {
        return weight;
    }
    
    @Override
    public String getName() {
        return name;
    }

}