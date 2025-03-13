package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.LeftListAdapter;
import com.example.myapplication.adapter.OrderListAdapter;
import com.example.myapplication.db.OrderDbHelper;
import com.example.myapplication.db.ShopcarDbHelper;
import com.example.myapplication.entity.Orderinfo;
import com.example.myapplication.entity.Shopcarinfo;
import com.example.myapplication.entity.Userinfo;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends Fragment {
    private View rootView;
    private RecyclerView recycler_order_items;
    private OrderListAdapter orderListAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_order, container, false);
        recycler_order_items = rootView.findViewById(R.id.recycler_order_items);

        // 初始化适配器
        orderListAdapter = new OrderListAdapter();
        recycler_order_items.setAdapter(orderListAdapter);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Userinfo userinfo = Userinfo.getUserinfo();
        if (userinfo!=null){
            List<Orderinfo> orderinfos = OrderDbHelper.getInstance(getActivity()).orderlist(userinfo.getUsername());
            orderListAdapter.setOrder(orderinfos);
        }
        refreshOrder();
    }

    // 刷新购物车数据的方法
    public void refreshOrder() {
        Userinfo userinfo = Userinfo.getUserinfo();
        if (userinfo != null) {
            List<Orderinfo> orderinfos = OrderDbHelper.getInstance(getActivity()).orderlist(userinfo.getUsername());
            orderListAdapter.setOrder(orderinfos);
            orderListAdapter.notifyDataSetChanged();
        }
    }
}