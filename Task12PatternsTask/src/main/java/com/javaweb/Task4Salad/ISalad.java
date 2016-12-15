package com.javaweb.Task4Salad;

import java.util.Map;

/**
 * @author Andrii Chernysh on 15-Dec-16. E-Mail : itcherry97@gmail.com
 */
public interface ISalad {
    void addIngredient(Ingredient ingredient);
    void removeIngredient(Ingredient ingredient);
    boolean checkAvailability(Ingredient ingredient);
    void showSalad();
    Map<Ingredient, Integer> getIngredientsAvailable();
}
