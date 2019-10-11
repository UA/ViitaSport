package com.vitasport.starlabs.vitasport.view_models;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.vitasport.starlabs.vitasport.R;
import com.vitasport.starlabs.vitasport.sessions.SessionManager;
import com.vitasport.starlabs.vitasport.utils.UtilManager;
import com.vitasport.starlabs.vitasport.view_models.adapters.UserViewAdapter;

import java.lang.ref.WeakReference;

public class UserViewModel extends AndroidViewModel {

    private UserViewAdapter userViewAdapter = null;

    public void setUserViewAdapter(UserViewAdapter userViewAdapter) {
        this.userViewAdapter = userViewAdapter;
    }

    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    public void registerUser(WeakReference<Activity> activityWeakReference, String nameSurname, String email, String password, String passwordRepeat) {
        if (UtilManager.isNull(nameSurname, email, password, passwordRepeat)) {
            if (userViewAdapter != null) userViewAdapter.onError(getApplication().getResources().getString(R.string.empty_fields));
            return;
        }

        if (UtilManager.isEmpty(nameSurname, email, password, passwordRepeat)) {
            if (userViewAdapter != null) userViewAdapter.onError(getApplication().getResources().getString(R.string.empty_fields));
            return;
        }

        if (!password.equalsIgnoreCase(passwordRepeat)) {
            if (userViewAdapter != null) userViewAdapter.onError(getApplication().getResources().getString(R.string.no_matches_password));
            return;
        }

        if (userViewAdapter != null) userViewAdapter.onLoading(true);

        //if (userViewAdapter != null) userViewAdapter.onRegisterSuccess();
        //if (userViewAdapter != null) userViewAdapter.onError(getApplication().getResources().getString(R.string.error_user_register));


    }


    public void autoLogin() {
        String email = SessionManager.getInstance(getApplication()).getEmail();
        String password = SessionManager.getInstance(getApplication()).getPassword();
        login(email, password);
    }

    public void login(String email, String password) {
        if (UtilManager.isNull(email, password)) {
            if (userViewAdapter != null) userViewAdapter.onError(getApplication().getResources().getString(R.string.empty_fields));
            return;
        }

        if (UtilManager.isEmpty(email, password)) {
            if (userViewAdapter != null) userViewAdapter.onError(getApplication().getResources().getString(R.string.empty_fields));
            return;
        }

        if (userViewAdapter != null) userViewAdapter.onLoading(true);

        //ParseUser user = new ParseUser();
        //user.setUsername(email);
        //user.setPassword(password);

        ParseUser.logInInBackground(email, password, new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (userViewAdapter != null) userViewAdapter.onLoading(false);
                if (e == null) {
                    SessionManager.getInstance(getApplication()).setEmail(email);
                    SessionManager.getInstance(getApplication()).setPassword(password);

                    if (userViewAdapter != null) userViewAdapter.onLoginSuccess();


                } else {
                    //if (userViewAdapter != null) userViewAdapter.onLoginSuccess();
                    if (userViewAdapter != null) userViewAdapter.onError(getApplication().getResources().getString(R.string.error_user_register));
                    ParseUser.logOut();
                    //return;
                }
                if (userViewAdapter != null) userViewAdapter.onLoading(false);
            }
        });

    }

    public void resetPassword(String email)  {
        if (UtilManager.isNull(email)) {
            if (userViewAdapter != null) userViewAdapter.onError(getApplication().getResources().getString(R.string.empty_fields));
            return;
        }

        if (UtilManager.isEmpty(email)) {
            if (userViewAdapter != null) userViewAdapter.onError(getApplication().getResources().getString(R.string.empty_fields));
            return;
        }

        if (userViewAdapter != null) userViewAdapter.onLoading(true);

        if (userViewAdapter != null) userViewAdapter.onError(getApplication().getResources().getString(R.string.error_user_register));
    }

    public void refreshPassword(String email, String password, String newPassword, String newPasswordRepeat) {
        if (UtilManager.isNull(email, password, newPassword, newPasswordRepeat)) {
            if (userViewAdapter != null) userViewAdapter.onError(getApplication().getResources().getString(R.string.empty_fields));
            return;
        }

        if (UtilManager.isEmpty(email, password, newPassword, newPasswordRepeat)) {
            if (userViewAdapter != null) userViewAdapter.onError(getApplication().getResources().getString(R.string.empty_fields));
            return;
        }

        if (userViewAdapter != null) userViewAdapter.onLoading(true);
    }

    public void logout() {
        SessionManager.getInstance(getApplication()).clear();
        if (userViewAdapter != null) userViewAdapter.onLogoutSuccess();
    }
}
