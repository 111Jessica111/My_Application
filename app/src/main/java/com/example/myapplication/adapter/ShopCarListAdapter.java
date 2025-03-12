package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.entity.Shopcarinfo;

import java.util.ArrayList;
import java.util.List;

public class ShopCarListAdapter extends RecyclerView.Adapter<ShopCarListAdapter.MyHolder> {

    private List<Shopcarinfo> shopcarinfos = new ArrayList<>();

    public void setShopData(List<Shopcarinfo> list){
        this.shopcarinfos = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    //加载布局
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_list,null);
        return new MyHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        //绑定
        Shopcarinfo shopcarinfo = shopcarinfos.get(position);
        holder.product_image.setImageResource(shopcarinfo.getProduct_image());
        holder.product_title.setText(shopcarinfo.getProduct_title());
        holder.product_money.setText(shopcarinfo.getProduct_money()+"");
        holder.product_delivery.setText(shopcarinfo.getProduct_delivery());
        holder.product_state.setText(shopcarinfo.getProduct_state());
        holder.product_count.setText(shopcarinfo.getProduct_count()+"");
    }

    @Override
    public int getItemCount() {
        return shopcarinfos.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder{
        ImageView product_image;
        TextView product_title;
        TextView product_money;
        TextView product_delivery;
        TextView product_state;
        TextView product_count;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            product_image = itemView.findViewById(R.id.product_image);
            product_title = itemView.findViewById(R.id.product_title);
            product_money = itemView.findViewById(R.id.product_money);
            product_delivery = itemView.findViewById(R.id.product_delivery);
            product_state = itemView.findViewById(R.id.product_state);
            product_count = itemView.findViewById(R.id.product_count);
        }
    }
}
