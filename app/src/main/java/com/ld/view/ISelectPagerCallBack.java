package com.ld.view;

import com.ld.base.IBaseCallBack;
import com.ld.model.domain.SelectCategories;
import com.ld.model.domain.SelectContent;

public interface ISelectPagerCallBack extends IBaseCallBack {
    /**
     * 分类的结果
     * @param categories
     */
    void onCategoriesLoaded(SelectCategories categories);

    /**
     * 内容的结果
     * @param content
     */
    void onContentLoaded(SelectContent content);
}
