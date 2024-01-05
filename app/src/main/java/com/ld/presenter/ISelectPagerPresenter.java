package com.ld.presenter;

import com.ld.base.IBasePresenter;
import com.ld.model.domain.SelectCategories;
import com.ld.view.ISelectPagerCallBack;

public interface ISelectPagerPresenter extends IBasePresenter<ISelectPagerCallBack> {
    /**
     * 获取精选分类
     */
    void getCategory();

    /**
     * 根据id获取内容
     * @param item
     */
    void getContentByCategoryId(SelectCategories.DataDTO item);
}
