package com.xiaoyu.elive.activities;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.xiaoyu.elive.base.BaseSlideBackActivity;

import com.xiaoyu.elive.R;

public class LoginActivity extends BaseSlideBackActivity {
    private Button btn_login;
    private Button btn_regist;
    private TextView forgetpwd;
    private ImageButton myphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_regist = (Button) findViewById(R.id.btn_regist);
        myphoto = (ImageButton) findViewById(R.id.myphoto_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, RegistActivity.class);
                startActivity(intent);
            }
        });

        myphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, UserCenterActivity.class);
                startActivity(intent);
            }
        });

        forgetpwd = (TextView) findViewById(R.id.forgetpwd);
        forgetpwd.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
    }
}
