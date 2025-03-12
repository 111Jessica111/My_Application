package com.example.myapplication.entity;

public class Shopcarinfo {
    private int shop_id;
    private String username;
    private int product_id;
    private int product_image;
    private String product_title;
    private int product_money;
    private String product_delivery;
    private String product_state;
    private int product_count;

    public Shopcarinfo(int shop_id, String username, int product_id, int product_image, String product_title, int product_money, String product_delivery, String product_state, int product_count) {
        this.shop_id = shop_id;
        this.username = username;
        this.product_id = product_id;
        this.product_image = product_image;
        this.product_title = product_title;
        this.product_money = product_money;
        this.product_delivery = product_delivery;
        this.product_state = product_state;
        this.product_count = product_count;
    }

    public int getProduct_count() {
        return product_count;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_image() {
        return product_image;
    }

    public void setProduct_image(int product_image) {
        this.product_image = product_image;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public int getProduct_money() {
        return product_money;
    }

    public void setProduct_money(int product_money) {
        this.product_money = product_money;
    }

    public String getProduct_delivery() {
        return product_delivery;
    }

    public void setProduct_delivery(String product_delivery) {
        this.product_delivery = product_delivery;
    }

    public String getProduct_state() {
        return product_state;
    }

    public void setProduct_state(String product_state) {
        this.product_state = product_state;
    }
}
