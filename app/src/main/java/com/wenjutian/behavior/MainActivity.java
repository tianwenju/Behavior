package com.wenjutian.behavior;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toobar)
    Toolbar toobar;
    @BindView(R.id.bt_zhihu)
    Button btZhihu;
    @BindView(R.id.bt_sheet)
    Button btSheet;
    @BindView(R.id.bt_swipeBehavoir)
    Button btSwipeBehavoir;
    @BindView(R.id.bt_define)
    Button btDefine;
    @BindView(R.id.activity_main)
    CoordinatorLayout activityMain;
    @BindView(R.id.bt_define2)
    Button btDefine2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toobar);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_zhihu, R.id.bt_sheet, R.id.bt_swipeBehavoir, R.id.bt_define, R.id.bt_define2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_zhihu:

                break;
            case R.id.bt_sheet:
                Intent intent = new Intent(MainActivity.this, BootsheetActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_swipeBehavoir:
                Intent intent1 = new Intent(MainActivity.this, zhihuActivity.class);
                startActivity(intent1);
                break;
            case R.id.bt_define:
                Intent intent2
                        = new Intent(MainActivity.this, DefineBehaivorActivity.class);
                startActivity(intent2
                );
                break;
            case R.id.bt_define2:
                Intent intent3
                        = new Intent(MainActivity.this, ScrollActivity.class);
                startActivity(intent3
                );
                break;
        }
    }


}
