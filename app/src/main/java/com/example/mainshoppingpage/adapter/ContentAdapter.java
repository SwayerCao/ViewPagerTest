package com.example.mainshoppingpage.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.mainshoppingpage.R;
import com.example.mainshoppingpage.bean.ContentItem;

import java.util.ArrayList;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {

    private final ArrayList<ContentItem> contentItems;

    public ContentAdapter(ArrayList<ContentItem> contentItems) {
        this.contentItems = contentItems;
    }

    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_content_item,parent,false);
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {
        if (contentItems.size() != 0) {
            Glide.with(holder.itemView.getContext()).load(contentItems.get(position).getDrawable()).into(holder.imageView);
            holder.tvTitle.setText(contentItems.get(position).getTitle());
            holder.tvContent.setText(contentItems.get(position).getContent());
        }
    }

    @Override
    public int getItemCount() {
        return contentItems.size();
    }

    static class ContentViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tvContent,tvTitle;

        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_content);
            tvTitle = itemView.findViewById(R.id.tv_content_title);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }

}
