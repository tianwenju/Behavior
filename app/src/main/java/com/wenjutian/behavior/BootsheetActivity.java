package com.wenjutian.behavior;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.wenjutian.behavior.adapter.ListRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BootsheetActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_bottom_sheet_control)
    Button btnBottomSheetControl;
    @BindView(R.id.btn_bottom_dialog_control)
    Button btnBottomDialogControl;
    @BindView(R.id.tab_layout)
    LinearLayout tabLayout;
    private BottomSheetBehavior<LinearLayout> bottomSheetBehavior;
    private RecyclerView mRecycleView;
    private BottomSheetBehavior<View> mBottomSheetBehavior;
    private BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bootsheet);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bottomSheetBehavior = BottomSheetBehavior.from(tabLayout);


        createBottomSheetDialog();
    }

    private void createBottomSheetDialog() {

        View view = LayoutInflater.from(this).inflate(R.layout.dialog_bottom_sheet, null);

        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(view);
        mRecycleView = ((RecyclerView) view.findViewById(R.id.recyclerView));
        mRecycleView.setHasFixedSize(true);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("我是第" + i + "个");
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        mRecycleView.setLayoutManager(linearLayoutManager);
        ListRecyclerAdapter adapter = new ListRecyclerAdapter(list);
        mRecycleView.setAdapter(adapter);
        //从bottomSheetDialog拿到behavior
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheetDialog.getDelegate().findViewById(android.support.design.R.id.design_bottom_sheet));
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    bottomSheetDialog.dismiss();
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    @OnClick({R.id.btn_bottom_sheet_control, R.id.btn_bottom_dialog_control})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_bottom_sheet_control:
                /**
                 * 在api24无效 state 是 setling .可以一开始设置其状态
                 */
                Log.e("自定义标签", "onClick: " + bottomSheetBehavior.getState());
                switch (bottomSheetBehavior.getState()) {
                    case BottomSheetBehavior.STATE_EXPANDED:
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                        break;
                }
                break;
            case R.id.btn_bottom_dialog_control:
                if (bottomSheetDialog.isShowing()) {
                    bottomSheetDialog.dismiss();
                } else {
                    bottomSheetDialog.show();
                }
                break;
        }
    }

    private boolean isInitialize = false;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (!isInitialize) {

            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            isInitialize = true;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
}
