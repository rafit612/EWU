package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutActivity extends AppCompatActivity {
     LinearLayout circleImageView,circleImageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        circleImageView = findViewById(R.id.a1);
        circleImageView2=findViewById(R.id.a2);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/100006637966096"));
                startActivity(intent);   //https://www.facebook.com/EWU.ECPA
            }
        });
    circleImageView2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/100003065931363"));
            startActivity(intent);   //https://www.facebook.com/EWU.ECPA
        }
    });

    }


}