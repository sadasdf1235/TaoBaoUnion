package com.ld.ui.fragment;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.ld.R;
import com.ld.base.BaseFragment;
import com.ld.model.domain.Categories;
import com.ld.presenter.impl.IHomePresenterImpl;
import com.ld.ui.adapter.HomePagerAdapter;
import com.ld.view.IHomeCallBack;

public class HomeFragment extends BaseFragment implements IHomeCallBack {

    private IHomePresenterImpl iHomePresenter;
    private HomePagerAdapter homePagerAdapter;
    private TabLayout tableLayout;

    @Override
    protected int returnId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void loadData() {
        iHomePresenter.getCategorise();
    }

    @Override
    protected void initView(View inflate) {
        tableLayout = inflate.findViewById(R.id.home_tablayout);
        ViewPager viewPager = inflate.findViewById(R.id.home_pager);
        tableLayout.setupWithViewPager(viewPager);
        homePagerAdapter = new HomePagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(homePagerAdapter);
    }

    /***
     * 创建Presenter
     */
    @Override
    protected void initPresenter() {
        iHomePresenter = new IHomePresenterImpl();
        iHomePresenter.getCategorise();
        iHomePresenter.registerViewCallBack(this);
    }

    @Override
    public void onCategoriesLoaded(Categories categories) {
        if(homePagerAdapter != null){
            homePagerAdapter.setCategoriesList(categories);
        }
    }

    @Override
    protected void release() {
        if(iHomePresenter != null){
            iHomePresenter.unregisterViewCallBack(this);
        }
    }
}
