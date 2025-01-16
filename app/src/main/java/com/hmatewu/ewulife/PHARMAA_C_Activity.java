package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class PHARMAA_C_Activity extends AppCompatActivity {
    WebView webView;
    String load_url;
    FirebaseFirestore fstore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_h_a_r_m_a_a__c_);
        webView=findViewById(R.id.web_phar_c);


        fstore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = fstore.collection("course_list").document("ZK5EYrNbRA37mRcWs4so");
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                load_url = documentSnapshot.getString("pharma");

                if(load_url != null){
                    Toast.makeText(PHARMAA_C_Activity.this, "updated", Toast.LENGTH_SHORT).show();
                    WebSettings webSettings = webView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    webView.setWebViewClient(new WebViewClient());
                    webView.loadUrl(load_url);
                }
                else{
                    Toast.makeText(PHARMAA_C_Activity.this, "DataBase in Maintainace", Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(PHARMAA_C_Activity.this,CourseChartActivity.class);
                    startActivity(intent);

                }

            }
        });
    }
}