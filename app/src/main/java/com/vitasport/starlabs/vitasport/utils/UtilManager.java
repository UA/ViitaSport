package com.vitasport.starlabs.vitasport.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.security.MessageDigest;

public class UtilManager {

    public static boolean isEmpty(String... texts) {
        for (String text: texts) {
            if (text.equalsIgnoreCase("") || TextUtils.isEmpty(text)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNull(Object... objects) {
        for (Object object: objects) {
            if (object == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Cihazın internet bağlantısı varmı yok mu onu kontrol eder.
     * @return dönecek olan boolean değer. True = İnternet Erişimi var, False = İnternet erişimi yok.
     */
    public static boolean isNetworkConnection(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    public static int dpToPx(Context context, int dp) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return (int) (dp * (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static float pxToDp(Context context, float px) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        if (imm != null)
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void printHashKey(Context pContext) {
        try {
            @SuppressLint("PackageManagerGetSignatures")
            PackageInfo info = pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), PackageManager.GET_SIGNATURES);
            for (android.content.pm.Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Log.i("VitaSport", "printHashKey() Hash Key: " + hashKey);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}