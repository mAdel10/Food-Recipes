//package com.example.foodrecipes.Views.RecipesListView;
//
//import android.content.Context;
//import android.util.Log;
//
//import androidx.lifecycle.LiveData;
//import androidx.lifecycle.MutableLiveData;
//
//import com.example.foodrecipes.Models.Recipe;
//import com.example.foodrecipes.Models.RecipeSearch;
//import com.example.foodrecipes.Requests.ServiceGenerator;
//import com.example.foodrecipes.Utilities.AppExecutors;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.Future;
//import java.util.concurrent.TimeUnit;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//import static com.example.foodrecipes.Utilities.Constants.NETWORK_TIMEOUT;
//
//public class RecipesListApiClient {
//
//    private static RecipesListApiClient instance;
//    private MutableLiveData<List<Recipe>> mRecipes;
//    //private RetrieveRecipesRunnable mRetrieveRecipesRunnable;
//    private static final String TAG = "RecipesListApiClient";
//    Context context;
//
//
//
//    public static RecipesListApiClient getInstance() {
////        if (instance == null) {
////            instance = new RecipesListApiClient();
////        }
////        return instance;
////    }
////
////    private RecipesListApiClient() {
////        mRecipes = new MutableLiveData<>();
////    }
////
////    public LiveData<List<Recipe>> getRecipes() {
////        return mRecipes;
////    }
////
////    public void searchRecipesApi(String query, int pageNumber) {
////        if (mRetrieveRecipesRunnable != null){
////            mRetrieveRecipesRunnable = null;
////        }
////        mRetrieveRecipesRunnable = new RetrieveRecipesRunnable(query, pageNumber);
////        final Future handler = AppExecutors.getInstance().networkIO().submit(mRetrieveRecipesRunnable);
////
////        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
////            @Override
////            public void run() {
////                // Let User Know That Time Out.
////                handler.cancel(true);
////            }
////        }, NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
////    }
////
////    private class RetrieveRecipesRunnable implements Runnable {
////
////        private String query;
////        private int pageNumber;
////        boolean cancelRequest;
////
////        public RetrieveRecipesRunnable(String query, int pageNumber) {
////            this.query = query;
////            this.pageNumber = pageNumber;
////            cancelRequest = false;
////        }
////
////        @Override
////        public void run() {
////            getRecipes();
////            if (cancelRequest) {
////                return;
////            }
////        }
////
////        public void getRecipes() {
////            ServiceGenerator.getRecipeApi(context).doGetRecipeSearch(query, String.valueOf(pageNumber))
////                    .enqueue(new Callback<RecipeSearch>() {
////                        @Override
////                        public void onResponse(Call<RecipeSearch> call, Response<RecipeSearch> response) {
////                            if (response.code() == 200){
////                                List<Recipe> recipes = new ArrayList<>(response.body().getRecipes());
////                                if (pageNumber == 1){
////                                    mRecipes.postValue(recipes);
////                                }else {
////                                    List<Recipe> currentRecipes = mRecipes.getValue();
////                                    currentRecipes.addAll(recipes);
////                                    mRecipes.postValue(recipes);
////                                }
////                            }
////                        }
////                        @Override
////                        public void onFailure(Call<RecipeSearch> call, Throwable t) {
////                            Log.e(TAG, "onFailure: ",t );
////                            mRecipes.postValue(null);
////                        }
////                    });
////        }
////
////        private void cancelRequest() {
////            Log.d(TAG, "cancelRequest: Canceling Search Request.");
////            cancelRequest = true;
////        }
////    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
