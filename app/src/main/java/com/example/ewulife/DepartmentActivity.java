package com.example.ewulife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class DepartmentActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView aCardView,bCardView,
            cCardView,dCardView,eCardView,fCardView,
            gCardView,hCardView,iCardView,jicardView,kCardView,lCardView,
            mCardView,nCardView , oCardView , pCardView , qardView , rCardView ,
            aboutCardView, classscCardView ,othersCardView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        aCardView = findViewById(R.id.BBA);
        bCardView = findViewById(R.id.eco);
        cCardView = findViewById(R.id.eng);
        dCardView = findViewById(R.id.llb);
        eCardView = findViewById(R.id.soc);
        fCardView = findViewById(R.id.islm);
        gCardView = findViewById(R.id.mps);
        hCardView = findViewById(R.id.cse);
        iCardView = findViewById(R.id.ece);
        jicardView = findViewById(R.id.geb);
        kCardView = findViewById(R.id.pharma);
        lCardView = findViewById(R.id.civil);
        mCardView = findViewById(R.id.sr);
        oCardView = findViewById(R.id.eee);
        nCardView = findViewById(R.id.mba);


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

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.BBA){
            Intent intent =new Intent(DepartmentActivity.this,BBAActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.eco){
            Intent intent =new Intent(DepartmentActivity.this,ECOActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.eng){
            Intent intent =new Intent(DepartmentActivity.this,ENGActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.llb){
            Intent intent =new Intent(DepartmentActivity.this,LLBActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.soc){
            Intent intent =new Intent(DepartmentActivity.this,SOCActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.islm){
            Intent intent =new Intent(DepartmentActivity.this,ISLMActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.mps){
            Intent intent =new Intent(DepartmentActivity.this,MPSActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.cse){
            Intent intent =new Intent(DepartmentActivity.this,CSEActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.ece){
            Intent intent =new Intent(DepartmentActivity.this,ECEActivity.class);
            startActivity(intent);
        }   if(v.getId()==R.id.geb){
            Intent intent =new Intent(DepartmentActivity.this,GEBActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.pharma){
            Intent intent =new Intent(DepartmentActivity.this,PHARMAActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.civil){
            Intent intent =new Intent(DepartmentActivity.this,CivilActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.sr){
            Intent intent =new Intent(DepartmentActivity.this,SRActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.eee){
            Intent intent =new Intent(DepartmentActivity.this,EEEActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.mba){
            Intent intent =new Intent(DepartmentActivity.this,MBAActivity.class);
            startActivity(intent);
        }
    }
}