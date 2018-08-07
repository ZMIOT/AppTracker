package com.example.hwapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.zip.Inflater;

import adapter.HwAppAdapter;
import bean.HwItem;


public class HwApplication extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button zh;
    private Button en;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw_application);

        zh=(Button)findViewById(R.id.zh_rcn);
        en=(Button)findViewById(R.id.en_rus);
        zh.setOnClickListener(this);
        en.setOnClickListener(this);
        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView=(RecyclerView)findViewById(R.id.rv_hwapp);
        mRecyclerView.setLayoutManager(mLayoutManager);
        HwAppAdapter hwAppAdapter=new HwAppAdapter(R.layout.item_hwapp,getData());
        mRecyclerView.setAdapter(hwAppAdapter);
    }
    public List<HwItem> getData(){
        List<HwItem> list=new ArrayList<>();
        String[] troubleName={getResources().getString(R.string.hwAccountAndPass),
                getResources().getString(R.string.gameCenter),
                getResources().getString(R.string.hwAppCenter),
                getResources().getString(R.string.service),
                getResources().getString(R.string.repair)};
        for(int i=0;i<=4;i++){
            HwItem hwItem=new HwItem();
            hwItem.setTroubleName(troubleName[i]);
            list.add(hwItem);
        }
        return list;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.zh_rcn:
                changeAppLanguage(Locale.SIMPLIFIED_CHINESE);
                break;
            case R.id.en_rus:
                changeAppLanguage(Locale.US);
                break;
        }
    }
    /**
     * 更改应用语言
     *
     * @param locale
     */
    public void changeAppLanguage(Locale locale) {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        Configuration configuration = getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {//jelly_bean_mr1
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
        getResources().updateConfiguration(configuration, metrics);
        //重新启动Activity
        Intent intent = new Intent(this, HwApplication.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
