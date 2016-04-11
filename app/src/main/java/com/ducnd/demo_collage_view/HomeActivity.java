package com.ducnd.demo_collage_view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ducnd.libs.MultiTouchListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements MultiTouchListener.MoveToFirst{
    private RelativeLayout home;
    private CollageView collageView1, collageView2, collageView3, collageView4;
    private ArrayList<CollageView> collageViews;
    private SparseArray<CollageView> collageViewSparseArray;
    private ImageView collageBgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        collageBgView = (ImageView) findViewById(R.id.collageBgView);
        collageBgView.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                return true;
            }
        });
//        findViewById(R.id.collageView1).setOnTouchListener(new MultiTouchListener());
//        findViewById(R.id.collageView2).setOnTouchListener(new MultiTouchListener());
//        findViewById(R.id.collageView3).setOnTouchListener(new MultiTouchListener());
//        findViewById(R.id.collageView4).setOnTouchListener(new MultiTouchListener());
        initComponent();
    }

    protected void initComponent() {
        home = (RelativeLayout) findViewById(R.id.home);
        collageViews = new ArrayList<>();
        collageView1 = (CollageView) findViewById(R.id.collageView1);
        collageView2 = (CollageView) findViewById(R.id.collageView2);
        collageView3 = (CollageView) findViewById(R.id.collageView3);
        collageView4 = (CollageView) findViewById(R.id.collageView4);


        collageViews.add(collageView4);
        collageViews.add(collageView3);
        collageViews.add(collageView2);
        collageViews.add(collageView1);




        collageView1.setOnTouchListener(new MultiTouchListener(new MultiTouchListener.GetMy() {
            @Override
            public CollageView getThis() {
                return collageView1;
            }
        }, this));

        collageView2.setOnTouchListener(new MultiTouchListener(new MultiTouchListener.GetMy() {
            @Override
            public CollageView getThis() {
                return collageView2;
            }
        }, this));
        collageView3.setOnTouchListener(new MultiTouchListener(new MultiTouchListener.GetMy() {
            @Override
            public CollageView getThis() {
                return collageView3;
            }
        }, this));
        collageView4.setOnTouchListener(new MultiTouchListener(new MultiTouchListener.GetMy() {
            @Override
            public CollageView getThis() {
                return collageView4;
            }
        }, this));
    }

    @Override
    public int findIndex(CollageView collageView) {
        return collageViews.indexOf(collageView);
    }

    @Override
    public void movoToFirst(int index) {
        collageViews.add(0, collageViews.remove(index));
        home.removeView(collageViews.get(0));
        home.addView(collageViews.get(0), home.getChildCount());
    }
}