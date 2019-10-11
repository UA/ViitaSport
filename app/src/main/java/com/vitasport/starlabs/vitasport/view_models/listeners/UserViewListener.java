package com.vitasport.starlabs.vitasport.view_models.listeners;

import com.vitasport.starlabs.vitasport.models.UserModel;

public interface UserViewListener extends BaseListener {
    void onUpdateProfileSuccess();
    void onRefreshPasswordSuccess();
    void onResetPasswordSuccess();
    void onRegisterSuccess();
    void onLoginSuccess();
    void onLogoutSuccess();
    void getUserData(UserModel user);
}
