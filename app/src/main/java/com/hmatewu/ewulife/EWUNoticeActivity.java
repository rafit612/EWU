package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class EWUNoticeActivity extends AppCompatActivity {
    public static final String EXTRA_NFID= "com.hm.roktojoddha.EXTRA_NFID";
    public static final String EXTRA_MOBILE= "com.hm.roktojoddha.EXTRA_MOBILE";
    public static final String EXTRA_ID= "com.hm.roktojoddha.EXTRA_ID";
    public static final String EXTRA_CLUB= "com.hm.roktojoddha.EXTRA_CLUB";
    public static final String EXTRA_CLUB_FORM= "com.hm.roktojoddha.EXTRA_CLUB_FORM";
    FirebaseFirestore fstore;
    FirebaseAuth fAuth;
    TextView t1,t2;
    String nfid2,userID2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_w_u_notice);
        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        Intent intent = getIntent();
        nfid2=intent.getStringExtra(FeedFragment.EXTRA_NFID);

        userID2=intent.getStringExtra(FeedFragment.EXTRA_ID);

        DocumentReference documentReference = fstore.collection("Notice_Detail").document(userID2).collection("History").document(nfid2);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                t1.setText(documentSnapshot.getString("Club"));
               t2.setText(documentSnapshot.getString("Title"));


            }
        });
    }
}