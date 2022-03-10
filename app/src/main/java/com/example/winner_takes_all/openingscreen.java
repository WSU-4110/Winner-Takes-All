package com.example.winner_takes_all;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class openingscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openingscreen);
    }

    public void signin_open(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);


        opensignin();
        toast.show();

    }

    public void signup_open(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);


        opensignup();

        toast.show();

    }

    public void opensignup(){
        Intent intent = new Intent(this, register.class);
        startActivity(intent);

    }



    public void opensignin(){
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);

    }
}