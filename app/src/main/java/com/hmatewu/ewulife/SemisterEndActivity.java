package com.hmatewu.ewulife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SemisterEndActivity extends AppCompatActivity {
    EditText cgpa,credit,drop_credit;
    Button button;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userID;
    public static final String EXTRA_CREDIT= "com.hm.roktojoddha.EXTRA_CREDIT";
    public static final String EXTRA_DROP = "com.hm.roktojoddha.EXTRA_DROP";
    public static final String EXTRA_SEMISTER   = "com.hm.roktojoddha.EXTRA_SEMISTER";
    String credit10,drop10,semi10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semister_end);
        fAuth = FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        userID =fAuth.getCurrentUser().getUid();
        button = findViewById(R.id.button16);
        cgpa = findViewById(R.id.editTextNumberDecimal6);
        credit = findViewById(R.id.editTextNumberDecimal5);
        drop_credit = findViewById(R.id.editTextNumberDecimal7);
        Intent intent = getIntent();
        credit10=intent.getStringExtra(ClassScActivity.EXTRA_CREDIT);
        drop10=intent.getStringExtra(ClassScActivity.EXTRA_DROP);
        semi10=intent.getStringExtra(ClassScActivity.EXTRA_SEMISTER);
        Toast.makeText(SemisterEndActivity.this, "0"+credit10,Toast.LENGTH_LONG).show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cgpa1=cgpa.getText().toString();
                double cgpa2=Double.parseDouble(cgpa1);
                if((cgpa1.isEmpty())){
                    cgpa1="0";
                }
                if(cgpa2>4){
                    Toast.makeText(SemisterEndActivity.this, "CGPA incorrect ",Toast.LENGTH_LONG).show();
                    return;
                }
                String credit1=credit.getText().toString();

                if((credit1.isEmpty())){
                    credit1="0";
                }
                double credit2=Double.parseDouble(credit1);
                if(credit2>30){
                    Toast.makeText(SemisterEndActivity.this, "Creditincorrect ",Toast.LENGTH_LONG).show();
                    return;
                }
                String dc1=drop_credit.getText().toString();

                if((dc1.isEmpty())){
                    dc1="0";
                }
                double dc2=Double.parseDouble(dc1);
                if(dc2>credit2){
                    Toast.makeText(SemisterEndActivity.this, "Drop Credit incorrect ",Toast.LENGTH_LONG).show();
                    return;
                }

               double tot_credit = Double.parseDouble(credit10)+credit2;
                double tot_drop =Double.parseDouble(drop10)+dc2;
                int tot_semi = Integer.parseInt(semi10)+1;

                DocumentReference documentReference =fstore.collection("EWU_student").document(userID);

                documentReference.update("Credit",String.valueOf(tot_credit)
                ,"Drop",String.valueOf(tot_drop)
                ,"Semister",String.valueOf(tot_semi),"CGPA",cgpa1).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SemisterEndActivity.this, "All Class Schedule deleted", Toast.LENGTH_SHORT).show();
                            DocumentReference documentReference1= fstore.collection("class").document(userID);
                            documentReference1.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){

                                        Intent intent = new Intent(SemisterEndActivity.this, UserProfileActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(SemisterEndActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                        }
                        else{
                            Toast.makeText(SemisterEndActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}