package com.vitasport.starlabs.vitasport.view_models.listeners;

import com.vitasport.starlabs.vitasport.models.AthletesModel;

import java.util.ArrayList;

public interface AthletesViewListener extends BaseListener{
    void getAthletesList(ArrayList<AthletesModel> list);
}
