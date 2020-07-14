package com.example.foodrecipes.helpers.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodrecipes.databinding.ItemCategoryListBinding;
import com.example.foodrecipes.models.Recipes;
import com.example.foodrecipes.utilities.OnRecipeListener;

public class CategoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ItemCategoryListBinding itemCategoryListBinding;
    private OnRecipeListener listener;

    public CategoryHolder(@NonNull ItemCategoryListBinding itemView, OnRecipeListener onRecipeListener) {
        super(itemView.getRoot());
        itemCategoryListBinding = itemView;
        this.listener = onRecipeListener;
        itemCategoryListBinding.categoryCardView.setOnClickListener(this);
    }

    public void bind(Recipes recipes){
        itemCategoryListBinding.setCategories(recipes);
    }

    @Override
    public void onClick(View v) {
        listener.onCategoryClick(itemCategoryListBinding.categoryTitle.getText().toString());
    }
}
