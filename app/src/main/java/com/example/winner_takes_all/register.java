package com.example.winner_takes_all;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class register extends AppCompatActivity {

    public static final String TAG = "TAG";
    // adding class variables
    EditText UserName,UserEmail,UserPassword,UserReenterPassword;
    Button RegistrationBtn;
    TextView LoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    FirebaseFirestore fStore;
    String userID;
    int Score = 0;
    int Admin = 0;
    int PowerUP1 = 0;
    int PowerUP2 = 0;
    int PowerUP3 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        UserName = findViewById(R.id.UserName);// setting up UserName text
        UserEmail = findViewById(R.id.Email);// setting up email text
        UserPassword =  findViewById(R.id.Password);// setting up password text
        UserReenterPassword = findViewById(R.id.Reenterpasssword);// setting up re enter password text
        RegistrationBtn = findViewById(R.id.Register);// setting up registration button
        LoginBtn = findViewById(R.id.login);// setting up login button
        fAuth = FirebaseAuth.getInstance();// setting up fire base Authentication on device
        fStore = FirebaseFirestore.getInstance();
        progressBar = findViewById(R.id.progressBar);// setting up progress bar


        RegistrationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = UserName.getText().toString();
                String email = UserEmail.getText().toString().trim();
                String password = UserPassword.getText().toString().trim();
                String reenterPassword = UserReenterPassword.getText().toString().trim();


                // if username is empty display error
                if (TextUtils.isEmpty(username)) {
                    UserName.setError("UserName is required");
                    return;
                }
                // if Email is empty display error
                if (TextUtils.isEmpty(email)){

                    UserEmail.setError("Email is required");
                    return;

                }
                // if password is empty display error
                if (TextUtils.isEmpty(password)){

                    UserPassword.setError("password is required");
                    return;

                }
                //if password is smaller than length display error
                if (password.length()< 8){

                    UserReenterPassword.setError("password >= 8 characters");
                    return;
                }
                //if re enter password is empty display error
                if (TextUtils.isEmpty(reenterPassword)){

                    UserReenterPassword.setError("please re-enter password");
                    return;

                }

                //if password matches then continue sign up process
                if (reenterPassword.equals(password)){
                    //check to see data base for email
                    fAuth.fetchSignInMethodsForEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                                @Override
                                public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {

                                    boolean isNewUser = task.getResult().getSignInMethods().isEmpty();
                                    // if the userEmail doesn't exist in the data base register account
                                    if (isNewUser) {
                                        fAuth.createUserWithEmailAndPassword(email,reenterPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                // if account is registered go to main page
                                                if(task.isSuccessful()){

                                                    Toast.makeText(register.this, "User Created", Toast.LENGTH_SHORT).show();
                                                    userID = fAuth.getCurrentUser().getUid();
                                                    DocumentReference documentReference = fStore.collection("users").document(userID);

                                                    Map<String,Object> user = new HashMap<>();
                                                    user.put("UserName:", username);
                                                    user.put("Admin:", Admin);
                                                    user.put("Email:", email);
                                                    user.put("Score:", Score);
                                                    user.put("PowerUp1:", PowerUP1);
                                                    user.put("PowerUp2:", PowerUP2);
                                                    user.put("PowerUp3:", PowerUP3);


                                                    documentReference.set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            Log.d(TAG,"user profile is created for "+ username);

                                                        }
                                                    }).addOnFailureListener(new OnFailureListener() {
                                                        @Override
                                                        public void onFailure(@NonNull Exception e) {
                                                            Log.d(TAG,"onFai1lure"+ e.toString());
                                                        }
                                                    });
                                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                                }
                                                // if account still isn't registered display error message
                                                else{

                                                    Toast.makeText(register.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                                }
                                            }
                                        });

                                    }
                                    // if Email exists in the Data base display error
                                    else {

                                        UserEmail.setError("Email already exists");
                                    }
                                }
                            });


                }
                // if password doesn't match display error
                else {

                    UserReenterPassword.setError("Password Doesn't match");
                }
                progressBar.setVisibility(View.VISIBLE);



            }
        });
        //Login button if account exists

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),SignIn.class));
            }
        });
    }
}