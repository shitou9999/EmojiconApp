package com.home.shitou.emojiconapp.emoji_three;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.home.shitou.emojiconapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 填充装载表情的控件
* 
* @author幸福
* @since 2014-12-12
* */
public class SmileyGrid {
        //（表情数组）  （表情对应文字数组）（装载控件）（要填充内容的控件）
        public static void initSimleGrid(final Activity activity, final int[] expressionImages1,
                        final String[] expressionImageNames1, GridView gridView, final TextView content_et) {
                List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
                // 生成24个表情
                for (int i = 0; i < 24; i++) {
                        Map<String, Object> listItem = new HashMap<String, Object>();
                        listItem.put("image", expressionImages1);
                        listItems.add(listItem);
                }
                SimpleAdapter simpleAdapter = new SimpleAdapter(activity, listItems,
                        R.layout.singleexpression, new String[] { "image" }, new int[] { R.id.image });
                gridView.setAdapter(simpleAdapter);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                                Bitmap bitmap = null;
                                bitmap = BitmapFactory.decodeResource(activity.getResources(),
                                                expressionImages1[arg2 % expressionImages1.length]);
                                int width = bitmap.getWidth();
                                int height = bitmap.getHeight();
                                Matrix matrix = new Matrix();
                                // 缩放图片动作
                                matrix.postScale(0.45f, 0.45f);
                                Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                                ImageSpan imageSpan = new ImageSpan(activity, resizedBitmap);
                                SpannableString spannableString = new SpannableString(
                                                expressionImageNames1[arg2].substring(0, expressionImageNames1[arg2].length()));
                                spannableString.setSpan(imageSpan, 0,
                                                expressionImageNames1[arg2].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                // 编辑框设置数据
                                content_et.append(spannableString);
                        }
                });

        }
}