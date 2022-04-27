package com.example.winner_takes_all;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leaderboards extends AppCompatActivity {
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    CollectionReference users = fStore.collection("users");


    ArrayList<String> details=new ArrayList<>();
    int Rank = 0;
    FirebaseAuth fAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_leaderboards);

        fAuth = FirebaseAuth.getInstance();

        DocumentReference objectDocumentReference;

        objectDocumentReference = fStore.collection("users").document(fAuth.getCurrentUser().getUid());

        FirebaseApp.initializeApp(this);
        final ListView listView=(ListView)findViewById(R.id.listView);
        users.orderBy("Score:", Query.Direction.DESCENDING).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot queryDocumentSnapshot : queryDocumentSnapshots) {
                    Rank = Rank + 1;
                    people people = queryDocumentSnapshot.toObject(people.class);

                    details.add(queryDocumentSnapshot.getString("UserName:") + "\n" + "Score:" + queryDocumentSnapshot.get("Score:") + "\n" + "Current Rank: " +  Rank + "\n");

                    if (Rank == 1 ){



                    }
                    else if (Rank == 2){


                    }
                    else if (Rank == 3){



                    }


                    ArrayAdapter<String> adapter = new ArrayAdapter<>(Leaderboards.this, R.layout.list_item, details);
                    listView.setAdapter(adapter);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Leaderboards.this, "An Error Occurred", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
