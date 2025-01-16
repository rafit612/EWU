package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FundActivity extends AppCompatActivity {

    TextView txt1,txt2,txt3,txt4;
    TextView txt5,txt6,txt7,txt8;
    ImageView img1,img2,img3,img4,img5;
    LinearLayout table1,table2,table3,table4,table5;
    CardView cardView;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund);
        txt1=findViewById(R.id.textView6);
        txt2=findViewById(R.id.ts);
        txt3=findViewById(R.id.fs);
        txt4=findViewById(R.id.ewu_emp);
        txt5=findViewById(R.id.medha);
        img1 =findViewById(R.id.imageView);
        img2 =findViewById(R.id.imageView2);
        img3 =findViewById(R.id.imageView3);
        img4 =findViewById(R.id.imageView4);
        img5 =findViewById(R.id.imageView5);

        cardView = findViewById(R.id.fundlist2);
        table1 = findViewById(R.id.tb1);
        table2 = findViewById(R.id.tb2);
        table3 = findViewById(R.id.tb3);
        table4 = findViewById(R.id.tb4);
        table5 = findViewById(R.id.tb5);
        button1 = findViewById(R.id.button);

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_internet_toast,(ViewGroup)findViewById(R.id.failView2));

        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setDuration((Toast.LENGTH_SHORT));
        toast.setView(layout);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((table2.getVisibility()==View.VISIBLE)||(table3.getVisibility()==View.VISIBLE)||
                (table4.getVisibility()==View.VISIBLE)||(table5.getVisibility()==View.VISIBLE)) {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table2.setVisibility(View.GONE);
                    img2.setBackgroundResource(R.drawable.expand);
                    table3.setVisibility(View.GONE);
                    img3.setBackgroundResource(R.drawable.expand);
                    table5.setVisibility(View.GONE);
                    img5.setBackgroundResource(R.drawable.expand);
                    table4.setVisibility(View.GONE);
                    img4.setBackgroundResource(R.drawable.expand);
                }
                if (table1.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table1.setVisibility(View.VISIBLE);
                    img1.setBackgroundResource(R.drawable.collapse);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table1.setVisibility(View.GONE);
                    img1.setBackgroundResource(R.drawable.expand);
                }
            }
        });
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((table2.getVisibility()==View.VISIBLE)||(table3.getVisibility()==View.VISIBLE)||
                        (table4.getVisibility()==View.VISIBLE)||(table5.getVisibility()==View.VISIBLE)) {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table2.setVisibility(View.GONE);
                    img2.setBackgroundResource(R.drawable.expand);
                    table3.setVisibility(View.GONE);
                    img3.setBackgroundResource(R.drawable.expand);
                    table5.setVisibility(View.GONE);
                    img5.setBackgroundResource(R.drawable.expand);
                    table4.setVisibility(View.GONE);
                    img4.setBackgroundResource(R.drawable.expand);
                }
                if (table1.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table1.setVisibility(View.VISIBLE);
                    img1.setBackgroundResource(R.drawable.collapse);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table1.setVisibility(View.GONE);
                    img1.setBackgroundResource(R.drawable.expand);
                }
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((table1.getVisibility()==View.VISIBLE)||(table3.getVisibility()==View.VISIBLE)||
                        (table4.getVisibility()==View.VISIBLE)||(table5.getVisibility()==View.VISIBLE)) {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table1.setVisibility(View.GONE);
                    img1.setBackgroundResource(R.drawable.expand);
                    table3.setVisibility(View.GONE);
                    img3.setBackgroundResource(R.drawable.expand);
                    table5.setVisibility(View.GONE);
                    img5.setBackgroundResource(R.drawable.expand);
                    table4.setVisibility(View.GONE);
                    img4.setBackgroundResource(R.drawable.expand);
                }
                if (table2.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table2.setVisibility(View.VISIBLE);
                    img2.setBackgroundResource(R.drawable.collapse);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table2.setVisibility(View.GONE);
                    img2.setBackgroundResource(R.drawable.expand);
                }
            }
        });
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((table1.getVisibility()==View.VISIBLE)||(table3.getVisibility()==View.VISIBLE)||
                        (table4.getVisibility()==View.VISIBLE)||(table5.getVisibility()==View.VISIBLE)) {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table1.setVisibility(View.GONE);
                    img1.setBackgroundResource(R.drawable.expand);
                    table3.setVisibility(View.GONE);
                    img3.setBackgroundResource(R.drawable.expand);
                    table4.setVisibility(View.GONE);
                    img4.setBackgroundResource(R.drawable.expand);
                    table5.setVisibility(View.GONE);
                    img5.setBackgroundResource(R.drawable.expand);

                }
                if (table2.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table2.setVisibility(View.VISIBLE);
                    img2.setBackgroundResource(R.drawable.collapse);
                }


                else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table2.setVisibility(View.GONE);
                    img2.setBackgroundResource(R.drawable.expand);
                }
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((table1.getVisibility()==View.VISIBLE)||(table2.getVisibility()==View.VISIBLE)||
                        (table4.getVisibility()==View.VISIBLE)||(table5.getVisibility()==View.VISIBLE)) {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table1.setVisibility(View.GONE);
                    img1.setBackgroundResource(R.drawable.expand);
                    table2.setVisibility(View.GONE);
                    img2.setBackgroundResource(R.drawable.expand);
                    table4.setVisibility(View.GONE);
                    img4.setBackgroundResource(R.drawable.expand);
                    table5.setVisibility(View.GONE);
                    img5.setBackgroundResource(R.drawable.expand);
                }
                if (table3.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table3.setVisibility(View.VISIBLE);
                    img3.setBackgroundResource(R.drawable.collapse);
                }


                else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table3.setVisibility(View.GONE);
                    img3.setBackgroundResource(R.drawable.expand);
                }
            }
        });
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((table1.getVisibility()==View.VISIBLE)||(table2.getVisibility()==View.VISIBLE)||
                        (table4.getVisibility()==View.VISIBLE)||(table5.getVisibility()==View.VISIBLE)) {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table1.setVisibility(View.GONE);
                    img1.setBackgroundResource(R.drawable.expand);
                    table2.setVisibility(View.GONE);
                    img2.setBackgroundResource(R.drawable.expand);
                    table4.setVisibility(View.GONE);
                    img4.setBackgroundResource(R.drawable.expand);
                    table5.setVisibility(View.GONE);
                    img5.setBackgroundResource(R.drawable.expand);
                }
                if (table3.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table3.setVisibility(View.VISIBLE);
                    img3.setBackgroundResource(R.drawable.collapse);
                }


                else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table3.setVisibility(View.GONE);
                    img3.setBackgroundResource(R.drawable.expand);
                }
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((table1.getVisibility()==View.VISIBLE)||(table2.getVisibility()==View.VISIBLE)||
                        (table3.getVisibility()==View.VISIBLE)||(table5.getVisibility()==View.VISIBLE)) {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table1.setVisibility(View.GONE);
                    img1.setBackgroundResource(R.drawable.expand);
                    table2.setVisibility(View.GONE);
                    img2.setBackgroundResource(R.drawable.expand);
                    table3.setVisibility(View.GONE);
                    img3.setBackgroundResource(R.drawable.expand);
                    table5.setVisibility(View.GONE);
                    img5.setBackgroundResource(R.drawable.expand);
                }
                if (table4.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table4.setVisibility(View.VISIBLE);
                    img4.setBackgroundResource(R.drawable.collapse);
                }


                else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table4.setVisibility(View.GONE);
                    img4.setBackgroundResource(R.drawable.expand);
                }
            }
        });
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((table1.getVisibility()==View.VISIBLE)||(table2.getVisibility()==View.VISIBLE)||
                        (table3.getVisibility()==View.VISIBLE)||(table5.getVisibility()==View.VISIBLE)) {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table1.setVisibility(View.GONE);
                    img1.setBackgroundResource(R.drawable.expand);
                    table2.setVisibility(View.GONE);
                    img2.setBackgroundResource(R.drawable.expand);
                    table3.setVisibility(View.GONE);
                    img3.setBackgroundResource(R.drawable.expand);
                    table5.setVisibility(View.GONE);
                    img5.setBackgroundResource(R.drawable.expand);
                }
                if (table4.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table4.setVisibility(View.VISIBLE);
                    img4.setBackgroundResource(R.drawable.collapse);
                }


                else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table4.setVisibility(View.GONE);
                    img4.setBackgroundResource(R.drawable.expand);
                }
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((table1.getVisibility()==View.VISIBLE)||(table2.getVisibility()==View.VISIBLE)||
                        (table3.getVisibility()==View.VISIBLE)||(table4.getVisibility()==View.VISIBLE)) {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table1.setVisibility(View.GONE);
                    img1.setBackgroundResource(R.drawable.expand);
                    table2.setVisibility(View.GONE);
                    img2.setBackgroundResource(R.drawable.expand);
                    table3.setVisibility(View.GONE);
                    img3.setBackgroundResource(R.drawable.expand);
                    table4.setVisibility(View.GONE);
                    img4.setBackgroundResource(R.drawable.expand);
                }
                if (table5.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table5.setVisibility(View.VISIBLE);
                    img5.setBackgroundResource(R.drawable.collapse);
                }


                else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table5.setVisibility(View.GONE);
                    img5.setBackgroundResource(R.drawable.expand);
                }
            }
        });
        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((table1.getVisibility()==View.VISIBLE)||(table2.getVisibility()==View.VISIBLE)||
                        (table3.getVisibility()==View.VISIBLE)||(table4.getVisibility()==View.VISIBLE)) {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table1.setVisibility(View.GONE);
                    img1.setBackgroundResource(R.drawable.expand);
                    table2.setVisibility(View.GONE);
                    img2.setBackgroundResource(R.drawable.expand);
                    table3.setVisibility(View.GONE);
                    img3.setBackgroundResource(R.drawable.expand);
                    table4.setVisibility(View.GONE);
                    img4.setBackgroundResource(R.drawable.expand);
                }
                if (table5.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table5.setVisibility(View.VISIBLE);
                    img5.setBackgroundResource(R.drawable.collapse);
                }


                else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    table5.setVisibility(View.GONE);
                    img5.setBackgroundResource(R.drawable.expand);
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ewubd.edu/forms-and-document"));
                startActivity(intent);
            }
        });
    }
}