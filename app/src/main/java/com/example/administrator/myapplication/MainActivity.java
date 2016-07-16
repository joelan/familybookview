package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FamilyBookView fbview;

    List<String> urls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initialize();
        urls=new ArrayList<>();
        urls.add("http://www.wallcoo.com/animal/MX069_Pretty_Puppies_puppy_garden_adventure/wallpapers/1920x1080/Garden_adventure_of_the_little_puppy_photos_pictures_puppy_MIL56021.jpg");

        urls.add("http://img1.3lian.com/2015/a2/246/d/58.jpg");
        urls.add("http://imgst-dl.meilishuo.net/pic/_o/84/a4/a30be77c4ca62cd87156da202faf_1440_900.jpg");
       urls.add("http://mvimg1.meitudata.com/566507ca1bcc65451.jpg");
       urls.add("http://img3.3lian.com/2013/v8/72/d/61.jpg");
        urls.add("http://pic8.nipic.com/20100723/4943220_075234451520_2.jpg");
        urls.add("http://www.shifenkafei.com/data/upload/553deb1621af2.jpg");

        fbview.setPics(urls);

    }

    private void initialize() {

        fbview = (FamilyBookView) findViewById(R.id.fbview);
    }
}
