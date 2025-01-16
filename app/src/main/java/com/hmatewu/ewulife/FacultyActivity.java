package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FacultyActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView aCardView,bCardView,
            cCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        aCardView = findViewById(R.id.fse);
        bCardView = findViewById(R.id.flass);
        cCardView = findViewById(R.id.fbe);

        aCardView.setOnClickListener(this);
        bCardView.setOnClickListener(this);
        cCardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.fse){
            Intent intent =new Intent(FacultyActivity.this,FSEActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.flass){
            Intent intent =new Intent(FacultyActivity.this,FLASSActivity2.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.fbe){
            Intent intent =new Intent(FacultyActivity.this,FBEActivity.class);
            startActivity(intent);
        }
    }
}