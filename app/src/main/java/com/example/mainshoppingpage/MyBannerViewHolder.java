package com.example.mainshoppingpage;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.youth.banner.holder.BannerImageHolder;

public class MyBannerViewHolder extends BannerImageHolder {
    ImageView imageView;
    public MyBannerViewHolder(@NonNull View view) {
        super(view);
        imageView = view.findViewById(R.id.banner_image);
    }
}
