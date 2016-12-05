package com.home.shitou.emojiconapp.emoji_three;

import com.home.shitou.emojiconapp.R;

//        1.拷贝表情图片资源到drawable其中的文件下，如图：
//        2.编辑表情对应的文字，封装成arrays.xml文件，如图：
//        3.封装表情和图片对应的类：
/**
* 表情图片和资源对照表
* @author 幸福
* */
public class Expressions {

        public static int[] expressionImgs = new int[] { R.drawable.d_zuiyou,
                        R.drawable.d_hehe, R.drawable.d_haha,
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
                        R.drawable.d_shuai };
        public static String[] expressionImgNames = new String[] { "[呲牙]", "[调皮]",
                        "[流汗]", "[偷笑]", "[再见]", "[敲打]", "[擦汗]", "[流泪]", "[大哭]", "[嘘...]",
                        "[酷]", "[抓狂]", "[委屈]", "[便便]", "[可爱]", "[色]", "[害羞]", "[得意]",
                        "[吐]", "[微笑]", "[发怒]", "[尴尬]", "[惊恐]", "[冷汗]" };

        public static int[] expressionImgs1 = new int[] { R.drawable.d_bizui,
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
                        R.drawable.d_ganmao };

        public static String[] expressionImgNames1 = new String[] { "[示爱]", "[白眼]",
                        "[傲慢]", "[惊讶]", "[疑问]", "[睡]", "[亲亲]", "[憨笑]", "[爱情]", "[撇嘴]",
                        "[阴脸]", "[奋斗]", "[发呆]", "[右哼哼]", "[拥抱]", "[坏笑]", "[鄙视]", "[晕]",
                        "[大兵]", "[可怜]", "[强]", "[弱]", "[握手]", "[胜利]" };

        public static int[] expressionImgs2 = new int[] { R.drawable.d_baibai,
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
                        R.drawable.h_quantou, R.drawable.f_v5,
                        R.drawable.w_xianhua };

        public static String[] expressionImgNames2 = new String[] { "[抱拳]", "[蛋糕]",
                        "[啤酒]", "[勾你]", "[爱你]", "[咖啡]", "[差劲]", "[拳头]", "[心碎]", "[足球]",
                        "[饥饿]", "[困]", "[咒骂]", "[折磨]", "[抠鼻]", "[鼓掌]", "[糗大了]", "[左哼哼]",
                        "[哈欠]", "[快哭了]", "[吓]", "[篮球]", "[乒乓]", "[NO]" };

        public static String[] replaceStrings(String[] str, String[] str2) {
                String newStr[] = new String[str.length - 1];
                for (int i = 0; i < str.length; i++) {
//                        newStr = str.replace(str, str2);
                        newStr[i] = str[i].replace(str[i], str2[i]);
                }
                return newStr;
        }

}
