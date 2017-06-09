package br.com.blueshipping.blueshipping.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;

import br.com.blueshipping.blueshipping.infrastructure.MyApplication;

/**
 * Created by aronuchoa on 17/05/17.
 */

public abstract class Utils {

    public static Typeface customFont(String font){

        String path = "fonts/" + font;
        return Typeface.createFromAsset(MyApplication.getAppContext().getAssets(),  path);
    }

    public static ProgressDialog getProgressDialog(Activity activity) {
        ProgressDialog mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Aguarde...");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(false);
        return mProgressDialog;
    }

    public static void saveCodeSharedPreferences(Activity activity, String code) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Code", code);
        editor.apply();
    }


}
