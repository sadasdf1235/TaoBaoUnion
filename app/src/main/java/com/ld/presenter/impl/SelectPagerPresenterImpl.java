package com.ld.presenter.impl;

import android.util.Log;

import com.google.gson.Gson;
import com.ld.model.API;
import com.ld.model.domain.SelectCategories;
import com.ld.model.domain.SelectContent;
import com.ld.presenter.ISelectPagerPresenter;
import com.ld.utils.RetrofitManager;
import com.ld.view.ISelectPagerCallBack;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectPagerPresenterImpl implements ISelectPagerPresenter {
    private static final String TAG = "SelectPagerPresenterImpl";
    private ISelectPagerCallBack mCallBack;

    @Override
    public void getCategory() {
        if(mCallBack != null){
            mCallBack.onLoading();
        }
        String s = "{\n" +
                "    \"success\": true,\n" +
                "    \"code\": 10000,\n" +
                "    \"message\": \"获取精选分类成功.\",\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"type\": 1,\n" +
                "            \"favorites_id\": 19876595,\n" +
                "            \"favorites_title\": \"程序员必备\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": 1,\n" +
                "            \"favorites_id\": 19876636,\n" +
                "            \"favorites_title\": \"办公室零食\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": 1,\n" +
                "            \"favorites_id\": 19876637,\n" +
                "            \"favorites_title\": \"上班族早餐\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": 1,\n" +
                "            \"favorites_id\": 19876649,\n" +
                "            \"favorites_title\": \"日用品\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": 1,\n" +
                "            \"favorites_id\": 19902751,\n" +
                "            \"favorites_title\": \"电脑周边\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": 1,\n" +
                "            \"favorites_id\": 19903201,\n" +
                "            \"favorites_title\": \"秋天必备\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        Gson gson = new Gson();
        SelectCategories selectCategories1 = gson.fromJson(s, SelectCategories.class);
        Log.d(TAG, "getCategory: "+selectCategories1);
        mCallBack.onCategoriesLoaded(selectCategories1);
        API api = RetrofitManager.getInstance().getApi();
        Call<SelectCategories> selectCategories = api.getSelectCategories();
        selectCategories.enqueue(new Callback<SelectCategories>() {
            @Override
            public void onResponse(Call<SelectCategories> call, Response<SelectCategories> response) {
                int code = response.code();
                Log.d(TAG, "code--->"+code);
                if(code == HttpURLConnection.HTTP_OK){
                    SelectCategories body = response.body();
                    Log.d(TAG, "onResponse: --->"+body);

//                    mCallBack.onCategoriesLoaded(body);
                    mCallBack.onCategoriesLoaded(selectCategories1);
                }
            }

            @Override
            public void onFailure(Call<SelectCategories> call, Throwable t) {

            }
        });
    }

    @Override
    public void getContentByCategoryId(SelectCategories.DataDTO item) {
        API api = RetrofitManager.getInstance().getApi();
        String url = "recommend/"+item.getFavoritesId();
        Log.d(TAG, "getContentByCategoryId: "+url);
        Call<SelectContent> contentBySelectCategoryId = api.getContentBySelectCategoryId(url);
        contentBySelectCategoryId.enqueue(new Callback<SelectContent>() {
            @Override
            public void onResponse(Call<SelectContent> call, Response<SelectContent> response) {
                int code = response.code();
                Log.d(TAG, "codeById--->"+code);
                if(code == HttpURLConnection.HTTP_OK){
                    SelectContent body = response.body();
                    Log.d(TAG, "onResponseById: --->"+body);

                    mCallBack.onContentLoaded(body);
                }
            }

            @Override
            public void onFailure(Call<SelectContent> call, Throwable t) {

            }
        });
    }

    @Override
    public void registerViewCallBack(ISelectPagerCallBack callBack) {
        this.mCallBack = callBack;
    }

    @Override
    public void unregisterViewCallBack(ISelectPagerCallBack callBack) {
        mCallBack = null;
    }
}
