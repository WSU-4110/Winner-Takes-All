package com.example.winner_takes_all;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ReminderBroadcast extends IntentService {
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    CollectionReference users = fStore.collection("users");
    ArrayList<String> mlbdetails = new ArrayList<>();



    public ReminderBroadcast() {
        super("MyTestService");
    }
    public void profile(){
        Intent intent = new Intent (this, ApiConnectionTest.class);
        startActivity(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Do the task here
        Log.i("MyTestService", "Service running");

    }
    /*
    protected void onCreate(Bundle savedInstanceState){
        FirebaseApp.initializeApp(this);
        users.orderBy("MLB", Query.Direction.DESCENDING).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for(QueryDocumentSnapshot queryDocumentSnapshot:queryDocumentSnapshots)
                {
                    people people=queryDocumentSnapshot.toObject(people.class);
                    mlbdetails.add(queryDocumentSnapshot.getString("MLB"));
               NEED TO COMMENT OUT, EXPERIMENTAL     mlbdetails.add((String) queryDocumentSnapshot.get("MLB"));
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ReminderBroadcast.this, "An Error Occurred", Toast.LENGTH_SHORT).show();
            }
        });
    }
    */
}

