package com.viewlrq.customview;

import android.widget.ImageView;

/**
 * Created by Administrator on 2017/12/15.
 */

public interface Loader {

    void load(String url, ImageView view);
    void loadFromlocal(String path,ImageView view);
    void loadFromsource(int sourceid,ImageView view);
}
