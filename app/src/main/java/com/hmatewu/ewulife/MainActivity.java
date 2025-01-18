package com.hmatewu.ewulife;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {
    ChipNavigationBar bar;
    FirebaseAuth fAuth;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore fstore;
    FirebaseUser user;
    String userID,full,mob;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = findViewById(R.id.nav_ewu);
        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        firebaseAuth =FirebaseAuth.getInstance();

        userID = fAuth.getCurrentUser().getUid();



        //checking users

        DocumentReference documentReference = fstore.collection("EWU_student").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                String  updatea = documentSnapshot.getString("Block");

                if(!updatea.equals("1")){
                    LayoutInflater inflater = getLayoutInflater();                             ///custom toast//
                    View layout = inflater.inflate(R.layout.custom_error_admin_toast,(ViewGroup)findViewById(R.id.errorad));
                    final Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    toast.setDuration((Toast.LENGTH_LONG));
                    toast.setView(layout);
                    toast.show();
                    Intent intent =new Intent(MainActivity.this,BlockedActivity2.class);
                    startActivity(intent);
                    finish();
                }




            }
        });

        final DocumentReference ref = FirebaseFirestore.getInstance().collection( "EWU_student" ).document(userID);
        ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @SuppressLint("ShowToast")
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot documentSnapshot = task.getResult();
                    if (documentSnapshot != null && documentSnapshot.exists()){

                    }
                    else{

                        LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
                        View layout1 = inflater1.inflate(R.layout.custom_incomplete_toast,(ViewGroup)findViewById(R.id.alarm));
                        final Toast toast1 = new Toast(getApplicationContext());
                        toast1.setGravity(Gravity.CENTER_VERTICAL,0,0);
                        toast1.setDuration((Toast.LENGTH_LONG));
                        toast1.setView(layout1);
                       // Toast.makeText(MainActivity.this, "Please Complete the given Information",Toast.LENGTH_LONG).show();
                        Intent intent =new Intent(MainActivity.this,UserRegistrationInfoActivity.class);
                        startActivity(intent);

                    }
                }
            }
        });

        if(savedInstanceState ==null){
            bar.setItemSelected(R.id.home,true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragment =new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.frag_page,homeFragment)
                    .commit();
        }
        bar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Fragment fragment = null;
                if (id == R.id.newsfeed) {
                    fragment = new FeedFragment();
                } else if (id == R.id.home) {
                    fragment = new HomeFragment();
                }
                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frag_page, fragment)
                            .commit();
                } else {
                    Toast.makeText(MainActivity.this, "Error opening fragment", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}