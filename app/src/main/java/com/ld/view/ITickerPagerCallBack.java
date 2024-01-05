package com.ld.view;

import com.ld.base.IBaseCallBack;
import com.ld.model.domain.TicketResult;

public interface ITickerPagerCallBack extends IBaseCallBack {
    /**
     * 淘口令加载结果
     * @param cover
     * @param ticket
     */
    void onTicketLoaded(String cover, TicketResult ticket);
}
