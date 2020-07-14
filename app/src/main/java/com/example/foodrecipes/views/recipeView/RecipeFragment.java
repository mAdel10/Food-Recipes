package com.example.foodrecipes.views.recipeView;


import android.util.Log;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.foodrecipes.R;
import com.example.foodrecipes.databinding.FragmentRecipeBinding;
import com.example.foodrecipes.models.Recipes;
import com.example.foodrecipes.views.BaseFragment;

import java.util.Objects;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class RecipeFragment extends BaseFragment {

    private FragmentRecipeBinding recipeBinding;
    private RecipeViewModel recipeViewModel;

    public RecipeFragment() {
        super(R.layout.fragment_recipe, false);
    }

    @Override
    protected void doOnCreate(View v) {
        recipeBinding = DataBindingUtil.bind(v);
        recipeViewModel = ViewModelProviders.of(requireActivity()).get(RecipeViewModel.class);

//        subscribeObservers();
        getIncomingData();
    }

    private void getIncomingData() {
        recipeViewModel.getRecipeInfoApi(getArguments().getString("id"));
    }

    private void subscribeObservers() {
        recipeViewModel.getRecipeInfo().observe(this, new Observer<Recipes>() {
            @Override
            public void onChanged(Recipes recipes) {
                if (recipes != null) {
                    Log.d(TAG, "onChanged: ....................................");
                    Log.d(TAG, "onChanged: " + recipes.getTitle());
                    for (String ingredient : recipes.getIngredients()) {
                        Log.d(TAG, "onChanged: " + ingredient);
                    }
                }
            }
        });
    }
}























































