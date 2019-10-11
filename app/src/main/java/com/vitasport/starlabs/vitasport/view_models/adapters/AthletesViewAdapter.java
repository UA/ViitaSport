package com.vitasport.starlabs.vitasport.view_models.adapters;

import com.vitasport.starlabs.vitasport.models.AthletesModel;
import com.vitasport.starlabs.vitasport.view_models.listeners.AthletesViewListener;

import java.util.ArrayList;

public abstract class AthletesViewAdapter implements AthletesViewListener {

    @Override
    public void getAthletesList(ArrayList<AthletesModel> list) {

    }


    @Override
    public void onLoading(boolean isLoading) {

    }

    @Override
    public void onError(String message) {

    }
}

