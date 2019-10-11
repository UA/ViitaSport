package com.vitasport.starlabs.vitasport.views.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;
import com.vitasport.starlabs.vitasport.R;
import com.vitasport.starlabs.vitasport.api.ApiClient;
import com.vitasport.starlabs.vitasport.api.ApiInterface;
import com.vitasport.starlabs.vitasport.models.AthleteDetail;
import com.vitasport.starlabs.vitasport.models.AthletesModel;
import com.vitasport.starlabs.vitasport.models.Calory;
import com.vitasport.starlabs.vitasport.models.ViitaApi;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetail extends AppCompatActivity  {
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_detail);

        TextView fullName = findViewById(R.id.tvFullName);
        TextView favoriteActivities = findViewById(R.id.tvFavoriteActivities);

        TextView dateOfBirth = findViewById(R.id.tvBirth);

        TextView mHeight = findViewById(R.id.tvHeightText);
        TextView weight = findViewById(R.id.tvWeight);
        TextView gender = findViewById(R.id.tvGender);
        SwitchCompat mondayTime = findViewById(R.id.mondayTime);
        TextView email  = findViewById(R.id.tvEmail);
        TextView suggestion = findViewById(R.id.btnSuggest);

        suggestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Feadback.class);
                intent.putExtra("email",email.getText().toString());
                startActivity(intent);
            }
        });



        if ( getIntent() == null)
            return;
        String identifier = getIntent().getStringExtra("identifier");

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        AthletesModel model = new AthletesModel();
        model.credentials.setIdentifier(identifier);
        model.credentials.setPassword("12345678");
        Call<AthleteDetail> call = apiInterface.signIn("application/json",model);
        call.enqueue(new Callback<AthleteDetail>() {
            @Override
            public void onResponse(Call<AthleteDetail> call, Response<AthleteDetail> response) {
                String favori = "";
                if (response.body() == null)
                    return;
                if (response.body().settings.watchSettings == null)
                    return;
                for (String favoriteActivity: response.body().settings.watchSettings.favoriteActivities) {
                    favori += favoriteActivity + " ";
                }
                favoriteActivities.setText(favori);
                if (response.body().settings.userSettings == null)
                    return;
                fullName.setText((response.body().settings.userSettings.firstName) + " " + (response.body().settings.userSettings.lastName));
                dateOfBirth.setText(response.body().settings.userSettings.dateOfBirth);
                //mHeight.setText(response.body().settings.userSettings.height);
                //weight.setText(response.body().settings.userSettings.weight);
                gender.setText(response.body().settings.userSettings.gender);
                email.setText(response.body().user.email);


                Call<ViitaApi> callData = apiInterface.getData(response.headers().get("X-Auth-Token"),"application/json");
                callData.enqueue(new Callback<ViitaApi>() {
                    @Override
                    public void onResponse(Call<ViitaApi> call, Response<ViitaApi> response) {

                        Log.d("Ayaz",response.body().calories.get(0).date);
                        for (Calory calory : response.body().calories) {
                            Log.d("Ayaz",calory.date);
                        }
                    }

                    @Override
                    public void onFailure(Call<ViitaApi> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onFailure(Call<AthleteDetail> call, Throwable t) {
                Log.d("Ugur","Basarisiz");

            }
        });

    }
}
