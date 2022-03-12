package com.example.winner_takes_all;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    // Realtime Database setup 1
    DatabaseReference databaseReference;
    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    // Create a new user with a first and last name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("this will show on firebase path");
        databaseReference.setValue("hello there").addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show(); // Could put success text
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
              /*  Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show(); Could put failed text */
            }
        }).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) { // W7hen it's done
                if (task.isSuccessful()) {
                   /* Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show(); */
                } else {
                   /* Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show(); */
                }

            }
        });
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
        //openserv();
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

   /* public void openserv(){
        Intent intent = new Intent(this, servers.class);
        startActivity(intent);

    }*/

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
