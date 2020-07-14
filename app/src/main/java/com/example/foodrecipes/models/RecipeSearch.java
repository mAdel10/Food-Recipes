package com.example.foodrecipes.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class RecipeSearch implements Serializable {

    @SerializedName("count")
    @Expose
    private int count;


    @SerializedName("recipes")
    @Expose
    private List<Recipes> recipes;

    public RecipeSearch() {
    }

    public RecipeSearch(int count, List<Recipes> recipes) {
        this.count = count;
        this.recipes = recipes;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Recipes> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipes> recipes) {
        this.recipes = recipes;
    }


    @Override
    public String toString() {
        return "RecipeSearch{" +
                "count=" + count +
                ", recipes=" + recipes +
//                ", recipe=" + recipe +
                '}';
    }
}
