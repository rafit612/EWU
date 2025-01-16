package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class RoktoJoddhaActivity extends AppCompatActivity implements View.OnClickListener {
    CardView facebook,group,request,member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rokto_joddha);

        facebook = findViewById(R.id.FBP);
        group = findViewById(R.id.JG);
        request = findViewById(R.id.RB);
        member = findViewById(R.id.BBD);

        facebook.setOnClickListener(this);
        group.setOnClickListener(this);
        request.setOnClickListener(this);
        member.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.FBP){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/110433143943287"));
            startActivity(intent);
        }
        if(v.getId()==R.id.JG){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://group/1153618531651006"));
            startActivity(intent);
        }
        if(v.getId()==R.id.RB){
            Intent intent =new Intent(RoktoJoddhaActivity.this,BloodFromActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.BBD){
            Intent intent =new Intent(RoktoJoddhaActivity.this,RequestWebFormActivity2.class);
            startActivity(intent);
        }
    }
}