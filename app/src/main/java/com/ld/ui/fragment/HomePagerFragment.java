package com.ld.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.ld.R;
import com.ld.base.BaseFragment;
import com.ld.model.domain.Categories;
import com.ld.model.domain.HomePagerContent;
import com.ld.presenter.impl.CategoryPagerPresenterImpl;
import com.ld.presenter.impl.TicketPagerPresenterImpl;
import com.ld.ui.activity.MainActivity;
import com.ld.ui.activity.TicketActivity;
import com.ld.ui.adapter.HomePageContentAdapter;
import com.ld.ui.adapter.LooperPagerAdapter;
import com.ld.ui.custom.AutoLooperViewPager;
import com.ld.utils.Constants;
import com.ld.utils.PresenterManager;
import com.ld.utils.SizeUtils;
import com.ld.view.ICategoryPagerCallBack;

import java.util.List;

public class HomePagerFragment extends BaseFragment implements ICategoryPagerCallBack, HomePageContentAdapter.OnItemClickListener, LooperPagerAdapter.OnLooperItemClickListener {
    private static final String TAG = "HomePagerFragment";
    private CategoryPagerPresenterImpl instance;
    private HomePageContentAdapter homePageContentAdapter;
    private int mId;
    private LooperPagerAdapter looperPagerAdapter;
    private TextView home_pager_title;
    //轮播图圆点
    private LinearLayout layout;
    //轮播图
    private AutoLooperViewPager viewPager;
    private LinearLayout linearLayout;
    private RecyclerView recyclerView;

    public static HomePagerFragment newInstance(Categories.DataDTO category){
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_HOME_PAGER_TITLE,category.getTitle());
        bundle.putInt(Constants.KEY_HOME_PAGER_ID,category.getId());
        HomePagerFragment homePagerFragment = new HomePagerFragment();
        homePagerFragment.setArguments(bundle);
        return homePagerFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        //开始轮播
        viewPager.startLooper();
    }

    @Override
    public void onPause() {
        super.onPause();
        //停止轮播
        viewPager.startLooper();
    }

    @Override
    protected void initView(View inflate) {
        homePageContentAdapter = new HomePageContentAdapter();

        //列表展示
        recyclerView = inflate.findViewById(R.id.home_pager_content);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.top = 8;
                outRect.bottom = 8;
            }
        });
        recyclerView.setAdapter(homePageContentAdapter);

        //轮播图
        viewPager = inflate.findViewById(R.id.home_pager_viewpager);
        looperPagerAdapter = new LooperPagerAdapter();
        viewPager.setAdapter(looperPagerAdapter);

        //标题
        home_pager_title = inflate.findViewById(R.id.include_home_pager_title);

        //轮播图圆点
        layout = inflate.findViewById(R.id.home_pager_viewpager_dot);

        //布局页 LinearLayout
        linearLayout = inflate.findViewById(R.id.home_pager_layout);
    }

    /**
     * 重写 返回当前布局页id
     * @return
     */
    @Override
    protected int returnId() {
        return R.layout.fragment_home_pager;
    }

    @Override
    protected void initPresenter() {
        instance = CategoryPagerPresenterImpl.getInstance();
        instance.registerViewCallBack(this);

    }

    @Override
    protected void loadData() {
        Bundle arguments = getArguments();
        String string = arguments.getString(Constants.KEY_HOME_PAGER_TITLE);
        mId = arguments.getInt(Constants.KEY_HOME_PAGER_ID);
        Log.d(TAG,"title--->"+string);
        Log.d(TAG,"id--->"+ mId);
        home_pager_title.setText(string);
        if(instance != null){
            instance.getContentByCategoryId(mId);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        instance.unregisterViewCallBack(this);
    }

    @Override
    protected void initListener() {
        homePageContentAdapter.setOnItemClickListener(this);
        looperPagerAdapter.setOnLooperItemClickListener(this);

        linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int measuredHeight = linearLayout.getMeasuredHeight();
//                Log.d(TAG,"height--->"+measuredHeight);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) recyclerView.getLayoutParams();
                layoutParams.height = measuredHeight;
                recyclerView.setLayoutParams(layoutParams);

                if(layoutParams.height != 0){
                    linearLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < layout.getChildCount(); i++) {
                    View childAt = layout.getChildAt(i);
                    if( i == position){
                        childAt.setBackgroundResource(R.drawable.shape_dot_select);
                    }else {
                        childAt.setBackgroundResource(R.drawable.shape_dot);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public int getCategoryId() {
        return mId;
    }

    @Override
    public void onContentLoaded(List<HomePagerContent.DataDTO> dtoList) {
        homePageContentAdapter.setData(dtoList);
    }

    @Override
    public void onLoadMoreError() {

    }

    @Override
    public void onLoadMoreEmpty() {

    }

    @Override
    public void onLoadMoreLoaded(List<HomePagerContent.DataDTO> dtoList) {

    }

    @Override
    public void onLooperListLoaded(List<HomePagerContent.DataDTO> dtoList) {
        looperPagerAdapter.setData(dtoList);
        //TODO 轮播图实现无线轮播 起始页可以向左滑动

        //动态添加小圆点
        for (int i = 0; i < dtoList.size(); i++) {
            View point = new View(getContext());
            int size = SizeUtils.dip2px(getContext(),8);
            int margin = SizeUtils.dip2px(getContext(),5);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size,size);
            params.leftMargin = margin;
            params.rightMargin = margin;
            point.setLayoutParams(params);
            if (i == 0) {
                point.setBackgroundResource(R.drawable.shape_dot_select);
            } else {
                point.setBackgroundResource(R.drawable.shape_dot);
            }
            layout.addView(point);
        }
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

    /**
     * 列表被点击
     * @param item
     */
    @Override
    public void onItemClick(HomePagerContent.DataDTO item) {
        handerClick(item);
    }

    private void handerClick(HomePagerContent.DataDTO item) {
        String title = item.getTitle();
        String url  = item.getCouponClickUrl();
        if(url == null){
            url = item.getClickUrl();
        }
        String cover = item.getPictUrl();
        TicketPagerPresenterImpl ticketPresenter = PresenterManager.getTicketPresenter();
        ticketPresenter.getTicket(title,url,cover);
        startActivity(new Intent(getContext(),TicketActivity.class));

    }

    /**
     * 轮播图被点击
     * @param item
     */
    @Override
    public void onLooperItemCLick(HomePagerContent.DataDTO item) {
        handerClick(item);
    }
}
