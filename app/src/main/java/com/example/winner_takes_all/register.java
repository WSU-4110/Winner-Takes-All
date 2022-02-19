package com.example.winner_takes_all;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

public class register extends AppCompatActivity {

    EditText UserName,UserEmail,UserPassword,UserReenterPassword;
    Button RegistrationBtn;
    TextView LoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        UserName = findViewById(R.id.UserName);
        UserEmail = findViewById(R.id.Email);
        UserPassword =  findViewById(R.id.Password);
        UserReenterPassword = findViewById(R.id.Reenterpasssword);
        RegistrationBtn = findViewById(R.id.Register);
        LoginBtn = findViewById(R.id.login);

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        if (fAuth.getCurrentUser()!= null){

            startActivity(new Intent(getApplicationContext(),SignIn.class));
            finish();
        }

        RegistrationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = UserName.getText().toString().trim();
                String email = UserEmail.getText().toString().trim();
                String password = UserPassword.getText().toString().trim();
                String reenterPassword = UserReenterPassword.getText().toString().trim();


                if (TextUtils.isEmpty(username)) {
                    UserName.setError("UserName is required");
                    return;
                }
                if (TextUtils.isEmpty(email)){

                    UserEmail.setError("Email is required");
                    return;

                }
                if (TextUtils.isEmpty(password)){

                    UserPassword.setError("password is required");
                    return;

                }
                if (password.length()< 8){

                    UserPassword.setError("password >= 8 characters");
                }
                if (TextUtils.isEmpty(reenterPassword)){

                    UserReenterPassword.setError("please re-enter password");
                    return;

                }
                if (reenterPassword.equals(password)){

                    fAuth.fetchSignInMethodsForEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                                @Override
                                public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {

                                    boolean isNewUser = task.getResult().getSignInMethods().isEmpty();

                                    if (isNewUser) {
                                        fAuth.createUserWithEmailAndPassword(email,reenterPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                if(task.isSuccessful()){

                                                    Toast.makeText(register.this, "User Created", Toast.LENGTH_SHORT).show();
                                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                                }
                                                else{

                                                    Toast.makeText(register.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                                }
                                            }
                                        });

                                    }
                                    else {

                                        UserEmail.setError("Email already exists");
                                    }
                                }
                            });


                }
                else {

                    UserReenterPassword.setError("Password Doesn't match");
                }
                progressBar.setVisibility(View.VISIBLE);



            }
        });
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),SignIn.class));
            }
        });
    }
}