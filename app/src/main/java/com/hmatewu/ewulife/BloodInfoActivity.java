package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import javax.annotation.Nullable;

import de.hdodenhof.circleimageview.CircleImageView;

public class BloodInfoActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_NFID= "com.hm.roktojoddha.EXTRA_NFID";
    public static final String EXTRA_MOBILE= "com.hm.roktojoddha.EXTRA_MOBILE";
    public static final String EXTRA_ID= "com.hm.roktojoddha.EXTRA_ID";

    FirebaseFirestore fstore;


    String userID;
    StorageReference storageReference;
    CircleImageView profile_pic;
    String mobile;
    String nfid,uploader_id,uploader_mobile;

    TextView PNtv,agetv,BGtv,Gendertv,covidtv,divisiontv,districttv,zonetv,verifytv,hospitaltv,locationtv,dieasetv,relationtv,need_quantitytv,notetv,datetv,timetv;
    Button call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_info);
        Intent intent = getIntent();
        nfid=intent.getStringExtra(FeedFragment.EXTRA_NFID);
        mobile=intent.getStringExtra(FeedFragment.EXTRA_MOBILE);
        userID=intent.getStringExtra(FeedFragment.EXTRA_ID);

        fstore = FirebaseFirestore.getInstance();
        storageReference= FirebaseStorage.getInstance().getReference();



        PNtv=findViewById(R.id.text7);
        agetv=findViewById(R.id.text11);
        BGtv=findViewById(R.id.text15);
        Gendertv=findViewById(R.id.text17);
        covidtv=findViewById(R.id.text51);
        divisiontv=findViewById(R.id.text95);
        districttv=findViewById(R.id.text98);
        zonetv=findViewById(R.id.textView100);

        hospitaltv=findViewById(R.id.textView104);
        locationtv=findViewById(R.id.textView106);
        dieasetv=findViewById(R.id.textView108);
        relationtv=findViewById(R.id.textView110);
        need_quantitytv=findViewById(R.id.textView112);

        notetv=findViewById(R.id.textView116);
        timetv=findViewById(R.id.textView120);
        datetv=findViewById(R.id.textView118);
        call=findViewById(R.id.but2);

        profile_pic=findViewById(R.id.NFD);


        call.setOnClickListener(this);

        StorageReference profRef = storageReference.child("ewuuser/"+userID+"profile.jpg");
        profRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profile_pic);
                //Picasso.get().load(uri).into(edit_pic);



            }
        });
        DocumentReference documentReference = fstore.collection("Blood_Detail").document(userID).collection("History").document(nfid);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                assert documentSnapshot != null;
                PNtv.setText(documentSnapshot.getString("Patient_Name"));
                agetv.setText(documentSnapshot.getString("Age"));
                BGtv.setText(documentSnapshot.getString("Blood_group"));
                Gendertv.setText(documentSnapshot.getString("Gender"));
                covidtv.setText(documentSnapshot.getString("Covid"));
                divisiontv.setText(documentSnapshot.getString("Division"));
                districttv.setText(documentSnapshot.getString("District"));
                zonetv.setText(documentSnapshot.getString("Area"));
                hospitaltv.setText(documentSnapshot.getString("Hospital_Blood_Bank"));
                locationtv.setText(documentSnapshot.getString("Location"));
                dieasetv.setText(documentSnapshot.getString("Blood_Patient_Problem"));
                relationtv.setText(documentSnapshot.getString("Gender"));
                need_quantitytv.setText(documentSnapshot.getString("Blood_Quantity"));
                notetv.setText(documentSnapshot.getString("Reason"));
                datetv.setText(documentSnapshot.getString("Blood_Giving_Date"));
                timetv.setText(documentSnapshot.getString("Blood_Giving_Time"));

            }
        });



    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.but2) {

            //Toast.makeText(BloodInfoActivity.this, " " + uploader_mobile, Toast.LENGTH_LONG).show();
            String mobCall2 = "tel:" + mobile.trim();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(mobCall2));
            startActivity(intent);
        }
    }

}