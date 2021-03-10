package com.example.ewulife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdmissionActivity extends AppCompatActivity implements View.OnClickListener {
    CardView under,over;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission);

        under = findViewById(R.id.ugs);
        over = findViewById(R.id.ggs);

        under.setOnClickListener(this);
        over.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.ugs){
            Intent intent =new Intent(AdmissionActivity.this,UnderActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.ggs){
            Intent intent =new Intent(AdmissionActivity.this,OverActivity.class);
            startActivity(intent);
        }
    }
}