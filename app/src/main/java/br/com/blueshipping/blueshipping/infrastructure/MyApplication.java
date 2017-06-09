package br.com.blueshipping.blueshipping.infrastructure;

import android.app.Application;
import android.content.Context;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import br.com.blueshipping.blueshipping.BuildConfig;

/**
 * Created by aronuchoa on 17/05/17.
 */

public class MyApplication extends Application {

    private static Context mAppContext;
    private Tracker mTracker = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = getApplicationContext();

        if (!BuildConfig.DEBUG) {

            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            analytics.setLocalDispatchPeriod(1800);
            analytics.setDryRun(false);

            mTracker = analytics.newTracker("UA-99926214-1");
            mTracker.enableAdvertisingIdCollection(true);
            mTracker.enableAutoActivityTracking(true);
        }
    }

    public static Context getAppContext() {
        return mAppContext;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
//        MultiDex.install(newBase);
        super.attachBaseContext(newBase);
    }
}
