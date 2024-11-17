package org.example.cppprojectui.models;

import org.example.cppprojectui.data.DataService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Client {
    private String name;
    private final Random random = new Random();
    private Order order;
    private DataService dataService;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Order getOrder(){
        return order;
    }

    public void createOrder(int clientQueueSize){
        int pizzaCount = random.nextInt(1, 6); // Випадкова кількість піц (1 до 5)
        ArrayList<Pizza> pizzas = new ArrayList<>();
        List<Pizza> availablePizzas = DataService.getPizzaList();
        //TO DO
        //ЧАС
        int time = 30;

        for (int i = 0; i < pizzaCount; i++) {
            Pizza randomPizza = availablePizzas.get(random.nextInt(availablePizzas.size()));
            pizzas.add(new Pizza(randomPizza.getName(), PizzaState.Awaiting_Preparation, time));
        }

        this.order = new Order(pizzas, this, clientQueueSize);
    }



    public CashRegister chooseCashRegister(List<CashRegister> cashRegisters){
        // Порівнюємо каси за кількістю клієнтів, якщо кількість однакова, то за id
        CashRegister chosenRegister = cashRegisters.stream()
                .min(Comparator.comparingInt((CashRegister r) -> r.getClientQueueSize())
                        .thenComparingInt(r -> r.getId()))
                .orElse(null); // Якщо список порожній, повертається null
        return chosenRegister;
    }
}
