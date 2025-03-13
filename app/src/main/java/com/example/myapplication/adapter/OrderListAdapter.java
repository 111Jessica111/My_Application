package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.Util.TimeUtil;
import com.example.myapplication.entity.Orderinfo;


import java.util.ArrayList;
import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.MyHolder>{

    private List<Orderinfo> orderinfos = new ArrayList<>();

    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        Orderinfo orderinfo = orderinfos.get(position);
        holder.tv_count.setText(orderinfo.getProduct_count()+"");
        holder.tv_delivery.setText(orderinfo.getProduct_delivery());
        holder.tv_title.setText(orderinfo.getProduct_title());
        holder.tv_time.setText(orderinfo.getTime());
    }

    @Override
    public int getItemCount() {
        return orderinfos.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder{
        private TextView tv_time;
        private TextView tv_title;
        private TextView tv_delivery;
        private TextView tv_count;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_time = itemView.findViewById(R.id.product_time);
            tv_title = itemView.findViewById(R.id.product_title);
            tv_delivery = itemView.findViewById(R.id.product_delivery);
            tv_count = itemView.findViewById(R.id.product_count);
        }
    }

    public void setOrder(List<Orderinfo> orderinfos){
        this.orderinfos = orderinfos;
    }
}
