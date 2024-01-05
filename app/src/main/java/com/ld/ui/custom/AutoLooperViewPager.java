package com.ld.ui.custom;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * 轮播图自动轮播
 */
public class AutoLooperViewPager extends ViewPager {
    public AutoLooperViewPager(@NonNull Context context) {
        super(context);
    }

    public AutoLooperViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    //控制是否自动轮播
    private boolean isLoop = false;

    /**
     * 开始自动轮播
     */
    public void startLooper(){
        isLoop = true;
        post(mtask);
    }
    private Runnable mtask = new Runnable() {
        @Override
        public void run() {
            int currentItem = getCurrentItem();
            currentItem++;
            setCurrentItem(currentItem);
            if(isLoop){
                postDelayed(this,2000);
            }
        }
    };

    /**
     * 停止自动轮播
     */
    public void stopLooper(){
        isLoop = false;
        removeCallbacks(mtask);
    }
}
