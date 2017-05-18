package br.com.blueshipping.blueshipping.infrastructure;

import android.app.Application;
import android.content.Context;

/**
 * Created by aronuchoa on 17/05/17.
 */

public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
