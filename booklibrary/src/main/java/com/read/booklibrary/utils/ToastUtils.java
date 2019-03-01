package com.read.booklibrary.utils;

import android.widget.Toast;

import com.read.booklibrary.bookApp;

/**
 * Created by newbiechen on 17-5-11.
 */

public class ToastUtils {

    public static void show(String msg){
        Toast.makeText(bookApp.getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
