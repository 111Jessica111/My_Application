package com.example.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.entity.Shopcarinfo;
import com.example.myapplication.entity.Userinfo;

public class UserDbHelper extends SQLiteOpenHelper {
    private static UserDbHelper userDbHelper;
    private static final String DB_name = "user.db";
    private static final int Version = 1;

    public UserDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //单例
    public synchronized static UserDbHelper getInstance(Context context){
        if (userDbHelper == null){
            userDbHelper = new UserDbHelper(context,DB_name,null,Version);
        }
        return userDbHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user_table(_id integer primary key autoincrement,"+
                "username text,"+
                "password text"+
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //登录
    public Userinfo login(String username){
        SQLiteDatabase db = null;
        Cursor cursor = null;
        Userinfo userinfo = null;

        try {
            db = getReadableDatabase();
            //数据库查询语句
            String sql = "SELECT _id, username, password FROM user_table WHERE username=?";
            //设置查询参数
            String[] selectionArgs = {username};
            //查询
            cursor = db.rawQuery(sql, selectionArgs);

            if (cursor != null && cursor.moveToFirst()) {
                //获得查询信息
                int user_id = cursor.getInt(cursor.getColumnIndexOrThrow("_id")); // 使用 getColumnIndexOrThrow 检查列是否存在
                String name = cursor.getString(cursor.getColumnIndexOrThrow("username"));
                String password = cursor.getString(cursor.getColumnIndexOrThrow("password"));

                userinfo = new Userinfo(user_id,name,password);
            }
        } catch (Exception e) {
            e.printStackTrace();  // 打印错误信息
        } finally {
            if (cursor != null) {
                cursor.close();  // 确保 cursor 被关闭
            }
            if (db != null) {
                db.close();  // 确保数据库被关闭
            }
        }
        return userinfo;
    }
    //注册
    public int relogin(String username,String password){
        //获取实例
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        //填充
        values.put("username",username);
        values.put("password",password);
        String nullColumHack = "values(null,?,?)";
        //插入
        int insert = (int) db.insert("user_table",nullColumHack,values);
        db.close();
        return insert;
    }
}
