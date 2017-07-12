package com.xiaoyu.elive.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.xiaoyu.elive.R;
import com.xiaoyu.elive.base.BaseSlideBackActivity;
import com.xiaoyu.elive.util.SmoothImageView;

import java.util.ArrayList;

public class AlbumImageDetailActivity extends BaseSlideBackActivity {

    private ArrayList<String> mDatas;
    private int mPosition;
    private int mLocationX;
    private int mLocationY;
    private int mWidth;
    private int mHeight;
    Bitmap bp = null;
    SmoothImageView imageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDatas = (ArrayList<String>) getIntent().getSerializableExtra("images");
        mPosition = getIntent().getIntExtra("position", 0);
        mLocationX = getIntent().getIntExtra("locationX", 0);
        mLocationY = getIntent().getIntExtra("locationY", 0);
        mWidth = getIntent().getIntExtra("width", 0);
        mHeight = getIntent().getIntExtra("height", 0);

        imageView = new SmoothImageView(this);
        imageView.setOriginalInfo(mWidth, mHeight, mLocationX, mLocationY);
        imageView.transformIn();
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setScaleType(ScaleType.FIT_CENTER);

        //选择头像
        if (getIntent().getIntExtra("motive", 0) == UserCenterActivity.CODE_APP_REQUEST) {
            setContentView(R.layout.activity_album_headimage_sel);
            imageView = (SmoothImageView) findViewById(R.id.detail_image);
            ImageLoader.getInstance().displayImage(mDatas.get(mPosition), imageView);
            ImageButton btn_cancel = (ImageButton) findViewById(R.id.cancel);
            ImageButton btn_ok = (ImageButton) findViewById(R.id.ok);
            btn_cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            btn_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplication(), UserCenterActivity.class);
                    //mDatas.get(mPosition)是 uri
                    intent.putExtra("image_uri", mDatas.get(mPosition).toString());
                    setResult(UserCenterActivity.CODE_APP_REQUEST, intent);
                    startActivity(intent);
                    finish();
                }
            });
        } else {
            //如果不是选择头像
            setContentView(R.layout.activity_album_image_detail);
            imageView = (SmoothImageView) findViewById(R.id.detail_image);
            ImageLoader.getInstance().displayImage(mDatas.get(mPosition), imageView);
            //
        }

        //此处可以加动画效果

    }

    @Override
    public void onBackPressed() {
        imageView.setOnTransformListener(new SmoothImageView.TransformListener() {
            @Override
            public void onTransformComplete(int mode) {
                if (mode == 2) {
                    finish();
                }
            }
        });
        imageView.transformOut();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            overridePendingTransition(0, 0);
        }
    }

    //点击当前activity销毁
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }

}
