package com.example.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.entity.Shopcarinfo;

import java.util.List;

public class OrderDbHelper extends SQLiteOpenHelper{
    private static OrderDbHelper orderDbHelper;
    private static final String DB_name = "order.db";
    private static final int Version = 1;
    private static Context context;

    public OrderDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public synchronized static OrderDbHelper getInstance(Context context){
        if (orderDbHelper == null){
            orderDbHelper = new OrderDbHelper(context, DB_name, null, Version);
        }
        return orderDbHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table order_table(_id integer primary key autoincrement," +
                        "username text," +
                        "product_title text," +
                        "product_delivery text," +
                        "product_count integer,"+
                        "address text,"+
                        "phone integer"+
                        ")");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //结算
    public void payAll(List<Shopcarinfo> shopcarinfos, String address, String phone){
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();

        try {
            for(int i = 0; i < shopcarinfos.size();i++){
                ContentValues values = new ContentValues();
                values.put("username", shopcarinfos.get(i).getUsername());
                values.put("product_title",shopcarinfos.get(i).getProduct_title());
                values.put("product_delivery",shopcarinfos.get(i).getProduct_delivery());
                values.put("product_count",shopcarinfos.get(i).getProduct_money());
                values.put("address",address);
                values.put("phone",phone);
                db.insert("order_table",null,values);
            }

            //标记事务成功
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
        db.close();
    }

}
