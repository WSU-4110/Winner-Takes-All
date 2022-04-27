package com.example.winner_takes_all;

import androidx.appcompat.app.AppCompatActivity;
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

import android.os.Bundle;

public class Rankings extends AppCompatActivity {

    FirebaseAuth  fAuth = FirebaseAuth.getInstance();
    Button PowerUP1, PowerUp2, PowerUp3;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankings);
        fAuth = FirebaseAuth.getInstance();
        PowerUP1 = findViewById(R.id.button_kaboom);
        PowerUp2 = findViewById(R.id.button_Bang);
        PowerUp3 = findViewById(R.id.buton_pop);
        String userID = fAuth.getCurrentUser().getUid();
        DocumentReference docRef = fStore.collection("users").document(userID);

        docRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                int PowerUP1Amount = value.getLong("PowerUp1:").intValue();
                int PowerUP2Amount = value.getLong("PowerUp2:").intValue();
                int PowerUP3Amount = value.getLong("PowerUp3:").intValue();
                int Score = value.getLong("Score:").intValue();

                if (PowerUP1Amount != 0) {
                    PowerUP1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                                    Toast.makeText(Rankings.this,"Kaboom Powerup Detected Adding 10 to score",Toast.LENGTH_SHORT).show();
                                    int ScoreUpdated  = Score + 10;
                                    int r = PowerUP1Amount - 1;
                                   docRef.update("Score:", ScoreUpdated);
                                   docRef.update("PowerUp1:", r);
                            }

                    });
                }
                else if (PowerUP1Amount == 0) {

                    PowerUP1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(Rankings.this,"No Kaboom Powerups",Toast.LENGTH_SHORT).show();
                        }

                    });


                }
                if (PowerUP2Amount != 0) {
                    PowerUp2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(Rankings.this,"Bang Powerup Detected Adding 5 to score",Toast.LENGTH_SHORT).show();
                            int ScoreUpdated  = Score + 5;
                            int r = PowerUP2Amount - 1;
                            docRef.update("Score:", ScoreUpdated);
                            docRef.update("PowerUp2:", r);

                        }
                    });
                }
                else if (PowerUP2Amount == 0) {

                    PowerUp2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(Rankings.this,"No bang Powerups",Toast.LENGTH_SHORT).show();
                        }
                    });


                }
                if (PowerUP3Amount != 0) {
                   PowerUp3.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           Toast.makeText(Rankings.this,"Pop Powerup Detected Adding 3 to score",Toast.LENGTH_SHORT).show();
                           int ScoreUpdated  = Score + 3;
                           int r = PowerUP3Amount - 1;
                           docRef.update("Score:", ScoreUpdated);
                           docRef.update("PowerUp3:", r);
                       }
                   });
                }
                else if (PowerUP3Amount == 0) {

                  PowerUp3.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                          Toast.makeText(Rankings.this,"No Pop Powerups",Toast.LENGTH_SHORT).show();
                      }
                  });


                }
            }
        });






    }
}