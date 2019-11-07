package com.example.myScreenAdapter.notch.callback;

import android.view.DisplayCutout;

/**
 * Created by luoling on 2019/11/7.
 * description: 判断手机是否含有刘海区
 */
public interface OnCutoutDetailListener extends OnCutoutListener {

    void onCutout(DisplayCutout cutout);

}
