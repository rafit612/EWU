package com.hmatewu.ewulife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity{
    EditText p1,p2,p3,p4,pass;
    Button button;
    TextView t1,reset;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        p1 = findViewById(R.id.editTextNumber4);
        pass = findViewById(R.id.editTextTextPassword);
        button = findViewById(R.id.button4);
        t1 = findViewById(R.id.textView42);
        firebaseAuth = FirebaseAuth.getInstance();


        progressDialog = new ProgressDialog(LoginActivity.this);
        reset = findViewById(R.id.textView70);





        LayoutInflater inflater1 = getLayoutInflater();
        View layout1 = inflater1.inflate(R.layout.custom_password_toast,(ViewGroup)findViewById(R.id.lock));



        final Toast toast1 = new Toast(getApplicationContext());
        toast1.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast1.setDuration((Toast.LENGTH_SHORT));
        toast1.setView(layout1);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText resetMail = new EditText(v.getContext());
                final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password ?");
                passwordResetDialog.setMessage("Enter Your Email To Received Reset Link.");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // extract the email and send reset link
                        String mail = resetMail.getText().toString();
                        firebaseAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(LoginActivity.this, "Reset Link Sent To Your Email.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginActivity.this, "Error ! Reset Link is Not Sent" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // close the dialog
                    }
                });

                passwordResetDialog.create().show();
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((p1.getText().toString().length()<5)){
                    Toast.makeText(LoginActivity.this, "Please enter Correct Email: ",Toast.LENGTH_LONG).show();
                    return;
                }
                if((pass.getText().toString().isEmpty())){
                    Toast.makeText(LoginActivity.this, "Please enter Password: ",Toast.LENGTH_LONG).show();
                    return;
                }



                String email=p1.getText().toString();
                String password = pass.getText().toString();

                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){



                            LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
                            View layout1 = inflater1.inflate(R.layout.custom_profile_toast,(ViewGroup)findViewById(R.id.pro));
                            final Toast toast = new Toast(getApplicationContext());
                            toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                            toast.setDuration((Toast.LENGTH_LONG));
                            toast.setView(layout1);
                            toast.show();

                            Intent intent =new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();


                        }
                        else{
                            if(task.getException().toString().equals("com.google.firebase.FirebaseNetworkException: A network error (such as timeout, interrupted connection or unreachable host) has occurred.")){
                                toast1.show();
                                Toast.makeText(LoginActivity.this, task.getException().toString(),Toast.LENGTH_LONG).show();


                            }


                        }


                    }
                });

            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}