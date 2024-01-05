package com.ld.presenter.impl;

import android.util.Log;

import com.ld.model.API;
import com.ld.model.domain.TicketParams;
import com.ld.model.domain.TicketResult;
import com.ld.presenter.ITicketPagerPresenter;
import com.ld.utils.RetrofitManager;
import com.ld.utils.UIUtils;
import com.ld.view.ITickerPagerCallBack;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TicketPagerPresenterImpl implements ITicketPagerPresenter {
    private static final String TAG = "TicketPagerPresenterImpl";
    private ITickerPagerCallBack mCallBack;

    @Override
    public void registerViewCallBack(ITickerPagerCallBack callBack) {
        this.mCallBack = callBack;
    }

    @Override
    public void unregisterViewCallBack(ITickerPagerCallBack callBack) {
        mCallBack = null;
    }

    @Override
    public void getTicket(String title,String url, String cover) {
        API api = RetrofitManager.getInstance().getApi();
        TicketParams ticketParams = new TicketParams(UIUtils.getTickUrl(url),title);
        Call<TicketResult> ticket = api.getTicket(ticketParams);
        ticket.enqueue(new Callback<TicketResult>() {
            @Override
            public void onResponse(Call<TicketResult> call, Response<TicketResult> response) {
                int code = response.code();
                Log.d(TAG,"code--->"+code);
                if(code == HttpURLConnection.HTTP_OK){
                    TicketResult body = response.body();
                    Log.d(TAG,"result--->"+body);
                    if(mCallBack != null){
                        mCallBack.onTicketLoaded(cover,body);
                    }
                }
            }

            @Override
            public void onFailure(Call<TicketResult> call, Throwable t) {

            }
        });
    }
}
