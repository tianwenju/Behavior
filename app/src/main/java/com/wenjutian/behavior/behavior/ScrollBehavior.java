package com.wenjutian.behavior.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by V.Wenju.Tian on 2016/11/3.
 */

public class ScrollBehavior extends AppBarLayout.ScrollingViewBehavior {
    public ScrollBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollBehavior() {
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {

       return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;

    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        int leftScrolled = target.getScrollY();
        child.setScrollY(leftScrolled);

    }

    @Override
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY) {
        // 直接将现在的y轴上的速度传递传递给child，让他fling起来就ok了。
        ((NestedScrollView) child).fling(((int) velocityY));
        return true;
    }

}

