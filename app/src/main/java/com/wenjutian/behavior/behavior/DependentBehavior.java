package com.wenjutian.behavior.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by V.Wenju.Tian on 2016/11/3.
 */

public class DependentBehavior extends CoordinatorLayout.Behavior<View> {
    public DependentBehavior() {
    }

    public DependentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param parent
     * @param child      设置behavior 的 view
     * @param dependency 我们要依赖的view 这里我们只关心 textview
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof TextView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        int offset = dependency.getTop() - child.getTop();
        ViewCompat.offsetTopAndBottom(child, offset);//获取移动的位移值,并让child移动
        return true;
    }
}
