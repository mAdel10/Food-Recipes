package com.example.foodrecipes.views;

import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodrecipes.R;
import com.example.foodrecipes.databinding.FragmentBaseBinding;

public abstract class BaseFragment extends Fragment {

    private int mFragmentLayout;
    private boolean showProgressBar;
    protected FragmentBaseBinding baseBinding;

    public BaseFragment(int activityLayout, boolean showProgressBar) {
        this.mFragmentLayout = activityLayout;
        this.showProgressBar = showProgressBar;
    }

    protected abstract void doOnCreate(View v);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        baseBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_base, container, false);
        inflater.inflate(mFragmentLayout, baseBinding.frameLayout, true);

        if (showProgressBar) {
            baseBinding.progressBar.setVisibility(View.VISIBLE);
        } else {
            baseBinding.progressBar.setVisibility(View.GONE);
        }
        doOnCreate(baseBinding.frameLayout.getChildAt(0));
        return baseBinding.getRoot();
    }

}