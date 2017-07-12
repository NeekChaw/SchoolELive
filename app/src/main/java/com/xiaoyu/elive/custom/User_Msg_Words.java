package com.xiaoyu.elive.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiaoyu.elive.R;

/**
 * Created by NeekChaw on 2017/7/5 0005.
 */

public class User_Msg_Words extends LinearLayout {
    private TextView msg_year, msg_day, msg_month, msg_date, msg_type, words_msg,
            zhuanfa_count, comment_count, like_count,icon_msg;

    private ImageButton zhuanfa_icon, comment_icon, like_icon;

    public User_Msg_Words(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.custom_user_msg_words, this, true);

        msg_year = (TextView) findViewById(R.id.msg_year);
        msg_month = (TextView) findViewById(R.id.msg_month);
        msg_day = (TextView) findViewById(R.id.msg_day);
        msg_date = (TextView) findViewById(R.id.msg_date);
        msg_type = (TextView) findViewById(R.id.msg_type);
        words_msg = (TextView) findViewById(R.id.words_msg);
        zhuanfa_count = (TextView) findViewById(R.id.zhuanfa_count);
        comment_count = (TextView) findViewById(R.id.comment_count);
        like_count = (TextView) findViewById(R.id.like_count);
        icon_msg = (TextView)findViewById(R.id.icon_msg);

        zhuanfa_icon = (ImageButton) findViewById(R.id.zhuanfa_icon);
        comment_icon = (ImageButton) findViewById(R.id.comment_icon);
        like_icon = (ImageButton) findViewById(R.id.like_icon);

        TypedArray typedArray = context.
                obtainStyledAttributes(attrs, R.styleable.Msg_Words_block);

        //定义年月日
        if (typedArray != null) {
            String get_year = typedArray.getString(R.styleable.Msg_Words_block_msg_year);
            if (!TextUtils.isEmpty(get_year)) {
                msg_year.setText(get_year);
            }
            String get_month = typedArray.getString(R.styleable.Msg_Words_block_msg_month);
            if (!TextUtils.isEmpty(get_month)) {
                msg_month.setText(get_month);
            }
            String get_day = typedArray.getString(R.styleable.Msg_Words_block_msg_day);
            if (!TextUtils.isEmpty(get_day)) {
                msg_day.setText(get_day);
            }
            String get_date = typedArray.getString(R.styleable.Msg_Words_block_msg_date);
            if (!TextUtils.isEmpty(get_date)) {
                msg_date.setText(get_date);
            }

            //定义文字类型
            String get_type = typedArray.getString(R.styleable.Msg_Words_block_msg_type);
            if (!TextUtils.isEmpty(get_type)) {
                msg_type.setText(get_type);
            }
            //定义文字
            String get_words = typedArray.getString(R.styleable.Msg_Words_block_words_msg);
            if (!TextUtils.isEmpty(get_words)) {
                words_msg.setText(get_words);
            }
            //定义内容图片
            int icon_msg_dw = typedArray.
                    getResourceId(R.styleable.Msg_Words_block_icon_msg, -1);
            if (icon_msg_dw != -1) {
                icon_msg.setVisibility(VISIBLE);
                icon_msg.setBackgroundResource(icon_msg_dw);
            }

            //定义转发数量
            String get_zhuanfa_count = typedArray.getString(R.styleable.Msg_Words_block_zhuanfa_count);
            if (!TextUtils.isEmpty(get_zhuanfa_count)) {
                zhuanfa_count.setText(get_zhuanfa_count);
            }

            //定义评论数量
            String get_comment_count = typedArray.getString(R.styleable.Msg_Words_block_comment_count);
            if (!TextUtils.isEmpty(get_comment_count)) {
                comment_count.setText(get_comment_count);
            }

            //定义点赞数量
            String get_like_count = typedArray.getString(R.styleable.Msg_Words_block_like_count);
            if (!TextUtils.isEmpty(get_like_count)) {
                like_count.setText(get_like_count);
            }

            //定义图标
            //转发
            int get_zhuanfa_icon = typedArray.
                    getResourceId(R.styleable.Msg_Words_block_zhuanfa_icon, -1);
            if (get_zhuanfa_icon != -1) {
                zhuanfa_icon.setBackgroundResource(get_zhuanfa_icon);
            }
            //评论
            int get_comment_icon = typedArray.
                    getResourceId(R.styleable.Msg_Words_block_comment_icon, -1);
            if (get_comment_icon != -1) {
                comment_icon.setBackgroundResource(get_comment_icon);
            }
            //点赞
            int get_like_icon = typedArray.
                    getResourceId(R.styleable.Msg_Words_block_like_icon, -1);
            if (get_like_icon != -1) {
                like_icon.setBackgroundResource(get_like_icon);
            }

        }
    }
}
