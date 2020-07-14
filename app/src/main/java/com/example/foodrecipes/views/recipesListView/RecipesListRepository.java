package com.example.foodrecipes.views.recipesListView;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.foodrecipes.models.RecipeSearch;
import com.example.foodrecipes.models.Recipes;
import com.example.foodrecipes.requests.RecipeApi;
import com.example.foodrecipes.requests.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipesListRepository {

    private static final String TAG = "RecipesListRepository";
    private static RecipesListRepository instance;
    private MutableLiveData<List<Recipes>> mRecipes;
    private static RecipeApi api;
    private boolean cancelRequest;
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public static RecipesListRepository getInstance() {
        if (instance == null) {
            instance = new RecipesListRepository();
            api = ServiceGenerator.getInstance();
        }
        return instance;
    }

    private RecipesListRepository() {
        mRecipes = new MutableLiveData<>();
    }

    public LiveData<List<Recipes>> getRecipes() {
        return mRecipes;
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public void searchRecipesApi(String query, int pageNumber) {
        isLoading.setValue(true);
        api.doGetRecipeSearch(query, String.valueOf(pageNumber)).enqueue(new Callback<RecipeSearch>() {
            @Override
            public void onResponse(Call<RecipeSearch> call, Response<RecipeSearch> response) {
               if (response.code() == 200) {
                    mRecipes.setValue(response.body().getRecipes());
                    Log.d(TAG, "onResponse: " + response);
                }
                isLoading.setValue(false);
            }

            @Override
            public void onFailure(Call<RecipeSearch> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
                isLoading.setValue(false);
                errorMessage.setValue(t.getMessage());
            }
        });
    }

    public void cancelRequest(){
        Log.d(TAG, "cancelRequest: Canceling The Search Request");
        cancelRequest = true;
    }
}
