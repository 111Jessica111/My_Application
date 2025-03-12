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
import com.example.myapplication.adapter.ShopCarListAdapter;
import com.example.myapplication.db.ShopcarDbHelper;
import com.example.myapplication.entity.Shopcarinfo;
import com.example.myapplication.entity.Userinfo;

import java.util.List;

public class ShopcarFragment extends Fragment {

    private View rootView;
    private RecyclerView recycle_shop;
    private ShopCarListAdapter shopCarListAdapter;
    private TextView tv_money_sum;
    private TextView tv_sum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_shopcar, container, false);

        recycle_shop = rootView.findViewById(R.id.recycle_shop);
        tv_money_sum = rootView.findViewById(R.id.tv_money_sum);
        tv_sum = rootView.findViewById(R.id.tv_sum);

        // 设置布局管理器
        recycle_shop.setLayoutManager(new LinearLayoutManager(getContext()));

        //初始化
        shopCarListAdapter = new ShopCarListAdapter();
        recycle_shop.setAdapter(shopCarListAdapter);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //加减点击事件
        shopCarListAdapter.setMonItemClickListener(new ShopCarListAdapter.onItemClickListener() {
            @Override
            public void onAddOnClick(Shopcarinfo shopcarinfo, int position) {
                ShopcarDbHelper.getInstance(getActivity()).add(shopcarinfo.getShop_id(),shopcarinfo);
                refreshShopCar();
            }

            @Override
            public void onSubtractOnClick(Shopcarinfo shopcarinfo, int position) {
                ShopcarDbHelper.getInstance(getActivity()).subtract(shopcarinfo.getShop_id(),shopcarinfo);
                refreshShopCar();
            }
        });

        //结算点击
        tv_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // 获取数据并显示
        refreshShopCar();
    }

    // 每次返回到这个Fragment时刷新数据(很重要！！！！！！！！！,把我害惨了 :( )
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
            setCountSum(shoplist);
        }
    }

    private void setCountSum(List<Shopcarinfo> shopcarinfos){
        int sum = 0;

        //循环进行计算总价钱
        for (int i = 0; i < shopcarinfos.size(); i++){
            int money = shopcarinfos.get(i).getProduct_money()*shopcarinfos.get(i).getProduct_count() ;
            sum = sum + money;
        }
        tv_money_sum.setText(sum+"");
    }
}