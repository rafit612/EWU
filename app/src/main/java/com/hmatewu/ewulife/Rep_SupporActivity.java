package com.hmatewu.ewulife;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Nullable;

public class Rep_SupporActivity extends AppCompatActivity {

    Button l1,l2,l3,l4;
    Spinner spinner;
    EditText editText;
    Button button;
    ArrayList<String> arrayList_club;
    ArrayAdapter<String> rr_club;
    FirebaseFirestore fstore;
    FirebaseAuth fAuth;
    FirebaseUser user;

    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rep__suppor);

        l1=findViewById(R.id.button15);
        l2=findViewById(R.id.button19);
        l3=findViewById(R.id.button18);
        l4=findViewById(R.id.button14);
        editText = findViewById(R.id.editTextTextPersonName2);
        spinner = findViewById(R.id.spinner9);
        button = findViewById(R.id.button13);
        fstore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();

        userID = fAuth.getCurrentUser().getUid();
        user = fAuth.getCurrentUser();

      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
       String currentDateandTime = sdf.format(new Date());

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("m.me/ami.rafiur"));
                startActivity(intent);
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_id = "roktojoddha@gmail.com";
                String msg = "Complient or Support";
                Intent sendEmail = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"+email_id)); // enter an email id here
                sendEmail.putExtra(Intent.EXTRA_SUBJECT, "subject"); //subject of the email
                sendEmail.putExtra(Intent.EXTRA_TEXT, msg); //body of the email
                startActivity(Intent.createChooser(sendEmail, "Choose an email client from..."));
            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.whatsapp.com/IBBUmHIjHsuDQ8AvDCoO7P"));
                startActivity(intent);
            }
        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/joinchat/91hdJ4jhJho0ZWY1"));
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String reason = spinner.getSelectedItem().toString().trim();

                if (reason.equals("Select")) {
                    Toast.makeText(Rep_SupporActivity.this, "Selected", Toast.LENGTH_SHORT).show();
                    return;
                }
                final String write = editText.getText().toString();
                if (TextUtils.isEmpty(write)) {
                    editText.setError("write something");
                    LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
                    View layout1 = inflater1.inflate(R.layout.write_custome_tooast,(ViewGroup)findViewById(R.id.wr));
                    final Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    toast.setDuration((Toast.LENGTH_SHORT));
                    toast.setView(layout1);
                    toast.show();

                    return;
                }
                final DocumentReference documentReference1 = fstore.collection("Support").document(reason).collection(currentDateandTime).document(userID);

                documentReference1.addSnapshotListener(Rep_SupporActivity.this, new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                        Map<String, Object> user = new HashMap<>();

                        user.put("Title", write);
                        user.put("User", userID);



                        documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                            @Override
                            public void onSuccess(Void aVoid) {
                                LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
                                View layout1 = inflater1.inflate(R.layout.done_custom_toast,(ViewGroup)findViewById(R.id.dn));
                                final Toast toast = new Toast(getApplicationContext());
                                toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                                toast.setDuration((Toast.LENGTH_SHORT));
                                toast.setView(layout1);
                                toast.show();
                                Intent intent = new Intent(Rep_SupporActivity.this,MainActivity.class);
                                startActivity(intent);
                                finish();


                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
                                View layout1 = inflater1.inflate(R.layout.custom_error_admin_toast,(ViewGroup)findViewById(R.id.errorad));
                                final Toast toast = new Toast(getApplicationContext());
                                toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                                toast.setDuration((Toast.LENGTH_SHORT));
                                toast.setView(layout1);
                                toast.show();
                                Toast.makeText(Rep_SupporActivity.this, "not updated" + e.toString(), Toast.LENGTH_LONG).show();
                            }
                        });


                    }
                });
            }
        });
        {

            arrayList_club = new ArrayList<>();
            arrayList_club.add("Select");
            arrayList_club.add("Report");
            arrayList_club.add("Suggestion");

        }
        rr_club = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_club);
        spinner.setAdapter(rr_club);

    }



}