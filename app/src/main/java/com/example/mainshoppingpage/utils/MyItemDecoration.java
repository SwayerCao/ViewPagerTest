package com.example.mainshoppingpage.utils;

import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class MyItemDecoration extends RecyclerView.ItemDecoration {


    public MyItemDecoration() {
        Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.YELLOW);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getAdapter() != null) {
            int left = 0;
            int right = 0;
            int top = 0;
            int bottom = 0;
            if (parent.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                //竖屏
                //左右
                if (parent.getChildAdapterPosition(view) % 2 == 0) {
                    left = 30;
                    right = 15;
                } else {
                    left = 15;
                    right = 30;
                }
                //上下
                if (parent.getChildAdapterPosition(view) < 2) {
                    top = 30;
                    bottom = 15;
                } else if (Objects.requireNonNull(parent.getAdapter()).getItemCount() - parent.getChildAdapterPosition(view) < 2) {
                    top = 15;
                    bottom = 30;
                } else {
                    top = 15;
                    bottom = 15;
                }
            } else {
                //横屏
                //左右
                if ((parent.getChildAdapterPosition(view) + 1) % 3 == 0) {
                    left = 10;
                    right = 30;
                } else if (parent.getChildAdapterPosition(view) % 3 == 0) {
                    left = 30;
                    right = 10;
                } else if ((parent.getChildAdapterPosition(view) - 1) % 3 == 0) {
                    left = 20;
                    right = 20;
                }
                //上下
                if (parent.getChildAdapterPosition(view) < 3) {
                    top = 30;
                    bottom = 15;
                } else if (parent.getAdapter().getItemCount() - parent.getChildAdapterPosition(view) <= 2) {
                    switch ((parent.getAdapter().getItemCount() + 1) % 3) {
                        case 0:
                            top = 15;
                            bottom = 30;
                            break;
                        case 1:
                            if (parent.getAdapter().getItemCount() == parent.getChildAdapterPosition(view)) {
                                top = 15;
                                bottom = 30;
                            } else {
                                top = 15;
                                bottom = 15;
                            }
                            break;
                        case 2:
                            if (parent.getAdapter().getItemCount() - parent.getChildAdapterPosition(view) < 2) {
                                top = 15;
                                bottom = 30;
                            } else {
                                top = 15;
                                bottom = 15;
                            }
                            break;
                    }
                } else {
                    top = 15;
                    bottom = 15;
                }
            }
            outRect.set(left, top, right, bottom);
            parent.getChildAt(parent.getChildAdapterPosition(view));
        }
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
/*
        int childCount = parent.getChildCount();
        遍历RecyclerView的所有子view
        for (int i = 0; i < childCount; i++) {
            //看看子view是否是列表中的条目，如果是的话，我们获取它的位置
            View view = parent.getChildAt(i);
            float dividerTop = view.getTop() ;
            float dividerLeft = view.getLeft() ;
            float dividerBottom = view.getTop() + 10;
            float dividerRight = parent.getWidth();
            c.drawRect(dividerLeft, dividerTop, dividerRight, dividerBottom, mPaint);
        }
*/
    }
}
