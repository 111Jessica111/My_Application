package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.db.ShopcarDbHelper;
import com.example.myapplication.entity.Productinfo;
import com.example.myapplication.entity.Userinfo;

public class DetailActivity extends AppCompatActivity {

    private ImageView product_image;
    private TextView product_money;
    private TextView product_name;
    private TextView product_detail;
    private TextView product_state_1;
    private TextView product_state_2;
    private TextView product_state_3;

    private Productinfo productinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        product_image = findViewById(R.id.product_image);
        product_money = findViewById(R.id.product_money);
        product_name = findViewById(R.id.product_name);
        product_detail = findViewById(R.id.product_details);
        product_state_1 = findViewById(R.id.product_state_1);
        product_state_2 = findViewById(R.id.product_state_2);
        product_state_3 = findViewById(R.id.product_state_3);

        findViewById(R.id.tool_detail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //获取商品信息
        productinfo = (Productinfo) getIntent().getSerializableExtra("productinfo");
        //设置相应的数据
        product_image.setImageResource(productinfo.getProduct_img());
        product_money.setText(productinfo.getProduct_money()+"");
        product_name.setText(productinfo.getProduct_name());
        product_detail.setText(productinfo.getProduct_details());
        product_state_1.setText(productinfo.getProduct_state_1());
        product_state_2.setText(productinfo.getProduct_state_2());
        product_state_3.setText(productinfo.getProduct_state_3());

        //加入购物车
        findViewById(R.id.add_shop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Userinfo userinfo = Userinfo.getUserinfo();
                if (userinfo != null){
                    int row = ShopcarDbHelper.getInstance(DetailActivity.this).add(userinfo.getUsername(),productinfo.getProduct_id(),productinfo.getProduct_img(),productinfo.getProduct_title(),productinfo.getProduct_money(),productinfo.getProduct_delivery(),productinfo.getProduct_state());
                    if (row>0){
                        Toast.makeText(DetailActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(DetailActivity.this,"添加失败",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }
}