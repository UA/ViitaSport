package com.vitasport.starlabs.vitasport.views.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.vitasport.starlabs.vitasport.R;
import com.vitasport.starlabs.vitasport.view_models.adapters.UserViewAdapter;
import com.vitasport.starlabs.vitasport.view_models.UserViewModel;
import com.vitasport.starlabs.vitasport.views.core.BaseFragment;
import com.vitasport.starlabs.vitasport.views.core.FragmentFactory;

public class Splash extends BaseFragment {

    private UserViewAdapter userViewAdapter = new UserViewAdapter() {
        @Override
        public void onLoginSuccess() {
            super.onLoginSuccess();
            if (isAdded() && isVisible() && getActivity() != null) {
                if (fragmentListener != null) {
                    fragmentListener.clearScreens();
                    fragmentListener.onReplaceFragment(FragmentFactory.FRAGMENTS.NAVIGATION, null, false);

                }
            }
        }

        @Override
        public void onError(String message) {
            super.onError(message);
            if (isAdded() && isVisible() && getActivity() != null) {
                fragmentListener.onReplaceFragment(FragmentFactory.FRAGMENTS.LOGIN, null, false);
            }
        }
    };

    private UserViewModel userViewModel = null;

    @Override
    protected int getLayoutId() {
        return R.layout.splash;
    }

    @Override
    protected void init(@NonNull View itemView, @Nullable Bundle savedInstanceState) {
        if (isAdded() && getActivity() != null) {
            userViewModel = ViewModelProviders.of(getActivity()).get(UserViewModel.class);
            userViewModel.setUserViewAdapter(userViewAdapter);

            Handler handler = new Handler();
            handler.postDelayed(() -> userViewModel.autoLogin(), 2000);
        }
    }
}