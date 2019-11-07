package com.example.myScreenAdapter.density;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

import androidx.annotation.NonNull;

/**
 * Created by luoling on 2019/11/6.
 * description: 修改density，densityDpi值-直接更改系统内部对于目标尺寸而言的像素密度
 */

public class DensityUtils {

    //参考像素密度（dp）
    private static final float WIDTH = 360;
    //表示屏幕密度
    private static float appDensity;
    //字体缩放比例，默认为appDensity
    private static float appScaleDensity;

    public static void setDensity(final Application application, Activity activity){
        DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
        if (appDensity == 0){
            appDensity = displayMetrics.density;
            appScaleDensity = displayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(@NonNull Configuration newConfig) {
                    //字体发生更改，重新计算scaleDensity
                    if (newConfig != null && newConfig.fontScale > 0){
                        appScaleDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }
        //计算目标density scaledDensity
        float targetDensity = displayMetrics.widthPixels / WIDTH;
        float targetScaleDensity = targetDensity * (appScaleDensity / appDensity);
        int targetDensityDpi = (int) (targetDensity * 160);
        //替换Activity的值
        //px = dp * (dpi / 160)
        DisplayMetrics dm = activity.getResources().getDisplayMetrics();
        dm.density = targetDensity;
        dm.densityDpi = targetDensityDpi;
        dm.scaledDensity = targetScaleDensity;
    }

}
