package com.ld.base;

import com.ld.view.IHomeCallBack;

public interface IBasePresenter<T> {
    void registerViewCallBack(T callBack);
    void unregisterViewCallBack(T callBack);
}
