package com.vitasport.starlabs.vitasport.view_models.adapters;

import com.vitasport.starlabs.vitasport.models.UserModel;
import com.vitasport.starlabs.vitasport.view_models.listeners.UserViewListener;

public abstract class UserViewAdapter implements UserViewListener {

    @Override
    public void onUpdateProfileSuccess() {

    }

    @Override
    public void onRefreshPasswordSuccess() {

    }

    @Override
    public void onResetPasswordSuccess() {

    }

    @Override
    public void onRegisterSuccess() {

    }

    @Override
    public void onLoginSuccess() {

    }

    @Override
    public void onLogoutSuccess() {

    }

    @Override
    public void getUserData(UserModel user) {

    }

    @Override
    public void onLoading(boolean isLoading) {

    }

    @Override
    public void onError(String message) {

    }
}