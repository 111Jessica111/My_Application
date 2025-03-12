package com.example.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.DetailActivity;
import com.example.myapplication.R;
import com.example.myapplication.adapter.LeftListAdapter;
import com.example.myapplication.adapter.RightListAdapter;
import com.example.myapplication.entity.DataProvider;
import com.example.myapplication.entity.Productinfo;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private View rootView;
    private RecyclerView rv_left;
    private RecyclerView rv_right;
    private LeftListAdapter mLeftListAdapter;
    private RightListAdapter mRightListAdapter;

    private List<String> leftDatalist = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //布局转化为View，从而对布局进行修改
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        rv_left = rootView.findViewById(R.id.rv_left);
        rv_right = rootView.findViewById(R.id.rv_right);

        // 设置布局管理器
        rv_left.setLayoutManager(new LinearLayoutManager(getContext()));

        // 初始化左适配器
        mLeftListAdapter = new LeftListAdapter(leftDatalist);
        rv_left.setAdapter(mLeftListAdapter);

        // 初始化右适配器
        mRightListAdapter = new RightListAdapter();
        rv_right.setAdapter(mRightListAdapter);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //添加
        leftDatalist.add("书本");
        leftDatalist.add("生活用品");
        leftDatalist.add("电子产品");
        leftDatalist.add("其他");

        //刷新视图
        mRightListAdapter.notifyDataSetChanged();

        //初始商品陈列
        mRightListAdapter.setProductData(DataProvider.getProductData(0));

        //详情 点击事件
        mRightListAdapter.setonItemClickListener(new RightListAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Productinfo productinfo, int position) {
                //跳转
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                //传值，将productinfo的整体数据传入需要Serializable接口
                intent.putExtra("productinfo",productinfo);
                startActivity(intent);

            }
        });

        //分类 点击事件
        mLeftListAdapter.setmLeftListOnClickItemListener(new LeftListAdapter.LeftListOnClickItemListener() {
            @Override
            public void onItemClick(int position) {
                mLeftListAdapter.setCurrentIndex(position);
                //陈列相应position的商品
                mRightListAdapter.setProductData(DataProvider.getProductData(position));
            }
        });
    }
}
