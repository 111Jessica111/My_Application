package com.example.myapplication.db;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.entity.DataProvider;
import com.example.myapplication.entity.Shopcarinfo;
import com.example.myapplication.fragment.ShopcarFragment;

import java.util.ArrayList;
import java.util.List;

public class ShopcarDbHelper extends SQLiteOpenHelper {
    private static ShopcarDbHelper shopcarDbHelper;
    private static final String DB_name = "shopcar.db";
    private static final int Version = 1;
    private Context context;

    public ShopcarDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }
    //单例
    public synchronized static ShopcarDbHelper getInstance(Context context) {
        if (shopcarDbHelper == null) {
            shopcarDbHelper = new ShopcarDbHelper(context, DB_name, null, Version);
        }
        return shopcarDbHelper;
    }

    //建立数据库表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table shopcar_table(_id integer primary key autoincrement," + "username text," +
                        "product_id integer," +
                        "product_image integer," +
                        "product_title text," +
                        "product_money integer," +
                        "product_delivery text," + "product_state text," +
                        "product_count integer"+
                        ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //添加到购物车
    public int add(String username, int product_id, int product_image, String product_title, int product_money, String product_delivery, String product_state) {
        //判断是否添加过商品
        Shopcarinfo addshop = is_add(username,product_id);
        if (addshop==null){
            //获取SQLiteDatabase实例
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            //填入数据
            values.put("username", username);
            values.put("product_id", product_id);
            values.put("product_image", product_image);
            values.put("product_title", product_title);
            values.put("product_money", product_money);
            values.put("product_delivery", product_delivery);
            values.put("product_state", product_state);
            values.put("product_count",1);
            String nullColumHack = "value(null,?,?,?,?,?,?,?,?)";
            //执行
            int insert = (int) db.insert("shopcar_table", nullColumHack, values);
            //db.close();
            return insert;
        }else {
            //如果已经添加过了，就直接数量加一
            return  add(addshop.getShop_id(),addshop);
        }
    }

    //购物车数量增加
    public int add(int shop_id, Shopcarinfo shopcarinfo){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        //添加后数量加一
        values.put("product_count",shopcarinfo.getProduct_count()+1);
        int update = db.update("shopcar_table",values,"_id=?",new String[]{shop_id+""});
        //db.close();
        return update;
    }


    //购物车数量减少
    public int subtract(int shop_id, Shopcarinfo shopcarinfo){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        if (shopcarinfo.getProduct_count() > 1){
            //添加后数量减一
            values.put("product_count",shopcarinfo.getProduct_count()-1);
            int update = db.update("shopcar_table",values,"_id=?",new String[]{shop_id+""});
            //db.close();
            return update;
        }
        //db.close();
        return 0;
    }

    //删除
    public int delete(String shop_id){
        SQLiteDatabase db = getWritableDatabase();
        int delete = db.delete("shopcar_table","_id=?",new String[]{shop_id});
        //db.close();
        return delete;
    }

    //数量修改
    public Shopcarinfo is_add(String username, int product_id) {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        Shopcarinfo shopinfo = null;

        try {
            db = getReadableDatabase();
            //数据库查询语句
            String sql = "SELECT _id, username, product_id, product_image, product_title, product_money, product_delivery, product_state, product_count FROM shopcar_table WHERE username=? AND product_id=?";
            //设置查询参数
            String[] selectionArgs = {username, String.valueOf(product_id)};
            //查询
            cursor = db.rawQuery(sql, selectionArgs);

            if (cursor != null && cursor.moveToNext()) {
                //获得查询信息
                int shop_id = cursor.getInt(cursor.getColumnIndexOrThrow("_id")); // 使用 getColumnIndexOrThrow 检查列是否存在
                String name = cursor.getString(cursor.getColumnIndexOrThrow("username"));
                int productId = cursor.getInt(cursor.getColumnIndexOrThrow("product_id"));
                int product_image = cursor.getInt(cursor.getColumnIndexOrThrow("product_image"));
                String product_title = cursor.getString(cursor.getColumnIndexOrThrow("product_title"));
                int product_money = cursor.getInt(cursor.getColumnIndexOrThrow("product_money"));
                String product_delivery = cursor.getString(cursor.getColumnIndexOrThrow("product_delivery"));
                String product_state = cursor.getString(cursor.getColumnIndexOrThrow("product_state"));
                int product_count = cursor.getInt(cursor.getColumnIndexOrThrow("product_count"));

                shopinfo = new Shopcarinfo(shop_id, name, productId, product_image, product_title, product_money, product_delivery, product_state, product_count);
            }
        } catch (Exception e) {
            e.printStackTrace();  // 打印错误信息
        } finally {
            if (cursor != null) {
                cursor.close();  // 确保 cursor 被关闭
            }
            if (db != null) {
               // db.close();  // 确保数据库被关闭
            }
        }
        return shopinfo;
    }



    //根据用户名查询购物车
    public List<Shopcarinfo> shoplist(String username){
        SQLiteDatabase db = null;
        Cursor cursor = null;
        List<Shopcarinfo> list = new ArrayList<>();

        try{
            db = getReadableDatabase();
            String sql = "SELECT _id, username, product_id, product_image, product_title, product_money, product_delivery, product_state, product_count FROM shopcar_table WHERE username=?";
            String[] selectionArgs = {username};
            cursor = db.rawQuery(sql,selectionArgs);

            while (cursor != null && cursor.moveToNext()) {
                //获得查询信息
                int shop_id = cursor.getInt(cursor.getColumnIndexOrThrow("_id")); // 使用 getColumnIndexOrThrow 检查列是否存在
                String name = cursor.getString(cursor.getColumnIndexOrThrow("username"));
                int productId = cursor.getInt(cursor.getColumnIndexOrThrow("product_id"));
                int product_image = cursor.getInt(cursor.getColumnIndexOrThrow("product_image"));
                String product_title = cursor.getString(cursor.getColumnIndexOrThrow("product_title"));
                int product_money = cursor.getInt(cursor.getColumnIndexOrThrow("product_money"));
                String product_delivery = cursor.getString(cursor.getColumnIndexOrThrow("product_delivery"));
                String product_state = cursor.getString(cursor.getColumnIndexOrThrow("product_state"));
                int product_count = cursor.getInt(cursor.getColumnIndexOrThrow("product_count"));

                list.add(new Shopcarinfo(shop_id, name, productId, product_image, product_title, product_money, product_delivery, product_state, product_count));
            }
        } catch (Exception e) {
            e.printStackTrace();  // 打印错误信息
        } finally {
            if (cursor != null) {
                cursor.close();  // 确保 cursor 被关闭
            }
            if (db != null) {
               //db.close();  // 确保数据库被关闭
            }
        }
        return list;
    }
}