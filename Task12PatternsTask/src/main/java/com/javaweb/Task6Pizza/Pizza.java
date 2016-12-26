package com.javaweb.Task6Pizza;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrii Chernysh on 25-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class Pizza implements Component {
    private static final int PROFIT_IN_PERCENTS = 15;
    private List<Component> components;
    private String name;

    public Pizza(String name) {
        this.name = name;
        components = new ArrayList<>();
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    public void printComponents() {
        System.out.println("Pizza \'" + name + "\';");
        System.out.println("Components : ");
        for (Component component : components) {
            System.out.println("\t" + component.toString());
        }
    }

    @Override
    public double getPrice() {
        return components.stream().mapToDouble(Component::getPrice).sum();
    }

    public double getProfit(){
        return getPrice() * PROFIT_IN_PERCENTS / 100;
    }

    public static class Builder {
        private Pizza pizza;

        public Builder(String name) {
            pizza = new Pizza(name);
        }

        public Builder addDough(Dough dough) {
            pizza.addComponent(dough);
            return this;
        }

        public Builder addSauce(Sauce sauce) {
            pizza.addComponent(sauce);
            return this;
        }

        public Builder addAdditive(Additive additive) {
            pizza.addComponent(additive);
            return this;
        }

        public Pizza build() {
            return pizza;
        }
    }
}
