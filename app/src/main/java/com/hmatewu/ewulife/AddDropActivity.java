package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class AddDropActivity extends AppCompatActivity {
 public TextView time1,time2,time3,time4,time5,time6,time7,time8,time9,time10,time11,time12,time13,time14,time15,time16,time17,time18,
         time19,time20,time21,time22,time23;
 TextView c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23;
 TextView d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16,d17,d18,d19,d20,d21,d22,d23;
 TextView des,title;
 Button help,portal;
 String join,update;
    FirebaseAuth firebaseAuth;
 LinearLayout l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23;
    FirebaseFirestore fstore;
    ProgressDialog progressDialog;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drop);
        firebaseAuth = FirebaseAuth.getInstance();


        LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
        View layout1 = inflater1.inflate(R.layout.custom_maintain_tooast,(ViewGroup)findViewById(R.id.maint));
        final Toast toast1 = new Toast(getApplicationContext());
        toast1.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast1.setDuration((Toast.LENGTH_SHORT));
        toast1.setView(layout1);






        {
            time1 = findViewById(R.id.t1);
            time2 = findViewById(R.id.t2);
            time3 = findViewById(R.id.t3);
            time4 = findViewById(R.id.t4);
            time5 = findViewById(R.id.t5);
            time6 = findViewById(R.id.t6);
            time7 = findViewById(R.id.t7);
            time8 = findViewById(R.id.t8);
            time9 = findViewById(R.id.t9);
            time10 = findViewById(R.id.t10);
            time11 = findViewById(R.id.t11);
            time12 = findViewById(R.id.t12);
            time13 = findViewById(R.id.t13);
            time14 = findViewById(R.id.t14);
            time15 = findViewById(R.id.t15);
            time16 = findViewById(R.id.t16);
            time17 = findViewById(R.id.t17);
            time18 = findViewById(R.id.t18);
            time19 = findViewById(R.id.t19);
            time20 = findViewById(R.id.t20);
            time21 = findViewById(R.id.t21);
            time22 = findViewById(R.id.t22);
            time23 = findViewById(R.id.t23);
        }
        {
            c1 = findViewById(R.id.cr1);
            c2 = findViewById(R.id.cr2);
            c3 = findViewById(R.id.cr3);
            c4 = findViewById(R.id.cr4);
            c5 = findViewById(R.id.cr5);
            c6 = findViewById(R.id.cr6);
            c7 = findViewById(R.id.cr7);
            c8 = findViewById(R.id.cr8);
            c9 = findViewById(R.id.cr9);
            c10 = findViewById(R.id.cr10);
            c11 = findViewById(R.id.cr11);
            c12 = findViewById(R.id.cr12);
            c13 = findViewById(R.id.cr13);
            c14 = findViewById(R.id.cr14);
            c15 = findViewById(R.id.cr15);
            c16 = findViewById(R.id.cr16);
            c17 = findViewById(R.id.cr17);
            c18 = findViewById(R.id.cr18);
            c19 = findViewById(R.id.cr19);
            c20 = findViewById(R.id.cr20);
            c21 = findViewById(R.id.cr21);
            c22 = findViewById(R.id.cr22);
            c23 = findViewById(R.id.cr23);
        }
        {
            d1 = findViewById(R.id.date_1);
            d2 = findViewById(R.id.date_2);
            d3 = findViewById(R.id.date_3);
            d4 = findViewById(R.id.date_4);
            d5 = findViewById(R.id.date_5);
            d6 = findViewById(R.id.date_6);
            d7 = findViewById(R.id.date_7);
            d8 = findViewById(R.id.date_8);
            d9 = findViewById(R.id.date_9);
            d10 = findViewById(R.id.date_10);
            d11 = findViewById(R.id.date_11);
            d12 = findViewById(R.id.date_12);
            d13 = findViewById(R.id.date_13);
            d14 = findViewById(R.id.date_14);
            d15 = findViewById(R.id.date_15);
            d16 = findViewById(R.id.date_16);
            d17 = findViewById(R.id.date_17);
            d18 = findViewById(R.id.date_18);
            d19 = findViewById(R.id.date_19);
            d20 = findViewById(R.id.date_20);
            d21 = findViewById(R.id.date21);
            d22 = findViewById(R.id.date22);
            d23 = findViewById(R.id.date23);
        }
        {
            l1 = findViewById(R.id.l_1);
            l2 = findViewById(R.id.l_2);
            l3 = findViewById(R.id.l_3);
            l4 = findViewById(R.id.l_4);
            l5 = findViewById(R.id.l_5);
            l6 = findViewById(R.id.l_6);
            l7 = findViewById(R.id.l_7);
            l8 = findViewById(R.id.l_8);
            l9 = findViewById(R.id.l_9);
            l10 = findViewById(R.id.l_10);
            l11 = findViewById(R.id.l_11);
            l12 = findViewById(R.id.l_12);
            l13 = findViewById(R.id.l_13);
            l14 = findViewById(R.id.l_14);
            l15 = findViewById(R.id.l_15);
            l16 = findViewById(R.id.l_16);
            l17 = findViewById(R.id.l_17);
            l18 = findViewById(R.id.l_18);
            l19 = findViewById(R.id.l_19);
            l20 = findViewById(R.id.l_20);
            l21 = findViewById(R.id.l_21);
            l22 = findViewById(R.id.l_22);
            l23 = findViewById(R.id.l_23);
        }


        des = findViewById(R.id.textView24);
        title = findViewById(R.id.textView20);

        help = findViewById(R.id.button2);
        portal = findViewById(R.id.button3);
        fstore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = fstore.collection("add_drop").document("mjYoVH58IpdAHaNGYpps");
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override

            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                update = documentSnapshot.getString("valid");

                if(update != null){

                }

                if(update == null) {
                    toast1.show();
                    Intent intent = new Intent(AddDropActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            

                title.setText(documentSnapshot.getString("Title"));
                des.setText(documentSnapshot.getString("Descrip"));
                String[] date = new String[100];

               date[1] = documentSnapshot.getString("dt1");
                if(date[1]==null){
                    l1.setVisibility(View.GONE);
                }
                else{
                    d1.setText(documentSnapshot.getString("dt1"));
                }
                date[2] = documentSnapshot.getString("dt2");
                if(date[2]==null){
                    l2.setVisibility(View.GONE);
                }
                else{
                    d2.setText(documentSnapshot.getString("dt2"));
                }
                date[3] = documentSnapshot.getString("dt3");
                if(date[3]==null){
                    l3.setVisibility(View.GONE);
                }
                else{
                    d3.setText(documentSnapshot.getString("dt3"));
                }
                date[4] = documentSnapshot.getString("dt4");
                if(date[4]==null){
                    l4.setVisibility(View.GONE);
                }
                else{
                    d4.setText(documentSnapshot.getString("dt4"));
                }
                date[5] = documentSnapshot.getString("dt5");
                if(date[5]==null){
                    l5.setVisibility(View.GONE);
                }
                else{
                    d5.setText(documentSnapshot.getString("dt5"));
                }
                date[6] = documentSnapshot.getString("dt6");
                if(date[6]==null){
                    l6.setVisibility(View.GONE);
                }
                else{
                    d6.setText(documentSnapshot.getString("dt6"));
                }
                date[7] = documentSnapshot.getString("dt7");
                if(date[7]==null){
                    l7.setVisibility(View.GONE);
                }
                else{
                    d7.setText(documentSnapshot.getString("dt7"));
                }
                date[8] = documentSnapshot.getString("dt8");
                if(date[8]==null){
                    l8.setVisibility(View.GONE);
                }
                else{
                    d8.setText(documentSnapshot.getString("dt8"));
                }
                date[9] = documentSnapshot.getString("dt9");
                if(date[9]==null){
                    l9.setVisibility(View.GONE);
                }
                else{
                    d9.setText(documentSnapshot.getString("dt9"));
                }
                date[10] = documentSnapshot.getString("dt10");
                if(date[10]==null){
                    l10.setVisibility(View.GONE);
                }
                else{
                    d10.setText(documentSnapshot.getString("dt10"));
                }
                date[11] = documentSnapshot.getString("dt11");
                if(date[11]==null){
                    l11.setVisibility(View.GONE);
                }
                else{
                    d11.setText(documentSnapshot.getString("dt11"));
                }
                date[12] = documentSnapshot.getString("dt12");
                if(date[12]==null){
                    l12.setVisibility(View.GONE);
                }
                else{
                    d12.setText(documentSnapshot.getString("dt12"));
                }
                date[13] = documentSnapshot.getString("dt13");
                if(date[13]==null){
                    l13.setVisibility(View.GONE);
                }
                else{
                    d13.setText(documentSnapshot.getString("dt13"));
                }
                date[14] = documentSnapshot.getString("dt14");
                if(date[14]==null){
                    l14.setVisibility(View.GONE);
                }
                else{
                    d14.setText(documentSnapshot.getString("dt14"));
                }
                date[15] = documentSnapshot.getString("dt15");
                if(date[15]==null){
                    l15.setVisibility(View.GONE);
                }
                else{
                    d15.setText(documentSnapshot.getString("dt15"));
                }
                date[16] = documentSnapshot.getString("dt16");
                if(date[16]==null){
                    l16.setVisibility(View.GONE);
                }
                else{
                    d16.setText(documentSnapshot.getString("dt16"));
                }
                date[17] = documentSnapshot.getString("dt17");
                if(date[17]==null){
                    l17.setVisibility(View.GONE);
                }
                else{
                    d17.setText(documentSnapshot.getString("dt17"));
                }
                date[18] = documentSnapshot.getString("dt18");
                if(date[18]==null){
                    l18.setVisibility(View.GONE);
                }
                else{
                    d18.setText(documentSnapshot.getString("dt18"));
                }
                date[19] = documentSnapshot.getString("dt19");
                if(date[19]==null){
                    l19.setVisibility(View.GONE);
                }
                else{
                    d19.setText(documentSnapshot.getString("dt19"));
                }
                date[20] = documentSnapshot.getString("dt20");
                if(date[20]==null){
                    l20.setVisibility(View.GONE);
                }
                else{
                    d20.setText(documentSnapshot.getString("dt20"));
                }
                date[21] = documentSnapshot.getString("dt21");
                if(date[21]==null){
                    l21.setVisibility(View.GONE);
                }
                else{
                    d21.setText(documentSnapshot.getString("dt21"));
                }
                date[22] = documentSnapshot.getString("dt22");
                if(date[22]==null){
                    l22.setVisibility(View.GONE);
                }
                else{
                    d22.setText(documentSnapshot.getString("dt22"));
                }
                date[23] = documentSnapshot.getString("dt23");
                if(date[23]==null){
                    l23.setVisibility(View.GONE);
                }
                else{
                    d23.setText(documentSnapshot.getString("dt23"));
                }

                c1.setText(documentSnapshot.getString("c1"));
                c2.setText(documentSnapshot.getString("c2"));
                c3.setText(documentSnapshot.getString("c3"));
                c4.setText(documentSnapshot.getString("c4"));
                c5.setText(documentSnapshot.getString("c5"));
                c6.setText(documentSnapshot.getString("c6"));
                c7.setText(documentSnapshot.getString("c7"));
                c8.setText(documentSnapshot.getString("c8"));
                c9.setText(documentSnapshot.getString("c9"));
                c10.setText(documentSnapshot.getString("c10"));
                c11.setText(documentSnapshot.getString("c11"));
                c12.setText(documentSnapshot.getString("c12"));
                c13.setText(documentSnapshot.getString("c13"));

                time1.setText(documentSnapshot.getString("t1"));
                time2.setText(documentSnapshot.getString("t2"));
                time3.setText(documentSnapshot.getString("t3"));
                time4.setText(documentSnapshot.getString("t4"));
                time5.setText(documentSnapshot.getString("t5"));
                time6.setText(documentSnapshot.getString("t6"));
                time7.setText(documentSnapshot.getString("t7"));
                time8.setText(documentSnapshot.getString("t8"));
                time9.setText(documentSnapshot.getString("t9"));
                time10.setText(documentSnapshot.getString("t10"));
                time11.setText(documentSnapshot.getString("t11"));
                time12.setText(documentSnapshot.getString("t12"));
                time13.setText(documentSnapshot.getString("t13"));


            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AddDropActivity.this,HelpDeskActivity.class);
                startActivity(intent);
            }
        });

        portal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AddDropActivity.this,PortalActivity.class);
                startActivity(intent);
            }
        });
    }
}