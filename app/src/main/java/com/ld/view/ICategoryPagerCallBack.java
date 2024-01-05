package com.ld.view;

import com.ld.base.IBaseCallBack;
import com.ld.model.domain.HomePagerContent;

import java.util.List;

public interface ICategoryPagerCallBack extends IBaseCallBack{
    int getCategoryId();
    void onContentLoaded(List<HomePagerContent.DataDTO> dtoList);
    void onLoadMoreError();
    void onLoadMoreEmpty();
    void onLoadMoreLoaded(List<HomePagerContent.DataDTO> dtoList);

    /**
     * 轮播图
     * @param dtoList
     */
    void onLooperListLoaded(List<HomePagerContent.DataDTO> dtoList);
}
