package com.ld.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ld.R;

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int id = returnId();
        //载页面
        View inflate = inflater.inflate(id, container, false);
        initView(inflate);
        initListener();
        //载Presenter
        initPresenter();
        //载数据
        loadData();
        return inflate;
    }

    /**
     * 子类可以重新改方法，实现监听
     */
    protected void initListener() {
    }

    protected void initView(View inflate) {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        release();
    }

    protected void release() {
    }

    protected void initPresenter() {
    }

    protected void loadData() {

    }

    protected abstract int returnId();
}
