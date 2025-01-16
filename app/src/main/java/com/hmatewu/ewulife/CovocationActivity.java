package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class CovocationActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView applicard,info_card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covocation);

        applicard = findViewById(R.id.con_info);
        info_card = findViewById(R.id.conv_appli);

       applicard.setOnClickListener(this);
        info_card.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.con_info){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ewubd.edu/convocation"));
            startActivity(intent);
        }
        if(v.getId()==R.id.conv_appli){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ewubd.edu/convocation-notice-board"));
            startActivity(intent);
        }
    }
}