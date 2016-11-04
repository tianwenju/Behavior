package com.wenjutian.behavior;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DefineBehaivorActivity extends AppCompatActivity {

    @BindView(R.id.depentent)
    TextView depentent;
    @BindView(R.id.activity_define_behaivor)
    CoordinatorLayout activityDefineBehaivor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_define_behaivor);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.depentent)
    public void onClick() {

        ViewCompat.offsetTopAndBottom(depentent,5);

    }
}
