package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class UnderActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView ugcard,ug_feecard,ug_datecard,ug_applycard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under);
        ugcard = findViewById(R.id.ugsp);
        ug_feecard = findViewById(R.id.u_fees);
        ug_datecard = findViewById(R.id.u_date);
        ug_applycard = findViewById(R.id.u_apply);

        ug_applycard.setOnClickListener(this);
        ug_datecard.setOnClickListener(this);
        ug_feecard.setOnClickListener(this);
        ugcard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.ugsp){
            Intent intent =new Intent(UnderActivity.this,UnderProgActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.u_fees){
            Intent intent =new Intent(UnderActivity.this,UnderFeeActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.u_date){
            Intent intent =new Intent(UnderActivity.this,UnderDateActivity2.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.u_apply){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://admission.ewubd.edu/"));
            startActivity(intent);
        }

    }
}