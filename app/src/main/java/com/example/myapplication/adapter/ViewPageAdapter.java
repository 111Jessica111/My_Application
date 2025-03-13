package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.myapplication.R;


public class ViewPageAdapter extends PagerAdapter {
    private int[] images = new int[]{R.mipmap.page_1,R.mipmap.page_2,R.mipmap.page_3,R.mipmap.page_4};
    private int[] context = new int[]{R.string.page_1,R.string.page_2,R.string.page_3,R.string.page_4};

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View page = LayoutInflater.from(container.getContext()).inflate(R.layout.page,null);
        ImageView page_image = page.findViewById(R.id.page_imag);
        TextView page_context = page.findViewById(R.id.page_context);

        page_image.setImageResource(images[position]);
        page_context.setText(container.getResources().getText(context[position]));

        container.addView(page);

        return page;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
