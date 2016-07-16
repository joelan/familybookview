package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2016/7/12.
 */
public class FamilyBookView extends LinearLayout {


    Context context;

    int picnum;
    public FamilyBookView(Context context) {
        super(context);
        this.context=context;
    }



    public FamilyBookView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
    }

    public FamilyBookView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;

        Log.i("familytbookView","on");
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.familybookview);

        picnum   =typedArray.getInteger(R.styleable.familybookview_picnum,1);

        String url=typedArray.getString(R.styleable.familybookview_picurl);

        Log.i("familytbookView","picnum="+picnum);
        Log.i("familytbookView","url="+url);
        setOrientation(LinearLayout.HORIZONTAL);

        int showpicnum=0;

        showpicnum=picnum;
        if(picnum>5)
            showpicnum=5;
        if(picnum<0)
            showpicnum=0;

        switch (showpicnum)
        {

            case 0:


              setVisibility(GONE);

                break;
            case 1:

                removeAllViewsInLayout();
                setOrientation(LinearLayout.HORIZONTAL);
                ImageView iv=new ImageView(context);

                iv.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

                iv.setAdjustViewBounds(true);

                if(!TextUtils.isEmpty(url))
                    ImageLoader.getInstance().displayImage(url,iv);
                addView(iv);
                iv.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                break;

            case 2:
                removeAllViewsInLayout();
                setOrientation(LinearLayout.HORIZONTAL);
                DisplayMetrics dm = new DisplayMetrics();
                //取得窗口属性
                Activity activity= (Activity) context;
                activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
                ImageView iv1=new ImageView(context);
                ImageView iv2=new ImageView(context);

                LinearLayout.LayoutParams lp=   new LayoutParams(0,dm.widthPixels/2);
                LinearLayout.LayoutParams lp2=   new LayoutParams(0,dm.widthPixels/2);

                lp.rightMargin= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1.5f,dm);

                lp2.leftMargin=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1.5f,dm);

                lp.weight=1;
                lp2.weight=1;
                        iv1.setLayoutParams(lp);

                iv2.setLayoutParams(lp2);

                iv1.setScaleType(ImageView.ScaleType.CENTER_CROP);
                iv2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(iv1);

                addView(iv2);

                iv1.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));

                iv2.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));

                break;

            case 3:
                removeAllViewsInLayout();
                setOrientation(LinearLayout.HORIZONTAL);
                DisplayMetrics dmx = new DisplayMetrics();
                //取得窗口属性
                Activity activityx= (Activity) context;
                activityx.getWindowManager().getDefaultDisplay().getMetrics(dmx);
                ImageView iv1x=new ImageView(context);
                ImageView iv2x=new ImageView(context);
                ImageView iv3=new ImageView(context);
                LinearLayout lin=new LinearLayout(context);
                lin.setOrientation(LinearLayout.VERTICAL);


                LinearLayout.LayoutParams linlp=new LinearLayout.LayoutParams((int)(dmx.widthPixels*(1f/3f)),(int)(dmx.widthPixels*(2f/3f)));

                linlp.leftMargin=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1.5f,dmx);
                lin.setLayoutParams(linlp);

                LinearLayout.LayoutParams lpx=   new LayoutParams(dmx.widthPixels/3,dmx.widthPixels/3);
                LinearLayout.LayoutParams lp2x=   new LayoutParams(dmx.widthPixels/3,dmx.widthPixels/3);

                LinearLayout.LayoutParams lp3=   new LayoutParams(0,(int)(dmx.widthPixels*(2f/3f)));


              /*  lpx.weight=1;
                lp2x.weight=1;*/
                lpx.bottomMargin=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1.5f,dmx);
                lp2x.topMargin=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1.5f,dmx);

                lp3.weight=1;
                lp3.rightMargin=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1.5f,dmx);


                iv1x.setLayoutParams(lpx);
                iv2x.setLayoutParams(lp2x);
                iv3.setLayoutParams(lp3);

                iv1x.setScaleType(ImageView.ScaleType.CENTER_CROP);
                iv2x.setScaleType(ImageView.ScaleType.CENTER_CROP);
                iv3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                lin.addView(iv1x);
                lin.addView(iv2x);

                addView(iv3);
                addView(lin);
                if(!TextUtils.isEmpty(url))
                    ImageLoader.getInstance().displayImage(url,iv1x);
                if(!TextUtils.isEmpty(url))
                    ImageLoader.getInstance().displayImage(url,iv2x);
                if(!TextUtils.isEmpty(url))
                    ImageLoader.getInstance().displayImage(url,iv3);

                iv1x.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));

                iv2x.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                iv3.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
                break;

            case 4:

                removeAllViewsInLayout();
                setOrientation(LinearLayout.VERTICAL);

                DisplayMetrics dmx4 = new DisplayMetrics();
                //取得窗口属性
                Activity activityx4= (Activity) context;
                activityx4.getWindowManager().getDefaultDisplay().getMetrics(dmx4);
                LinearLayout lin4=new LinearLayout(context);
                lin4.setOrientation(LinearLayout.HORIZONTAL);


                LinearLayout.LayoutParams lin4lp=new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,(int)(dmx4.widthPixels*(1f/3f)));

                lin4lp.topMargin=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,3f,dmx4);
                lin4.setLayoutParams(lin4lp);

                ImageView iv41=new ImageView(context);


                ImageView iv42=new ImageView(context);
                ImageView iv43=new ImageView(context);
                ImageView iv44=new ImageView(context);

                LinearLayout.LayoutParams iv42p=   new LayoutParams(0,dmx4.widthPixels/3);
                LinearLayout.LayoutParams iv43p=   new LayoutParams(0,dmx4.widthPixels/3);
                LinearLayout.LayoutParams iv44p=   new LayoutParams(0,dmx4.widthPixels/3);

                LinearLayout.LayoutParams iv41p=   new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,(int)(dmx4.widthPixels*(2f/3f)));

                iv42p.weight=1;
                iv43p.weight=1;
                iv44p.weight=1;
                iv42p.rightMargin=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3*(2f/3f),dmx4);
                iv43p.leftMargin=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3*(1f/3f),dmx4);
                iv43p.rightMargin=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,3*(1f/3f),dmx4);
                iv44p.leftMargin=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3*(2f/3f),dmx4);


                iv42.setLayoutParams(iv42p);
                iv43.setLayoutParams(iv43p);
                iv44.setLayoutParams(iv44p);
                iv41.setLayoutParams(iv41p);


                iv41.setScaleType(ImageView.ScaleType.CENTER_CROP);
                iv42.setScaleType(ImageView.ScaleType.CENTER_CROP);
                iv43.setScaleType(ImageView.ScaleType.CENTER_CROP);

                iv44.setScaleType(ImageView.ScaleType.CENTER_CROP);

                lin4.addView(iv42);
                lin4.addView(iv43);
                lin4.addView(iv44);

                addView(iv41);
                addView(lin4);


                if(!TextUtils.isEmpty(url))
                    ImageLoader.getInstance().displayImage(url,iv41);
                if(!TextUtils.isEmpty(url))
                    ImageLoader.getInstance().displayImage(url,iv42);
                if(!TextUtils.isEmpty(url))
                    ImageLoader.getInstance().displayImage(url,iv43);
                if(!TextUtils.isEmpty(url))
                    ImageLoader.getInstance().displayImage(url,iv44);

                iv41.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));

                iv42.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                iv43.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
                iv44.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));

                break;

            case 5:
                Log.i("familytbookView","casee=5");
                removeAllViewsInLayout();
                setOrientation(LinearLayout.VERTICAL);

                DisplayMetrics dmx5 = new DisplayMetrics();
                //取得窗口属性
                Activity activityx5= (Activity) context;
                activityx5.getWindowManager().getDefaultDisplay().getMetrics(dmx5);


                LinearLayout lin5down=new LinearLayout(context);
                lin5down.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams lin5lp=new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,(int)(dmx5.widthPixels*(1f/3f)));
                lin5lp.topMargin=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3f/2f,dmx5);
                lin5down.setLayoutParams(lin5lp);

                LinearLayout lin5up=new LinearLayout(context);
                lin5up.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams linlpup=new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,(int)(dmx5.widthPixels*(1f/2f)));
                linlpup.bottomMargin=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3f/2f,dmx5);
                lin5up.setLayoutParams(linlpup);


                ImageView iv51=new ImageView(context);
                ImageView iv52=new ImageView(context);


                ImageView iv53=new ImageView(context);
                ImageView iv54=new ImageView(context);
                ImageView iv55=new ImageView(context);


                LinearLayout.LayoutParams iv51p=   new LayoutParams(0,dmx5.widthPixels/2);
                LinearLayout.LayoutParams iv52p=   new LayoutParams(0,dmx5.widthPixels/2);

                LinearLayout.LayoutParams iv53p=   new LayoutParams(0,dmx5.widthPixels/3);
                LinearLayout.LayoutParams iv54p=   new LayoutParams(0,dmx5.widthPixels/3);
                LinearLayout.LayoutParams iv55p=   new LayoutParams(0,dmx5.widthPixels/3);



               // LinearLayout.LayoutParams iv51p=   new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,(int)(dmx5.widthPixels*(2f/3f)));

                iv51p.weight=1;
                iv52p.weight=1;
                iv53p.weight=1;
                iv54p.weight=1;
                iv55p.weight=1;

                iv51p.rightMargin=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1.5f,dmx5);
                iv52p.leftMargin=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1.5f,dmx5);

                iv53p.rightMargin=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3*(2f/3f),dmx5);
                iv54p.leftMargin=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3*(1f/3f),dmx5);
                iv54p.rightMargin=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,3*(1f/3f),dmx5);
                iv55p.leftMargin=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3*(2f/3f),dmx5);


               iv51.setLayoutParams(iv51p);
               iv52.setLayoutParams(iv52p);

                iv53.setLayoutParams(iv53p);
                iv54.setLayoutParams(iv54p);
                iv55.setLayoutParams(iv55p);


               // iv51.setLayoutParams(iv51p);


                iv51.setScaleType(ImageView.ScaleType.CENTER_CROP);
                iv52.setScaleType(ImageView.ScaleType.CENTER_CROP);
                iv53.setScaleType(ImageView.ScaleType.CENTER_CROP);

                iv54.setScaleType(ImageView.ScaleType.CENTER_CROP);

                iv54.setScaleType(ImageView.ScaleType.CENTER_CROP);


                lin5up.addView(iv51);
                lin5up.addView(iv52);

                lin5down.addView(iv53);
                lin5down.addView(iv54);
                lin5down.addView(iv55);

                //ddView(iv51);
                addView(lin5up);
                addView(lin5down);


                if(!TextUtils.isEmpty(url))
                    ImageLoader.getInstance().displayImage(url,iv51);
                if(!TextUtils.isEmpty(url))
                    ImageLoader.getInstance().displayImage(url,iv52);
                if(!TextUtils.isEmpty(url))
                    ImageLoader.getInstance().displayImage(url,iv53);
                if(!TextUtils.isEmpty(url))
                    ImageLoader.getInstance().displayImage(url,iv54);
                if(!TextUtils.isEmpty(url))
                    ImageLoader.getInstance().displayImage(url,iv54);

                iv51.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));

                iv52.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                iv53.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
                iv54.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
                iv55.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));

                break;
        }




    }

    public void setPics(List<String> urls)
    {

        if(urls!=null) {

            int showpicnum = 0;
            picnum=urls.size();
            showpicnum = picnum;
            if (picnum > 5)
                showpicnum = 5;
            if (picnum < 0)
                showpicnum = 0;

            switch (showpicnum) {

                case 0:


                    setVisibility(GONE);

                    break;
                case 1:

                    removeAllViewsInLayout();
                    setOrientation(LinearLayout.HORIZONTAL);
                    ImageView iv = new ImageView(context);

                    iv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

                    iv.setAdjustViewBounds(true);

                    if (!TextUtils.isEmpty(urls.get(0)))
                        ImageLoader.getInstance().displayImage(urls.get(0), iv, DisplayImageOptions.createSimple());
                    addView(iv);
              /*      iv.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));*/
                    break;

                case 2:
                    removeAllViewsInLayout();
                    setOrientation(LinearLayout.HORIZONTAL);
                    DisplayMetrics dm = new DisplayMetrics();
                    //取得窗口属性
                    Activity activity = (Activity) context;
                    activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
                    ImageView iv1 = new ImageView(context);
                    ImageView iv2 = new ImageView(context);

                    LinearLayout.LayoutParams lp = new LayoutParams(0, dm.widthPixels / 2);
                    LinearLayout.LayoutParams lp2 = new LayoutParams(0, dm.widthPixels / 2);

                    lp.rightMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1.5f, dm);

                    lp2.leftMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1.5f, dm);

                    lp.weight = 1;
                    lp2.weight = 1;
                    iv1.setLayoutParams(lp);

                    iv2.setLayoutParams(lp2);

                    iv1.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    iv2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    addView(iv1);

                    addView(iv2);


                    if (!TextUtils.isEmpty(urls.get(0)))
                        ImageLoader.getInstance().displayImage(urls.get(0), iv1, DisplayImageOptions.createSimple());
                    if (!TextUtils.isEmpty(urls.get(1)))
                        ImageLoader.getInstance().displayImage(urls.get(1), iv2, DisplayImageOptions.createSimple());
              /*      iv1.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));

                    iv2.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));*/

                    break;

                case 3:
                    removeAllViewsInLayout();
                    setOrientation(LinearLayout.HORIZONTAL);
                    DisplayMetrics dmx = new DisplayMetrics();
                    //取得窗口属性
                    Activity activityx = (Activity) context;
                    activityx.getWindowManager().getDefaultDisplay().getMetrics(dmx);
                    ImageView iv1x = new ImageView(context);
                    ImageView iv2x = new ImageView(context);
                    ImageView iv3 = new ImageView(context);
                    LinearLayout lin = new LinearLayout(context);
                    lin.setOrientation(LinearLayout.VERTICAL);


                    LinearLayout.LayoutParams linlp = new LinearLayout.LayoutParams((int) (dmx.widthPixels * (1f / 3f)), (int) (dmx.widthPixels * (2f / 3f)));

                    linlp.leftMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1.5f, dmx);
                    lin.setLayoutParams(linlp);

                    LinearLayout.LayoutParams lpx = new LayoutParams(dmx.widthPixels / 3, dmx.widthPixels / 3);
                    LinearLayout.LayoutParams lp2x = new LayoutParams(dmx.widthPixels / 3, dmx.widthPixels / 3);

                    LinearLayout.LayoutParams lp3 = new LayoutParams(0, (int) (dmx.widthPixels * (2f / 3f)));


              /*  lpx.weight=1;
                lp2x.weight=1;*/
                    lpx.bottomMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1.5f, dmx);
                    lp2x.topMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1.5f, dmx);

                    lp3.weight = 1;
                    lp3.rightMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1.5f, dmx);


                    iv1x.setLayoutParams(lpx);
                    iv2x.setLayoutParams(lp2x);
                    iv3.setLayoutParams(lp3);

                    iv1x.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    iv2x.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    iv3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    lin.addView(iv1x);
                    lin.addView(iv2x);

                    addView(iv3);
                    addView(lin);
                    if (!TextUtils.isEmpty(urls.get(0)))
                        ImageLoader.getInstance().displayImage(urls.get(0), iv1x);
                    if (!TextUtils.isEmpty(urls.get(1)))
                        ImageLoader.getInstance().displayImage(urls.get(1), iv2x);
                    if (!TextUtils.isEmpty(urls.get(2)))
                        ImageLoader.getInstance().displayImage(urls.get(2), iv3);

                /*    iv1x.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));

                    iv2x.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                    iv3.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));*/
                    break;

                case 4:

                    removeAllViewsInLayout();
                    setOrientation(LinearLayout.VERTICAL);

                    DisplayMetrics dmx4 = new DisplayMetrics();
                    //取得窗口属性
                    Activity activityx4 = (Activity) context;
                    activityx4.getWindowManager().getDefaultDisplay().getMetrics(dmx4);
                    LinearLayout lin4 = new LinearLayout(context);
                    lin4.setOrientation(LinearLayout.HORIZONTAL);


                    LinearLayout.LayoutParams lin4lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int) (dmx4.widthPixels * (1f / 3f)));

                    lin4lp.topMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3f, dmx4);
                    lin4.setLayoutParams(lin4lp);

                    ImageView iv41 = new ImageView(context);


                    ImageView iv42 = new ImageView(context);
                    ImageView iv43 = new ImageView(context);
                    ImageView iv44 = new ImageView(context);

                    LinearLayout.LayoutParams iv42p = new LayoutParams(0, dmx4.widthPixels / 3);
                    LinearLayout.LayoutParams iv43p = new LayoutParams(0, dmx4.widthPixels / 3);
                    LinearLayout.LayoutParams iv44p = new LayoutParams(0, dmx4.widthPixels / 3);

                    LinearLayout.LayoutParams iv41p = new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) (dmx4.widthPixels * (2f / 3f)));

                    iv42p.weight = 1;
                    iv43p.weight = 1;
                    iv44p.weight = 1;
                    iv42p.rightMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3 * (2f / 3f), dmx4);
                    iv43p.leftMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3 * (1f / 3f), dmx4);
                    iv43p.rightMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3 * (1f / 3f), dmx4);
                    iv44p.leftMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3 * (2f / 3f), dmx4);


                    iv42.setLayoutParams(iv42p);
                    iv43.setLayoutParams(iv43p);
                    iv44.setLayoutParams(iv44p);
                    iv41.setLayoutParams(iv41p);


                    iv41.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    iv42.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    iv43.setScaleType(ImageView.ScaleType.CENTER_CROP);

                    iv44.setScaleType(ImageView.ScaleType.CENTER_CROP);

                    lin4.addView(iv42);
                    lin4.addView(iv43);
                    lin4.addView(iv44);

                    addView(iv41);
                    addView(lin4);


                    if (!TextUtils.isEmpty(urls.get(0)))
                        ImageLoader.getInstance().displayImage(urls.get(0), iv41,DisplayImageOptions.createSimple());
                    if (!TextUtils.isEmpty(urls.get(1)))
                        ImageLoader.getInstance().displayImage(urls.get(1), iv42,DisplayImageOptions.createSimple());
                    if (!TextUtils.isEmpty(urls.get(2)))
                        ImageLoader.getInstance().displayImage(urls.get(2), iv43,DisplayImageOptions.createSimple());
                    if (!TextUtils.isEmpty(urls.get(3)))
                        ImageLoader.getInstance().displayImage(urls.get(3), iv44,DisplayImageOptions.createSimple());

  /*                  iv41.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));

                    iv42.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                    iv43.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
                    iv44.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));*/

                    break;

                case 5:
                    Log.i("familytbookView", "casee=5");
                    removeAllViewsInLayout();
                    setOrientation(LinearLayout.VERTICAL);

                    DisplayMetrics dmx5 = new DisplayMetrics();
                    //取得窗口属性
                    Activity activityx5 = (Activity) context;
                    activityx5.getWindowManager().getDefaultDisplay().getMetrics(dmx5);


                    LinearLayout lin5down = new LinearLayout(context);
                    lin5down.setOrientation(LinearLayout.HORIZONTAL);
                    LinearLayout.LayoutParams lin5lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int) (dmx5.widthPixels * (1f / 3f)));
                    lin5lp.topMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3f / 2f, dmx5);
                    lin5down.setLayoutParams(lin5lp);

                    LinearLayout lin5up = new LinearLayout(context);
                    lin5up.setOrientation(LinearLayout.HORIZONTAL);
                    LinearLayout.LayoutParams linlpup = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int) (dmx5.widthPixels * (1f / 2f)));
                    linlpup.bottomMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3f / 2f, dmx5);
                    lin5up.setLayoutParams(linlpup);


                    ImageView iv51 = new ImageView(context);
                    ImageView iv52 = new ImageView(context);


                    ImageView iv53 = new ImageView(context);
                    ImageView iv54 = new ImageView(context);


                    RelativeLayout rela=new RelativeLayout(context);

                    ImageView iv55 = new ImageView(context);
                    TextView ivt5txt=new TextView(context);


                    iv55.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));
                    ivt5txt.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));

                    LinearLayout.LayoutParams iv51p = new LayoutParams(0, dmx5.widthPixels / 2);
                    LinearLayout.LayoutParams iv52p = new LayoutParams(0, dmx5.widthPixels / 2);

                    LinearLayout.LayoutParams iv53p = new LayoutParams(0, dmx5.widthPixels / 3);
                    LinearLayout.LayoutParams iv54p = new LayoutParams(0, dmx5.widthPixels / 3);

                    LinearLayout.LayoutParams iv55p = new LayoutParams(0, dmx5.widthPixels / 3);


                    // LinearLayout.LayoutParams iv51p=   new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,(int)(dmx5.widthPixels*(2f/3f)));

                    iv51p.weight = 1;
                    iv52p.weight = 1;
                    iv53p.weight = 1;
                    iv54p.weight = 1;

                    iv55p.weight = 1;

                    iv51p.rightMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1.5f, dmx5);
                    iv52p.leftMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1.5f, dmx5);

                    iv53p.rightMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3 * (2f / 3f), dmx5);
                    iv54p.leftMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3 * (1f / 3f), dmx5);
                    iv54p.rightMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3 * (1f / 3f), dmx5);
                    iv55p.leftMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3 * (2f / 3f), dmx5);


                    iv51.setLayoutParams(iv51p);
                    iv52.setLayoutParams(iv52p);

                    iv53.setLayoutParams(iv53p);
                    iv54.setLayoutParams(iv54p);


                    rela.setLayoutParams(iv55p);


                    // iv51.setLayoutParams(iv51p);


                    iv51.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    iv52.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    iv53.setScaleType(ImageView.ScaleType.CENTER_CROP);

                    iv54.setScaleType(ImageView.ScaleType.CENTER_CROP);

                    iv55.setScaleType(ImageView.ScaleType.CENTER_CROP);


                    lin5up.addView(iv51);
                    lin5up.addView(iv52);


                    rela.addView(iv55);
                    rela.addView(ivt5txt);

                    lin5down.addView(iv53);
                    lin5down.addView(iv54);
                    lin5down.addView(rela);

                    //ddView(iv51);
                    addView(lin5up);
                    addView(lin5down);


                    if (!TextUtils.isEmpty(urls.get(0)))
                        ImageLoader.getInstance().displayImage(urls.get(0), iv51,DisplayImageOptions.createSimple());
                    if (!TextUtils.isEmpty(urls.get(1)))
                        ImageLoader.getInstance().displayImage(urls.get(1), iv52,DisplayImageOptions.createSimple());
                    if (!TextUtils.isEmpty(urls.get(2)))
                        ImageLoader.getInstance().displayImage(urls.get(2), iv53,DisplayImageOptions.createSimple());
                    if (!TextUtils.isEmpty(urls.get(3)))
                        ImageLoader.getInstance().displayImage(urls.get(3), iv54,DisplayImageOptions.createSimple());
                    if (!TextUtils.isEmpty(urls.get(4)))
                        ImageLoader.getInstance().displayImage(urls.get(4), iv55,DisplayImageOptions.createSimple());



                    ivt5txt.setGravity(Gravity.CENTER);
                    ivt5txt.setTextColor(getResources().getColor(android.R.color.white));

                    int restnum=0;
                    if(urls.size()>showpicnum)
                    {
                        restnum=  urls.size()-showpicnum;
                        ivt5txt.setText("+" + restnum);
                        ivt5txt.setTextSize(20);
                        ivt5txt.setBackgroundColor(0x80716f70);

                        ivt5txt.setVisibility(VISIBLE);

                    }
                    else
                    {
                        ivt5txt.setVisibility(GONE);
                    }

                    /*iv51.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));

                    iv52.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                    iv53.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
                    iv54.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
                    iv55.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));*/

                    break;
            }


        }

    }

}
