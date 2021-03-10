package com.example.ewulife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CourseChartActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView aCardView,bCardView,
            cCardView,dCardView,eCardView,fCardView,
            gCardView,hCardView,iCardView,jicardView,kCardView,lCardView,
            mCardView,nCardView , oCardView , pCardView , qardView , rCardView ,
            aboutCardView, sCardView ,othersCardView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_chart);
        aCardView = findViewById(R.id.BBAc);
        bCardView = findViewById(R.id.ecoc);
        cCardView = findViewById(R.id.engc);
        dCardView = findViewById(R.id.llbc);
        eCardView = findViewById(R.id.socc);
        fCardView = findViewById(R.id.islmc);
        gCardView = findViewById(R.id.mpsc);
        hCardView = findViewById(R.id.csec);
        iCardView = findViewById(R.id.ecec);
        jicardView = findViewById(R.id.gebc);
        kCardView = findViewById(R.id.pharmac);
        lCardView = findViewById(R.id.civilc);
        mCardView = findViewById(R.id.src);
        oCardView = findViewById(R.id.eeec);
        nCardView = findViewById(R.id.mbac);
        pCardView = findViewById(R.id.ap_c);
        qardView = findViewById(R.id.ics_c);

        sCardView = findViewById(R.id.ete);


        aCardView.setOnClickListener(this);
        bCardView.setOnClickListener(this);
        cCardView.setOnClickListener(this);
        dCardView.setOnClickListener(this);
        eCardView.setOnClickListener(this);
        fCardView.setOnClickListener(this);
        gCardView.setOnClickListener(this);
        hCardView.setOnClickListener(this);
        iCardView.setOnClickListener(this);
        jicardView.setOnClickListener(this);
        kCardView.setOnClickListener(this);
        lCardView.setOnClickListener(this);
        mCardView.setOnClickListener(this);
        nCardView.setOnClickListener(this);
        oCardView.setOnClickListener(this);
        pCardView.setOnClickListener(this);
        qardView.setOnClickListener(this);

        sCardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.BBAc){
            Intent intent =new Intent(CourseChartActivity.this,BBA_CActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.ecoc){
            Intent intent =new Intent(CourseChartActivity.this,ECO_CActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.engc){
            Intent intent =new Intent(CourseChartActivity.this,ENG_CActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.llbc){
            Intent intent =new Intent(CourseChartActivity.this,LLB_CActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.socc){
            Intent intent =new Intent(CourseChartActivity.this,SOC_CActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.islmc){
            Intent intent =new Intent(CourseChartActivity.this,ISLM_CActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.mpsc){
            Intent intent =new Intent(CourseChartActivity.this,MPS_CActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.csec){
            Intent intent =new Intent(CourseChartActivity.this,CSE_CActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.ecec){
            Intent intent =new Intent(CourseChartActivity.this,ECE_CActivity.class);
            startActivity(intent);
        }   if(v.getId()==R.id.gebc){
            Intent intent =new Intent(CourseChartActivity.this,GEB_CActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.pharmac){
            Intent intent =new Intent(CourseChartActivity.this,PHARMAA_C_Activity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.civilc){
            Intent intent =new Intent(CourseChartActivity.this,Civil_CActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.src){
            Intent intent =new Intent(CourseChartActivity.this,SR_CActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.eeec){
            Intent intent =new Intent(CourseChartActivity.this,EEEActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.mbac){
            Intent intent =new Intent(CourseChartActivity.this,MPS_CActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.ap_c){
            Intent intent =new Intent(CourseChartActivity.this,AS_CActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.ics_c){
            Intent intent =new Intent(CourseChartActivity.this,ICS_CActivity.class);
            startActivity(intent);
        }

        if(v.getId()==R.id.ete){
            Intent intent =new Intent(CourseChartActivity.this,ETE_CActivity.class);
            startActivity(intent);
        }
    }
}