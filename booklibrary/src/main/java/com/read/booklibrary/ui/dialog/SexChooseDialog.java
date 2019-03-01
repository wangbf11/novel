package com.read.booklibrary.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.read.booklibrary.R;
import com.read.booklibrary.RxBus;
import com.read.booklibrary.event.RecommendBookEvent;
import com.read.booklibrary.utils.Constant;
import com.read.booklibrary.utils.SharedPreUtils;

/**
 * Created by newbiechen on 17-4-15.
 */

public class SexChooseDialog extends Dialog implements View.OnClickListener {
    ImageView mIvClose;
    Button mBtnBoy;
    Button mBtnGirl;

    public SexChooseDialog(Context context) {
        super(context,R.style.CommonDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_sex_choose);
        mIvClose  = findViewById(R.id.choose_iv_close);
        mBtnBoy  = findViewById(R.id.choose_btn_boy);
        mBtnGirl  = findViewById(R.id.choose_btn_girl);
        setUpWindow();

        mIvClose.setOnClickListener(this);
        mBtnBoy.setOnClickListener(this);
        mBtnGirl.setOnClickListener(this);
    }

    private void setUpWindow(){
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.horizontalMargin = 0;
    }

    @Override
    public void onClick(View view){
        int i = view.getId();
        if (i == R.id.choose_btn_boy) {//保存到SharePreference中
            SharedPreUtils.getInstance()
                    .putString(Constant.SHARED_SEX, Constant.SEX_BOY);
            RxBus.getInstance().post(new RecommendBookEvent("male"));

        } else if (i == R.id.choose_btn_girl) {//保存到SharePreference中
            SharedPreUtils.getInstance()
                    .putString(Constant.SHARED_SEX, Constant.SEX_GIRL);
            RxBus.getInstance().post(new RecommendBookEvent("female"));

        } else {

        }
        dismiss();
    }
}
