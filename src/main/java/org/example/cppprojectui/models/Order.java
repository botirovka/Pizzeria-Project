package org.example.cppprojectui.models;

import java.util.ArrayList;

public class Order {
    private ArrayList<Pizza> pizzas;
    private Client client;
    private int orderNumber;

    public Order(){
        //delete
    }

    public Order(ArrayList<Pizza> pizzas, Client client, int orderNumber) {
        this.pizzas = pizzas;
        this.client = client;
        this.orderNumber = orderNumber;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }
    public OrderState getState() {
        int states = 0;
        for(Pizza pizza : pizzas) {
            if(pizza.getState() != PizzaState.Awaiting_Preparation && pizza.getState() != PizzaState.Ready){
                states += pizzas.size() + 1; // if one of the pizzas is not awaiting preparation or not ready
                //states always will be bigger that pizzas.size()
            } else if (pizza.getState() == PizzaState.Ready) {
                ++states;
            }
        }

        if (states == pizzas.size()) { return OrderState.Done; }
        if (states > pizzas.size())  { return OrderState.In_Progress; }
        return OrderState.Waiting;
    }

    @Override
    public String toString() {
        return "Order{" + "pizzas=" + pizzas  + "ID=" + orderNumber + '}';
    }

    public Client getClient() {
        return client;
    }
    public int getOrderNumber() {
        return orderNumber;
    }
}