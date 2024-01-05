package com.ld.presenter;

import com.ld.base.IBasePresenter;
import com.ld.view.ICategoryPagerCallBack;

public interface ICategoryPagerPresenter extends IBasePresenter<ICategoryPagerCallBack> {
    void getContentByCategoryId(int categoryId);
    void loadMore(int categoryId);
    void reload(int categoryId);
}
