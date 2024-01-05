package com.ld.presenter;

import com.ld.base.IBasePresenter;
import com.ld.view.IHomeCallBack;

public interface IHomePresenter extends IBasePresenter<IHomeCallBack> {
    /**
     *
     */
    void getCategorise();
}
