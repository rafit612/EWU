package com.hmatewu.ewulife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.google.firebase.database.annotations.Nullable;
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

import de.hdodenhof.circleimageview.CircleImageView;

public class UserRegistrationInfoActivity extends AppCompatActivity  implements View.OnClickListener{
    Button next;
    FirebaseFirestore fstore;
    FirebaseAuth fAuth;
    String userID;
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
    double cred2,semi2,cgpa2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration_info);

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();

        storageReference = FirebaseStorage.getInstance().getReference();
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
                Toast.makeText(UserRegistrationInfoActivity.this, "File is not Uploaded" + e, Toast.LENGTH_SHORT).show();
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

                Toast.makeText(UserRegistrationInfoActivity.this, "Selected Gender", Toast.LENGTH_SHORT).show();
                return;
            }
            String blood_group = bloodgroup.getSelectedItem().toString();
            if (blood_group.equals("Select")) {
                Toast.makeText(UserRegistrationInfoActivity.this, "Selected Department", Toast.LENGTH_SHORT).show();
                return;
            }
            String gen = gender.getText().toString();
            final String cre = credit.getText().toString();
            if(cre.isEmpty()){
                credit.setError("Enter Valid Credit");
                Toast.makeText(UserRegistrationInfoActivity.this, "Enter Valid Credit or leave it blank if you are new", Toast.LENGTH_SHORT).show();
                return;
            }
            if((Double.parseDouble(cre))>200){
                credit.setError("Enter valid Credit");
                Toast.makeText(UserRegistrationInfoActivity.this, "Enter valid CGPA or leave it blank if you are new", Toast.LENGTH_SHORT).show();
                return;
            }

            final String semi = semister.getText().toString();
            if(semi.isEmpty()){
                semister.setError("Enter valid semister");
                Toast.makeText(UserRegistrationInfoActivity.this, "Enter valid Semister or leave it blank if you are new", Toast.LENGTH_SHORT).show();
                return;
            }
            if((Double.parseDouble(semi))>20){
                semister.setError("Enter valid Semister");
                Toast.makeText(UserRegistrationInfoActivity.this, "Enter valid CGPA or leave it blank if you are new", Toast.LENGTH_SHORT).show();
                return;
            }

            final String cgpa1 = cgpa.getText().toString();

            if(cgpa1.isEmpty()){
                cgpa.setError("Enter valid CGPA");
                Toast.makeText(UserRegistrationInfoActivity.this, "Enter valid CGPA or leave it blank if you are new", Toast.LENGTH_SHORT).show();
                return;
            }
            if((Double.parseDouble(cgpa1))>4){
                cgpa.setError("Enter valid CGPA");
                Toast.makeText(UserRegistrationInfoActivity.this, "Enter valid CGPA or leave it blank if you are new", Toast.LENGTH_SHORT).show();
                return;
            }
            final DocumentReference documentReference3 = fstore.collection("EWU_student").document(userID);
            documentReference3.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot1, @Nullable FirebaseFirestoreException e2) {


                    Map<String, Object> user = new HashMap<>();
                    user.put("Name",name);
                    user.put("EWU_ID",number);
                    user.put("Credit",cre);
                    user.put("Semister",semi);
                    user.put("Program",blood_group);
                    user.put("Gender",gen);
                    user.put("USER ID",userID);
                    user.put("Drop","0");
                    user.put("Profile Photo","ewuuser/"+userID+"profile.jpg");
                    user.put("CGPA",cgpa1);
                    user.put("Block","1");



                    documentReference3.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                        @Override
                        public void onSuccess(Void aVoid) {

                            LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
                            View layout1 = inflater1.inflate(R.layout.custom_profile_toast,(ViewGroup)findViewById(R.id.pro));
                            final Toast toast = new Toast(getApplicationContext());
                            toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                            toast.setDuration((Toast.LENGTH_LONG));
                            toast.setView(layout1);
                            toast.show();
                            Intent intent = new Intent(UserRegistrationInfoActivity.this, MainActivity.class);

                            startActivity(intent);
                            finish();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
                            View layout1 = inflater1.inflate(R.layout.custom_incomplete_toast,(ViewGroup)findViewById(R.id.alarm));
                            final Toast toast1 = new Toast(getApplicationContext());
                            toast1.setGravity(Gravity.CENTER_VERTICAL,0,0);
                            toast1.setDuration((Toast.LENGTH_LONG));
                            toast1.setView(layout1);
                            Intent intent = new Intent(UserRegistrationInfoActivity.this, UserRegistrationInfoActivity.class);

                            startActivity(intent);
                            finish();
                        }
                    });


                }
            });


        }
    }
}