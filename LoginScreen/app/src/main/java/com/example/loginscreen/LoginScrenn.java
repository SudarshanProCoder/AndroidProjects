package com.example.loginscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginScrenn extends AppCompatActivity {

    EditText text1, text2;
    TextView signup;
    Button login;
    FirebaseAuth firebaseAuth;

    ProgressDialog progressDialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        text1 = findViewById(R.id.inputEmail);
        text2 = findViewById(R.id.inputPassword);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signUp);
        progressDialog = new ProgressDialog(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = text1.getText().toString();
                String pass = text2.getText().toString();



                progressDialog.show();

                text1.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        if (user.equals("") && pass.equals("")) {
                            text1.setError("Enter the Email");
                            text2.setError("Enter the Password");
                            login.setEnabled(false);
                        }
                        if (!user.equals("") && pass.equals("")) {

                            login.setEnabled(true);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
                text2.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        if (user.equals("") && pass.equals("")) {
                            text1.setError("Enter the Email");
                            text2.setError("Enter the Password");
                            login.setEnabled(false);
                        }
                        if (!user.equals("") && pass.equals("")) {

                            login.setEnabled(true);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                firebaseAuth.signInWithEmailAndPassword(user, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putBoolean("username", true);
                        editor.apply();
                        Intent intent = new Intent(LoginScrenn.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        Toast.makeText(LoginScrenn.this, "Login Successful...", Toast.LENGTH_SHORT).show();
                        progressDialog.cancel();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LoginScrenn.this, "Login Unsuccessful...", Toast.LENGTH_SHORT).show();
                        progressDialog.cancel();
                    }
                });
            }


        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScrenn.this, SignUp.class);
                startActivity(intent);
                finish();
            }
        });

    }
}