package com.xiaoyu.elive.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.xiaoyu.elive.R;
import com.xiaoyu.elive.base.BaseSlideBackActivity;
import com.xiaoyu.elive.util.BitmapSampleUtil;
import com.xiaoyu.elive.util.SquareCenterImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NeekChaw on 2017/7/7 0007.
 */

public class AlbumActivity extends BaseSlideBackActivity {
    public static DisplayImageOptions mNormalImageOptions;
    //private static final int CODE_APP_REQUEST = 0xa2;//APP
    public static final String SDCARD_PATH = Environment.getExternalStorageDirectory().toString();
    public static final String IMAGES_FOLDER = SDCARD_PATH + File.separator + "demo" + File.separator + "images" + File.separator;
    private GridView mGridView;
    private ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        btn_back = (ImageButton) findViewById(R.id.btn_bar_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AlbumActivity.this, UserCenterActivity.class);
                startActivity(intent);
            }
        });
        initImageLoader(this);
        mGridView = (GridView) findViewById(R.id.multi_photo_grid);
        List<String> datas = new ArrayList<String>();
        for (int i = 0; i < 15; i++) {
            datas.add(BitmapSampleUtil.getBmpUrl());
        }
        mGridView.setAdapter(new ImagesInnerGridViewAdapter(datas));

    }


    private void initImageLoader(Context context) {
        int memoryCacheSize = (int) (Runtime.getRuntime().maxMemory() / 5);
        MemoryCache memoryCache;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            memoryCache = new LruMemoryCache(memoryCacheSize);
        } else {
            memoryCache = new LRULimitedMemoryCache(memoryCacheSize);
        }

        mNormalImageOptions = new DisplayImageOptions.Builder().bitmapConfig(Config.RGB_565).cacheInMemory(true).cacheOnDisc(true)
                .resetViewBeforeLoading(true).build();

        // This
        // This configuration tuning is custom. You can tune every option, you
        // may tune some of them,
        // or you can create default configuration by
        // ImageLoaderConfiguration.createDefault(this);
        // method.
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).defaultDisplayImageOptions(mNormalImageOptions)
                .denyCacheImageMultipleSizesInMemory().discCache(new UnlimitedDiskCache(new File(IMAGES_FOLDER)))
                // .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .memoryCache(memoryCache)
                // .memoryCacheSize(memoryCacheSize)
                .tasksProcessingOrder(QueueProcessingType.LIFO).threadPriority(Thread.NORM_PRIORITY - 2).threadPoolSize(3).build();

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }

    private class ImagesInnerGridViewAdapter extends BaseAdapter {

        private List<String> datas;

        public ImagesInnerGridViewAdapter(List<String> datas) {
            this.datas = datas;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final SquareCenterImageView imageView = new SquareCenterImageView(AlbumActivity.this);
            imageView.setScaleType(ScaleType.CENTER_CROP);
            ImageLoader.getInstance().displayImage(datas.get(position), imageView);
            imageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (getIntent() != null) {
                        Intent intent = new Intent(getApplication(), AlbumImageDetailActivity.class);
                        intent.putExtra("images", (ArrayList<String>) datas);
                        intent.putExtra("position", position);
                        int[] location = new int[2];
                        imageView.getLocationOnScreen(location);
                        intent.putExtra("locationX", location[0]);
                        intent.putExtra("locationY", location[1]);
                        intent.putExtra("width", imageView.getWidth());
                        intent.putExtra("height", imageView.getHeight());
                        intent.putExtra("motive", UserCenterActivity.CODE_APP_REQUEST);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                    } else {
                        Intent intent = new Intent(getApplication(), AlbumImageDetailActivity.class);
                        intent.putExtra("images", (ArrayList<String>) datas);
                        intent.putExtra("position", position);
                        int[] location = new int[2];
                        imageView.getLocationOnScreen(location);
                        intent.putExtra("locationX", location[0]);
                        intent.putExtra("locationY", location[1]);
                        intent.putExtra("width", imageView.getWidth());
                        intent.putExtra("height", imageView.getHeight());
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                    }
                }
            });
            return imageView;
        }

    }
}