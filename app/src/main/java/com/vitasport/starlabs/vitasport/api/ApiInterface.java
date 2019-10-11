package com.vitasport.starlabs.vitasport.api;

import com.vitasport.starlabs.vitasport.models.AthleteDetail;
import com.vitasport.starlabs.vitasport.models.AthletesModel;
import com.vitasport.starlabs.vitasport.models.ViitaApi;
import com.vitasport.starlabs.vitasport.views.ui.Athletes;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface{
    @POST("v1/auth/signin")
    Call<AthleteDetail> signIn(@Header("Content-Type") String contentType, @Body AthletesModel model);

    @GET("v1/data")
    Call<ViitaApi> getData(@Header("X-Auth-Token") String token, @Header("Content-Type") String contentType);


}