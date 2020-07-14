package com.example.foodrecipes.views.recipesListView;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodrecipes.utilities.OnRecipeListener;
import com.example.foodrecipes.databinding.ItemRecipeListBinding;
import com.example.foodrecipes.models.Recipes;

public class RecipesListHolder extends RecyclerView.ViewHolder {

    private ItemRecipeListBinding itemRecipeListBinding;
    private OnRecipeListener onRecipeListener;

    public RecipesListHolder(@NonNull ItemRecipeListBinding itemView) {
        super(itemView.getRoot());
        itemRecipeListBinding = itemView;
        //this.onRecipeListener = onRecipeListener;
//        itemRecipeListBinding.recipesCardView.setOnClickListener(this);
    }

    public void bind(Recipes recipes){
        itemRecipeListBinding.setRecipes(recipes);
    }

//    @Override
//    public void onClick(View v) {
//        onRecipeListener.onRecipeClick(getLayoutPosition());
//    }
}