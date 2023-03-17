package com.example.mainshoppingpage;

import static com.example.mainshoppingpage.R.layout.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.mainshoppingpage.adapter.MainPagerAdapter;
import com.example.mainshoppingpage.fragment.ContentFragment;
import com.example.mainshoppingpage.fragment.MainFragment;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        viewPager = findViewById(R.id.first_main_viewpager);
        tabLayout =findViewById(R.id.first_main_tab_layout);
        initMainAct();
    }

    private void initMainAct() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        int[] tabsId = new int[]{R.mipmap.m1_menu_entrance,R.mipmap.m1_menu_sales_service,R.mipmap.m1_menu_pick,R.mipmap.m1_menu_ticket};
        String[] strTv = new String[]{"聊天","通讯录","发现","我的"};

        fragments.add(new MainFragment());
        fragments.add(new ContentFragment());
        fragments.add(new ContentFragment());
        fragments.add(new ContentFragment());

        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(),fragments));
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < fragments.size(); i++) {
            View view = getLayoutInflater().inflate(menu_bar_item,tabLayout,false);
            ImageView imageView = view.findViewById(R.id.iv_get_goods);
            TextView textView = view.findViewById(R.id.tv_get_goods);
            imageView.setImageResource(tabsId[i]);
            textView.setText(strTv[i]);
            if (i == 0) {
                imageView.setColorFilter(Color.GREEN);
                textView.setTextColor(Color.GREEN);
                view.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.bg_bottom_tab,getTheme()));
            }
            if (tabLayout.getScrollBarSize() > 0 && tabLayout != null) {
                Objects.requireNonNull(tabLayout.getTabAt(i)).setCustomView(view);
            }
            if (tabLayout != null) {
                tabLayout.setSelectedTabIndicatorHeight(0);
                tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        View customView = tab.getCustomView();
                        if (customView != null) {
                            ImageView ivSelected = customView.findViewById(R.id.iv_get_goods);
                            TextView tvSelected = customView.findViewById(R.id.tv_get_goods);
                            ivSelected.setColorFilter(Color.GREEN);
                            tvSelected.setTextColor(Color.GREEN);
                        }

                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        View customView = tab.getCustomView();
                        if (customView != null) {
                            ImageView ivUnSelected = customView.findViewById(R.id.iv_get_goods);
                            TextView tvUnSelected = customView.findViewById(R.id.tv_get_goods);
                            ivUnSelected.setColorFilter(Color.TRANSPARENT);
                            tvUnSelected.setTextColor(Color.GRAY);
                        }
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });
            }
        }
    }

}