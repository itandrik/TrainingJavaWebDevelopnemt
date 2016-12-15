package com.javaweb.Task4Salad;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Andrii Chernysh on 15-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class Salad implements ISalad {
    /**
     * Value - quantity of ingredient
     */
    private Map<Ingredient, Integer> ingredientsAvailable;
    private List<Ingredient> salad = new ArrayList<>();;

    public Salad(Map<Ingredient, Integer> ingredientsAvailable) {
        this.ingredientsAvailable = ingredientsAvailable;
    }

    public Salad() {}

    @Override
    public void addIngredient(Ingredient ingredient) {
        if (checkAvailability(ingredient)) {
            salad.add(ingredient);
            ingredientsAvailable.put(ingredient,
                    ingredientsAvailable.get(ingredient) - 1);
        } else {
            System.out.println("No more ingredient " + ingredient.toString());
        }
    }

    @Override
    public void removeIngredient(Ingredient ingredient) {
        salad.remove(ingredient);
        ingredientsAvailable.put(ingredient,
                ingredientsAvailable.get(ingredient) + 1);
    }

    @Override
    public boolean checkAvailability(Ingredient ingredient) {
        return (ingredientsAvailable.containsKey(ingredient) &&
                ingredientsAvailable.get(ingredient) > 0);
    }

    @Override
    public void showSalad() {
        System.out.println("Ingredients of this salad : \n");
        salad.forEach(elem-> System.out.println("\t" + elem + ","));
    }

    @Override
    public Map<Ingredient, Integer> getIngredientsAvailable() {
        return ingredientsAvailable;
    }

    public void setIngredientsAvailable(Map<Ingredient, Integer> ingredientsAvailable) {
        this.ingredientsAvailable = ingredientsAvailable;
    }

    public static class Builder {
        Salad salad = new Salad();

        public Builder setIngredientsAvailable(
                Map<Ingredient, Integer> ingredientsAvailable) {
            salad.setIngredientsAvailable(ingredientsAvailable);
            return this;
        }

        public Builder addIngredient(Ingredient ingredient) {
            salad.addIngredient(ingredient);
            return this;
        }

        public Builder removeIngredient(Ingredient ingredient) {
            salad.removeIngredient(ingredient);
            return this;
        }

        public Salad build() {
            return salad;
        }
    }
}
