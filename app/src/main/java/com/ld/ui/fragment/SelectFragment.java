package com.ld.ui.fragment;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ld.R;
import com.ld.base.BaseFragment;
import com.ld.model.domain.SelectCategories;
import com.ld.model.domain.SelectContent;
import com.ld.presenter.impl.SelectPagerPresenterImpl;
import com.ld.ui.adapter.SelectPagerLeftAdapter;
import com.ld.ui.adapter.SelectPagerRightAdapter;
import com.ld.utils.PresenterManager;
import com.ld.utils.SizeUtils;
import com.ld.view.ISelectPagerCallBack;

public class SelectFragment extends BaseFragment implements ISelectPagerCallBack, SelectPagerLeftAdapter.OnLeftItemCLick, SelectPagerRightAdapter.OnSelectedPageContentItemClickListener {
    private static final String TAG = "SelectFragment";

    private SelectPagerPresenterImpl selectPagerPresenter;
    private RecyclerView leftView;
    private SelectPagerLeftAdapter selectPagerLeftAdapter;
    private RecyclerView rightView;
    private SelectPagerRightAdapter selectPagerRightAdapter;

    @Override
    protected int returnId() {
        return R.layout.fragment_select;
    }

    @Override
    protected void initView(View inflate) {
        leftView = inflate.findViewById(R.id.select_left_navigation);
        selectPagerLeftAdapter = new SelectPagerLeftAdapter();
        leftView.setLayoutManager(new LinearLayoutManager(getContext()));
        leftView.setAdapter(selectPagerLeftAdapter);

        rightView = inflate.findViewById(R.id.select_right_list);
        selectPagerRightAdapter = new SelectPagerRightAdapter();
        rightView.setLayoutManager(new LinearLayoutManager(getContext()));
        rightView.setAdapter(selectPagerRightAdapter);
        rightView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                int topAndBottom = SizeUtils.dip2px(getContext(),4);
                int leftAndRight = SizeUtils.dip2px(getContext(),6);
                outRect.left = leftAndRight;
                outRect.right = leftAndRight;
                outRect.top = topAndBottom;
                outRect.bottom = topAndBottom;
            }
        });

    }

    @Override
    protected void initPresenter() {
        selectPagerPresenter = PresenterManager.getSelectPagerPresenter();
        selectPagerPresenter.registerViewCallBack(this);
        selectPagerPresenter.getCategory();
    }

    @Override
    protected void initListener() {
        selectPagerLeftAdapter.setOnLeftItemClick(this);

        selectPagerRightAdapter.setOnSelectedPageContentItemClickListener(this);
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onEmpty() {

    }

    @Override
    public void onCategoriesLoaded(SelectCategories categories) {
        Log.d(TAG, "onCategoriesLoaded: "+categories);
        selectPagerLeftAdapter.setData(categories);
    }

    @Override
    public void onContentLoaded(SelectContent content) {
        selectPagerRightAdapter.setData(content);
//        rightView.scrollToPosition(0);
    }

    @Override
    public void onLeftClick(SelectCategories.DataDTO dataDTO) {
//        selectPagerPresenter.getContentByCategoryId(dataDTO);
    }

    @Override
    public void onContentItemClick(SelectContent.DataDTO.TbkUatmFavoritesItemGetResponseDTO.ResultsDTO.UatmTbkItemDTO item) {

    }
}
