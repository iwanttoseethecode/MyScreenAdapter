package com.example.myScreenAdapter.pixel;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by luoling on 2019/11/6.
 * description:
 */
public class Utils {

    private static Utils utils;
    private Context mContext;

    //ui设计师的设计图的尺寸
    private static final float STANDRAD_WIDTH = 1080;
    private static final float STANDRAD_HEIGHT = 1920;

    //屏幕可用显示布局的尺寸
    private int mDisplayWidth;
    private int mDisplayHeight;

    private Utils(Context context){
        mContext = context;
        if (mDisplayWidth == 0 || mDisplayHeight == 0){
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            if (windowManager != null){
                //宽高获取
                DisplayMetrics displayMetrics = new DisplayMetrics();
                //如果不是NavigationBar沉浸式（不包含NavigationBar）
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                //真实屏幕宽高
//                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
                if (displayMetrics.widthPixels > displayMetrics.heightPixels){
                    //横屏
                    mDisplayWidth = displayMetrics.heightPixels;
                    mDisplayHeight = displayMetrics.widthPixels - getStatusBarHeight(context);
                }else{
                    mDisplayWidth = displayMetrics.widthPixels;
                    mDisplayHeight = displayMetrics.heightPixels - getStatusBarHeight(context);
                }
            }
        }
    }

    public static Utils getInstance(Context context){
        if (utils == null){
            synchronized (Utils.class){
                if (utils == null){
                    utils = new Utils(context);
                }
            }
        }
        return utils;
    }

    public int getStatusBarHeight(Context context){
        int resId = context.getResources().getIdentifier("status_bar_height","dimen","android");
        if (resId > 0){
            return context.getResources().getDimensionPixelSize(resId);
        }
        return 0;
    }

    //获取水平方向的缩放比例
    public float getHorizontalScale(){
        return mDisplayWidth / STANDRAD_WIDTH;
    }

    //获取垂直方向的缩放比例
    public float getVerticalScale(){
        return mDisplayHeight / (STANDRAD_HEIGHT - getStatusBarHeight(mContext));
    }

}
