package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cuberto.liquid_swipe.LiquidPager;

public class SLIDEActivity extends AppCompatActivity {
    LiquidPager pager;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_l_i_d_e);
        pager = findViewById(R.id.pager);
        viewPager= new ViewPager(getSupportFragmentManager(),1);
        pager.setAdapter(viewPager);
    }
}