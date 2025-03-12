package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.entity.Productinfo;

import java.util.ArrayList;
import java.util.List;

public class RightListAdapter extends RecyclerView.Adapter<RightListAdapter.MyHolder> {
    private List<Productinfo> mProductinfo = new ArrayList<>();

    public void setProductData(List<Productinfo> list){
        this.mProductinfo = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.right_list,null);
        return new MyHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        //绑定
        Productinfo productinfo = mProductinfo.get(position);
        holder.product_image.setImageResource(productinfo.getProduct_img());
        holder.product_title.setText(productinfo.getProduct_title());
        holder.product_money.setText(productinfo.getProduct_money()+"");
        holder.product_delivery.setText(productinfo.getProduct_delivery());
        holder.product_state.setText(productinfo.getProduct_state());

        //点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (monItemClickListener!=null){
                    monItemClickListener.onItemClick(productinfo,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mProductinfo.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder{
        ImageView product_image;
        TextView product_title;
        TextView product_money;
        TextView product_delivery;
        TextView product_state;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            product_image = itemView.findViewById(R.id.product_image);
            product_title = itemView.findViewById(R.id.product_title);
            product_money = itemView.findViewById(R.id.product_money);
            product_delivery = itemView.findViewById(R.id.product_delivery);
            product_state = itemView.findViewById(R.id.product_state);
        }
    }

    private onItemClickListener monItemClickListener;

    public void setonItemClickListener(onItemClickListener monItemClickListener) {
        this.monItemClickListener = monItemClickListener;
    }

    public interface onItemClickListener{
        void onItemClick(Productinfo productinfo,int position);
    }
}
