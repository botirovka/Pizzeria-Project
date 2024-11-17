package org.example.cppprojectui.models;

public class Pizza {
    private String name;
    private PizzaState state;
    private int cookingTime;

    public Pizza(String name, PizzaState state, int cookingTime) {
        this.name = name;
        this.state = state;
        this.cookingTime = cookingTime;
    }

    public String getName(){
        return name;
    }

    public PizzaState getState(){
        return state;
    }

    public void setState(PizzaState state) {
        this.state = state;
    }

    public int getCookingTime(){
        return cookingTime;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
