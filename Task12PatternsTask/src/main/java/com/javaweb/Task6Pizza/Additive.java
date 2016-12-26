package com.javaweb.Task6Pizza;

/**
 * @author Andrii Chernysh on 25-Dec-16. E-Mail : itcherry97@gmail.com
 */
public enum Additive implements Component{
    KETCHUP(0.75),
    MUSHROOMS(1.75),
    CORN(0.5),
    SAUSAGES(3),
    TOMATOES(1),
    CHEESE(2),
    PINEAPPLE(2),
    SALMON(5);

    double price;

    Additive(double priceAdditive) {
        this.price = priceAdditive;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Additive : " + super.toString();
    }
}
