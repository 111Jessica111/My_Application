package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.db.UserDbHelper;
import com.example.myapplication.entity.Userinfo;

public class LoginActivity extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        TextView tv_register = findViewById(R.id.tv_register);
        //立即注册
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转
                Intent intent = new Intent(LoginActivity.this,ReloginActivity.class);
                startActivity(intent);
            }
        });
        //登录
        findViewById(R.id.tv_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                //未按要求输入
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this,"未按要求输入",Toast.LENGTH_SHORT).show();
                }else {
                    Userinfo login = UserDbHelper.getInstance(LoginActivity.this).login(username);
                    if (login!=null){
                        //判断是否相同
                        if (username.equals(login.getUsername())&&password.equals(login.getPassword())){
                            //保存登录信息
                            Userinfo.setUserinfo(login);
                            //跳转
                            Intent intent = new Intent(LoginActivity.this, PageViewActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(LoginActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(LoginActivity.this,"该账号尚未注册",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}