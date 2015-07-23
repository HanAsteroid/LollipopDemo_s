package com.example.administrator.lollipopdemo_s;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class RecyclerActivity extends Activity implements MyAdapter.MyOnChildClickListener {

    private RecyclerView recycler;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        recycler = ((RecyclerView) findViewById(R.id.recycler));
        LinearLayoutManager manager = new LinearLayoutManager(this);
//        逆向滚动
//        manager.setReverseLayout(true);
        //水平滑动
//        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //网格 3行(列)
//        GridLayoutManager manager1 = new GridLayoutManager(this, 3);
        //瀑布流
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recycler.setLayoutManager(staggeredGridLayoutManager);
//        List<String>list = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            list.add("Item"+i);
//        }
        List<Integer>list = new ArrayList<>();
        list.add(R.mipmap.meinv);
        list.add(R.mipmap.meinv1);
        list.add(R.mipmap.meinv2);
        list.add(R.mipmap.meinv3);
        list.add(R.mipmap.meinv4);
        list.add(R.mipmap.meinv5);
        list.add(R.mipmap.meinv6);
        list.add(R.mipmap.meinv7);
        list.add(R.mipmap.mm8);
        list.add(R.mipmap.mm9);
        list.add(R.mipmap.mm10);
        list.add(R.mipmap.mm11);
        list.add(R.mipmap.mm12);
        list.add(R.mipmap.mm13);
        list.add(R.mipmap.mm14);
        list.add(R.mipmap.mm15);
        list.add(R.mipmap.mm16);
        list.add(R.mipmap.mm17);
        list.add(R.mipmap.mm18);
        adapter = new MyAdapter(this,list);
        adapter.setMyOnChildClicker(this);

        recycler.setAdapter(adapter);
        recycler.addItemDecoration(new RecyclerView.ItemDecoration() {
            /**
             *
             * @param outRect   外边框
             * @param view  itemView
             * @param parent    RecyclerView
             * @param state 状态
             */
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                //分割线,左,上,右,下
                outRect.set(1,1,1,1);
            }
        });
    }


    @Override
    public void myOnChildVlick(View v, int position, Integer data) {
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show();
    }
}
