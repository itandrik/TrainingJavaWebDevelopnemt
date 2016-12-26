package com.javaweb.Task6Pizza;

/**
 * @author Andrii Chernysh on 25-Dec-16. E-Mail : itcherry97@gmail.com
 */
public enum  Sauce implements Component{
    MIGNONETTE_SAUCE(0.1),
    MINT_SAUCE(0.15),
    MUSHROOM_KETCHUP(0.2),
    NORMANDE_SAUCE(0.25),
    PAN_SAUCE(0.3),
    PEPPERCORN_SAUCE(0.05),
    RAINBOW_SAUCE(0.07),
    RAVIGOTE_SAUCE(0.12),
    ROMESCO(0.5),
    SALAD_DRESSING(0.45),
    SALSA(0.01),
    SATZIBELI(0.24),
    SAUCE_ANDALOUSE(0.1);

    double price;

    Sauce(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Sauce : " + super.toString();
    }
}
