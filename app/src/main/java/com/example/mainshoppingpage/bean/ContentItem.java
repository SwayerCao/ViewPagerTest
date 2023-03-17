package com.example.mainshoppingpage.bean;

import android.graphics.drawable.Drawable;

import com.example.mainshoppingpage.R;

public class ContentItem {

    private int drawable;

    private String title;

    private String content;

    private ContentItem contentItem;

    public ContentItem() {
    }

    public ContentItem(int drawable, String title, String content) {
        this.drawable = drawable;
        this.title = title;
        this.content = content;
    }

    public int getDrawable() {
        return drawable;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
