package com.example.foodrecipes.requests;

import com.example.foodrecipes.models.RecipeSearch;
import com.example.foodrecipes.models.Recipes;
import com.example.foodrecipes.utilities.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeApi {

    @GET(Constants.SERVICES_GET_SEARCH)
    Call<RecipeSearch> doGetRecipeSearch(
            @Query("q") String query,
            @Query("page") String page
    );

    @GET(Constants.SERVICES_GET_RECIPES)
    Call<Recipes> doGetRecipeById(
            @Query("rId") String recipeId
    );
}
