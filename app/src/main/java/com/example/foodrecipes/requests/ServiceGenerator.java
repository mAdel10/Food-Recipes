package com.example.foodrecipes.requests;

import com.example.foodrecipes.utilities.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static RecipeApi instance;

    public static RecipeApi getInstance() {
//        context = cont;
//        if (recipeApi == null) {
//            int cacheSize = 10 * 1024 * 1024; // 10 MB
//            Cache cache = new Cache(context.getCacheDir(), cacheSize);
//
//            OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                    .cache(cache)
//                    .build();
//        }
        if (instance == null) {
            instance = new Retrofit
                    .Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    //.client(okHttpClient)
                    .build()
                    .create(RecipeApi.class);

        }
        return instance;
    }
}
