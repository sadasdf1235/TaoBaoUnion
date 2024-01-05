package com.ld.ui.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ld.R;
import com.ld.model.domain.SelectContent;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SelectPagerRightAdapter extends RecyclerView.Adapter<SelectPagerRightAdapter.InnerHolder> {
    List<SelectContent.DataDTO.TbkUatmFavoritesItemGetResponseDTO.ResultsDTO.UatmTbkItemDTO> mData = new ArrayList<>();
    private OnSelectedPageContentItemClickListener mContentItemClickListener = null;
    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selected_page_content,parent,false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        SelectContent.DataDTO.TbkUatmFavoritesItemGetResponseDTO.ResultsDTO.UatmTbkItemDTO uatmTbkItemDTO = mData.get(position);
        holder.setData(uatmTbkItemDTO);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mContentItemClickListener != null) {
                    mContentItemClickListener.onContentItemClick(uatmTbkItemDTO);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(SelectContent content) {
        if(content.getCode() == 10000){
            List<SelectContent.DataDTO.TbkUatmFavoritesItemGetResponseDTO.ResultsDTO.UatmTbkItemDTO> uatmTbkItem = content.getData().getTbkUatmFavoritesItemGetResponse().getResults().getUatmTbkItem();
            mData.clear();
            mData.addAll(uatmTbkItem);
            notifyDataSetChanged();
        }
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        ImageView cover;
        TextView offPriseTv;
        TextView title;
        TextView buyBtn;
        TextView originalPriseTv;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void setData(SelectContent.DataDTO.TbkUatmFavoritesItemGetResponseDTO.ResultsDTO.UatmTbkItemDTO itemData){
            title.setText(itemData.getTitle());
            String pict_url = itemData.getPictUrl();
            Glide.with(itemView.getContext()).load(pict_url).into(cover);
            if(TextUtils.isEmpty(itemData.getCouponClickUrl())) {
                originalPriseTv.setText("晚啦，没有优惠券了");
                buyBtn.setVisibility(View.GONE);
            } else {
                originalPriseTv.setText("原价：" + itemData.getZkFinalPrice());
                buyBtn.setVisibility(View.GONE);
            }

            if(TextUtils.isEmpty(itemData.getCouponInfo())) {
                offPriseTv.setVisibility(View.GONE);
            } else {
                offPriseTv.setVisibility(View.VISIBLE);
                offPriseTv.setText(itemData.getCouponInfo());
            }
        }
    }

    public void setOnSelectedPageContentItemClickListener(OnSelectedPageContentItemClickListener listener) {
        this.mContentItemClickListener = listener;
    }

    public interface OnSelectedPageContentItemClickListener {
        void onContentItemClick(SelectContent.DataDTO.TbkUatmFavoritesItemGetResponseDTO.ResultsDTO.UatmTbkItemDTO item);
    }
}
