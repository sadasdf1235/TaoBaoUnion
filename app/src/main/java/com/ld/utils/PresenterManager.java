package com.ld.utils;

import com.ld.presenter.impl.CategoryPagerPresenterImpl;
import com.ld.presenter.impl.IHomePresenterImpl;
import com.ld.presenter.impl.SelectPagerPresenterImpl;
import com.ld.presenter.impl.TicketPagerPresenterImpl;

public class PresenterManager {
    private static final PresenterManager presenterManager = new PresenterManager();
//    private final CategoryPagerPresenterImpl categoryPagerPresenter;
//    private final IHomePresenterImpl homePresenter;
    private  final TicketPagerPresenterImpl ticketPagerPresenter;
    private final SelectPagerPresenterImpl selectPagerPresenter;
    private PresenterManager(){
//        categoryPagerPresenter = new CategoryPagerPresenterImpl();
        ticketPagerPresenter = new TicketPagerPresenterImpl();
        selectPagerPresenter = new SelectPagerPresenterImpl();
    }
    public static TicketPagerPresenterImpl getTicketPresenter(){
        return presenterManager.ticketPagerPresenter;
    }
    public static SelectPagerPresenterImpl getSelectPagerPresenter(){
        return presenterManager.selectPagerPresenter;
    }
}
