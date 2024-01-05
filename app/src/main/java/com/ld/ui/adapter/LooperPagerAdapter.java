package com.ld.ui.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.ld.model.domain.HomePagerContent;

import java.util.ArrayList;
import java.util.List;

public class LooperPagerAdapter extends PagerAdapter {
    private static final String TAG = "LooperPagerAdapter";
    private final List<HomePagerContent.DataDTO> data = new ArrayList<>();
    private OnLooperItemClickListener looperListener = null;

    @Override
    public int getCount() {
        //TODO 轮播图实现无线轮播 返回1000
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //TODO 轮播图实现无线轮播 图片轮询
        String url = "https:"+data.get(position).getPictUrl();
        ImageView imageView = new ImageView(container.getContext());
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(looperListener != null){
                    looperListener.onLooperItemCLick(data.get(position));
                }
            }
        });
        Glide.with(container.getContext()).load(url).into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    public void setData(List<HomePagerContent.DataDTO> dtoList) {
        data.clear();
        data.addAll(dtoList);
        notifyDataSetChanged();
        Log.d(TAG, "setData: "+data.size());
    }

    /**
     * 暴露轮播图长度
     * @return
     */
    public int getDataSize(){
        return data.size();
    }

    /**
     * 获取listener
     * @param listener
     */
    public void setOnLooperItemClickListener(OnLooperItemClickListener listener){
        this.looperListener = listener;
    }
    public interface OnLooperItemClickListener{
        public void onLooperItemCLick(HomePagerContent.DataDTO item);
    }
}
