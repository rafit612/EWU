package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomeActivity extends AppCompatActivity {
    private static int TIME=3500;
    Button register,guest;
    TextView t1,t2;
    ImageView i1,i2;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        firebaseAuth =FirebaseAuth.getInstance();

        t1 = findViewById(R.id.textView100);
        t2 = findViewById(R.id.textView620);

        i2 = findViewById(R.id.imageView130);




    }
    protected void onStart(){
        super.onStart();

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            Intent intent =new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        else{

            t1.animate().translationX(-1400).setDuration(1000).setStartDelay(3000);
            t2.animate().translationX(-1400).setDuration(1000).setStartDelay(3000);

            i2.animate().translationX(-1400).setDuration(1000).setStartDelay(3000);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent =new Intent(WelcomeActivity.this,SLIDEActivity.class);
                    startActivity(intent);
                    finish();
                }
            },TIME);
        }
    }

}