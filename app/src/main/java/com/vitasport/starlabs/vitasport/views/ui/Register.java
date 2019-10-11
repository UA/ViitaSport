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

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.OnClick;

public class Register extends BaseFragment {

    private LoadingPopup loadingPopup = null;

    @OnClick(R.id.register_btnRegister)
    public void clickBtnRegister() {
        if (isAdded() && isVisible() && getActivity() != null) {
            userViewModel.registerUser(
                    new WeakReference<>(getActivity()),
                    editNameSurname.getText().toString(),
                    editEmail.getText().toString(),
                    editPassword.getText().toString(),
                    editPasswordRepeat.getText().toString()
            );
        }
    }

    @OnClick(R.id.register_btnBack)
    public void clickBtnBack() {
        if (isAdded() && isVisible() && getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @BindView(R.id.register_editEmail) protected EditText editEmail;
    @BindView(R.id.register_editNameSurname) protected EditText editNameSurname;
    @BindView(R.id.register_editPassword) protected EditText editPassword;
    @BindView(R.id.register_editPasswordRepeat) protected EditText editPasswordRepeat;

    private UserViewAdapter userViewAdapter = new UserViewAdapter() {
        @Override
        public void onRegisterSuccess() {
            super.onRegisterSuccess();
            if (isAdded() && isVisible() && getActivity() != null) {
                if (fragmentListener != null) {
                    fragmentListener.clearScreens();
                    fragmentListener.onReplaceFragment(FragmentFactory.FRAGMENTS.NAVIGATION, null, false);
                }
            }
        }

        @Override
        public void onLoading(boolean isLoading) {
            super.onLoading(isLoading);
            if (isAdded() && isVisible() && getActivity() != null) {
                if (loadingPopup == null)
                    loadingPopup = new LoadingPopup(getActivity());
                if (isLoading) {
                    if (!loadingPopup.isShowing())
                        loadingPopup.show();
                } else {
                    loadingPopup.dismiss();
                }
            }
        }

        @Override
        public void onError(String message) {
            super.onError(message);
            if (isAdded() && isVisible() && getActivity() != null) {
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        }
    };

    private UserViewModel userViewModel = null;

    @Override
    protected int getLayoutId() {
        return R.layout.register;
    }

    @Override
    protected void init(@NonNull View itemView, @Nullable Bundle savedInstanceState) {
        if (isAdded() && getActivity() != null) {
            if (fragmentListener != null) {
                fragmentListener.onFullScreen(true);
                fragmentListener.onActiveFragment(this);
            }
            userViewModel = ViewModelProviders.of(getActivity()).get(UserViewModel.class);
            userViewModel.setUserViewAdapter(userViewAdapter);
        }

    }
}
