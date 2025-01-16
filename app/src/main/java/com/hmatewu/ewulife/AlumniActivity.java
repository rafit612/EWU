package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class AlumniActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView aCardView,bCardView,
            cCardView,dCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumni);
        aCardView = findViewById(R.id.al_reg);
        bCardView = findViewById(R.id.al_event);
        cCardView = findViewById(R.id.al_member);
        dCardView = findViewById(R.id.al_web);

        aCardView.setOnClickListener(this);
        bCardView.setOnClickListener(this);
        cCardView.setOnClickListener(this);
        dCardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.al_reg){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://alumni.ewubd.edu/login"));
            startActivity(intent);
        }
        if(v.getId()==R.id.al_event){
            Intent intent =new Intent(AlumniActivity.this,ALUMeventActivity2.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.al_member){
            Intent intent =new Intent(AlumniActivity.this,ALUMmemberActivity2.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.al_web){
            Intent intent =new Intent(AlumniActivity.this,ALUMwebActivity2.class);
            startActivity(intent);
        }

    }
}