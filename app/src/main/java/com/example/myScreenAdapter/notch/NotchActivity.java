package com.example.myScreenAdapter.notch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myScreenAdapter.R;
import com.example.myScreenAdapter.density.BaseActivtiy;
import com.example.myScreenAdapter.pixel.ScreenAdapterLayout;

public class NotchActivity extends BaseActivtiy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notch);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(getIsHasCutout()){
            ScreenAdapterLayout layout = findViewById(R.id.layout);

            layout.setPadding(0, StatusBarUtil.getStatusBarHeight(this)
                    , 0, 0);
        }
    }

}
