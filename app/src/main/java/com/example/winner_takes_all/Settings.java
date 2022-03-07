package com.example.winner_takes_all;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Settings extends AppCompatActivity {

    private Button button;
    private Button button1;
    private Button button2;
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

        button2 = (Button) findViewById(R.id.Theme);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTheme();
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
}