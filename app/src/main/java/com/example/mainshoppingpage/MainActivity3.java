package com.example.mainshoppingpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mainshoppingpage.adapter.MainPagerAdapter;
import com.example.mainshoppingpage.bean.GoodsItem;
import com.example.mainshoppingpage.fragment.ContentFragment;
import com.example.mainshoppingpage.fragment.GoodsFragment;
import com.example.mainshoppingpage.fragment.MainFragment;
import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        viewPager = findViewById(R.id.vp_main);
        tabLayout = findViewById(R.id.tab_main);

        initMyMenu();
    }

    private void initMyMenu() {
        ArrayList<GoodsItem> goodsItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            goodsItems.add(new GoodsItem(R.drawable.img,"钛金手机" + i,"性能赛过苹果","128g 高级红","19999",100));
        }
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new MainFragment());
        fragmentList.add(new GoodsFragment(goodsItems));
        fragmentList.add(new ContentFragment());
        fragmentList.add(new GoodsFragment(goodsItems));

        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(),fragmentList));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        int[] ivTabs = new int[]{R.mipmap.m1_menu_entrance,R.mipmap.m1_menu_sales_service,R.mipmap.m1_menu_pick,R.mipmap.m1_menu_ticket};
        String[] tvTabs = new String[]{"聊天","通讯录","发现","我的"};

        for (int i = 0; i < fragmentList.size(); i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.menu_bar_item, tabLayout, false);
            ImageView ivTab=view.findViewById(R.id.iv_get_goods);
            TextView tvTab=view.findViewById(R.id.tv_get_goods);
            ivTab.setImageResource(ivTabs[i]);
            tvTab.setText(tvTabs[i]);
            if (i==0){
                ivTab.setColorFilter(Color.GREEN);
                tvTab.setTextColor(Color.GREEN);
                view.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.bg_bottom_tab,getTheme()));
            }
            tabLayout.getTabAt(i).setCustomView(view);
        }
        tabLayout.setSelectedTabIndicatorHeight(0);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                ImageView iv = customView.findViewById(R.id.iv_get_goods);
                TextView tv = customView.findViewById(R.id.tv_get_goods);
                iv.setColorFilter(Color.GREEN);
                tv.setTextColor(Color.GREEN);
                customView.setBackground(getResources().getDrawable(R.drawable.bg_bottom_tab));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                ImageView iv = customView.findViewById(R.id.iv_get_goods);
                TextView tv = customView.findViewById(R.id.tv_get_goods);
                iv.setColorFilter(Color.TRANSPARENT);
                tv.setTextColor(Color.GRAY);
                customView.setBackground(getResources().getDrawable(R.drawable.bg_bottom_tab));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}