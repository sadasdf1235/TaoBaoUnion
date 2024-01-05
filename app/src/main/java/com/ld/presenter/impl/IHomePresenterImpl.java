package com.ld.presenter.impl;

import android.util.Log;

import com.ld.base.IBaseCallBack;
import com.ld.model.API;
import com.ld.model.domain.Categories;
import com.ld.presenter.IHomePresenter;
import com.ld.utils.RetrofitManager;
import com.ld.view.IHomeCallBack;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IHomePresenterImpl implements IHomePresenter {
    private static final String TAG = "IHomePresenterImpl";
    private IHomeCallBack mCallBack = null;

    /**
     * 获取分类数据
     */
    @Override
    public void getCategorise() {
        API api = RetrofitManager.getInstance().getApi();
        Call<Categories> categories = api.getCategories();
        categories.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                int code = response.code();
                Log.d(TAG,"code--->"+code);
                if(code == HttpURLConnection.HTTP_OK){
                    Categories body = response.body();
                    Log.d(TAG,"result---->"+body);
                    if(mCallBack != null){
                        mCallBack.onCategoriesLoaded(body);
                    }
                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                Log.d(TAG,"请求错误-->"+t);
            }
        });
    }

    @Override
    public void registerViewCallBack(IHomeCallBack callBack) {
        this.mCallBack = callBack;
    }

    @Override
    public void unregisterViewCallBack(IHomeCallBack callBack) {
            mCallBack = null;
    }
}
