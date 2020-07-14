package com.example.foodrecipes.views.recipeView;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.foodrecipes.models.Recipes;
import com.example.foodrecipes.requests.RecipeApi;
import com.example.foodrecipes.requests.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class RecipeRepository {

    private static RecipeRepository instance;
    private MutableLiveData<Recipes> mRecipeInfo;
    private static RecipeApi api;
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public static RecipeRepository getInstance(){
        if (instance == null){
            instance = new RecipeRepository();
            api = ServiceGenerator.getInstance();
        }
        return instance;
    }

    private RecipeRepository(){
        mRecipeInfo = new MutableLiveData<>();
    }

    public LiveData<Recipes> getRecipeInfo(){
        return mRecipeInfo;
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public void getRecipeInfoApi(String id){
        isLoading.setValue(true);
        api.doGetRecipeById(id).enqueue(new Callback<Recipes>() {
            @Override
            public void onResponse(Call<Recipes> call, Response<Recipes> response) {
                if (response.code() == 200){
                    mRecipeInfo.setValue(response.body());
                    Log.d(TAG, "onResponse: " + response);
                }
                isLoading.setValue(false);
            }

            @Override
            public void onFailure(Call<Recipes> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
                isLoading.setValue(false);
                errorMessage.setValue(t.getMessage());
            }
        });
    }
}
