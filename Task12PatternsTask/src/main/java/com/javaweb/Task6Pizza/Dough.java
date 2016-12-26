package com.javaweb.Task6Pizza;

/**
 * @author Andrii Chernysh on 25-Dec-16. E-Mail : itcherry97@gmail.com
 */
public enum Dough implements Component{
    NINE_GRAIN_WHEAT(3.2),
    MULTIGRAIN_FLATBREAD(3),
    ITALIAN(4),
    ITALIAN_HERBS_AND_CHEESE(3.2),
    RYE_BREAD(1.5),
    FLAT(1.5);

    double price;

    Dough(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Dough : " + super.toString();
    }
}
