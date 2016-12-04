package com.home.shitou.emojiconapp.emoji_two;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.home.shitou.emojiconapp.R;

import zhanghuan.cn.emojiconlibrary.FaceConversionUtil;
import zhanghuan.cn.emojiconlibrary.FaceRelativeLayout;

/**
 * 第二种写法
 */
public class EmoiconActivity extends AppCompatActivity {
    private EditText mEditEmojicon;
    private ImageView mSend;
    private TextView mShowTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoicon);

        initView();
    }

    private void initView() {
        mShowTxt = (TextView) findViewById(R.id.show);
        mEditEmojicon = (EditText) findViewById(R.id.et_sendmessage);

        mSend = (ImageView) findViewById(R.id.btn_send);
        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = "内容显示:" + mEditEmojicon.getText().toString();
                showText(content);
            }
        });
    }

    private void showText(String content) {
        SpannableString spannableString = FaceConversionUtil.getInstace().getExpressionString(EmoiconActivity.this, content);
        mShowTxt.setText(spannableString);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && ((FaceRelativeLayout) findViewById(R.id.FaceRelativeLayout)).hideFaceView()) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
