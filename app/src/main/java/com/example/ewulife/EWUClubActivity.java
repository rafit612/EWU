package com.example.ewulife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class EWUClubActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView aCardView,bCardView,
    cCardView,dCardView,eCardView,fCardView,
   gCardView,hCardView,iCardView,jicardView,kCardView,lCardView,
           mCardView,nCardView , oCardView , pCardView , qardView , rCardView ,
    aboutCardView, classscCardView ,othersCardView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_w_u_club);
        aCardView = findViewById(R.id.a);
        bCardView = findViewById(R.id.b);
        cCardView = findViewById(R.id.c);
        dCardView = findViewById(R.id.d);
        eCardView = findViewById(R.id.e);
        fCardView = findViewById(R.id.f);
        gCardView = findViewById(R.id.g);
        hCardView = findViewById(R.id.h);
        iCardView = findViewById(R.id.i);
        jicardView = findViewById(R.id.ji);
        kCardView = findViewById(R.id.k);
        lCardView = findViewById(R.id.l);
        mCardView = findViewById(R.id.m);
        oCardView = findViewById(R.id.o);
        nCardView = findViewById(R.id.n);
        pCardView = findViewById(R.id.p);
        qardView = findViewById(R.id.q);
        rCardView = findViewById(R.id.j);

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
        rCardView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.a){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/103160894764904"));
            startActivity(intent);
        }
        if(v.getId()==R.id.b){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1469755913307760"));
            startActivity(intent);
        }
        if(v.getId()==R.id.c){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/393648010662437"));
            startActivity(intent);   //https://www.facebook.com/EWU.ECPA
        }
        if(v.getId()==R.id.d){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/459252267511756"));
            startActivity(intent);       //https://www.facebook.com/EWUBC
        }
        if(v.getId()==R.id.e){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/107198719615400"));
            startActivity(intent);      //https://www.facebook.com/ewudc
        }
        if(v.getId()==R.id.f){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/231219780618950"));
            startActivity(intent);   //https://www.facebook.com/ewueconomicsclub
        }
        if(v.getId()==R.id.g){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1509435916025800"));
            startActivity(intent);   //https://www.facebook.com/ewuRoboticsClub
        }
        if(v.getId()==R.id.h){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/212265778807446"));
            startActivity(intent);  //https://www.facebook.com/EWUECC/
        }
        if(v.getId()==R.id.i){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/610714095616773"));
            startActivity(intent);     //https://www.facebook.com/ewuesc/
        }   if(v.getId()==R.id.j){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1231454686889509"));
            startActivity(intent);  //https://www.facebook.com/EWUIFC.BD
        }
          if(v.getId()==R.id.ji){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/121097061329915"));
            startActivity(intent); //https://www.facebook.com/ewuieee
        }
        if(v.getId()==R.id.k){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/399745436887279"));
            startActivity(intent);  //https://www.facebook.com/ewumunc/
        }
        if(v.getId()==R.id.l){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/647849551969351"));
            startActivity(intent);  //https://www.facebook.com/ewupc.bd/
        }
        if(v.getId()==R.id.m){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1613863388934073"));
            startActivity(intent);  //https://www.facebook.com/rotaractsofewu
        }
        if(v.getId()==R.id.n){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/122654974478172"));
            startActivity(intent);      //https://www.facebook.com/ewusc04/
        }
        if(v.getId()==R.id.o){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/249743269016805"));
            startActivity(intent);        //https://www.facebook.com/scewu/
        }
        if(v.getId()==R.id.p){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/300557563333714"));
            startActivity(intent);     //https://www.facebook.com/EWUSC.EWU/
        }
        if(v.getId()==R.id.q){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/264136207008070"));
            startActivity(intent);        //https://www.facebook.com/EWUTC/
        }


    }
}