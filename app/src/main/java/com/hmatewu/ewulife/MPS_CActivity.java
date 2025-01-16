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

public class MPS_CActivity extends AppCompatActivity {
    WebView webView;
    String load_url;
    FirebaseFirestore fstore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_p_s__c);
        webView=findViewById(R.id.web_mps_c);


        fstore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = fstore.collection("course_list").document("ZK5EYrNbRA37mRcWs4so");
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                load_url = documentSnapshot.getString("mps");

                if(load_url != null){
                    Toast.makeText(MPS_CActivity.this, "updated", Toast.LENGTH_SHORT).show();
                    WebSettings webSettings = webView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    webView.setWebViewClient(new WebViewClient());
                    webView.loadUrl(load_url);
                }
                else{
                    Toast.makeText(MPS_CActivity.this, "DataBase in Maintainace", Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(MPS_CActivity.this,CourseChartActivity.class);
                    startActivity(intent);

                }

            }
        });
    }
}