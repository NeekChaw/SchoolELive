package com.xiaoyu.elive.util;

/**
 * Created by NeekChaw on 2017/7/7 0007.
 */

import com.xiaoyu.elive.R;

import java.util.Random;

public class BitmapSampleUtil {

    public static String[] IMAGES = new String[]{
            "drawable://" + R.drawable.dw_1,
            "drawable://" + R.drawable.dw_2,
            "drawable://" + R.drawable.dw_3,
            "drawable://" + R.drawable.dw_4,
            "drawable://" + R.drawable.dw_5,
            "drawable://" + R.drawable.dw_6,
            "drawable://" + R.drawable.dw_7,
            "drawable://" + R.drawable.dw_8,
            "drawable://" + R.drawable.dw_9};
//            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1500026165&di=48f61dd07c4a6c545138ee174f1f13a7&imgtype=jpg&er=1&src=http%3A%2F%2Ftupian.enterdesk.com%2F2012%2F0602%2Fyt%2F20%2FAmazing_Flowers_Wallpapers_69_In_the_morning_sun.jpg",
//            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1499431438509&di=d7b587c42c082cf9ecaca4a2007f6483&imgtype=0&src=http%3A%2F%2Fimg2.duitang.com%2Fuploads%2Fitem%2F201212%2F02%2F20121202153422_Uancu.thumb.600_0.jpeg",
//            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1499431438508&di=972ffa54045b12ebf6a874dea55f97ca&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201403%2F20%2F20140320222513_dZf23.jpeg",
//            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1499431438507&di=117dc63495853f7a2a8203b0ec686247&imgtype=0&src=http%3A%2F%2Ftupian.enterdesk.com%2F2013%2Fxll%2F012%2F05%2F9%2F7.jpg",
//            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1499431438507&di=70704eea47475c82041b0a98976cdd5f&imgtype=0&src=http%3A%2F%2Fa3.topitme.com%2F0%2F31%2Ff3%2F1135791907b8ef3310l.jpg",
//            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1499431438506&di=6fb5580ec121443b4e79e7104c128d9e&imgtype=0&src=http%3A%2F%2Fimg.qqzhi.com%2Fupload%2Fimg_0_2346865801D3265372779_23.jpg",
//            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1499431438504&di=c1ab813e3616308fa07d27a6701c5e42&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201510%2F23%2F20151023001018_RcziX.jpeg",
//            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1499431621347&di=ade05c0ddddadd0b9bfc2e39f8514e99&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D3935687835%2C1002139675%26fm%3D214%26gp%3D0.jpg",
//            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1499431438501&di=8e324292efb866fd9f4b83888402af9d&imgtype=0&src=http%3A%2F%2Ftupian.enterdesk.com%2F2015%2Flcx%2F1%2F26%2F5%2F1.jpg",};

    /**
     * 随机产生的一个图片Url
     *
     * @return
     */
    public static String getBmpUrl() {
        int index = new Random().nextInt(IMAGES.length);
        return IMAGES[index];
    }
}

