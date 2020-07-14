package com.example.foodrecipes.views.recipesListView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.foodrecipes.utilities.MonBackPressed;
import com.example.foodrecipes.utilities.OnRecipeListener;
import com.example.foodrecipes.models.Recipes;
import com.example.foodrecipes.R;
import com.example.foodrecipes.views.BaseFragment;
import com.example.foodrecipes.databinding.FragmentRecipesListBinding;
import com.example.foodrecipes.views.MainActivity;
import java.util.List;


public class RecipesListFragment extends BaseFragment implements OnRecipeListener, MonBackPressed {

    private static final String TAG = "RecipesListFragment";
    private FragmentRecipesListBinding recipesListBinding;
    private RecipesListViewModel mRecipesListViewModel;
    private RecipesListAdapter adapter;
    private Recipes Recipes;

    public RecipesListFragment() {
        super(R.layout.fragment_recipes_list, false);
    }

    @Override
    protected void doOnCreate(View v) {
        recipesListBinding = DataBindingUtil.bind(v);
        mRecipesListViewModel = ViewModelProviders.of(requireActivity()).get(RecipesListViewModel.class);
        MainActivity.setBackPressed(this);
        initRecyclerView();
        subscribeObservers();
        //searchRecipesApi();
        initSearchView();
        if (!mRecipesListViewModel.isViewingRecipes()) {
            displaySearchCategory();
        }
        backToCategories();
    }

    private void subscribeObservers() {
        mRecipesListViewModel.getRecipes().observe(this, new Observer<List<Recipes>>() {
            @Override
            public void onChanged(List<Recipes> recipes) {
                if (recipes != null) {
                    for (Recipes recipe : recipes) {
                        Log.d(TAG, "onChanged: " + recipe.getTitle());
                    }
                    adapter.setRecipes(recipes);
                    mRecipesListViewModel.setIsPerformingQuery(false);
                }
            }
        });

        mRecipesListViewModel.isLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean loading) {
                if (loading) {
                    adapter.displayLoading();
                }
            }
        });

        mRecipesListViewModel.errorMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String errorMessage) {
                Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initRecyclerView() {
        adapter = new RecipesListAdapter(this);
        recipesListBinding.recyclerview.setAdapter(adapter);
        recipesListBinding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initSearchView() {
        recipesListBinding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mRecipesListViewModel.searchRecipesApi(query, 1);
                recipesListBinding.searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

//    private void searchRecipesApi() {
//        mRecipesListViewModel.searchRecipesApi();
//    }

//    @Override
//    public void onRecipeClick(int position) {
//        Log.d(TAG, "onRecipeClick: clicked. " + position);
//    }


    @Override
    public void onRecipeClick(com.example.foodrecipes.models.Recipes r) {
        Log.d(TAG, "onRecipeClick: clicked. ");

        Bundle bundle = new Bundle();
        bundle.putString("id", r.getRecipe_id());
        Navigation.findNavController(requireActivity(), R.id.my_nav_host_fragment).navigate(R.id.toRecipeDetails,bundle);
    }

    @Override
    public void onCategoryClick(String category) {
        adapter.displayLoading();
        mRecipesListViewModel.searchRecipesApi(category, 1);
        recipesListBinding.searchView.clearFocus();
    }

    private void displaySearchCategory() {
        Log.d(TAG, "displaySearchCategories: called.");
        mRecipesListViewModel.setIsViewingRecipes(false);
        adapter.displaySearchCategories();
    }

    private void backToCategories() {
        recipesListBinding.backToCategoriesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.displaySearchCategories();
            }
        });
    }

    @Override
    public void doBackClick() {
        if (adapter.type == 1){
            requireActivity().finish();
        }else if (adapter.type == 3){
            adapter.displaySearchCategories();
        }
    }
}































