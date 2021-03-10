package com.example.ewulife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity{
    EditText p1,p2,p3,p4,pass;
    Button button;
    TextView t1;
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

        //p3.addTextChangedListener(new TextWatcher() {
           // @Override
           // public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           // }

           // @Override
           // public void onTextChanged(CharSequence s, int start, int before, int count) {
           //     if(p3.getText().toString().length()==2){
             //       p4.requestFocus();
            //    }


          //  }

         //   @Override
          //  public void afterTextChanged(Editable s) {

          //  }
     //   });

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
                progressDialog.setTitle("Credential Check ");
                progressDialog.setTitle("Please wait, unitl checking log");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
                String email=p1.getText().toString();
                String password = pass.getText().toString();

                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progressDialog.dismiss();
                            Toast.makeText(LoginActivity.this, "User Found",Toast.LENGTH_LONG).show();
                            Intent intent =new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            progressDialog.dismiss();
                            Toast.makeText(LoginActivity.this, task.getException().toString(),Toast.LENGTH_LONG).show();
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