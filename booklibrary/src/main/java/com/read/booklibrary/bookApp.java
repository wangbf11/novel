package com.read.booklibrary;

import android.content.Context;
import android.content.Intent;

import com.read.booklibrary.service.DownloadService;

/**
 * Created by wbf
 */

public class bookApp {
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
        context.startService(new Intent(context, DownloadService.class));
    }

    public static Context getContext(){
        return mContext;
    }
}