package com.example.ewulife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class OverActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView over_gcard,over_g_feecard,over_g_datecard,over_g_applycard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over);
        over_gcard = findViewById(R.id.ogsp);
        over_g_feecard = findViewById(R.id.over_fees);
        over_g_datecard = findViewById(R.id.over_date);
        over_g_applycard = findViewById(R.id.over_apply);

        over_g_applycard.setOnClickListener(this);
        over_g_datecard.setOnClickListener(this);
        over_g_feecard.setOnClickListener(this);
        over_gcard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.ogsp){
            Intent intent =new Intent(OverActivity.this,OverProgramActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.over_fees){
            Intent intent =new Intent(OverActivity.this,OverFeeActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.over_date){
            Intent intent =new Intent(OverActivity.this,UnderDateActivity2.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.over_apply){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://admission.ewubd.edu/"));
            startActivity(intent);
        }
    }
}