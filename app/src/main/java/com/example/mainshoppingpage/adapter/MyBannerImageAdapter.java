package com.example.mainshoppingpage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mainshoppingpage.MyBannerViewHolder;
import com.example.mainshoppingpage.R;
import com.youth.banner.adapter.BannerImageAdapter;
import java.util.List;

public class MyBannerImageAdapter extends BannerImageAdapter {
    private final Context context;

    public MyBannerImageAdapter(List mData,Context context) {
        super(mData);
        this.context = context;
    }



    @Override
    public MyBannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        super.onCreateHolder(parent, viewType);
        View view = LayoutInflater.from(context).inflate(R.layout.bannerimageitem,parent);
        return new MyBannerViewHolder(view);
    }

    @Override
    public void onBindView(Object holder, Object data, int position, int size) {

    }
}
