package com.example.foodrecipes.utilities;

public class Constants {
    /**
     * ---------------------------------------------------------------------------------------------
     * ---------------------------------------- API ------------------------------------------------
     */
    public static final String BASE_URL = "https://recipesapi.herokuapp.com/api/";
    ;
    public static final String SERVICES_GET_SEARCH = BASE_URL + "search";
    public static final String SERVICES_GET_RECIPES = BASE_URL + "get";

    /**
     * ---------------------------------------------------------------------------------------------
     * ---------------------------------------- TIMER ------------------------------------------------
     */
    public static final int SPLASH_TIMER = 3000;
    public static final int NETWORK_TIMEOUT = 3000;


    /**
     * ---------------------------------------------------------------------------------------------
     * ---------------------------------------- CATEGORIES LIST ------------------------------------------------
     */
    public static final String[] DEFAULT_SEARCH_CATEGORIES =
            {"Barbeque", "Breakfast", "Chicken", "Beef", "Brunch", "Dinner", "Wine", "Italian"};

    public static final String[] DEFAULT_SEARCH_CATEGORY_IMAGES =
            {
                    "barbeque",
                    "breakfast",
                    "chicken",
                    "beef",
                    "brunch",
                    "dinner",
                    "wine",
                    "italian"
            };
}
