package com.home.shitou.emojiconapp.emoji_three;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;

import com.home.shitou.emojiconapp.R;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmileyParser {
        /*
         * 单例模式 1文字资源，图片资源 2.使用正则表达式进行匹配文字 3.把edittext当中整体的内容匹配正则表达式一次
         * 4.SpannableStringBuilder 进行替换
         */
        private static SmileyParser sInstance;

        public static SmileyParser getInstance() {
                return sInstance;
        }

        public static void init(Context context) {
                sInstance = new SmileyParser(context);
        }

        private final Context mContext;
        private final String[] arrText;
        // 正则表达式
        private final Pattern mPattern;
        // String 图片字符串 Integer表情
        private final HashMap<String, Integer> mSmileyToRes;
        // arrays里面的表情内容
        public static final int DEFAULT_SMILEY_TEXTS = R.array.default_smiley_texts;

        private SmileyParser(Context context) {
                mContext = context;
                // 获取表情文字资源
                arrText = mContext.getResources().getStringArray(DEFAULT_SMILEY_TEXTS);
                // 获取表情ID与表情图标的Map
                mSmileyToRes = buildSmileyToRes();
                // 获取构建的正则表达式
                mPattern = buildPattern();
        }

        // 表情图片集合
        private static final int[] DEFAULT_SMILEY_RES_IDS = {
                        R.drawable.d_zuiyou, R.drawable.d_haha,
                R.drawable.d_xixi, R.drawable.d_aini,
                R.drawable.d_wabishi, R.drawable.d_chijing,
                R.drawable.d_yun, R.drawable.d_lei,
                R.drawable.d_chanzui, R.drawable.d_zhuakuang,
                R.drawable.d_heng, R.drawable.d_keai,
                R.drawable.d_nu, R.drawable.d_han,
                R.drawable.d_haixiu, R.drawable.d_shuijiao,
                R.drawable.d_qian, R.drawable.d_touxiao,
                R.drawable.d_xiaoku, R.drawable.d_doge,
                R.drawable.d_miao, R.drawable.d_ku,
                R.drawable.d_bishi, R.drawable.d_huaxin,
                R.drawable.d_guzhang, R.drawable.d_beishang,
                R.drawable.d_sikao, R.drawable.d_shengbing,
                R.drawable.d_qinqin, R.drawable.d_numa,
                R.drawable.d_taikaixin, R.drawable.d_landelini,
                R.drawable.d_youhengheng, R.drawable.d_zuohengheng,
                R.drawable.d_xu, R.drawable.d_weiqu,
                R.drawable.d_tu, R.drawable.d_kelian,
                R.drawable.d_dahaqi, R.drawable.d_jiyan,
                R.drawable.d_shiwang, R.drawable.d_ding,
                R.drawable.d_yiwen, R.drawable.d_kun,
                R.drawable.d_heixian, R.drawable.d_yinxian,
                R.drawable.d_dalian, R.drawable.d_shayan,
                R.drawable.f_hufen, R.drawable.l_xin,
                R.drawable.l_shangxin, R.drawable.d_zhutou,
                R.drawable.d_xiongmao, R.drawable.d_tuzi,
                R.drawable.h_woshou, R.drawable.h_zuoyi,
                R.drawable.h_zan, R.drawable.h_ye,
                R.drawable.h_good, R.drawable.h_ruo,
                R.drawable.h_buyao, R.drawable.h_ok,
                R.drawable.h_haha, R.drawable.h_lai,
                R.drawable.h_quantou, R.drawable.f_v5 };

        /**
         * 使用HashMap的key-value的形式来影射表情的ID和图片资源
         * 
         * @return
         */
        private HashMap<String, Integer> buildSmileyToRes() {
                if (DEFAULT_SMILEY_RES_IDS.length != arrText.length) {
                        throw new IllegalStateException("ID和图片不匹配");
                }
                HashMap<String, Integer> smileyToRes = new HashMap<String, Integer>(arrText.length);
                for (int i = 0; i < arrText.length; i++) {
                        // 图片名称作为key值，图片资源ID作为value值
                        smileyToRes.put(arrText[i], DEFAULT_SMILEY_RES_IDS[i]);
                }
                return smileyToRes;
        }

        /**
         * 构建正则表达式,用来找到我们所要使用的图片
         * @return
         */
        private Pattern buildPattern() {
                StringBuilder patternString = new StringBuilder(arrText.length * 3);
                patternString.append('(');
                for (String s : arrText) {
                        patternString.append(Pattern.quote(s));
                        patternString.append('|');
                }
                patternString.replace(patternString.length() - 1,
                                patternString.length(), ")");
                // 把String字符串编译成正则表达式()
                // ([调皮]|[调皮]|[调皮])
                return Pattern.compile(patternString.toString());
        }

        /**
         * 根据文本替换成图片
         * 
         * @param text
         *            对应表情
         * @return 一个表示图片的序列
         */
        public CharSequence addSmileySpans(CharSequence text) {
                // 把文字替换为对应图片
                SpannableStringBuilder builder = new SpannableStringBuilder(text);
                // 判断提取工具类（按照正则表达式）
                Matcher matcher = mPattern.matcher(text);
                while (matcher.find()) {
                        // 获取对应表情的图片id
                        int resId = mSmileyToRes.get(matcher.group());
                        // 替换制定字符
                        builder.setSpan(new ImageSpan(mContext, resId), matcher.start(),
                                        matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                return builder;
        }
}