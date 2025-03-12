package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class LeftListAdapter extends RecyclerView.Adapter<LeftListAdapter.MyHolder> {

    private List<String> datalist = new ArrayList<>();
    private int currentIndex = 0;

    //构造方法
    public LeftListAdapter(List<String> datalist){
        this.datalist=datalist;
    }

    @NonNull
    @Override
    //创建新的视图，并封装在ViewHolder中
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.left_list,null);
        return new MyHolder(view);
    }

    @Override
    @SuppressLint("RecyclerView")
    //绑定布局
    public void onBindViewHolder(@NonNull MyHolder holder,  int position) {
        //绑定数据
        String item_name = datalist.get(position);
        holder.left_item.setText(item_name);

        //点击
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLeftListOnClickItemListener != null){
                    mLeftListOnClickItemListener.onItemClick(position);
                }
            }
        });

        //判断选中
        if (currentIndex == position){
            holder.itemView.setBackgroundResource(R.drawable.item_selector_bg);
        }else {
            holder.itemView.setBackgroundResource(R.drawable.item_selector_common_bg);
        }
    }

    @Override
    //返回数目
    public int getItemCount() {
        return datalist.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder{
        TextView left_item;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            left_item = itemView.findViewById(R.id.left_item);
        }
    }

    private LeftListOnClickItemListener mLeftListOnClickItemListener;

    //设置该接口的监听器
    public void setmLeftListOnClickItemListener(LeftListOnClickItemListener mLeftListOnClickItemListener) {
        this.mLeftListOnClickItemListener = mLeftListOnClickItemListener;
    }

    //点击效果接口
    public interface LeftListOnClickItemListener{
        void onItemClick(int position);
    }

    public void setCurrentIndex(int position){
        this.currentIndex = position;
        notifyDataSetChanged();
    }
}
