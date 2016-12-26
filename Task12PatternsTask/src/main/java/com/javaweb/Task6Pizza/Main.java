package com.javaweb.Task6Pizza;

/**
 * @author Andrii Chernysh on 25-Dec-16.
 *         E-Mail : itcherry97@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.Builder("Margarita")
                .addDough(Dough.RYE_BREAD)
                .addSauce(Sauce.PEPPERCORN_SAUCE)
                .addSauce(Sauce.MINT_SAUCE)
                .addAdditive(Additive.CHEESE)
                .addAdditive(Additive.PINEAPPLE)
                .addAdditive(Additive.CORN)
                .addAdditive(Additive.MUSHROOMS)
                .build();

        pizza.printComponents();
        System.out.println("Price : $" + pizza.getPrice() +
                " + $" + pizza.getProfit() + "(profit) = $"
                + (pizza.getPrice() + pizza.getProfit()));

    }
}
