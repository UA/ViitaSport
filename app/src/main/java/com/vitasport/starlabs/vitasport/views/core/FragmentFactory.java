package com.vitasport.starlabs.vitasport.views.core;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.vitasport.starlabs.vitasport.views.ui.Login;
import com.vitasport.starlabs.vitasport.views.ui.Navigation;
import com.vitasport.starlabs.vitasport.views.ui.Register;
import com.vitasport.starlabs.vitasport.views.ui.Splash;

public class FragmentFactory {

    public enum FRAGMENTS {
        SPLASH,
        LOGIN,
        REGISTER,
        FORGET_PASSWORD,
        NAVIGATION
    }

    public static synchronized BaseFragment getFragment(FRAGMENTS fragmentTag, @Nullable Bundle data) {
        if (fragmentTag == null) {
            return null;
        }
        if (fragmentTag == FRAGMENTS.SPLASH) {
            return new Splash();
        } else if (fragmentTag == FRAGMENTS.NAVIGATION) {
            return new Navigation();
        } else if (fragmentTag == FRAGMENTS.LOGIN) {
            return new Login();
        } else if (fragmentTag == FRAGMENTS.REGISTER) {
            return new Register();
        } else if (fragmentTag == FRAGMENTS.FORGET_PASSWORD) {
            return null;
        }

        return null;
    }
}
