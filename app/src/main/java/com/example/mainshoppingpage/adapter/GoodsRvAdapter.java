package com.example.mainshoppingpage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mainshoppingpage.bean.GoodsItem;
import com.example.mainshoppingpage.R;

import java.util.ArrayList;

public class GoodsRvAdapter extends RecyclerView.Adapter<GoodsRvAdapter.MyViewHolder>{

    private final ArrayList<GoodsItem> goodsItems;

    public GoodsRvAdapter(ArrayList<GoodsItem> goodsItems) {
        this.goodsItems = goodsItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.goods_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (goodsItems.size() != 0) {
            Glide.with(holder.context)
                    .load(goodsItems.get(position).getImage())
                    .into(holder.imageView);
            holder.tvTitle.setText(goodsItems.get(position).getTitle());
            holder.tvContent.setText(goodsItems.get(position).getContent());
            holder.tvType.setText(goodsItems.get(position).getType());
            holder.tvStorage.setText(String.valueOf(goodsItems.get(position).getStorage()));
            holder.tvPrice.setText(goodsItems.get(position).getPrice());
            holder.imageView.setOnClickListener(v -> {

            });
        }
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvTitle,tvContent,tvType,tvPrice,tvStorage;
        Context context;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            imageView = itemView.findViewById(R.id.iv_goods);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvType = itemView.findViewById(R.id.tv_type);
            tvStorage = itemView.findViewById(R.id.tv_store);
            tvPrice = itemView.findViewById(R.id.tv_price);
        }
    }

    @Override
    public int getItemCount() {
        return goodsItems.size();
    }
}
