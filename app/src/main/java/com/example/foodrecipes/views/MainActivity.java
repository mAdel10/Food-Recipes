package com.example.foodrecipes.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;

import com.example.foodrecipes.R;
import com.example.foodrecipes.utilities.MonBackPressed;

public class MainActivity extends AppCompatActivity {

    private static MonBackPressed backPressed;

    public static void setBackPressed(MonBackPressed backPressed) {
        MainActivity.backPressed = backPressed;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setupNavigation();
    }

    @Override
    public void onBackPressed() {
        if (true){
            backPressed.doBackClick();
        }else {
            super.onBackPressed();
        }
    }

    //    private void setupNavigation() {
//        NavController navController = Navigation.findNavController(this, R.id.my_nav_host_fragment);
//    }


}