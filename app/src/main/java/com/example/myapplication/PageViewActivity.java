package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.adapter.ViewPageAdapter;

public class PageViewActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPageAdapter viewPageAdapter;
    private TextView skip;
    private TextView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page_view);

        viewPager = findViewById(R.id.viewPager);
        skip = findViewById(R.id.skip);
        next = findViewById(R.id.next);

        viewPageAdapter = new ViewPageAdapter();
        viewPager.setAdapter(viewPageAdapter);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转
                Intent intent = new Intent(PageViewActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem = viewPager.getCurrentItem();
                if (currentItem == 3){
                    Intent intent = new Intent(PageViewActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                if (currentItem < viewPager.getAdapter().getCount() - 1) {
                    viewPager.setCurrentItem(currentItem + 1);
                }

            }
        });
    }
}