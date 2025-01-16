package com.hmatewu.ewulife;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
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
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class ClubAdminActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_CLUB_KEY1= "com.hm.roktojoddha.EXTRA_CLUB_KEY1";
    public static final String EXTRA_CLUB_KEY2= "com.hm.roktojoddha.EXTRA_CLUB_KEY2";
    public static final String EXTRA_CLUB_KEY3= "com.hm.roktojoddha.EXTRA_CLUB_KEY3";
    public static final String EXTRA_CLUB_KEY4= "com.hm.roktojoddha.EXTRA_CLUB_KEY4";
    public static final String EXTRA_CLUB_CODE= "com.hm.roktojoddha.EXTRA_CLUB_CODE";
    public static final String EXTRA_NFID= "com.hm.roktojoddha.EXTRA_NFID";

    EditText title, description, places, code, form;
    Spinner club;
    int ages;
    int month1, day1, years;
    String mtoday,key1,key2,key3,key4;
    String mbirth, give_date;
    int months;
    int days;
    int months2;
    int days2;
    int years2;
    ArrayList<String> arrayList_club;
    ArrayAdapter<String> rr_club;
    String current, dob, age1, age, cmon, mon, mon1, cday, day, current_time, need_date, need_time, nfid;
    DatePicker datePicker, datePicker2;
    Button button;
    FirebaseFirestore fstore;
    FirebaseAuth fAuth;
    FirebaseUser user;
    String userID;
    TimePicker timePicker;
    String club_code;
    LottieAnimationView lottieAnimationView;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_admin);

        Intent intent = getIntent();

        fstore = FirebaseFirestore.getInstance();
        description = findViewById(R.id.club_note);
        title = findViewById(R.id.club_title);
        club_code=intent.getStringExtra(ClubAuthActivity.EXTRA_CLUB_CODE);
        club = findViewById(R.id.clubspinner);
        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();
        user = fAuth.getCurrentUser();
        places = findViewById(R.id.club_place);
        form = findViewById(R.id.club_form);
        button = findViewById(R.id.club_button17);

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
                    Intent intent =new Intent(ClubAdminActivity.this,BlockedActivity2.class);
                    startActivity(intent);
                    finish();
                }




            }
        });

        button.setOnClickListener(this);
      //  current = currentDate();

        datePicker2 = findViewById(R.id.club_giving_Date);
        timePicker = findViewById(R.id.club_time);
        timePicker.setIs24HourView(true);
        current_time = timePicker.getHour() + ":" + timePicker.getMinute() + " ";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        nfid=NFID_method();
        mtoday = simpleDateFormat.format(Calendar.getInstance().getTime());
        LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
        View layout1 = inflater1.inflate(R.layout.custom_admin_toast,(ViewGroup)findViewById(R.id.adtoast));
        final Toast toast1 = new Toast(getApplicationContext());
        toast1.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast1.setDuration((Toast.LENGTH_SHORT));
        toast1.setView(layout1);

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
        club.setAdapter(rr_club);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    String NFID_method() {
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(datePicker2.getYear());
        stringBuilder3.append((datePicker2.getMonth() + 1));
        stringBuilder3.append(datePicker2.getDayOfMonth());
        stringBuilder3.append(timePicker.getHour());
        stringBuilder3.append(timePicker.getMinute());
        stringBuilder3.append(userID);
        return stringBuilder3.toString().trim();
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    String TIME_method() {
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(datePicker2.getYear());
        stringBuilder3.append((datePicker2.getMonth() + 1));
        stringBuilder3.append(datePicker2.getDayOfMonth());
        stringBuilder3.append(timePicker.getHour());
        stringBuilder3.append(timePicker.getMinute());
        return stringBuilder3.toString().trim();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    String currentDate() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(datePicker2.getDayOfMonth() + "/");
        stringBuilder.append((datePicker2.getMonth() + 1) + "/");
        stringBuilder.append(datePicker2.getYear());

        return stringBuilder.toString();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.club_button17) {

            give_date = currentDate();

            need_date=give_date;



            final String club_title = title.getText().toString();

            final String club_description = description.getText().toString();
            final String club_place = places.getText().toString();
            final String url = form.getText().toString();
            if (TextUtils.isEmpty(club_title)) {
                title.setError("Title Required");
                Toast.makeText(ClubAdminActivity.this, "Title Required", Toast.LENGTH_LONG).show();
                return;
            }




            if (TextUtils.isEmpty(club_place)) {
                places.setError("Placesr Required");
                Toast.makeText(ClubAdminActivity.this, "Places Required", Toast.LENGTH_LONG).show();
                return;
            }
            final String club_value = club.getSelectedItem().toString().trim();
            if (club_value.equals("Select")) {
                Toast.makeText(ClubAdminActivity.this, "Selected Club", Toast.LENGTH_SHORT).show();
                return;
            }
           String CC = null;
               //cc is club code//
            if(club_value.equals("Agro Industrialization")){
                 CC="1";
            }
            if(club_value.equals("Creative Marketing")){
                  CC="2";
            }
            if(club_value.equals("Club For Performing Arts")){
             CC="3";
            }
            if(club_value.equals("Bussiness")){
                 CC="4";
            }
            if(club_value.equals("Debatingn")){
                 CC="5";
            }
            if(club_value.equals("Economics")){
                CC="6";
            }
            if(club_value.equals("Electronics Programming and Robotics")){
               CC="7";
            }
            if(club_value.equals("English Conversation")){
               CC="8";
            }
            if(club_value.equals("Environmental and Social")){
               CC="9";
            }
            if(club_value.equals("Investment and Finance")){
                CC="10";
            }
            if(club_value.equals("IEEE")){
               CC="11";
            }
            if(club_value.equals("Model United Nation")){
                CC="12";
            }
            if(club_value.equals("Photography")){
                CC="13";
            }
            if(club_value.equals("Rotaract")){
             CC="14";
            }
            if(club_value.equals("Science")){
               CC="15";
            }
            if(club_value.equals("Sociology")){
                CC="16";
            }
            if(club_value.equals("Sports")){
               CC="17";
            }
            if(club_value.equals("TeleCommunication")){
                 CC="18";
            }
            if(club_value.equals("পাঠচক্র")){
                CC="19";
            }
            if(club_value.equals("EWUCoPC")){
                CC="20";
            }
            if(club_value.equals("Pharmacy")){
                CC="21";
            }
            if(club_value.equals("Career Counseling Center")){
                CC="22";
            }
            if(club_value.equals("EWU Notice")){
                CC="100";

            }
            if (TextUtils.isEmpty(club_description)) {
                description.setError("Please Descripe (Minimum  20 Alphabet)");
                return;

            }
            if (club_description.length() < 20) {
                description.setError("Minimum  20 Alphabet");
                return;
            }


            need_time = timePicker.getHour() + ":" + timePicker.getMinute();



            final DocumentReference documentReference1 = fstore.collection("News_Feed").document(NFID_method());
            String finalCC = CC;
            documentReference1.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                    Map<String, Object> user = new HashMap<>();

                    user.put("Title", club_title);
                    user.put("Description", club_description);
                    user.put("Category", "Club");
                    user.put("NFID", NFID_method());
                    user.put("Upload_User_ID", club_code);
                    user.put("TimeUpload", TIME_method());


                    documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                        @Override
                        public void onSuccess(Void aVoid) {



                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ClubAdminActivity.this, "not updated" + e.toString(), Toast.LENGTH_LONG).show();
                        }
                    });


                }
            });


            final DocumentReference documentReference3 = fstore.collection("Club_Detail").document(club_code).collection("History").document(NFID_method());
            documentReference3.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot1, @Nullable FirebaseFirestoreException e2) {


                    Map<String, Object> user = new HashMap<>();
                    user.put("Title", club_title);
                    user.put("Description", club_description);

                    user.put("Places", club_place);
                    user.put("Club",club_value);

                    user.put("Time", need_time);
                    user.put("Date", need_date);
                    user.put("Request ID", userID);
                    user.put("Upload_Date", mtoday);
                    user.put("URL", url);
                    user.put("Category", "Club");
                    user.put("NFID", NFID_method());
                    user.put("TimeUpload", TIME_method());


                    documentReference3.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                        @Override
                        public void onSuccess(Void aVoid) {
                            LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
                            View layout1 = inflater1.inflate(R.layout.custom_admin_toast,(ViewGroup)findViewById(R.id.adtoast));
                            final Toast toast1 = new Toast(getApplicationContext());
                            toast1.setGravity(Gravity.CENTER_VERTICAL,0,0);
                            toast1.setDuration((Toast.LENGTH_SHORT));
                            toast1.setView(layout1);

                            toast1.show();
                            Intent intent = new Intent(ClubAdminActivity.this, MainActivity.class);

                            startActivity(intent);
                            finish();


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
                            View layout1 = inflater1.inflate(R.layout.custom_error_admin_toast,(ViewGroup)findViewById(R.id.adtoast));
                            final Toast toast = new Toast(getApplicationContext());
                            toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                            toast.setDuration((Toast.LENGTH_SHORT));
                            toast.setView(layout1);
                            Toast.makeText(ClubAdminActivity.this, "Eror " + e.toString(), Toast.LENGTH_LONG).show();
                        }
                    });


                }
            });



        }

        }
       }



