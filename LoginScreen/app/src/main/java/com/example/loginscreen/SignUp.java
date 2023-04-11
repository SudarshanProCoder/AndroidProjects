package com.example.loginscreen;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUp extends AppCompatActivity {

    EditText name, email, password, number, conformPass;
    Button signup;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;

    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_screen);
        name=findViewById(R.id.Full_Name);
        email=findViewById(R.id.email);
        number=findViewById(R.id.phoneno);
        password=findViewById(R.id.password);
        conformPass=findViewById(R.id.conformpassword);
        firebaseFirestore = FirebaseFirestore.getInstance();
        signup = findViewById(R.id.signup);
        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FullName = name.getText().toString();
                String Email = email.getText().toString();
                String Number = number.getText().toString();
                String Pass = password.getText().toString();
                String ConfirmPass = conformPass.getText().toString();
                if(FullName.equals("") && Email.equals("") && Number.equals("") && Pass.equals("") && ConfirmPass.equals("")){
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(SignUp.this);
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("Please Fill All details!");
                }
                if(Pass.equals(ConfirmPass)){
                    progressDialog.show();
                    firebaseAuth.createUserWithEmailAndPassword(Email, Pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            startActivity(new Intent(SignUp.this, LoginScrenn.class));
                            progressDialog.cancel();

                            firebaseFirestore.collection("user").document(FirebaseAuth.getInstance().getUid()).set(new UserModel(FullName, Number, Email));


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            progressDialog.cancel();
                        }
                    });

                }else{
                    conformPass.setError("password invalid");
                }
            }
        });

    }
}
