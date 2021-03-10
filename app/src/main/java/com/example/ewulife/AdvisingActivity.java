package com.example.ewulife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class AdvisingActivity extends AppCompatActivity {
    public TextView time1a,time2a,time3a,time4a,time5a,time6a,time7a,time8a,time9a,time10a,time11a,time12a,time13a;
    TextView c1a,c2a,c3a,c4a,c5a,c6a,c7a,c8a,c9a,c10a,c11a,c12a,c13a;
    TextView d1a,d2a,d3a,d4a,d5a,d6a,d7a,d8a,d9a,d10a,d11a,d12a,d13a;
    TextView desa,titlea;
    Button helpa,portala;
    String joina,updatea;
    public FirebaseFirestore fstore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advising);

        time1a = findViewById(R.id.t1a);
        time2a = findViewById(R.id.t2a);
        time3a = findViewById(R.id.t3a);
        time4a = findViewById(R.id.t4a);
        time5a = findViewById(R.id.t5a);
        time6a = findViewById(R.id.t6a);
        time7a = findViewById(R.id.t7a);
        time8a = findViewById(R.id.t8a);
        time9a = findViewById(R.id.t9a);
        time10a = findViewById(R.id.t10a);
        time11a = findViewById(R.id.t11a);
        time12a = findViewById(R.id.t12a);
        time13a = findViewById(R.id.t13a);

        c1a =findViewById(R.id.cr1a);
        c2a =findViewById(R.id.cr2a);
        c3a =findViewById(R.id.cr3a);
        c4a =findViewById(R.id.cr4a);
        c5a =findViewById(R.id.cr5a);
        c6a =findViewById(R.id.cr6a);
        c7a =findViewById(R.id.cr7a);
        c8a =findViewById(R.id.cr8a);
        c9a =findViewById(R.id.cr9a);
        c10a =findViewById(R.id.cr10a);
        c11a =findViewById(R.id.cr11a);
        c12a =findViewById(R.id.cr12a);
        c13a =findViewById(R.id.cr13a);

        d1a = findViewById(R.id.date_1a);
        d2a = findViewById(R.id.date_2a);
        d3a = findViewById(R.id.date_3a);
        d4a  = findViewById(R.id.date_4a);
        d5a  = findViewById(R.id.date_5a);
        d6a = findViewById(R.id.date_6a);
        d7a = findViewById(R.id.date_7a);
        d8a = findViewById(R.id.date_8a);
        d9a = findViewById(R.id.date_9a);
        d10a = findViewById(R.id.date_10a);
        d11a = findViewById(R.id.date11a);
        d12a = findViewById(R.id.date12a);
        d13a = findViewById(R.id.date13a);

        desa = findViewById(R.id.textView24a);
        titlea = findViewById(R.id.textView20a);

        helpa = findViewById(R.id.button2);
        portala = findViewById(R.id.button3);
        fstore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = fstore.collection("advising").document("EcKCQQm0qprtjM6wsM5w ");
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                updatea = documentSnapshot.getString("valid");

                if(updatea != null){
                    Toast.makeText(AdvisingActivity.this, "Advising is updated", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(AdvisingActivity.this, "Advising Will be update on time", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AdvisingActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                titlea.setText(documentSnapshot.getString("Title"));
                desa.setText(documentSnapshot.getString("Descrip"));


                d1a.setText(documentSnapshot.getString("dt1"));
                d2a.setText(documentSnapshot.getString("dt2"));
                d3a.setText(documentSnapshot.getString("dt3"));
                d4a.setText(documentSnapshot.getString("dt4"));
                d5a.setText(documentSnapshot.getString("dt5"));
                d6a.setText(documentSnapshot.getString("dt6"));
                d7a.setText(documentSnapshot.getString("dt7"));
                d8a.setText(documentSnapshot.getString("dt8"));
                d9a.setText(documentSnapshot.getString("dt9"));
                d10a.setText(documentSnapshot.getString("dt10"));
                d11a.setText(documentSnapshot.getString("dt11"));
                d12a.setText(documentSnapshot.getString("dt12"));
                d13a.setText(documentSnapshot.getString("dt13"));

                c1a.setText(documentSnapshot.getString("c1"));
                c2a.setText(documentSnapshot.getString("c2"));
                c3a.setText(documentSnapshot.getString("c3"));
                c4a.setText(documentSnapshot.getString("c4"));
                c5a.setText(documentSnapshot.getString("c5"));
                c6a.setText(documentSnapshot.getString("c6"));
                c7a.setText(documentSnapshot.getString("c7"));
                c8a.setText(documentSnapshot.getString("c8"));
                c9a.setText(documentSnapshot.getString("c9"));
                c10a.setText(documentSnapshot.getString("c10"));
                c11a.setText(documentSnapshot.getString("c11"));
                c12a.setText(documentSnapshot.getString("c12"));
                c13a.setText(documentSnapshot.getString("c13"));

                time1a.setText(documentSnapshot.getString("t1"));
                time2a.setText(documentSnapshot.getString("t2"));
                time3a.setText(documentSnapshot.getString("t3"));
                time4a.setText(documentSnapshot.getString("t4"));
                time5a.setText(documentSnapshot.getString("t5"));
                time6a.setText(documentSnapshot.getString("t6"));
                time7a.setText(documentSnapshot.getString("t7"));
                time8a.setText(documentSnapshot.getString("t8"));
                time9a.setText(documentSnapshot.getString("t9"));
                time10a.setText(documentSnapshot.getString("t10"));
                time11a.setText(documentSnapshot.getString("t11"));
                time12a.setText(documentSnapshot.getString("t12"));
                time13a.setText(documentSnapshot.getString("t13"));


            }
        });

        helpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AdvisingActivity.this,HelpDeskActivity.class);
                startActivity(intent);
            }
        });

        portala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AdvisingActivity.this,PortalActivity.class);
                startActivity(intent);
            }
        });
    }
}