package com.example.mainshoppingpage.bean;

import android.graphics.drawable.Drawable;

public class GoodsItem {

    private int image;

    private String title;

    private String Content;

    private String type;

    private String price;

    private int storage;


    public int getImage() {
        return image;
    }

    public GoodsItem(int image, String title, String content, String type, String price, int storage) {
        this.image = image;
        this.title = title;
        Content = content;
        this.type = type;
        this.price = price;
        this.storage = storage;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
}
