package com.viewlrq.customview;

import android.widget.ImageView;

/**
 * Created by Administrator on 2017/12/15.
 */

public class ImageLoader {


    private Loader loader;
    private ImageLoader()
    {

    }
    public static ImageLoader  getInstance(Loader mloader)
    {
       // loader=mloader;
        ImageLoader instance= new ImageLoader();
        instance .loader=mloader;
        return instance;

    }

   public void loadImagefromeNetwork(String url,ImageView view)
    {
       if(loader!=null)
           loader.load(url,view);

    }
    public void loadImagefromLocal(String path,ImageView view)
    {
        if(loader!=null)
            loader.loadFromlocal(path,view);

    }
    public void loadImagefromsource(int id,ImageView view)
    {
        if(loader!=null)
            loader.loadFromsource(id,view);

    }


}
