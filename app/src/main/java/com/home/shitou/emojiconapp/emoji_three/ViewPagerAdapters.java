package com.home.shitou.emojiconapp.emoji_three;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.List;

/**
 * 用途:
 *
 * @version V1.0 <描述当前版本功能>
 * @author: myName
 * @date: 2016-12-05 23:47
 */
public class ViewPagerAdapters extends PagerAdapter {

    private Context context;
    private List<GridView> gridViewList;

    public ViewPagerAdapters(Context context, List<GridView> gridViewList) {
        this.context = context;
        this.gridViewList = gridViewList;
    }

    @Override
    public int getCount() {
        return gridViewList.size();
    }

    @Override
    public Object instantiateItem(View arg0, int arg1) {
        ((ViewPager)arg0).addView(gridViewList.get(arg1));
        return gridViewList.get(arg1);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
