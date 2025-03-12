package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.db.UserDbHelper;

public class ReloginActivity extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_relogin);
        et_username = findViewById(R.id.et_user_name);
        et_password = findViewById(R.id.et_password);

        findViewById(R.id.tool_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.tv_relogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                //未按要求输入
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
                    Toast.makeText(ReloginActivity.this,"未按要求输入",Toast.LENGTH_SHORT).show();
                }else {
                    int row = UserDbHelper.getInstance(ReloginActivity.this).relogin(username,password);
                    if (row>0){
                        Toast.makeText(ReloginActivity.this,"注册成功，请登录",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }
}