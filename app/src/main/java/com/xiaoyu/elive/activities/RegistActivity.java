package com.xiaoyu.elive.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.xiaoyu.elive.base.BaseSlideBackActivity;

import com.xiaoyu.elive.R;

/**
 * Created by NeekChaw on 2017/7/2 0002.
 */

public class RegistActivity extends BaseSlideBackActivity {

    private ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_regist);

        btn_back = (ImageButton) findViewById(R.id.btn_bar_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(RegistActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}


