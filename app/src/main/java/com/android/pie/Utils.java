package com.android.pie;

import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * author： Created by shiming on 2018/8/9 15:38
 * mailbox：lamshiming@sina.com
 */

public class Utils {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static int getAppStandbyBucket(Context context){
//        UsageStatsManager.INTERVAL_BEST
        UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);
        int appStandbyBucket = usageStatsManager.getAppStandbyBucket();
        System.out.println("appStandbyBucket="+appStandbyBucket);
        return appStandbyBucket;
    }
}
