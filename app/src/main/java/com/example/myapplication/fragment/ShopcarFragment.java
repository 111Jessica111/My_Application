package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.LeftListAdapter;
import com.example.myapplication.adapter.ShopCarListAdapter;
import com.example.myapplication.db.ShopcarDbHelper;
import com.example.myapplication.entity.Shopcarinfo;
import com.example.myapplication.entity.Userinfo;

import java.util.List;

public class ShopcarFragment extends Fragment {

    private View rootView;
    private RecyclerView recycle_shop;
    private ShopCarListAdapter shopCarListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_shopcar, container, false);

        recycle_shop = rootView.findViewById(R.id.recycle_shop);

        // 设置布局管理器
        recycle_shop.setLayoutManager(new LinearLayoutManager(getContext()));

        shopCarListAdapter = new ShopCarListAdapter();
        recycle_shop.setAdapter(shopCarListAdapter);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 获取数据并显示
        refreshShopCar();
    }

    // 每次返回到这个Fragment时刷新数据(很重要！！！！！！！！！)
    @Override
    public void onResume() {
        super.onResume();
        refreshShopCar();
    }

    // 刷新购物车数据的方法
    private void refreshShopCar() {
        Userinfo userinfo = Userinfo.getUserinfo();
        if (userinfo != null){
            List<Shopcarinfo> shoplist = ShopcarDbHelper.getInstance(getActivity()).shoplist(userinfo.getUsername());
            shopCarListAdapter.setShopData(shoplist);
        }
    }
}