package com.ld.presenter.impl;

import android.util.Log;

import com.ld.model.API;
import com.ld.model.domain.HomePagerContent;
import com.ld.presenter.ICategoryPagerPresenter;
import com.ld.utils.RetrofitManager;
import com.ld.utils.UrlUtils;
import com.ld.view.ICategoryPagerCallBack;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CategoryPagerPresenterImpl implements ICategoryPagerPresenter {
    private static final String TAG = "CategoryPagerPresenterImpl";
    private static CategoryPagerPresenterImpl categoryPagerPresenterImpl;
    private final Map<Integer,Integer> pageInfo = new HashMap<>();
    private final List<ICategoryPagerCallBack> callBackList = new ArrayList<>();
    private CategoryPagerPresenterImpl(){

    }
    public static CategoryPagerPresenterImpl getInstance(){
        if(categoryPagerPresenterImpl == null){
            categoryPagerPresenterImpl = new CategoryPagerPresenterImpl();
        }
        return categoryPagerPresenterImpl;
    }
    @Override
    public void registerViewCallBack(ICategoryPagerCallBack callBack) {
        if(!callBackList.contains(callBack)){
            callBackList.add(callBack);
        }
    }

    @Override
    public void unregisterViewCallBack(ICategoryPagerCallBack callBack) {
        callBackList.remove(callBack);
    }

    @Override
    public void getContentByCategoryId(int categoryId) {
        API api = RetrofitManager.getInstance().getApi();

        Integer integer = pageInfo.computeIfAbsent(categoryId, k -> 1);

        String url = UrlUtils.getUrl(categoryId, integer);
        Call<HomePagerContent> homePagerContent = api.getHomePagerContent(url);
        homePagerContent.enqueue(new Callback<HomePagerContent>() {
            @Override
            public void onResponse(Call<HomePagerContent> call, Response<HomePagerContent> response) {
                int code = response.code();
                Log.d(TAG,"code--->"+code);
                if(code == HttpURLConnection.HTTP_OK){
                    HomePagerContent body = response.body();
                    Log.d(TAG,"result--->"+body);
                    handerHomePageContent(body,categoryId);
                }
            }

            @Override
            public void onFailure(Call<HomePagerContent> call, Throwable t) {
                    Log.d(TAG,"fail--->"+t);
            }
        });
    }
    private void handerHomePageContent(HomePagerContent body, int categoryId) {
        List<HomePagerContent.DataDTO> data = body.getData();
        for (ICategoryPagerCallBack iCategoryPagerCallBack : callBackList) {
           if(iCategoryPagerCallBack.getCategoryId() == categoryId){
               if(body.getData().size() == 0){
                   iCategoryPagerCallBack.onEmpty();
               }else{
                   //轮播图数据
                   iCategoryPagerCallBack.onLooperListLoaded(data.subList(data.size()-5,data.size()));
                   //列表数据
                   iCategoryPagerCallBack.onContentLoaded(data);
               }
           }
        }
    }

    @Override
    public void loadMore(int categoryId) {

    }

    @Override
    public void reload(int categoryId) {

    }
}
