package com.read.booklibrary.ui.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import com.read.booklibrary.utils.StatusBarCompat;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by PC on 2016/9/8.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final int INVALID_VAL = -1;

    protected CompositeDisposable mDisposable;

    /****************************abstract area*************************************/

    @LayoutRes
    protected abstract int getContentId();

    /************************init area************************************/
    protected void addDisposable(Disposable d){
        if (mDisposable == null){
            mDisposable = new CompositeDisposable();
        }
        mDisposable.add(d);
    }

    /**
     * 配置Toolbar
     * @param toolbar
     */
    protected void setUpToolbar(Toolbar toolbar){
    }

    protected void initData(Bundle savedInstanceState){
    }
    /**
     * 初始化零件
     */
    protected void initWidget() {

    }
    /**
     * 初始化点击事件
     */
    protected void initClick(){
    }
    /**
     * 逻辑使用区
     */
    protected void processLogic(){
    }

    /*************************lifecycle area*****************************************************/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentId());
        initData(savedInstanceState);
        initWidget();
        initClick();
        processLogic();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDisposable != null){
            mDisposable.dispose();
        }
    }

    /**************************used method area*******************************************/

    protected void startActivity(Class<? extends AppCompatActivity> activity){
        Intent intent = new Intent(this,activity);
        startActivity(intent);
    }

    protected void setStatusBarColor(int statusColor){
        StatusBarCompat.compat(this, ContextCompat.getColor(this, statusColor));
    }

    // 设置状态栏文字颜色
    public void setStatusTextColor(boolean isBlack) {
        if (isBlack) {
            if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
                setStatusBarDarkMode(true, this);
            }
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
                setStatusBarDarkMode(false, this);
            }
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }
    }

    /**
     * 部分小米手机需要用到这个才能修改状态栏字体颜色
     */
    public void setStatusBarDarkMode(boolean darkmode, Activity activity) {
        Class<? extends Window> clazz = activity.getWindow().getClass();
        try {
            int darkModeFlag = 0;
            Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            darkModeFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
            extraFlagField.invoke(activity.getWindow(), darkmode ? darkModeFlag : 0, darkModeFlag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
