package com.care24;

import care24.com.core.model.CommonContainer;

/**
 * Created by mohanish on 3/15/16.
 */
public class Care24Application extends com.activeandroid.app.Application {

    public static final String TAG = Care24Application.class.getSimpleName();


    @Override
    public void onCreate() {
        super.onCreate();
        CommonContainer.BASE_URL = BuildConfig.HOST;
        CommonContainer.mContext = getApplicationContext();

    }
}
