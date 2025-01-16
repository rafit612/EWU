package com.hmatewu.ewulife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import javax.annotation.Nullable;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserProfileActivity extends AppCompatActivity {
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    FirebaseUser user;
    String userID,full,mob;
    StorageReference storageReference;
    CircleImageView profile_pic,edit_pic;
    ImageView history;
    TextView name,age,blood,mobile,depar,CGPA,Credit,semister;

    Button logout, change_photo,edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        storageReference= FirebaseStorage.getInstance().getReference();

        userID = fAuth.getCurrentUser().getUid();
        user=fAuth.getCurrentUser();
        profile_pic=findViewById(R.id.profile_image1299);

        name=findViewById(R.id.textView511);

        mobile=findViewById(R.id.textView12999);
        CGPA = findViewById(R.id.textView4399);
        depar = findViewById(R.id.textView39);
        Credit=findViewById(R.id.textView4499);
        semister=findViewById(R.id.textView4599);
        change_photo=findViewById(R.id.button1099);
        logout = findViewById(R.id.button999);
        edit = findViewById(R.id.button1199);



        DocumentReference documentReference = fstore.collection("EWU_student").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                name.setText(documentSnapshot.getString("Name"));

                depar.setText(documentSnapshot.getString("Program"));
                semister.setText(documentSnapshot.getString("Semister"));
                Credit.setText(documentSnapshot.getString("Credit"));
                CGPA.setText(documentSnapshot.getString("CGPA"));
                mobile.setText(documentSnapshot.getString("EWU_ID"));

            }
        });
        StorageReference profRef = storageReference.child("ewuuser/"+userID+"profile.jpg");
        profRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profile_pic);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this,UserRegistrationInfoActivity.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(UserProfileActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        change_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open gallery
                Intent openGalery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGalery, 1000);


            }
        });
      //  String shareFact = name.getText().toString();
      //  Toast.makeText(UserProfileActivity.this, " " +shareFact,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @androidx.annotation.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {
                Uri imageuri = data.getData();
                profile_pic.setImageURI(imageuri);
                // edit_pic.setImageURI(imageuri);


                uploadImageToFirebase(imageuri);

            }
        }
    }

    private void uploadImageToFirebase(Uri imageUri) {
        //upload
        final StorageReference fileRef =  storageReference.child("ewuuser/"+userID+"profile.jpg");
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).into(profile_pic);
                        // Picasso.get().load(uri).into(edit_pic);



                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UserProfileActivity.this, "File is not Uploaded"+e, Toast.LENGTH_SHORT).show();

            }
        });
    }
}