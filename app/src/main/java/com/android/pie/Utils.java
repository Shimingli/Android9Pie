package com.android.pie;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;

/**
 * author： Created by shiming on 2018/8/9 15:38
 * mailbox：lamshiming@sina.com
 */

public class Utils {
    @SuppressLint("MissingPermission")
    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static int getAppStandbyBucket(Context context) {
//        UsageStatsManager.INTERVAL_BEST
        UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);
        int appStandbyBucket = usageStatsManager.getAppStandbyBucket();
        System.out.println("appStandbyBucket=" + appStandbyBucket);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            String serial = Build.getSerial();
        }
        return appStandbyBucket;
    }
}
