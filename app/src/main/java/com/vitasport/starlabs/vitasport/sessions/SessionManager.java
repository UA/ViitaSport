package com.vitasport.starlabs.vitasport.sessions;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private static SharedPreferences sharedPreferences = null;
    private static SharedPreferences.Editor editor = null;

    private volatile static SessionManager mInstance = null;

    private SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences("vita_sport_session", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public static synchronized SessionManager getInstance(Context context) {
        if (mInstance == null)
            mInstance = new SessionManager(context);
        return mInstance;
    }

    public void setEmail(String email) {
        editor.putString("email", email);
        editor.commit();
    }

    public void setPassword(String password) {
        editor.putString("password", password);
        editor.commit();
    }

    public void clear() {
        editor.clear();
        editor.commit();
    }

    public String getEmail() {
        return sharedPreferences.getString("email", "");
    }

    public String getPassword() {
        return sharedPreferences.getString("password", "");
    }
}