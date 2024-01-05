package com.ld.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ld.R;
import com.ld.model.domain.TicketResult;
import com.ld.presenter.impl.TicketPagerPresenterImpl;
import com.ld.utils.PresenterManager;
import com.ld.view.ITickerPagerCallBack;

public class TicketActivity extends AppCompatActivity implements ITickerPagerCallBack {
    private static final String TAG = "TicketActivity";

    private TicketPagerPresenterImpl ticketPresenter;
    private ImageView back;
    private ImageView img;
    private EditText coupon;
    private boolean isTaobao;
    private Button get_coupon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        initView();
        initEvent();
        initPresenter();
    }


    private void initPresenter() {
        ticketPresenter = PresenterManager.getTicketPresenter();
        if(ticketPresenter != null){
            ticketPresenter.registerViewCallBack(this);
        }

        //判断是否安装淘宝
        /*
        act = android.intent.action.MAIN
        cat  = android.intent.category.LAUNCHER
         */
        PackageManager packageManager = getPackageManager();
        try {
           PackageInfo packageInfo =  packageManager.getPackageInfo("com.taobao.taobao",
                   PackageManager.MATCH_UNINSTALLED_PACKAGES);
           isTaobao = packageInfo != null;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            isTaobao = false;
        }
        get_coupon.setText(isTaobao?"打开淘宝领劵":"复制淘口令");
    }

    private void initEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        get_coupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = coupon.getText().toString().trim();
               ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("ticket_text", code);
                clipboardManager.setPrimaryClip(clipData);
                if(isTaobao){
                    //打开淘宝
                    Intent intent = new Intent();
//                    intent.setAction("android.intent.action.MAIN");
//                    intent.addCategory("android.intent.category.LAUNCHER");
                    ComponentName componentName = new ComponentName("com.taobao.taobao", "com.taobao.tao.TBMainActivity");
                    intent.setComponent(componentName);
                    startActivity(intent);

                }else {
                    Toast.makeText(getApplicationContext(),"复制成功",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        //返回按钮
        back = findViewById(R.id.ticket_back);
        //展示图片
        img = findViewById(R.id.ticket_img);
        //优惠劵
        coupon = findViewById(R.id.ticket_coupon);
        //按钮
        get_coupon = findViewById(R.id.get_coupon);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
    public void onTicketLoaded(String cover, TicketResult ticket) {
        //加载图片数据
        Glide.with(this).load("https:"+cover).into(img);

        //加载口令数据
        String s = ticket.getData().getTbkTpwdCreateResponse().getData().getModel();
        // 找到第一个 "￥" 的索引
        int start = s.indexOf("￥");
        // 找到最后一个 "￥" 的索引
        int end = s.lastIndexOf("￥");
        // 截取子字符串
        String result = s.substring(start, end + 1);
        coupon.setText(result);
    }
}