package com.example.winner_takes_all;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    //private Button button5;
    private Button button7;
    private Button button8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        button = (Button) findViewById(R.id.chnguser);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensetuser();
            }
        });

        button1 = (Button) findViewById(R.id.Chngpass);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changepass();
            }
        });

        button2 = (Button) findViewById(R.id.theme);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTheme();
            }
        });

        button3 = (Button) findViewById(R.id.DeleteAccount);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAccount();
            }
        });

        button4 = (Button) findViewById(R.id.retrievedata);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile();
            }
        });

/*        button5 = (Button) findViewById(R.id.TeamNames);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeUserName();
            }
        });*/
        button7 = (Button) findViewById(R.id.ChangeUSN);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeUser();
            }
        });
    }
    public void opensetuser(){
        Intent intent = new Intent (this, SettingUserNM.class);
        startActivity(intent);
    }
    public void changepass(){
        Intent intent = new Intent (this, ChangePassword.class);
        startActivity(intent);
    }
    public void changeTheme(){
        Intent intent = new Intent (this, Theme.class);
        startActivity(intent);
    }
    public void deleteAccount(){
        Intent intent = new Intent (this, deleteAccount.class);
        startActivity(intent);
    }

    public void profile(){
        Intent intent = new Intent (this, retrieveuserdata.class);
        startActivity(intent);
    }

/*    public void ChangeUserName(){
        Intent intent = new Intent (this, changeUserName.class);
        startActivity(intent);
    }*/

    public void ChangeUser(){
        Intent intent = new Intent (this, ChangeUserN.class);
        startActivity(intent);
    }



}