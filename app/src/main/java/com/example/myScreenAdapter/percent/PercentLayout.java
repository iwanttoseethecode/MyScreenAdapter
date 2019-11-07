package com.example.myScreenAdapter.percent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.myScreenAdapter.R;

/**
 * Created by luoling on 2019/11/7.
 * description:
 */
public class PercentLayout extends RelativeLayout {

    private boolean flag;

    public PercentLayout(Context context) {
        super(context);
    }

    public PercentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PercentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!flag){
            flag = true;
            int widthSize = MeasureSpec.getSize(widthMeasureSpec);
            int heightSize = MeasureSpec.getSize(heightMeasureSpec);

            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++){
                View child = getChildAt(i);
                ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                if (checkLayoutParams(layoutParams)){
                    LayoutParams lp = (LayoutParams) layoutParams;
                    float widthPercent = lp.widthPercent;
                    float heightPercent = lp.heightPercent;
                    float marginLeftPercent = lp.marginLeftPercent;
                    float marginRightPercent = lp.marginRightPercent;
                    float marginTopPercent = lp.marginTopPercent;
                    float marginBottomPercent = lp.marginBottomPercent;
                    if (widthPercent > 0){
                        lp.width = (int) (widthSize * widthPercent);
                    }
                    if (heightPercent > 0){
                        lp.height = (int) (heightSize * heightPercent);
                    }
                    if (marginLeftPercent > 0){
                        lp.leftMargin = (int) (widthSize * marginLeftPercent);
                    }
                    if (marginRightPercent > 0){
                        lp.rightMargin = (int) (widthSize * marginRightPercent);
                    }
                    if (marginTopPercent > 0){
                        lp.topMargin = (int) (heightSize * marginTopPercent);
                    }
                    if (marginBottomPercent > 0){
                        lp.bottomMargin = (int) (heightSize * marginBottomPercent);
                    }
                }
            }

        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    @Override
    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(),attrs);
    }

    public static class LayoutParams extends RelativeLayout.LayoutParams{

        private float widthPercent;
        private float heightPercent;
        private float marginLeftPercent;
        private float marginRightPercent;
        private float marginTopPercent;
        private float marginBottomPercent;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);

            TypedArray typedArray = c.obtainStyledAttributes(attrs, R.styleable.PercentLayout);

            widthPercent = typedArray.getFraction(R.styleable.PercentLayout_widthPercent,1,2,0);
            heightPercent = typedArray.getFraction(R.styleable.PercentLayout_heightPercent,1,2,0);
            marginLeftPercent = typedArray.getFraction(R.styleable.PercentLayout_marginLeftPercent,1,2,0);
            marginTopPercent = typedArray.getFraction(R.styleable.PercentLayout_marginTopPercent,1,2,0);
            marginRightPercent = typedArray.getFraction(R.styleable.PercentLayout_marginRightPercent,1,2,0);
            marginBottomPercent = typedArray.getFraction(R.styleable.PercentLayout_marginBottomPercent,1,2,0);
            typedArray.recycle();
        }

    }

}
