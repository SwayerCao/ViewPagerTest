package com.example.mainshoppingpage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MyBottomTabView extends LinearLayout {

    ImageView imageView;
    TextView textView;
    Drawable drawable;
    String string;


    public MyBottomTabView(Context context, Drawable drawable,String string) {
        super(context);
        initView(context);
    }

    public MyBottomTabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getAttrs(context,attrs);
        initView(context);
    }

    public MyBottomTabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttrs(context,attrs);
        initView(context);
    }

    public MyBottomTabView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        getAttrs(context,attrs);
        initView(context);
    }

    private void getAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.myBottomTabViewAttr);
        drawable = typedArray.getDrawable(R.styleable.myBottomTabViewAttr_attrDrawable);
        string = typedArray.getString(R.styleable.myBottomTabViewAttr_attrText);
        typedArray.recycle();
    }

    private void initView(Context context) {
        View view = inflate(context,R.layout.menu_bar_item,this);
        imageView = view.findViewById(R.id.iv_get_goods);
        textView = view.findViewById(R.id.tv_get_goods);
        imageView.setBackground(drawable);
        textView.setText(string);
    }

}
