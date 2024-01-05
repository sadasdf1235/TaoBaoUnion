package com.ld.presenter;

import com.ld.base.IBasePresenter;
import com.ld.view.ITickerPagerCallBack;

public interface ITicketPagerPresenter extends IBasePresenter<ITickerPagerCallBack> {
    /**
     * 获取淘口令数据
     * @param title
     * @param url
     * @param cover
     */
    void getTicket(String title,String url,String cover);
}
