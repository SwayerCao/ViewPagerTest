package com.example.mainshoppingpage.fragment;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.mainshoppingpage.R;
import com.example.mainshoppingpage.adapter.GoodsRvAdapter;
import com.example.mainshoppingpage.bean.GoodsItem;
import com.example.mainshoppingpage.utils.MyItemDecoration;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initGoodsList(view);
        initBannerView(view);
        return view;
    }

    private void initGoodsList(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_goods);
        ArrayList<GoodsItem> goodsItems = new ArrayList<>();
        GridLayoutManager gridLayoutManager;
        for (int i = 0; i < 11; i++) {
            goodsItems.add(new GoodsItem(R.drawable.img,i+"钛金手机","性能赛过苹果","128g 高级红","19999",100));
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            gridLayoutManager = new GridLayoutManager(view.getContext(),2);
        } else {
            gridLayoutManager = new GridLayoutManager(view.getContext(),3);
        }
        RecyclerView.ItemDecoration itemDecoration = new MyItemDecoration();
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(gridLayoutManager);
        GoodsRvAdapter goodsRvAdapter = new GoodsRvAdapter(goodsItems);
        recyclerView.setAdapter(goodsRvAdapter);
    }

    private void initBannerView(View view) {
        Banner banner = view.findViewById(R.id.banner_top);
        List<BannerClass> bannerList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            bannerList.add(new BannerClass(R.drawable.mall_banner2, "phone1"));
        }
        banner.setAdapter(new BannerImageAdapter<BannerClass>(bannerList) {
            @Override
            public void onBindView(BannerImageHolder holder, BannerClass data, int position, int size) {
                Glide.with(holder.imageView)
                        .load(data.getBannerImage())
                        .into(holder.imageView);
            }

        });
    }

    static class BannerClass {

        private final int bannerImage;

        public final String imageName;

        public BannerClass(int bannerImage, String imageName) {
            this.bannerImage = bannerImage;
            this.imageName = imageName;
        }

        public int getBannerImage() {
            return bannerImage;
        }


    }
}