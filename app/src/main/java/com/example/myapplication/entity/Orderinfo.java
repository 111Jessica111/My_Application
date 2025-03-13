package com.example.myapplication.entity;

public class Orderinfo {
    private int order_id;
    private String username;
    private String product_title;
    private String product_delivery;
    private int product_count;
    private String address;
    private String phone;
    private String time;

    public Orderinfo(int order_id, String username, String product_title, String product_delivery, int product_count, String address, String phone, String time) {
        this.order_id = order_id;
        this.username = username;
        this.product_title = product_title;
        this.product_delivery = product_delivery;
        this.product_count = product_count;
        this.address = address;
        this.phone = phone;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public String getProduct_delivery() {
        return product_delivery;
    }

    public void setProduct_delivery(String product_delivery) {
        this.product_delivery = product_delivery;
    }

    public int getProduct_count() {
        return product_count;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
