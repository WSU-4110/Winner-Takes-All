package com.example.winner_takes_all;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingUserNM extends AppCompatActivity {

    FirebaseAuth auth;
    Button changeuseremail;
    EditText changeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_user_nm);

        final EditText email=findViewById(R.id.Currentemail);
        final EditText password=findViewById(R.id.EnterPassW);

        changeuseremail=findViewById(R.id.ChangeEmailButton);
        changeuseremail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeUseremail(email.getText().toString(),password.getText().toString());
            }
        });
    }

    private void changeUseremail(String email, final String password) {
        changeText=findViewById(R.id.changeE);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        AuthCredential credential = EmailAuthProvider
                .getCredential(email,password);
        user.reauthenticate(credential)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        user.updateEmail(changeText.getText().toString())
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(SettingUserNM.this,
                                                    "Email Has Been Changed to " +
                                                            changeText.getText().toString(),Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                    }
                });
    }
}