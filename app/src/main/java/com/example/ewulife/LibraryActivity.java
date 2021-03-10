package com.example.ewulife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class LibraryActivity extends AppCompatActivity {
    public CardView regis,visit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        regis = findViewById(R.id.lib_regis);
        visit = findViewById(R.id.on_lib);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lib.ewubd.edu/page/library-membership-online-application"));
                startActivity(intent);
            }
        });
        visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LibraryActivity.this,LIBwebActivity.class);
                startActivity(intent);
            }
        });
    }
}