package com.ld.ui.adapter;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ld.R;
import com.ld.model.domain.SelectCategories;
import com.ld.utils.SizeUtils;

import java.util.ArrayList;
import java.util.List;

public class SelectPagerLeftAdapter extends RecyclerView.Adapter<SelectPagerLeftAdapter.InnerHolder> {
    private  List<SelectCategories.DataDTO> mData = new ArrayList<>();
    private int currentItem = 0;
    private OnLeftItemCLick leftItemClick = null;

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_select_left, parent, false);
        return new InnerHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.setData(mData.get(position),position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(SelectCategories categories) {
        List<SelectCategories.DataDTO> data = categories.getData();
        if(data != null){
            this.mData.clear();
           this.mData.addAll(data);
           notifyDataSetChanged();
        }
        if(mData.size() > 0){
            leftItemClick.onLeftClick(mData.get(currentItem));
        }
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.select_item_tv);
        }

        public void setData(SelectCategories.DataDTO dataDTO,int position) {
            textView.setText(dataDTO.getFavoritesTitle());
            if(currentItem == position){
                textView.setBackgroundColor(textView.getResources().getColor(R.color.select_left,null));
            }else{
                textView.setBackgroundColor(textView.getResources().getColor(R.color.white,null));
            }
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(leftItemClick != null && currentItem != position){
                        currentItem = position;
                        leftItemClick.onLeftClick(dataDTO);
                        notifyDataSetChanged();
                    }
                }
            });
        }
    }
    public void setOnLeftItemClick(OnLeftItemCLick onLeftItemClick){
        this.leftItemClick = onLeftItemClick;
    }
    public interface OnLeftItemCLick{
        void onLeftClick( SelectCategories.DataDTO dataDTO);
    }
}
