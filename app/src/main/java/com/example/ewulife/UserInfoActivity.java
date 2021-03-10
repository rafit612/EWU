package com.example.ewulife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserInfoActivity extends AppCompatActivity implements View.OnClickListener {
    Button next;

    Spinner bloodgroup;
    RadioGroup radioGroup;
    RadioButton gender;
    ArrayList<String> arrayList_blood;
    ArrayAdapter<String> rr_blood;
    EditText fullname,Mobile,credit,semister,cgpa;
    String Fullname, Blood, Gender;
    ImageView condition, upload;
    CircleImageView profile_image;
    StorageReference storageReference;

    FirebaseFirestore fstore;
    FirebaseAuth fAuth;
    FirebaseUser user;
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        storageReference = FirebaseStorage.getInstance().getReference();
        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        bloodgroup = findViewById(R.id.spinner00);

        fullname = findViewById(R.id.editTextTextPersonName00);

        Mobile =findViewById(R.id.editTextTextPersonName200);

        next = findViewById(R.id.button1300);

        upload = findViewById(R.id.imageView1600);
        profile_image = findViewById(R.id.profile_image300);
        credit = findViewById(R.id.editTextNumber);
        semister = findViewById(R.id.editTextNumberDecimal);
        cgpa = findViewById(R.id.editTextNumberDecimal2);
        profile_image.setOnClickListener(this);
        upload.setOnClickListener(this);

        next.setOnClickListener(this);
        userID = fAuth.getCurrentUser().getUid();


        {
            radioGroup = findViewById(R.id.gender00);
            arrayList_blood = new ArrayList<>();
            arrayList_blood.add("Select");
            arrayList_blood.add("BBA");
            arrayList_blood.add("BSS in Economics");
            arrayList_blood.add("BA in English");
            arrayList_blood.add("LL.B (Hon’s)");
            arrayList_blood.add("BSS in Sociology");
            arrayList_blood.add("BSS in ISLM");
            arrayList_blood.add("BS in Applied Statistics");
            arrayList_blood.add("B.Sc. in ETE");
            arrayList_blood.add("B.Sc. in ICE");
            arrayList_blood.add("B.Sc. in CSE");
            arrayList_blood.add("B.Sc. in EEE");
            arrayList_blood.add("B.Pharm.");
            arrayList_blood.add("B.Sc. in GEB");
            arrayList_blood.add("B.Sc. in Civil Engineering");
            arrayList_blood.add("B.Sc. in ECE");

            arrayList_blood.add("Select");
            arrayList_blood.add("MBA");
            arrayList_blood.add("EMBA");
            arrayList_blood.add("MDS");
            arrayList_blood.add("MSS in Economics");
            arrayList_blood.add("MA in English");
            arrayList_blood.add("MA in ELT");
            arrayList_blood.add("LL.M");
            arrayList_blood.add("MPRHGD");
            arrayList_blood.add("PPDM");
            arrayList_blood.add("MS in Applied Statistics");
            arrayList_blood.add("MS in TE");
            arrayList_blood.add("MS in CSE");
            arrayList_blood.add("MS in APE");
            arrayList_blood.add("M. Pharm");

        }
        rr_blood = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_blood);
        bloodgroup.setAdapter(rr_blood);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        gender = findViewById(selectedId);

        StorageReference profRef = storageReference.child("ewuuser/"+userID+"profile.jpg");
        profRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profile_image);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @androidx.annotation.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {
                Uri imageuri = data.getData();

                profile_image.setImageURI(imageuri);
                //back_pic.setImageURI(imageuri);

                uploadImageToFirebase(imageuri);

            }
        }
    }

    private void uploadImageToFirebase(Uri imageUri) {
        //upload
        final StorageReference fileRef = storageReference.child("ewuuser/" + userID + "profile.jpg");
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).into(profile_image);
                        //Picasso.get().load(uri).into(back_pic);

                        //progressBar_prof.setVisibility(View.GONE);
                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@androidx.annotation.NonNull Exception e) {
                Toast.makeText(UserInfoActivity.this, "File is not Uploaded" + e, Toast.LENGTH_SHORT).show();
                //progressBar_prof.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.imageView1600) {
            Intent openGalery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(openGalery, 1000);

        }
        if (v.getId() == R.id.button1300) {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            gender = findViewById(selectedId);
            final String name = fullname.getText().toString();
            final String number = Mobile.getText().toString();
            if (name.isEmpty()) {
                fullname.setError("Name Required");
                return;
            }

            if (gender == null) {

                Toast.makeText(UserInfoActivity.this, "Selected Gender", Toast.LENGTH_SHORT).show();
                return;
            }
            String blood_group = bloodgroup.getSelectedItem().toString();
            if (blood_group.equals("Select")) {
                Toast.makeText(UserInfoActivity.this, "Selected Department", Toast.LENGTH_SHORT).show();
                return;
            }
            String gen = gender.getText().toString();
            final String cre = credit.getText().toString();
            if(cre.isEmpty()){
                double cre2=0;
            }
            else{
                double cre2 = Double.parseDouble(cre);
                if(cre2>200){
                    credit.setError("Enter Valid CGPA");
                    Toast.makeText(UserInfoActivity.this, "Enter Valid Credit or leave it blank if you are new", Toast.LENGTH_SHORT).show();
                    return;
                }
            }


            final String semi = semister.getText().toString();
            if(semi.isEmpty()){
                double semi2=0;
            }
            else{
                double semi2 = Double.parseDouble(semi);
                if(semi2>20){
                    semister.setError("Enter valid semister");
                    Toast.makeText(UserInfoActivity.this, "Enter valid Semister or leave it blank if you are new", Toast.LENGTH_SHORT).show();
                    return;
                }

                }

            final String cgpa1 = cgpa.getText().toString();

            if(cgpa1.isEmpty()){
                double cgpa2=0;
            }
            else{
                double cgpa2 = Double.parseDouble(cgpa1);
                if(cgpa2>4){
                    cgpa.setError("Enter valid CGPA");
                    Toast.makeText(UserInfoActivity.this, "Enter valid CGPA or leave it blank if you are new", Toast.LENGTH_SHORT).show();
                    return;
                }

            }

   

            final DocumentReference documentReference1 = fstore.collection("EWU_student").document(userID);
            documentReference1.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                    Map<String,Object> user = new HashMap<>();
                    user.put("Name",name);
                    user.put("EWU_ID",number);

                    if (cre.isEmpty()) {
                        user.put("Credit","0");
                    }
                    else{
                        user.put("Credit",cre);
                    }
                    final String semi = semister.getText().toString();
                   if(semi.isEmpty()){
                       user.put("Semister","0");
                   }
                   else {
                       user.put("Semister",semi);
                   }
                    user.put("Program",blood_group);
                    user.put("Gender",gen);
                    user.put("USER ID",userID);

                    user.put("Profile Photo","bfuser/"+userID+"profile.jpg");
                    if(cgpa1.isEmpty()){
                        user.put("CGPA","0");
                    }
                    else {
                        user.put("CGPA",cgpa1);
                    }







                    documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(UserInfoActivity.this, "User created"+userID, Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(UserInfoActivity.this, MainActivity.class);

                            startActivity(intent);
                            finish();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(UserInfoActivity.this, "User not created"+e.toString(), Toast.LENGTH_LONG).show();
                        }
                    });


                }
            });
        }
    }
}