package com.vitasport.starlabs.vitasport.views.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;

import com.vitasport.starlabs.vitasport.R;
import com.vitasport.starlabs.vitasport.views.core.BaseFragment;

import butterknife.BindView;

public class Navigation extends BaseFragment {

    //@BindView(R.id.navigationBottomNavigation) protected BottomNavigationView navigationView;
    @BindView(R.id.navigationContainer) protected FrameLayout container;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.navigation_athletes:
                fragment = new Athletes();
                setFragment(fragment);
                return true;
            case R.id.navigation_add:
                fragment = new Add();
                setFragment(fragment);
                return true;
        }
        return false;
    };


    @Override
    protected int getLayoutId() {
        return R.layout.navigation;
    }

    @Override
    protected void init(@NonNull View itemView, @Nullable Bundle savedInstanceState) {
        if (isAdded() && isVisible() && getActivity() != null) {
            if (fragmentListener != null) {
                fragmentListener.onActiveFragment(this);
                fragmentListener.onFullScreen(false);
            }
            //navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            setFragment(new Athletes());
        }
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.navigationContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}