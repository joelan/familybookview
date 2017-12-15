package com.example.administrator.myapplication;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.viewlrq.customview.Loader;

/**
 * Created by Administrator on 2017/12/15.
 */

public class MyImageLoader implements Loader {


    @Override
    public void load(String url, ImageView view) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.defalut)
                .showImageOnFail(R.drawable.defalut)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(url,view,options);

    }

    @Override
    public void loadFromlocal(String path, ImageView view) {

    }

    @Override
    public void loadFromsource(int sourceid, ImageView view) {

    }

}
