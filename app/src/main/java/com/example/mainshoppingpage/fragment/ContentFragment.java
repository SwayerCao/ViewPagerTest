package com.example.mainshoppingpage.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mainshoppingpage.R;
import com.example.mainshoppingpage.adapter.ContentAdapter;
import com.example.mainshoppingpage.bean.ContentItem;

import java.util.ArrayList;

public class ContentFragment extends Fragment {

    public ContentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_content_main);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<ContentItem> contentItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            contentItems.add(new ContentItem(R.mipmap.m1_menu_entrance,"标题","内容"));
        }
        ContentAdapter contentAdapter = new ContentAdapter(contentItems);
        recyclerView.setAdapter(contentAdapter);
        return view;
    }
}