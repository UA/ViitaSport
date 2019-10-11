package com.vitasport.starlabs.vitasport.listeners;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.vitasport.starlabs.vitasport.views.core.FragmentFactory;

public interface IActivityFragmentListener {
    void onReplaceFragment(FragmentFactory.FRAGMENTS fragmentTag, @Nullable Bundle data, boolean isBackState);
    void onFullScreen(boolean isFullScreen);
    void onActiveFragment(Fragment fragment);
    void clearScreens();
}
