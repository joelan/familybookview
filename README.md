# familybookview
## 仿facebook  好友动态ListViewitem里面的图片布局格局，根据图片数量个数，出现不一样的图片布局。

## 截图：
![image](https://github.com/joelan/familybookview/raw/master/screenshoot/Screenshot_2016-07-17-2.png)
![image](https://github.com/joelan/familybookview/raw/master/screenshoot/Screenshot_2016-07-17-3.png)
![image](https://github.com/joelan/familybookview/raw/master/screenshoot/Screenshot_2016-07-17_4.png)
![image](https://github.com/joelan/familybookview/raw/master/screenshoot/Screenshot_2016-07-16.png)

## 1.集成
### 添加依赖
### 依赖库分发在Jcenter。
```groovy
dependencies {
compile 'com.lrq.view:fbviewlibrary:1.0.1'
}
```

### 2.使用
#### (1)布局上添加如下代码
```xml
    <com.viewlrq.customview.FBView
        android:layout_width="match_parent"
        android:id="@+id/fbview"
        android:layout_height="wrap_content">


    </com.viewlrq.customview.FBView>
```
#### (2)在代码里，传url列表和图片加载Loader到FBview里（setpics调用的时候也同时开始图片加载展现了）
```java
List<String> urls;
urls=new ArrayList<>();
     urls.add("http://www.wallcoo.com/animal/MX069_Pretty_Puppies_puppy_garden_adventure/wallpapers/1920x1080/Garden_adventure_of_the_little_puppy_photos_pictures_puppy_MIL56021.jpg");
urls.add("http://img1.3lian.com/2015/a2/246/d/58.jpg");

//传网络图片url列表到fbview里，并传进实现om.viewlrq.customview.Loader接口的类进行图片加载，具体实现参考Demo。
fbview.setPics(urls,new MyImageLoader());

//设置每一个图片点击事件
fbview.setItemclicklistener(new FbViewItemonclickListener() {
            @Override
            public void onItemClickListener(View view, int position) {

                Toast.makeText(MainActivity.this,"点击的位置为"+position,Toast.LENGTH_SHORT).show();

            }
        });

```



