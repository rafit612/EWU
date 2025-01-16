package com.hmatewu.ewulife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity  {
    EditText p1,p2,p3,p4,pass,pass2;
    Button button;
    TextView t1;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(RegisterActivity.this);
        setContentView(R.layout.activity_register);
        p1 = findViewById(R.id.editTextNumber4a);
        pass = findViewById(R.id.editTextTextPassword3);
        pass2 = findViewById(R.id.editTextTextPassword4);
        button = findViewById(R.id.button6);
        t1 = findViewById(R.id.textView56);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((p1.getText().toString().length()<5)){
                    Toast.makeText(RegisterActivity.this, "Please enter Correct Email: ",Toast.LENGTH_LONG).show();
                    return;
                }
                if((pass.getText().toString().isEmpty())){
                    Toast.makeText(RegisterActivity.this, "Please enter Password: ",Toast.LENGTH_LONG).show();
                    return;
                }
                if((pass2.getText().toString().isEmpty())){
                    Toast.makeText(RegisterActivity.this, "Please RE-enter Password: ",Toast.LENGTH_LONG).show();
                    return;
                }
                 String pa1= pass.getText().toString().trim();
                 String pa2 =pass2.getText().toString().trim();
                if((pass.getText().toString().length()<8)){
                    Toast.makeText(RegisterActivity.this, "Password Must be greater than 8 character: ",Toast.LENGTH_LONG).show();
                    return;
                }
                if(!pa1.equals(pa2)){
                    Toast.makeText(RegisterActivity.this, "Password Does not Match: ",Toast.LENGTH_LONG).show();
                    return;
                }
              progressDialog.setTitle("Registeration");
               progressDialog.setTitle("Please wait, unitl user Account Created");
                progressDialog.setCanceledOnTouchOutside(false);
               progressDialog.show();

                LayoutInflater inflater = getLayoutInflater();
                String email=p1.getText().toString().trim();
                String password = pass.getText().toString().trim();
                Toast.makeText(RegisterActivity.this, email,Toast.LENGTH_LONG).show();


                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                           progressDialog.dismiss();
                            Toast.makeText(RegisterActivity.this, "User Created",Toast.LENGTH_LONG).show();
                            Intent intent =new Intent(RegisterActivity.this,UserRegistrationInfoActivity.class);
                            startActivity(intent);
                            finish();

                        }
                        else{
                            progressDialog.dismiss();
                            Toast.makeText(RegisterActivity.this, task.getException().toString(),Toast.LENGTH_LONG).show();



                        }
                    }
                });


            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });
    }


}