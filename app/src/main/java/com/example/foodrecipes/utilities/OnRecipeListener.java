package com.example.foodrecipes.utilities;

import com.example.foodrecipes.models.Recipes;

public interface OnRecipeListener {

    void onRecipeClick(Recipes r);

    void onCategoryClick(String category);
}