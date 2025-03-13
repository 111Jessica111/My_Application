package com.example.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.Util.TimeUtil;
import com.example.myapplication.entity.Orderinfo;
import com.example.myapplication.entity.Shopcarinfo;

import java.util.ArrayList;
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
                        "phone integer,"+
                        "time text"+
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
                values.put("product_count",shopcarinfos.get(i).getProduct_count());
                values.put("address",address);
                values.put("phone",phone);
                values.put("time", TimeUtil.getCurrentTime());
                db.insert("order_table",null,values);
            }

            //标记事务成功
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
        db.close();
    }

    //查询
    public List<Orderinfo> orderlist(String username){
        SQLiteDatabase db = null;
        Cursor cursor = null;
        List<Orderinfo> list = new ArrayList<>();

        try{
            db = getReadableDatabase();
            String sql = "SELECT _id, username, product_title, product_delivery, product_count, address, phone, time FROM order_table WHERE username=?";
            String[] selectionArgs = {username};
            cursor = db.rawQuery(sql,selectionArgs);

            while (cursor != null && cursor.moveToNext()) {
                //获得查询信息
                int order_id = cursor.getInt(cursor.getColumnIndexOrThrow("_id")); // 使用 getColumnIndexOrThrow 检查列是否存在
                String name = cursor.getString(cursor.getColumnIndexOrThrow("username"));
                String product_title = cursor.getString(cursor.getColumnIndexOrThrow("product_title"));
                String product_delivery = cursor.getString(cursor.getColumnIndexOrThrow("product_delivery"));
                int product_count = cursor.getInt(cursor.getColumnIndexOrThrow("product_count"));
                String address = cursor.getString(cursor.getColumnIndexOrThrow("address"));
                String phone = cursor.getString(cursor.getColumnIndexOrThrow("phone"));
                String time = cursor.getString(cursor.getColumnIndexOrThrow("time"));

                list.add(new Orderinfo(order_id, name, product_title, product_delivery, product_count, address, phone, time));
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
        return list;
    }
}
