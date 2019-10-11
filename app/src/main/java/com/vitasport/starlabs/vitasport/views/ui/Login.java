package com.vitasport.starlabs.vitasport.views.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.vitasport.starlabs.vitasport.R;
import com.vitasport.starlabs.vitasport.view_models.adapters.UserViewAdapter;
import com.vitasport.starlabs.vitasport.view_models.UserViewModel;
import com.vitasport.starlabs.vitasport.views.core.BaseFragment;
import com.vitasport.starlabs.vitasport.views.core.FragmentFactory;
import com.vitasport.starlabs.vitasport.views.popups.LoadingPopup;

import butterknife.BindView;
import butterknife.OnClick;

public class Login extends BaseFragment {

    private UserViewAdapter userViewAdapter = new UserViewAdapter() {
        @Override
        public void onLoginSuccess() {
            super.onLoginSuccess();
            if (isAdded() && isVisible() && getActivity() != null) {
                if (fragmentListener != null) {
                    fragmentListener.clearScreens();
                    fragmentListener.onReplaceFragment(FragmentFactory.FRAGMENTS.NAVIGATION, null, false);
                    loadingPopup.dismiss();
                }
            }
        }

        @Override
        public void onLoading(boolean isLoading) {
            super.onLoading(isLoading);
            if (isAdded() && isVisible() && getActivity() != null) {
                if (loadingPopup == null)
                    loadingPopup = new LoadingPopup(getActivity());
                if (isLoading)
                    if (!loadingPopup.isShowing())
                        loadingPopup.show();
                    else
                        loadingPopup.dismiss();
            }
        }

        @Override
        public void onError(String message) {
            super.onError(message);
            if (isAdded() && isVisible() && getActivity() != null) {
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                loadingPopup.dismiss();
            }
        }
    };

    @BindView(R.id.login_editEmail) protected EditText editEmail;
    @BindView(R.id.login_editPassword) protected EditText editPassword;

    private LoadingPopup loadingPopup = null;
    private UserViewModel userViewModel = null;

    @OnClick(R.id.login_btnLogin)
    public void clickBtnLogin() {
        if (isAdded() && isVisible() && getActivity() != null) {
            userViewModel.login(editEmail.getText().toString(), editPassword.getText().toString());
        }
    }

    @OnClick(R.id.login_btnRegister)
    public void loginBtnRegister() {
        if (isAdded() && isVisible() && getActivity() != null) {
            fragmentListener.onReplaceFragment(FragmentFactory.FRAGMENTS.REGISTER, null, true);
        }
    }

    @OnClick(R.id.login_btnForgetPassword)
    public void loginBtnForgetPassword() {
        if (isAdded() && isVisible() && getActivity() != null) {
            fragmentListener.onReplaceFragment(FragmentFactory.FRAGMENTS.FORGET_PASSWORD, null, true);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.login;
    }

    @Override
    protected void init(@NonNull View itemView, @Nullable Bundle savedInstanceState) {
        if (isAdded() && getActivity() != null) {
            if (fragmentListener != null) fragmentListener.onFullScreen(true);

            userViewModel = ViewModelProviders.of(getActivity()).get(UserViewModel.class);
            userViewModel.setUserViewAdapter(userViewAdapter);
        }
    }
}
