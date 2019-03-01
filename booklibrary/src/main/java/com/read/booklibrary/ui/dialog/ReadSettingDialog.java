package com.read.booklibrary.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.read.booklibrary.R;
import com.read.booklibrary.model.local.ReadSettingManager;
import com.read.booklibrary.ui.activity.MoreSettingActivity;
import com.read.booklibrary.ui.activity.ReadActivity;
import com.read.booklibrary.ui.adapter.PageStyleAdapter;
import com.read.booklibrary.utils.BrightnessUtils;
import com.read.booklibrary.utils.ScreenUtils;
import com.read.booklibrary.widget.page.PageLoader;
import com.read.booklibrary.widget.page.PageMode;
import com.read.booklibrary.widget.page.PageStyle;

import java.lang.reflect.Field;
import java.util.Arrays;


/**
 * Created by newbiechen on 17-5-18.
 */

public class ReadSettingDialog extends Dialog {
    private static final String TAG = "ReadSettingDialog";
    private static final int DEFAULT_TEXT_SIZE = 16;

    ImageView mIvBrightnessMinus;
    SeekBar mSbBrightness;
    ImageView mIvBrightnessPlus;
    CheckBox mCbBrightnessAuto;
    TextView mTvFontMinus;
    TextView mTvFont;
    TextView mTvFontPlus;
    CheckBox mCbFontDefault;
    RadioGroup mRgPageMode;

    RadioButton mRbSimulation;
    RadioButton mRbCover;
    RadioButton mRbSlide;
    RadioButton mRbScroll;
    RadioButton mRbNone;
    RecyclerView mRvBg;
    TextView mTvMore;
    TextView mReadSettingTvFontHangMin;
    TextView mReadSettingTvFontHangMid;
    TextView mReadSettingTvFontHangMax;
    /************************************/
    private PageStyleAdapter mPageStyleAdapter;
    private ReadSettingManager mSettingManager;
    private PageLoader mPageLoader;
    private Activity mActivity;

    private PageMode mPageMode;
    private PageStyle mPageStyle;

    private int mBrightness;
    private int mTextSize;

    private boolean isBrightnessAuto;
    private boolean isTextDefault;
    private float mHang;


    public ReadSettingDialog(@NonNull Activity activity, PageLoader mPageLoader) {
        super(activity, R.style.ReadSettingDialog);
        mActivity = activity;
        this.mPageLoader = mPageLoader;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_read_setting);
        mIvBrightnessMinus  = findViewById(R.id.read_setting_iv_brightness_minus);
        mSbBrightness = findViewById(R.id.read_setting_sb_brightness);
        mIvBrightnessPlus = findViewById(R.id.read_setting_iv_brightness_plus);
        mCbBrightnessAuto = findViewById(R.id.read_setting_cb_brightness_auto);
        mTvFontMinus = findViewById(R.id.read_setting_tv_font_minus);
        mTvFont = findViewById(R.id.read_setting_tv_font);
        mTvFontPlus = findViewById(R.id.read_setting_tv_font_plus);
        mCbFontDefault = findViewById(R.id.read_setting_cb_font_default);
        mRgPageMode = findViewById(R.id.read_setting_rg_page_mode);

        mRbSimulation = findViewById(R.id.read_setting_rb_simulation);
        mRbCover = findViewById(R.id.read_setting_rb_cover);
        mRbSlide = findViewById(R.id.read_setting_rb_slide);
        mRbScroll = findViewById(R.id.read_setting_rb_scroll);
        mRbNone = findViewById(R.id.read_setting_rb_none);
        mRvBg = findViewById(R.id.read_setting_rv_bg);
        mTvMore = findViewById(R.id.read_setting_tv_more);
        mReadSettingTvFontHangMin = findViewById(R.id.read_setting_tv_font_hang_min);
        mReadSettingTvFontHangMid = findViewById(R.id.read_setting_tv_font_hang_mid);
        mReadSettingTvFontHangMax = findViewById(R.id.read_setting_tv_font_hang_max);
        setUpWindow();
        initData();
        initWidget();
        initClick();
    }

    //设置Dialog显示的位置
    private void setUpWindow() {
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        window.setAttributes(lp);

        //解决 状态栏变色的bug
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.TRANSPARENT);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                try {
                    Class decorViewClazz = Class.forName("com.android.internal.policy.DecorView");
                    Field field = decorViewClazz.getDeclaredField("mSemiTransparentStatusBarColor");
                    field.setAccessible(true);
                    field.setInt(getWindow().getDecorView(), Color.TRANSPARENT);  //去掉高版本蒙层改为透明
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //隐藏状态栏
            View decorView = getWindow().getDecorView();
            int option = decorView.getSystemUiVisibility() | View.SYSTEM_UI_FLAG_FULLSCREEN |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(option);
        }
    }

    private void initData() {
        mSettingManager = ReadSettingManager.getInstance();

        isBrightnessAuto = mSettingManager.isBrightnessAuto();
        mBrightness = mSettingManager.getBrightness();
        mTextSize = mSettingManager.getTextSize();
        isTextDefault = mSettingManager.isDefaultTextSize();
        mPageMode = mSettingManager.getPageMode();
        mPageStyle = mSettingManager.getPageStyle();
    }

    private void initWidget() {
        mSbBrightness.setProgress(mBrightness);
        mTvFont.setText(mTextSize + "");
        mCbBrightnessAuto.setChecked(isBrightnessAuto);
        mCbFontDefault.setChecked(isTextDefault);
        initPageMode();
        //RecyclerView
        setUpAdapter();
    }

    private void setUpAdapter() {
        Drawable[] drawables = {
                getDrawable(R.color.nb_read_bg_1)
                , getDrawable(R.color.nb_read_bg_2)
                , getDrawable(R.color.nb_read_bg_3)
                , getDrawable(R.color.nb_read_bg_4)
                , getDrawable(R.color.nb_read_bg_5)};

        mPageStyleAdapter = new PageStyleAdapter();
        mRvBg.setLayoutManager(new GridLayoutManager(getContext(), 5));
        mRvBg.setAdapter(mPageStyleAdapter);
        mPageStyleAdapter.refreshItems(Arrays.asList(drawables));

        mPageStyleAdapter.setPageStyleChecked(mPageStyle);

    }

    private void initPageMode() {
        switch (mPageMode) {
            case SIMULATION:
                mRbSimulation.setChecked(true);
                break;
            case COVER:
                mRbCover.setChecked(true);
                break;
            case SLIDE:
                mRbSlide.setChecked(true);
                break;
            case NONE:
                mRbNone.setChecked(true);
                break;
            case SCROLL:
                mRbScroll.setChecked(true);
                break;
        }
    }

    private Drawable getDrawable(int drawRes) {
        return ContextCompat.getDrawable(getContext(), drawRes);
    }

    private void initClick() {
        //亮度调节
        mIvBrightnessMinus.setOnClickListener(
                (v) -> {
                    if (mCbBrightnessAuto.isChecked()) {
                        mCbBrightnessAuto.setChecked(false);
                    }
                    int progress = mSbBrightness.getProgress() - 1;
                    if (progress < 0) return;
                    mSbBrightness.setProgress(progress);
                    BrightnessUtils.setBrightness(mActivity, progress);
                }
        );
        mIvBrightnessPlus.setOnClickListener(
                (v) -> {
                    if (mCbBrightnessAuto.isChecked()) {
                        mCbBrightnessAuto.setChecked(false);
                    }
                    int progress = mSbBrightness.getProgress() + 1;
                    if (progress > mSbBrightness.getMax()) return;
                    mSbBrightness.setProgress(progress);
                    BrightnessUtils.setBrightness(mActivity, progress);
                    //设置进度
                    ReadSettingManager.getInstance().setBrightness(progress);
                }
        );

        mSbBrightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                if (mCbBrightnessAuto.isChecked()) {
                    mCbBrightnessAuto.setChecked(false);
                }
                //设置当前 Activity 的亮度
                BrightnessUtils.setBrightness(mActivity, progress);
                //存储亮度的进度条
                ReadSettingManager.getInstance().setBrightness(progress);
            }
        });

        mCbBrightnessAuto.setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    if (isChecked) {
                        //获取屏幕的亮度
                        BrightnessUtils.setBrightness(mActivity, BrightnessUtils.getScreenBrightness(mActivity));
                    } else {
                        //获取进度条的亮度
                        BrightnessUtils.setBrightness(mActivity, mSbBrightness.getProgress());
                    }
                    ReadSettingManager.getInstance().setAutoBrightness(isChecked);
                }
        );

        //字体大小调节
        mTvFontMinus.setOnClickListener(
                (v) -> {
                    if (mCbFontDefault.isChecked()) {
                        mCbFontDefault.setChecked(false);
                    }
                    int fontSize = Integer.valueOf(mTvFont.getText().toString()) - 1;
                    if (fontSize < 0) return;
                    mTvFont.setText(fontSize + "");
                    mPageLoader.setHangSize((int) (fontSize * mHang));
                    mPageLoader.setTextSize(fontSize);
                }
        );

        mTvFontPlus.setOnClickListener(
                (v) -> {
                    if (mCbFontDefault.isChecked()) {
                        mCbFontDefault.setChecked(false);
                    }
                    int fontSize = Integer.valueOf(mTvFont.getText().toString()) + 1;
                    mTvFont.setText(fontSize + "");
                    mPageLoader.setHangSize((int) (fontSize * mHang));
                    mPageLoader.setTextSize(fontSize);
                }
        );
        //最小行间距
        mReadSettingTvFontHangMin.setOnClickListener(
                (v) -> {
                    int fontSize = Integer.valueOf(mTvFont.getText().toString());
                    mHang = 0.0f;
                    mPageLoader.setHangSize((int) (fontSize * mHang));
                    mPageLoader.setTextSize(fontSize);
                }
        );

        //中等行间距
        mReadSettingTvFontHangMid.setOnClickListener(
                (v) -> {
                    int fontSize = Integer.valueOf(mTvFont.getText().toString());
                    mHang = 0.5f;
                    mPageLoader.setHangSize((int) (fontSize * mHang));
                    mPageLoader.setTextSize(fontSize);
                }
        );

        //最大行间距
        mReadSettingTvFontHangMax.setOnClickListener(
                (v) -> {
                    int fontSize = Integer.valueOf(mTvFont.getText().toString());
                    mHang = 1;
                    mPageLoader.setHangSize((int) (fontSize * mHang));
                    mPageLoader.setTextSize(fontSize);
                }
        );

        mCbFontDefault.setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    if (isChecked) {
                        int fontSize = ScreenUtils.dpToPx(DEFAULT_TEXT_SIZE);
                        mTvFont.setText(fontSize + "");
                        mPageLoader.setTextSize(fontSize);
                    }
                }
        );

        //Page Mode 切换
        mRgPageMode.setOnCheckedChangeListener(
                (group, checkedId) -> {
                    PageMode pageMode;
                    if (checkedId == R.id.read_setting_rb_simulation) {
                        pageMode = PageMode.SIMULATION;

                    } else if (checkedId == R.id.read_setting_rb_cover) {
                        pageMode = PageMode.COVER;

                    } else if (checkedId == R.id.read_setting_rb_slide) {
                        pageMode = PageMode.SLIDE;

                    } else if (checkedId == R.id.read_setting_rb_scroll) {
                        pageMode = PageMode.SCROLL;

                    } else if (checkedId == R.id.read_setting_rb_none) {
                        pageMode = PageMode.NONE;

                    } else {
                        pageMode = PageMode.SIMULATION;

                    }
                    mPageLoader.setPageMode(pageMode);
                }
        );

        //背景的点击事件
        mPageStyleAdapter.setOnItemClickListener(
                (view, pos) -> mPageLoader.setPageStyle(PageStyle.values()[pos])
        );

        //更多设置
        mTvMore.setOnClickListener(
                (v) -> {
                    Intent intent = new Intent(getContext(), MoreSettingActivity.class);
                    mActivity.startActivityForResult(intent, ReadActivity.REQUEST_MORE_SETTING);
                    //关闭当前设置
                    dismiss();
                }
        );
    }

    public boolean isBrightFollowSystem() {
        if (mCbBrightnessAuto == null) {
            return false;
        }
        return mCbBrightnessAuto.isChecked();
    }
}
