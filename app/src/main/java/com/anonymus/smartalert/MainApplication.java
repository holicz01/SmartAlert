package com.anonymus.smartalert;

import android.app.Application;


/**
 * Created by Dev on 9/5/2016 AD.
 */
public class MainApplication extends Application {

    String TAG = "MainApplication";
    @Override
    public void onCreate() {
        super.onCreate();

        Contextor.getInstance().init(getApplicationContext());

    }
}
