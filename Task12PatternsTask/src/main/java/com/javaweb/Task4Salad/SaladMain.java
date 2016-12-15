package com.javaweb.Task4Salad;

/**
 * @author Andrii Chernysh on 15-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class SaladMain {
    public static void main(String[] args) {
        IngredientsStorage storage = new IngredientsStorage();
        storage.addIngredient(Ingredient.CABBAGE,5)
                .addIngredient(Ingredient.CUCUMBER,2)
                .addIngredient(Ingredient.PORK,4)
                .addIngredient(Ingredient.CABBAGE,30)
                .addIngredient(Ingredient.OIL,2)
                .addIngredient(Ingredient.POTATO,45)
                .addIngredient(Ingredient.PEPPER,1);

        Salad salad = new Salad.Builder()
                .setIngredientsAvailable(storage.getIngredients())
                .addIngredient(Ingredient.CABBAGE)
                .addIngredient(Ingredient.CABBAGE)
                .addIngredient(Ingredient.PORK)
                .addIngredient(Ingredient.OIL)
                .addIngredient(Ingredient.PEPPER)
                .build();
        storage.setIngredients(salad.getIngredientsAvailable());
        salad.showSalad();
    }
}
