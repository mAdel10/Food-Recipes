package com.example.foodrecipes.views.recipeView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodrecipes.models.Recipes;

public class RecipeViewModel extends ViewModel {

    private RecipeRepository mRecipeInfoRepository;

    public RecipeViewModel() {
        mRecipeInfoRepository = RecipeRepository.getInstance();
    }

    public LiveData<Recipes> getRecipeInfo(){
        return mRecipeInfoRepository.getRecipeInfo();
    }

    public MutableLiveData<Boolean> isLoading() {
        return mRecipeInfoRepository.getIsLoading();
    }

    public MutableLiveData<String> errorMessage() {
        return mRecipeInfoRepository.getErrorMessage();
    }

    public void getRecipeInfoApi(String id){
        mRecipeInfoRepository.getRecipeInfoApi(id);
    }

}
