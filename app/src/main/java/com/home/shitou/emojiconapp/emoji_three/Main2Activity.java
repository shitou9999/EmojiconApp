package com.home.shitou.emojiconapp.emoji_three;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.GridView;
import android.widget.TextView;

import com.home.shitou.emojiconapp.R;

import java.util.ArrayList;


//初始化// 设置详情,解析表情
//        SmileyParser.init(activity);
//        SmileyParser parser = SmileyParser.getInstance();
//        t.setText(parser.addSmileySpans(item.getTi_details()));
//        就是SmileyParser的addSmileySpans（String string）方法
public class Main2Activity extends AppCompatActivity {

    private ViewPager viewPager;
    private int[] expressionImages;
    private String[] expressionImageNames;
    private int[] expressionImages1;
    private String[] expressionImageNames1;
    private int[] expressionImages2;
    private String[] expressionImageNames2;
    private ArrayList<GridView> grids;
    private Boolean faceState = false;
    private GridView gView1;
    private GridView gView2;
    private GridView gView3;

    private ViewPagerAdapters adapter;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        viewPager= (ViewPager) findViewById(R.id.viewPager);
        text=(TextView) findViewById(R.id.text);


        initFace();
        initViewPager();
    }

    private void initFace() {
        expressionImages = Expressions.expressionImgs;
        expressionImageNames = Expressions.expressionImgNames;
        expressionImages1 = Expressions.expressionImgs1;
        expressionImageNames1 = Expressions.expressionImgNames1;
        expressionImages2 = Expressions.expressionImgs2;
        expressionImageNames2 = Expressions.expressionImgNames2;
    }
    private void initViewPager() {
        LayoutInflater inflater = LayoutInflater.from(this);
        grids = new ArrayList<GridView>();
        gView1 = (GridView) inflater.inflate(R.layout.grid1, null);
        grids.add(gView1);
        gView2 = (GridView) inflater.inflate(R.layout.grid2, null);
        grids.add(gView2);
        gView3 = (GridView) inflater.inflate(R.layout.grid3, null);
        grids.add(gView3);
        //这里不陌生吧，就是我们封装好的，想添加多少都行，这是初始化第一页表情
        SmileyGrid.initSimleGrid(this, expressionImages, expressionImageNames, gView1, text);
        adapter=new ViewPagerAdapters(this,grids);
        viewPager.setAdapter(adapter);
//        viewPager.setAdapter(AdapterUtil.getGridPager(grids));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                switch (arg0) {
                    //第二页表情
                    case 1:
                        // 生成表情
                        SmileyGrid.initSimleGrid(Main2Activity.this, expressionImages1, expressionImageNames1, gView2, text);
                        break;
                        //第三页表情
                    case 2:
                        // 生成表情
                        SmileyGrid.initSimleGrid(Main2Activity.this, expressionImages2, expressionImageNames2, gView3, text);
                        break;
                        //如果三页显示不完，就接着添加3.4.5要多少有多少直接调用SmileyGrid.initSimleGrid（）生成就行了，记得创建GridView在上面
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }




}
