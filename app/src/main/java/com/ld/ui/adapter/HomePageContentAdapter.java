package com.ld.ui.adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ld.R;
import com.ld.model.domain.HomePagerContent;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HomePageContentAdapter extends RecyclerView.Adapter<HomePageContentAdapter.InnerHolder> {
    private static final String TAG = "HomePageContentAdapter";
    private final List<HomePagerContent.DataDTO> list = new ArrayList<>();
    private OnItemClickListener onClickListener  =null;

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_pager_content, parent, false);
        return new InnerHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        HomePagerContent.DataDTO dataDTO = list.get(position);
        holder.setData(dataDTO);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onClickListener != null){
                    onClickListener.onItemClick(dataDTO);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<HomePagerContent.DataDTO> dtoList) {
        Log.d(TAG, "setData: "+dtoList);
        list.clear();
        list.addAll(dtoList);
        notifyDataSetChanged();
    }

    public static class InnerHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "HomePageContentAdapter:InnerHolder";
        ImageView img;
        TextView title;
        TextView sprice;
        TextView price;
        TextView rprice;
        TextView person;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_home_img);
            title = itemView.findViewById(R.id.item_home_title);
            sprice = itemView.findViewById(R.id.item_home_sprice);
            price = itemView.findViewById(R.id.item_home_price);
            rprice = itemView.findViewById(R.id.item_home_rprice);
            person = itemView.findViewById(R.id.item_home_person);
        }

        @SuppressLint("SetTextI18n")
        public void setData(HomePagerContent.DataDTO dataDTO) {
            Log.d(TAG, "setData: "+dataDTO);
            ViewGroup.LayoutParams layoutParams = img.getLayoutParams();
            int width = layoutParams.width;
            int height = layoutParams.height;
            int size = (Math.max(width, height))/2;
            Glide.with(itemView.getContext()).load("https:"+dataDTO.getPictUrl()+"_"+size+"x"+size+".jpg").into(img);
            title.setText(dataDTO.getTitle());
            price.setText(dataDTO.getCouponAmount()+"元");
            person.setText(dataDTO.getVolume()+"人购买");
        }
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.onClickListener = listener;
    }
    public interface OnItemClickListener{
        void onItemClick(HomePagerContent.DataDTO item);
    }
}
