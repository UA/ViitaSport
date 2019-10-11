package com.vitasport.starlabs.vitasport.views.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.Window;
import android.view.WindowManager;

import com.vitasport.starlabs.vitasport.R;
import com.vitasport.starlabs.vitasport.listeners.IActivityFragmentListener;
import com.vitasport.starlabs.vitasport.utils.UtilManager;
import com.vitasport.starlabs.vitasport.views.core.BaseActivity;
import com.vitasport.starlabs.vitasport.views.core.FragmentFactory;

public class HomeActivity extends BaseActivity implements IActivityFragmentListener {

    private Fragment activeFragment = null;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        UtilManager.printHashKey(this);
        onReplaceFragment(FragmentFactory.FRAGMENTS.SPLASH, null, false);
    }

    @Override
    public void onReplaceFragment(FragmentFactory.FRAGMENTS fragmentTag, @Nullable Bundle data, boolean isBackState) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment selectedFragment = FragmentFactory.getFragment(fragmentTag, data);
        if (selectedFragment != null) {
            transaction.replace(R.id.activity_home_container, selectedFragment, fragmentTag.name());
            if (isBackState) {
                transaction.addToBackStack(fragmentTag.name());
            }
            transaction.commit();
        }
    }

    @Override
    public void onFullScreen(boolean isFullScreen) {
        if (isFullScreen) {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.hide();
            }
            getWindow().addFlags(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            getWindow().clearFlags(Window.FEATURE_NO_TITLE);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    @Override
    public void onActiveFragment(Fragment fragment) {
        this.activeFragment = fragment;
    }

    @Override
    public void clearScreens() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0)
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        onReplaceFragment(FragmentFactory.FRAGMENTS.NAVIGATION, null, false);
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (fragment != null) {
                fragment.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (fragment != null) {
                fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }
}