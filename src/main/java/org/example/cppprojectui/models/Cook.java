package org.example.cppprojectui.models;

public class Cook {
    private String name;
    private CookStrategy strategy;
    private CookState state;

    public Cook(String name, CookStrategy strategy, CookState state) {
        this.name = name;
        this.strategy = strategy;
        this.state = state;
    }

    public void preparePizza(Pizza pizza) {
        try {
            // Симуляція процесу приготування
            setState(CookState.Active);
            Thread.sleep(1000); // Підготовка тіста

            pizza.setState(PizzaState.Preparing_Dough);

            pizza.setState(PizzaState.Adding_Ingredients);
            Thread.sleep(1000); // Додавання інгредієнтів

            pizza.setState(PizzaState.Baking);
            Thread.sleep(pizza.getCookingTime() * 1000); // Випікання

            pizza.setState(PizzaState.Packaging);
            Thread.sleep(500); // Пакування


            pizza.setState(PizzaState.Ready);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //setters
    public void setState(CookState state) {
        this.state = state;
    }
    public void setStrategy(CookStrategy strategy) {
        this.strategy = strategy;
    }
    public void setName(String name) {
        this.name = name;
    }

    //getters
    public String getName() {
        return name;
    }
    public CookStrategy getStrategy() {
        return strategy;
    }
    public CookState getState() {
        return state;
    }
}

