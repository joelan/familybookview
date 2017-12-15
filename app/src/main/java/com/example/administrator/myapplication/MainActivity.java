package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.viewlrq.customview.FBView;
import com.viewlrq.customview.FbViewItemonclickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FBView fbview;

    List<String> urls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initialize();
        urls=new ArrayList<>();
        urls.add("http://www.wallcoo.com/animal/MX069_Pretty_Puppies_puppy_garden_adventure/wallpapers/1920x1080/Garden_adventure_of_the_little_puppy_photos_pictures_puppy_MIL56021.jpg");

        urls.add("http://img1.3lian.com/2015/a2/246/d/58.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513318828457&di=4564e2d5bea542e5ef5e51cf5c7933f7&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fb21c8701a18b87d6cc08befb0d0828381e30fd88.jpg");
        urls.add("http://mvimg1.meitudata.com/566507ca1bcc65451.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513322919932&di=28019c0d23d2e7c6456b83c329baa42f&imgtype=0&src=http%3A%2F%2Fpic32.nipic.com%2F20130813%2F9422601_092646030000_2.jpg");

        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513327207780&di=7d28deec0a734f7a0f7eddb234fc604a&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Faa64034f78f0f736464e7d1f0055b319ebc4137f.jpg");

    /*   urls.add("http://img3.3lian.com/2013/v8/72/d/61.jpg");
        urls.add("http://pic8.nipic.com/20100723/4943220_075234451520_2.jpg");
        urls.add("http://www.shifenkafei.com/data/upload/553deb1621af2.jpg");
*/
        fbview.setPics(urls,new MyImageLoader());

        fbview.setItemclicklistener(new FbViewItemonclickListener() {
            @Override
            public void onItemClickListener(View view, int position) {

                Toast.makeText(MainActivity.this,"点击的位置为"+position,Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void initialize() {

        fbview = (FBView) findViewById(R.id.fbview);
    }
}
