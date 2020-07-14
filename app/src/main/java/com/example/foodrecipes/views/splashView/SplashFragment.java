package com.example.foodrecipes.views.splashView;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.activity.OnBackPressedCallback;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;

import com.example.foodrecipes.R;
import com.example.foodrecipes.views.BaseFragment;
import com.example.foodrecipes.databinding.FragmentSplashBinding;

import static com.example.foodrecipes.utilities.Constants.SPLASH_TIMER;

public class SplashFragment extends BaseFragment {

    private FragmentSplashBinding splashBinding;
    private Animation topAnimation, bottomAnimation;

    public SplashFragment() {
        super(R.layout.fragment_splash, false);
    }

    @Override
    protected void doOnCreate(View v) {
        topAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.bottom_animation);
        splashBinding = DataBindingUtil.bind(v);

        splashBinding.splashImg.setAnimation(topAnimation);
        splashBinding.splashTv.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment).navigate(R.id.toRecipesListFragment);
            }
        }, SPLASH_TIMER);

    }
}