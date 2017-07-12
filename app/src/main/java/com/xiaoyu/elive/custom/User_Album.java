package com.xiaoyu.elive.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiaoyu.elive.R;

/**
 * Created by NeekChaw on 2017/7/7 0007.
 */

public class User_Album extends LinearLayout {
    private TextView photo_year, photo_month, photo_day;

    public User_Album(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.custom_user_album, this, true);

        photo_year=(TextView)findViewById(R.id.photo_year);
        photo_month=(TextView)findViewById(R.id.photo_month);
        photo_day=(TextView)findViewById(R.id.photo_day);

        TypedArray typedArray = context.
                obtainStyledAttributes(attrs, R.styleable.User_Album);

        if (typedArray != null) {
            String get_year = typedArray.getString(R.styleable.User_Album_photo_year);
            if (!TextUtils.isEmpty(get_year)) {
                photo_year.setText(get_year);
            }
            String get_month = typedArray.getString(R.styleable.Msg_Words_block_msg_month);
            if (!TextUtils.isEmpty(get_month)) {
                photo_month.setText(get_month);
            }
            String get_day = typedArray.getString(R.styleable.Msg_Words_block_msg_day);
            if (!TextUtils.isEmpty(get_day)) {
                photo_day.setText(get_day);
            }
        }
    }
}
