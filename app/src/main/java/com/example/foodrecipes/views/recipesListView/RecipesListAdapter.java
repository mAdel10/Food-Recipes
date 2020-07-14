package com.example.foodrecipes.views.recipesListView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodrecipes.databinding.ItemCategoryListBinding;
import com.example.foodrecipes.helpers.holders.CategoryHolder;
import com.example.foodrecipes.helpers.holders.LoadingViewHolder;
import com.example.foodrecipes.utilities.Constants;
import com.example.foodrecipes.utilities.OnRecipeListener;
import com.example.foodrecipes.models.Recipes;
import com.example.foodrecipes.R;
import com.example.foodrecipes.databinding.ItemRecipeListBinding;

import java.util.ArrayList;
import java.util.List;

public class RecipesListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int RECIPE_TYPE = 1;
    private static final int LOADING_TYPE = 2;
    private static final int CATEGORY_TYPE = 3;

    public int type;


    private List<Recipes> recipes;
    private OnRecipeListener onRecipeListener;

    public RecipesListAdapter(OnRecipeListener onRecipeListener) {
        this.onRecipeListener = onRecipeListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = null;
        switch (viewType) {

            case CATEGORY_TYPE: {
                ItemCategoryListBinding itemCategoryListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_category_list, parent, false);
                type = 1;
                return new CategoryHolder(itemCategoryListBinding, onRecipeListener);
            }

            case LOADING_TYPE: {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading_list, parent, false);
                type = 2;
                return new LoadingViewHolder(view);
            }
            default: {
                ItemRecipeListBinding itemRecipeListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_recipe_list, parent, false);
                type = 3;
                itemRecipeListBinding.setListener(onRecipeListener);
                return new RecipesListHolder(itemRecipeListBinding);
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == RECIPE_TYPE) {
            ((RecipesListHolder) holder).bind(recipes.get(position));

        } else if (itemViewType == CATEGORY_TYPE) {
            ((CategoryHolder) holder).bind(recipes.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (recipes.get(position).getTitle().equals("LOADING...")) {
            return LOADING_TYPE;
        } else if (recipes.get(position).getSocial_rank() == -1) {
            return CATEGORY_TYPE;
        } else {
            return RECIPE_TYPE;
        }
    }


    public void displayLoading() {
        if (!isLoading()) {
            Recipes recipe = new Recipes();
            recipe.setTitle("LOADING...");
            List<Recipes> loadingList = new ArrayList<>();
            loadingList.add(recipe);
            recipes = loadingList;
            notifyDataSetChanged();
        }
    }

    private boolean isLoading() {
        if (recipes != null) {
            if (recipes.size() > 0) {
                if (recipes.get(recipes.size() - 1).getTitle().equals("LOADING...")) {
                    return true;
                }
            }
        }
        return false;
    }


    public void displaySearchCategories() {
        List<Recipes> categories = new ArrayList<>();
        for (int i = 0; i < Constants.DEFAULT_SEARCH_CATEGORIES.length; i++) {
            Recipes recipe = new Recipes();
            recipe.setTitle(Constants.DEFAULT_SEARCH_CATEGORIES[i]);
            recipe.setImage_url(Constants.DEFAULT_SEARCH_CATEGORY_IMAGES[i]);
            recipe.setSocial_rank(-1);
            categories.add(recipe);
        }
        recipes = categories;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (recipes != null) {
            return recipes.size();
        }
        return 0;
    }

    public void setRecipes(List<Recipes> recipe) {
        recipes = recipe;
        notifyDataSetChanged();
    }

    public Recipes getSelectedRecipe(int position) {
        if (recipes != null) {
            if (recipes.size() > 0) {
                return recipes.get(position);
            }
        }
        return null;
    }
}