package com.example.winner_takes_all;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class changeUserName extends AppCompatActivity {

    FirebaseAuth auth;
    Button ChangeUserN;
    EditText changeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_user_name);

        final EditText ChangeUser=findViewById(R.id.CurrentUserName);
        final EditText password=findViewById(R.id.EnterPassW);

    }
}