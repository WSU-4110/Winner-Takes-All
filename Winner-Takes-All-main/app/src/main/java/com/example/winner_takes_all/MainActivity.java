package com.example.winner_takes_all;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);


        openNewActivity();
        toast.show();

    }

    public void showToastserv(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);


        openserv();
        toast.show();

    }

    public void showToastrank(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);


        openrank();
        toast.show();

    }

    public void showToastleads(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);


        openleads();
        toast.show();

    }

    public void showApi(View view)
    {
        Toast toast = Toast.makeText(this,"New Page!", Toast.LENGTH_SHORT);

        openApi();
        toast.show();
    }




    public void openNewActivity(){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);

    }

    public void openserv(){
        Intent intent = new Intent(this, servers.class);
        startActivity(intent);

    }

    public void openrank(){
        Intent intent = new Intent(this, Rankings.class);
        startActivity(intent);

    }

    public void openleads(){
        Intent intent = new Intent(this, Leaderboards.class);
        startActivity(intent);

    }

    public void openApi(){
        Intent intent =new Intent(this,ApiConnectionTest.class);
        startActivity(intent);
    }
}
