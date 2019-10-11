package com.vitasport.starlabs.vitasport.views.core;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vitasport.starlabs.vitasport.listeners.IActivityFragmentListener;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    protected IActivityFragmentListener fragmentListener;
    protected abstract int getLayoutId();
    protected abstract void init(@NonNull View itemView, @Nullable Bundle savedInstanceState);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        if (getActivity() instanceof IActivityFragmentListener)
            fragmentListener = (IActivityFragmentListener) getActivity();
        init(view, savedInstanceState);
    }
}
