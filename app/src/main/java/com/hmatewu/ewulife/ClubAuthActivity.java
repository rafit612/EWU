package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class ClubAuthActivity extends AppCompatActivity {
    public static final String EXTRA_CLUB_CODE= "com.hm.roktojoddha.EXTRA_CLUB_CODE";

    Spinner spinner;
    EditText editText;
    Button button;

    FirebaseFirestore fstore;
    FirebaseAuth fAuth;
    FirebaseUser user;
    String userID;
    TimePicker timePicker;
    ArrayList<String> arrayList_club;
    ArrayAdapter<String> rr_club;
   String club_code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_auth);
        fstore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();
        user = fAuth.getCurrentUser();
        editText=findViewById(R.id.editTextTextPasswordclub);
        spinner =findViewById(R.id.spinner8);
        button = findViewById(R.id.button4club);


        DocumentReference documentReference = fstore.collection("EWU_student").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@androidx.annotation.Nullable DocumentSnapshot documentSnapshot, @androidx.annotation.Nullable FirebaseFirestoreException e) {

                String  updatea = documentSnapshot.getString("Block");

                if(!updatea.equals("1")){
                    LayoutInflater inflater = getLayoutInflater();                             ///custom toast//
                    View layout = inflater.inflate(R.layout.custom_error_admin_toast,(ViewGroup)findViewById(R.id.errorad));
                    final Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    toast.setDuration((Toast.LENGTH_LONG));
                    toast.setView(layout);
                    toast.show();
                    Intent intent =new Intent(ClubAuthActivity.this,BlockedActivity2.class);
                    startActivity(intent);
                    finish();
                }




            }
        });


        {

            arrayList_club = new ArrayList<>();
            arrayList_club.add("Select");
            arrayList_club.add("Agro Industrialization");
            arrayList_club.add("Creative Marketing");
            arrayList_club.add("Club For Performing Arts");
            arrayList_club.add("Bussiness");
            arrayList_club.add("Debating");
            arrayList_club.add("Economics");
            arrayList_club.add("Electronics Programming and Robotics");
            arrayList_club.add("English Conversation");
            arrayList_club.add("Environmental and Social");
            arrayList_club.add("Investment and Finance");
            arrayList_club.add("IEEE");
            arrayList_club.add("Model United Nation");
            arrayList_club.add("Photography");
            arrayList_club.add("Rotaract");
            arrayList_club.add("Science");
            arrayList_club.add("Sociology");
            arrayList_club.add("Sports");
            arrayList_club.add("TeleCommunication");
            arrayList_club.add("পাঠচক্র");
            arrayList_club.add("EWUCoPC");
            arrayList_club.add("Pharmacy");
            arrayList_club.add("Career Counseling Center");
            arrayList_club.add("EWU Notice");
        }
        rr_club = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_club);
        spinner.setAdapter(rr_club);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                club_code = editText.getText().toString();
                final String club_value = spinner.getSelectedItem().toString().trim();
                if (club_value.equals("Select")) {
                    Toast.makeText(ClubAuthActivity.this, "Selected Club", Toast.LENGTH_SHORT).show();
                    return;
                }
               String CC = null;
                //cc is club code//
                if(club_value.equals("Agro Industrialization")){
                    CC="1";
                    password(CC);
                }
                if(club_value.equals("Creative Marketing")){
                    CC="2";
                    password(CC);
                }
                if(club_value.equals("Club For Performing Arts")){
                    CC="3";
                    password(CC);
                }
                if(club_value.equals("Bussiness")){
                    CC="4";
                    password(CC);
                }
                if(club_value.equals("Debatingn")){
                    CC="5";
                    password(CC);
                }
                if(club_value.equals("Economics")){
                    CC="6";
                    password(CC);
                }
                if(club_value.equals("Electronics Programming and Robotics")){
                    CC="7";
                    password(CC);
                }
                if(club_value.equals("English Conversation")){
                    CC="8";
                    password(CC);
                }
                if(club_value.equals("Environmental and Social")){
                    CC="9";
                    password(CC);
                }
                if(club_value.equals("Investment and Finance")){
                    CC="10";
                    password(CC);
                }
                if(club_value.equals("IEEE")){
                    CC="11";
                    password(CC);
                }
                if(club_value.equals("Model United Nation")){
                    CC="12";
                    password(CC);
                }
                if(club_value.equals("Photography")){
                    CC="13";
                    password(CC);
                }
                if(club_value.equals("Rotaract")){
                    CC="14";
                    password(CC);
                }
                if(club_value.equals("Science")){
                    CC="15";
                    password(CC);
                }
                if(club_value.equals("Sociology")){
                    CC="16";
                    password(CC);
                }
                if(club_value.equals("Sports")){
                    CC="17";
                    password(CC);
                }
                if(club_value.equals("TeleCommunication")){
                    CC="18";

                    password(CC);
                }
                if(club_value.equals("পাঠচক্র")){
                    CC="19";

                    password(CC);
                }
                if(club_value.equals("EWUCoPCর")){
                    CC="20";

                    password(CC);
                }
                if(club_value.equals("Pharmacy")){
                    CC="21";
                    password(CC);
                }
                if(club_value.equals("Career Counseling Center")){
                    CC="22";
                    password(CC);
                }
                if(club_value.equals("EWU Notice")){
                    CC="100";
                    password(CC);
                }

            }
        });
    }

    protected void password(String a){
        DocumentReference documentReference = fstore.collection("Club_Access_Code").document(a);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                final    String key1= documentSnapshot.getString("KEY1");
                 if(club_code.equals(key1)){
                     LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
                     View layout1 = inflater1.inflate(R.layout.right_pass_toast,(ViewGroup)findViewById(R.id.rp));
                     final Toast toast = new Toast(getApplicationContext());
                     toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                     toast.setDuration((Toast.LENGTH_LONG));
                     toast.setView(layout1);
                     toast.show();
                     Intent intent = new Intent(ClubAuthActivity.this,ClubAdminActivity.class);
                     intent.putExtra(EXTRA_CLUB_CODE, a);

                     startActivity(intent);
                     finish();
                 }
                 else {
                     LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
                     View layout1 = inflater1.inflate(R.layout.wrong_pass_toast,(ViewGroup)findViewById(R.id.wr));
                     final Toast toast = new Toast(getApplicationContext());
                     toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                     toast.setDuration((Toast.LENGTH_LONG));
                     toast.setView(layout1);
                     toast.show();
                     return;
                 }


            }
        });
    }
}