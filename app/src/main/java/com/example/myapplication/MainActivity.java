package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.fragment.HomeFragment;
import com.example.myapplication.fragment.MineFragment;
import com.example.myapplication.fragment.OrderFragment;
import com.example.myapplication.fragment.ShopcarFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private HomeFragment mHomeFragment;
    private ShopcarFragment mShopcarFragment;
    private OrderFragment mOrderFragment;
    private MineFragment mMineFragment;
    private BottomNavigationView btn_nvgt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn_nvgt = findViewById(R.id.btn_nvgt);

        btn_nvgt.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.home){
                    selectedFragment(0);
                } else if (item.getItemId()==R.id.shopcar) {
                    selectedFragment(1);
                } else if (item.getItemId()==R.id.order) {
                    selectedFragment(2);
                }else {
                    selectedFragment(3);
                }
                return true;
            }
        });
        //默认在首页
        selectedFragment(0);
    }

    private void selectedFragment(int position){
        //获取点击前即当前页面
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //隐藏当前页面
        hideFragment(fragmentTransaction);
        //根据传入的position，将对应的Fragment布局放入fl_content中
        if (position == 0){
            if (mHomeFragment == null){
                mHomeFragment = new HomeFragment();
                fragmentTransaction.add(R.id.fl_content,mHomeFragment);
            }else {
                fragmentTransaction.show(mHomeFragment);
            }
        }
        else if (position == 1){
            if (mShopcarFragment == null){
                mShopcarFragment = new ShopcarFragment();
                fragmentTransaction.add(R.id.fl_content,mShopcarFragment);
            }else {
                fragmentTransaction.show(mShopcarFragment);
                mShopcarFragment.refreshShopCar();
            }
        }
        else if (position == 2){
            if (mOrderFragment == null){
                mOrderFragment = new OrderFragment();
                fragmentTransaction.add(R.id.fl_content,mOrderFragment);
            }else {
                fragmentTransaction.show(mOrderFragment);
                mOrderFragment.refreshOrder();
            }
        }
        else {
            if (mMineFragment == null){
                mMineFragment = new MineFragment();
                fragmentTransaction.add(R.id.fl_content,mMineFragment);
            }else {
                fragmentTransaction.show(mMineFragment);
            }
        }
        //实现
        fragmentTransaction.commit();
    }

    //隐藏
    private void hideFragment(FragmentTransaction fragmentTransaction){
        //找到已实例化的布局，即起为当前布局，需要隐藏
        if (mHomeFragment!=null){
            fragmentTransaction.hide(mHomeFragment);
        }
        if (mShopcarFragment!=null){
            fragmentTransaction.hide(mShopcarFragment);
        }
        if (mOrderFragment!=null){
            fragmentTransaction.hide(mOrderFragment);
        }
        if (mMineFragment!=null){
            fragmentTransaction.hide(mMineFragment);
        }
    }
}