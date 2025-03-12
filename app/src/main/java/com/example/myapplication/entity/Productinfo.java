package com.example.myapplication.entity;

import java.io.Serializable;

public class Productinfo implements Serializable {
    private int product_id;
    private int product_img;
    private int product_money;
    private String product_title;
    private String product_delivery;
    private String product_state;
    private String product_name;
    private String product_details;
    private String product_state_1;
    private String product_state_2;
    private String product_state_3;

    public Productinfo(int product_id, int product_img, String product_title, int product_money, String product_delivery, String product_state, String product_name, String product_details, String product_state_1, String product_state_2, String product_state_3) {
        this.product_id = product_id;
        this.product_img = product_img;
        this.product_money = product_money;
        this.product_title = product_title;
        this.product_delivery = product_delivery;
        this.product_state = product_state;
        this.product_name = product_name;
        this.product_details = product_details;
        this.product_state_1 = product_state_1;
        this.product_state_2 = product_state_2;
        this.product_state_3 = product_state_3;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_img() {
        return product_img;
    }

    public void setProduct_img(int product_img) {
        this.product_img = product_img;
    }

    public int getProduct_money() {
        return product_money;
    }

    public void setProduct_money(int product_money) {
        this.product_money = product_money;
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

    public String getProduct_state() {
        return product_state;
    }

    public void setProduct_state(String product_state) {
        this.product_state = product_state;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_details() {
        return product_details;
    }

    public void setProduct_details(String product_details) {
        this.product_details = product_details;
    }

    public String getProduct_state_1() {
        return product_state_1;
    }

    public void setProduct_state_1(String product_state_1) {
        this.product_state_1 = product_state_1;
    }

    public String getProduct_state_2() {
        return product_state_2;
    }

    public void setProduct_state_2(String product_state_2) {
        this.product_state_2 = product_state_2;
    }

    public String getProduct_state_3() {
        return product_state_3;
    }

    public void setProduct_state_3(String product_state_3) {
        this.product_state_3 = product_state_3;
    }
}
