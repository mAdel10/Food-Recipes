package com.example.foodrecipes.views.recipesListView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodrecipes.models.Recipes;

import java.util.List;

public class RecipesListViewModel extends ViewModel {

    private RecipesListRepository mRecipesListRepository;
    private boolean mIsViewingRecipes;
    private boolean mIsPerformingQuery;

    public RecipesListViewModel() {
        mIsViewingRecipes = false;
        mIsPerformingQuery = false;
        mRecipesListRepository = RecipesListRepository.getInstance();
    }

    public LiveData<List<Recipes>> getRecipes() {
        return mRecipesListRepository.getRecipes();
    }

    public void searchRecipesApi(String query, int pageNumber) {
        mIsViewingRecipes = true;
        mIsPerformingQuery = true;
        mRecipesListRepository.searchRecipesApi(query, pageNumber);
    }

    public boolean isViewingRecipes() {
        return mIsViewingRecipes;
    }

    public void setIsViewingRecipes(boolean isViewingRecipes) {
        mIsViewingRecipes = isViewingRecipes;
    }

    public void setIsPerformingQuery(boolean isPerformingQuery) {
        mIsPerformingQuery = isPerformingQuery;
    }

    public boolean isPerformingQuery() {
        return mIsPerformingQuery;
    }

    public boolean onBackPressed(){
        if (isPerformingQuery()){
            //cancelQuery
            mRecipesListRepository.cancelRequest();
            mIsPerformingQuery = false;
        }
        if (isViewingRecipes()){
            mIsViewingRecipes = true;
            return false;
        }
        return true;
    }

    public MutableLiveData<Boolean> isLoading() {
        return mRecipesListRepository.getIsLoading();
    }

    public MutableLiveData<String> errorMessage() {
        return mRecipesListRepository.getErrorMessage();
    }

}