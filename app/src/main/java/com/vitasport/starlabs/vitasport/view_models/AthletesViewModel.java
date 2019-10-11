package com.vitasport.starlabs.vitasport.view_models;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.vitasport.starlabs.vitasport.models.AthletesModel;
import com.vitasport.starlabs.vitasport.utils.UtilManager;
import com.vitasport.starlabs.vitasport.view_models.adapters.AthletesViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class AthletesViewModel extends AndroidViewModel {
    private AthletesModel athletesModel;
    private AthletesViewAdapter athletesViewAdapter = null;

    public AthletesModel getAthletesModel() {
        return athletesModel;
    }

    public void setAthletesModel(AthletesModel athletesModel) {
        this.athletesModel = athletesModel;
    }

    public AthletesViewModel(@NonNull Application application) {
        super(application);
    }

    public void setAthletesViewAdapter(AthletesViewAdapter athletesViewAdapter) {
        this.athletesViewAdapter = athletesViewAdapter;
    }

    public void getAthletesModelList(){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Athletes");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    ArrayList<AthletesModel> athletesList = new ArrayList<>();
                    for (ParseObject parseObject : list){
                        athletesModel = new AthletesModel();
                        athletesModel.setIdentifier(parseObject.getString("identifier"));
                        athletesModel.setPassword(parseObject.getString("password"));
                        athletesModel.setWatchid(parseObject.getString("watchid"));
                        athletesList.add(athletesModel);
                    }

                    if (athletesViewAdapter != null) athletesViewAdapter.getAthletesList(athletesList);


                } else {

                }
            }
        });
    }

}
