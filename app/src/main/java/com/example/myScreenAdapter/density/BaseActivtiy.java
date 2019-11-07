package com.example.myScreenAdapter.density;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myScreenAdapter.notch.NotchUtil;
import com.example.myScreenAdapter.notch.callback.OnCutoutListener;

/**
 * Created by luoling on 2019/11/6.
 * description:
 */
public class BaseActivtiy extends AppCompatActivity {

    private boolean isHasCutout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        DensityUtils.setDensity(getApplication(),this);
    }

    protected boolean getIsHasCutout(){
        return isHasCutout;
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        //判断有没有刘海屏(获取需要在View绑定到Window之后，否在拿不到)
        NotchUtil.isHasCutout(this, new OnCutoutListener() {
            @Override
            public void isHasCutout(boolean isHas) {
                isHasCutout = isHas;
                if (isHas) {
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    /**
                     * * @see #LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT 全屏模式，内容下移 非全屏模式下不受影响
                     * * @see #LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES 允许内容进入刘海区域
                     * * @see #LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER 不允许内容进入刘海区域
                     */
                    NotchUtil.setImmersiveWidthNotch(BaseActivtiy.this, false,
                            WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES);
                }
            }
        });
    }

}
