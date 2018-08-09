package com.android.pie;

import android.app.Application;
import android.app.LauncherActivity;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * author： Created by shiming on 2018/8/9 16:14
 * mailbox：lamshiming@sina.com
 */
public  class MyApp extends Application {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate() {
        super.onCreate();
//        int i=  Utils.getAppStandbyBucket(this);
//        at com.android.pie.Utils.getAppStandbyBucket(Utils.java:18)
//        at com.android.pie.MyApp.onCreate(MyApp.java:17)
        System.out.println(" Utils.getAppStandbyBucket(this)");

    }
}
