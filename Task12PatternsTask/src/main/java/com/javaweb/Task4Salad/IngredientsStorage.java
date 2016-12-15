package com.javaweb.Task4Salad;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andrii Chernysh on 15-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class IngredientsStorage {
    private Map<Ingredient, Integer> ingredients;

    public IngredientsStorage() {
        this.ingredients = new HashMap<>();
    }

    public IngredientsStorage addIngredient(Ingredient ingredient, int quantity){
        ingredients.put(ingredient,quantity);
        return this;
    }

    public void setIngredients(Map<Ingredient, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public Map<Ingredient, Integer> getIngredients(){
        return ingredients;
    }

}
