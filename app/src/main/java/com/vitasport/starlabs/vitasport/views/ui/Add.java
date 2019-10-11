package com.vitasport.starlabs.vitasport.views.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.vitasport.starlabs.vitasport.R;
import com.vitasport.starlabs.vitasport.views.core.BaseFragment;

public class Add extends BaseFragment {


    @Override
    protected int getLayoutId() {
        return R.layout.add;
    }

    @Override
    protected void init(@NonNull View itemView, @Nullable Bundle savedInstanceState) {
        if (isAdded() && getActivity() != null) {

        }
    }
}

