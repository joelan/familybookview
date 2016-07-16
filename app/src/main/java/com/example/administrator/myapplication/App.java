package com.example.administrator.myapplication;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by Administrator on 2016/7/12.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(
                this);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.threadPoolSize(3);
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.memoryCache(new WeakMemoryCache());
        config.memoryCacheSize(10 * 1024 * 1024);
        config.writeDebugLogs(); // Remove for release app
        ImageLoader.getInstance().init(config.build());

    }
}
