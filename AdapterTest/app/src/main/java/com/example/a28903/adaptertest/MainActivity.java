package com.example.a28903.adaptertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapter.TestAdapter;
import bean.Itembean;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private LayoutInflater layoutInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listview);

        listView.setAdapter(new TestAdapter(this,getData(),layoutInflater,R.layout.item_test));
    }
    private List<Itembean> getData(){
        String title[]={"华为应用列表页","游戏中心","其他"};
       /* int img[]={R.mipmap.right_in1,R.mipmap.right_in1,R.mipmap.right_in1};
        int headImg[]={R.mipmap.tx,R.mipmap.person,R.mipmap.person};*/

        List<Itembean> mList = new ArrayList<>();
        Itembean itembean=new Itembean();
        itembean.setTitle(title[0]);
        mList.add(itembean);

        Itembean itembean2=new Itembean();
        itembean2.setTitle(title[1]);
        mList.add(itembean2);

        Itembean itembean3=new Itembean();
        itembean3.setTitle(title[2]);
        mList.add(itembean3);

        return mList;
    }
}
