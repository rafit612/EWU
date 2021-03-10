package com.example.ewulife;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
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

public class AddClassActivity extends AppCompatActivity {
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userID,current_time,mtoday,cls_start,cls_end,nfid;
    EditText course,credit,instructor,section;
    TimePicker day1,day2,day;
    Spinner theory1,theory2,lab;
    ArrayAdapter<String> rr_blood;
    Button can,ad;
    ArrayList<String> arrayList_Day;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        fAuth = FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        userID =fAuth.getCurrentUser().getUid();
        course = findViewById(R.id.editTextTextPersonName);
        credit = findViewById(R.id.editTextNumberDecimal3);
        instructor = findViewById(R.id.editTextTextPersonName5);
        section = findViewById(R.id.editTextNumberDecimal4);
        day1= findViewById(R.id.time);
        day2= findViewById(R.id.time2);
        day1.setIs24HourView(true);
        day2.setIs24HourView(true);
        theory1 = findViewById(R.id.spinner);
        theory2 = findViewById(R.id.spinner2);
        lab = findViewById(R.id.spinner3);
        can = findViewById(R.id.button5);
        ad =findViewById(R.id.button7);
        current_time = day1.getHour()+"_"+day1.getMinute()+"";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        mtoday = simpleDateFormat.format(Calendar.getInstance().getTime());
        nfid=NFID_method();
        Toast.makeText(AddClassActivity.this, mtoday, Toast.LENGTH_SHORT).show();
        arrayList_Day = new ArrayList<>();
        arrayList_Day.add("Select");
        arrayList_Day.add("No Class");
        arrayList_Day.add("Sunday");
        arrayList_Day.add("Monday");
        arrayList_Day.add("Tuesday");
        arrayList_Day.add("Wednesday");
        arrayList_Day.add("Thursday");
        rr_blood = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_Day);
        theory1.setAdapter(rr_blood);
        theory2.setAdapter(rr_blood);
        lab.setAdapter(rr_blood);
        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddClassActivity.this, ClassScActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String name2 = course.getText().toString();
                if (name2.isEmpty()) {
                    course.setError("Emter Course Name");
                    return;
                }
                final String credit2 = credit.getText().toString();
                if (credit2.isEmpty()) {
                    credit.setError("Enter Room Number");
                    return;
                }
                final String ins2 = instructor.getText().toString();
                if (ins2.isEmpty()) {
                    instructor.setError("Emter Instructor Initial");
                    return;
                }
                final String sec2 = section.getText().toString();
                if (sec2.isEmpty()) {
                    section.setError("Enter Section");
                    return;
                }
                String day11 = theory1.getSelectedItem().toString();
                if (day11.equals("Select")) {
                    Toast.makeText(AddClassActivity.this, "Selected Day1", Toast.LENGTH_SHORT).show();
                    return;
                }
                String day22 = theory2.getSelectedItem().toString();
                if (day22.equals("Select")) {
                    Toast.makeText(AddClassActivity.this, "Selected Day2", Toast.LENGTH_SHORT).show();
                    return;
                }
                String lab11 = lab.getSelectedItem().toString();
                if (lab11.equals("Select")) {
                    Toast.makeText(AddClassActivity.this, "Selected lab Day", Toast.LENGTH_SHORT).show();
                    return;
                }
                if((lab11.equals("No Class") && day22.equals("No Class")  && day11.equals("No Class") )){
                    Toast.makeText(AddClassActivity.this, "Selected a lab/theory Day", Toast.LENGTH_SHORT).show();
                    return;
                }

                cls_start = day1.getHour()+":"+day1.getMinute();
                cls_end = day2.getHour()+":"+day2.getMinute();
                if(day11.equals("Sunday")){
                    final DocumentReference documentReference1 = fstore.collection("class").document(userID).collection("Sunday").document(mtoday);
                    documentReference1.addSnapshotListener(AddClassActivity.this, new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                            Map<String,Object> user = new HashMap<>();
                            user.put("Course",name2);
                            user.put("Room",credit2);
                            user.put("Instructor",ins2);
                            user.put("Section",sec2);
                            user.put("Start",cls_start);
                            user.put("End",cls_end);
                            user.put("ref",mtoday);
                            user.put("day",day11);

                            documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(AddClassActivity.this, "User created"+userID, Toast.LENGTH_LONG).show();


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(AddClassActivity.this, "User not created"+e.toString(), Toast.LENGTH_LONG).show();
                                }
                            });


                        }
                    });
                }
                if(day11.equals("Monday")){
                    final DocumentReference documentReference1 = fstore.collection("class").document(userID).collection("Monday").document(mtoday);
                    documentReference1.addSnapshotListener(AddClassActivity.this, new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                            Map<String,Object> user = new HashMap<>();
                            user.put("Course",name2);
                            user.put("Room",credit2);
                            user.put("Instructor",ins2);
                            user.put("Section",sec2);
                            user.put("Start",cls_start);
                            user.put("End",cls_end);
                            user.put("ref",mtoday);
                            user.put("day",day11);

                            documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(AddClassActivity.this, "User created"+userID, Toast.LENGTH_LONG).show();


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(AddClassActivity.this, "User not created"+e.toString(), Toast.LENGTH_LONG).show();
                                }
                            });


                        }
                    });
                }
                if(day11.equals("Tuesday")){
                    final DocumentReference documentReference1 = fstore.collection("class").document(userID).collection("Tuesday").document(mtoday);
                    documentReference1.addSnapshotListener(AddClassActivity.this, new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                            Map<String,Object> user = new HashMap<>();
                            user.put("Course",name2);
                            user.put("Room",credit2);
                            user.put("Instructor",ins2);
                            user.put("Section",sec2);
                            user.put("Start",cls_start);
                            user.put("End",cls_end);
                            user.put("ref",mtoday);
                            user.put("day",day11);

                            documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                                @Override
                                public void onSuccess(Void aVoid) {


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(AddClassActivity.this, "User not created"+e.toString(), Toast.LENGTH_LONG).show();
                                }
                            });


                        }
                    });
                }
                if(day11.equals("Wednesday")){
                    final DocumentReference documentReference1 = fstore.collection("class").document(userID).collection("Wednesday").document(mtoday);
                    documentReference1.addSnapshotListener(AddClassActivity.this, new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                            Map<String,Object> user = new HashMap<>();
                            user.put("Course",name2);
                            user.put("Room",credit2);
                            user.put("Instructor",ins2);
                            user.put("Section",sec2);
                            user.put("Start",cls_start);
                            user.put("End",cls_end);
                            user.put("ref",mtoday);
                            user.put("day",day11);

                            documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                                @Override
                                public void onSuccess(Void aVoid) {


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(AddClassActivity.this, "User not created"+e.toString(), Toast.LENGTH_LONG).show();
                                }
                            });


                        }
                    });
                }
                if(day11.equals("Thursday")){
                    final DocumentReference documentReference1 = fstore.collection("class").document(userID).collection("Thursday").document(mtoday);
                    documentReference1.addSnapshotListener(AddClassActivity.this, new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                            Map<String,Object> user = new HashMap<>();
                            user.put("Course",name2);
                            user.put("Room",credit2);
                            user.put("Instructor",ins2);
                            user.put("Section",sec2);
                            user.put("Start",cls_start);
                            user.put("End",cls_end);
                            user.put("ref",mtoday);
                            user.put("day",day11);

                            documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                                @Override
                                public void onSuccess(Void aVoid) {


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(AddClassActivity.this, "User not created"+e.toString(), Toast.LENGTH_LONG).show();
                                }
                            });


                        }
                    });
                }
                if(day22.equals("Sunday")){
                    final DocumentReference documentReference1 = fstore.collection("class").document(userID).collection("Sunday").document(mtoday);
                    documentReference1.addSnapshotListener(AddClassActivity.this, new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                            Map<String,Object> user = new HashMap<>();
                            user.put("Course",name2);
                            user.put("Room",credit2);
                            user.put("Instructor",ins2);
                            user.put("Section",sec2);
                            user.put("Start",cls_start);
                            user.put("End",cls_end);
                            user.put("ref",mtoday);
                            user.put("day",day22);

                            documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(AddClassActivity.this, "User created"+userID, Toast.LENGTH_LONG).show();


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(AddClassActivity.this, "User not created"+e.toString(), Toast.LENGTH_LONG).show();
                                }
                            });


                        }
                    });
                }
                if(day22.equals("Monday")){
                    final DocumentReference documentReference1 = fstore.collection("class").document(userID).collection("Monday").document(mtoday);
                    documentReference1.addSnapshotListener(AddClassActivity.this, new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                            Map<String,Object> user = new HashMap<>();
                            user.put("Course",name2);
                            user.put("Room",credit2);
                            user.put("Instructor",ins2);
                            user.put("Section",sec2);
                            user.put("Start",cls_start);
                            user.put("End",cls_end);
                            user.put("ref",mtoday);
                            user.put("day",day22);

                            documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(AddClassActivity.this, "User created"+userID, Toast.LENGTH_LONG).show();


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(AddClassActivity.this, "User not created"+e.toString(), Toast.LENGTH_LONG).show();
                                }
                            });


                        }
                    });
                }
                if(day22.equals("Tuesday")){
                    final DocumentReference documentReference1 = fstore.collection("class").document(userID).collection("Tuesday").document(mtoday);
                    documentReference1.addSnapshotListener(AddClassActivity.this, new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                            Map<String,Object> user = new HashMap<>();
                            user.put("Course",name2);
                            user.put("Room",credit2);
                            user.put("Instructor",ins2);
                            user.put("Section",sec2);
                            user.put("Start",cls_start);
                            user.put("End",cls_end);
                            user.put("ref",mtoday);
                            user.put("day",day22);

                            documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                                @Override
                                public void onSuccess(Void aVoid) {


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(AddClassActivity.this, "User not created"+e.toString(), Toast.LENGTH_LONG).show();
                                }
                            });


                        }
                    });
                }
                if(day22.equals("Wednesday")){
                    final DocumentReference documentReference1 = fstore.collection("class").document(userID).collection("Wednesday").document(mtoday);
                    documentReference1.addSnapshotListener(AddClassActivity.this, new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                            Map<String,Object> user = new HashMap<>();
                            user.put("Course",name2);
                            user.put("Room",credit2);
                            user.put("Instructor",ins2);
                            user.put("Section",sec2);
                            user.put("Start",cls_start);
                            user.put("End",cls_end);
                            user.put("ref",mtoday);
                            user.put("day",day22);

                            documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                                @Override
                                public void onSuccess(Void aVoid) {


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(AddClassActivity.this, "User not created"+e.toString(), Toast.LENGTH_LONG).show();
                                }
                            });


                        }
                    });
                }
                if(day22.equals("Thursday")){
                    final DocumentReference documentReference1 = fstore.collection("class").document(userID).collection("Thursday").document(mtoday);
                    documentReference1.addSnapshotListener(AddClassActivity.this, new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                            Map<String,Object> user = new HashMap<>();
                            user.put("Course",name2);
                            user.put("Room",credit2);
                            user.put("Instructor",ins2);
                            user.put("Section",sec2);
                            user.put("Start",cls_start);
                            user.put("End",cls_end);
                            user.put("ref",mtoday);
                            user.put("day",day22);

                            documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                                @Override
                                public void onSuccess(Void aVoid) {


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(AddClassActivity.this, "User not created"+e.toString(), Toast.LENGTH_LONG).show();
                                }
                            });


                        }
                    });
                }
                if(lab11.equals("Sunday")){
                    final DocumentReference documentReference1 = fstore.collection("class").document(userID).collection("Sunday").document(mtoday+"l");
                    documentReference1.addSnapshotListener(AddClassActivity.this, new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                            Map<String,Object> user = new HashMap<>();
                            user.put("Course",name2+" LAB");
                            user.put("Room",credit2);
                            user.put("Instructor",ins2);
                            user.put("Section",sec2);
                            user.put("Start",cls_end);
                            user.put("ref",mtoday+"l");
                            user.put("day",lab11);

                            documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(AddClassActivity.this, "User created"+userID, Toast.LENGTH_LONG).show();


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(AddClassActivity.this, "User not created"+e.toString(), Toast.LENGTH_LONG).show();
                                }
                            });


                        }
                    });
                }
                if(lab11.equals("Monday")){
                    final DocumentReference documentReference1 = fstore.collection("class").document(userID).collection("Monday").document(mtoday+"l");
                    documentReference1.addSnapshotListener(AddClassActivity.this, new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                            Map<String,Object> user = new HashMap<>();
                            user.put("Course",name2+" LAB");
                            user.put("Room",credit2);
                            user.put("Instructor",ins2);
                            user.put("Section",sec2);
                            user.put("Start",cls_end);
                            user.put("ref",mtoday+"l");
                            user.put("day",lab11);

                            documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(AddClassActivity.this, "User created"+userID, Toast.LENGTH_LONG).show();


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(AddClassActivity.this, "User not created"+e.toString(), Toast.LENGTH_LONG).show();
                                }
                            });


                        }
                    });
                }
                if(lab11.equals("Tuesday")){
                    final DocumentReference documentReference1 = fstore.collection("class").document(userID).collection("Tuesday").document(mtoday+"l");
                    documentReference1.addSnapshotListener(AddClassActivity.this, new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                            Map<String,Object> user = new HashMap<>();
                            user.put("Course",name2+" LAB");
                            user.put("Room",credit2);
                            user.put("Instructor",ins2);
                            user.put("Section",sec2);
                            user.put("Start",cls_end);
                            user.put("ref",mtoday+"l");
                            user.put("day",lab11);

                            documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                                @Override
                                public void onSuccess(Void aVoid) {


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(AddClassActivity.this, "User not created"+e.toString(), Toast.LENGTH_LONG).show();
                                }
                            });


                        }
                    });
                }
                if(lab11.equals("Wednesday")){
                    final DocumentReference documentReference1 = fstore.collection("class").document(userID).collection("Wednesday").document(mtoday+"l");
                    documentReference1.addSnapshotListener(AddClassActivity.this, new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                            Map<String,Object> user = new HashMap<>();
                            user.put("Course",name2+" LAB");
                            user.put("Room",credit2);
                            user.put("Instructor",ins2);
                            user.put("Section",sec2);
                            user.put("Start",cls_end);
                            user.put("ref",mtoday+"l");
                            user.put("day",lab11);

                            documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                                @Override
                                public void onSuccess(Void aVoid) {


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(AddClassActivity.this, ""+e.toString(), Toast.LENGTH_LONG).show();
                                }
                            });


                        }
                    });
                }
                if(lab11.equals("Thursday")){
                    final DocumentReference documentReference1 = fstore.collection("class").document(userID).collection("Thursday").document(mtoday+"l");
                    documentReference1.addSnapshotListener(AddClassActivity.this, new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                            Map<String,Object> user = new HashMap<>();
                            user.put("Course",name2+" LAB");
                            user.put("Room",credit2);
                            user.put("Instructor",ins2);
                            user.put("Section",sec2);
                            user.put("Start",cls_end);

                            user.put("ref",mtoday+"l");
                            user.put("day",lab11);

                            documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                                @Override
                                public void onSuccess(Void aVoid) {


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(AddClassActivity.this, "User not created"+e.toString(), Toast.LENGTH_LONG).show();
                                }
                            });


                        }
                    });
                }
                final DocumentReference documentReference2 = fstore.collection("INST").document(name2).collection(sec2).document(mtoday+"l");
                documentReference2.addSnapshotListener(AddClassActivity.this, new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                        Map<String,Object> user = new HashMap<>();

                        user.put("Instructor",ins2);


                        documentReference2.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                            @Override
                            public void onSuccess(Void aVoid) {

                                Intent intent = new Intent(AddClassActivity.this, ClassScActivity.class);
                                startActivity(intent);
                                finish();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(AddClassActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                            }
                        });


                    }
                });

            }
        });

    }
    String NFID_method(){
        StringBuilder stringBuilder3 = new StringBuilder();

        stringBuilder3.append(mtoday);
        stringBuilder3.append(day1);
        return stringBuilder3.toString().trim();
    }
}