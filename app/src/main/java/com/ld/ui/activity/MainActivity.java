package com.ld.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.ld.R;
import com.ld.base.BaseFragment;
import com.ld.ui.fragment.HomeFragment;
import com.ld.ui.fragment.RedPacketFragment;
import com.ld.ui.fragment.SearchFragment;
import com.ld.ui.fragment.SelectFragment;


public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private FrameLayout frameLayout;
    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private RedPacketFragment redPacketFragment;
    private SelectFragment selectFragment;
    private SearchFragment searchFragment;
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initFragment();
        addNavagationListener();
        switchFragment(homeFragment);
    }

    /**
     * 对底部导航进行监听
     */
    private void addNavagationListener() {
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if(itemId == R.id.bottombar_home){
                Log.d(TAG,"展示首页内容");
                switchFragment(homeFragment);
            } else if (itemId == R.id.bottombar_red_packet) {
                Log.d(TAG,"展示特惠内容");
                switchFragment(redPacketFragment);
            } else if (itemId == R.id.bottombar_select) {
                Log.d(TAG,"展示精选内容");
                switchFragment(selectFragment);
            }else {
                Log.d(TAG,"展示搜索内容");
                switchFragment(selectFragment);
            }
            return true;
        });
    }

    /***
     * 初始化控件
     */
    private void initView() {
        //初始化控件
        frameLayout = findViewById(R.id.fragment_container);
        bottomNavigationView = findViewById(R.id.bottomnavigation);
        supportFragmentManager = getSupportFragmentManager();
    }

    /***
     * 初始化Fragment
     */
    private void initFragment(){
        //初始化Fragment
        homeFragment = new HomeFragment();
        redPacketFragment = new RedPacketFragment();
        selectFragment = new SelectFragment();
        searchFragment = new SearchFragment();
    }

    //保存上一个页面的状态
    private BaseFragment lastOneFragment = null;
    /**
     * 底部导航切换页面
     * @param tag
     */
    private void switchFragment(BaseFragment tag){
        //开启事务
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        /*
        如果当前页面没有被添加，就添加页面。
        存在就展示
         */
        if(!tag.isAdded()){
            fragmentTransaction.add(R.id.fragment_container,tag);
        }else{
            fragmentTransaction.show(tag);
        }
        if(lastOneFragment != null){
            fragmentTransaction.hide(lastOneFragment);
        }
        lastOneFragment = tag;
        //进行页面替换
//        fragmentTransaction.replace(R.id.fragment_container,tag);
        //提交事务
        fragmentTransaction.commit();
    }
}