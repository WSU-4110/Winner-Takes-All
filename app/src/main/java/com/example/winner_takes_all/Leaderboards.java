package com.example.winner_takes_all;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;



public class Leaderboards extends AppCompatActivity {
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    TextView UserName, Score, UserI; // check this
    Button addScore, endScore;
    int score = 0;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboards);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        UserI = findViewById(R.id.useRID);
        userID = fAuth.getCurrentUser().getUid();
        UserName = findViewById(R.id.Name);
        Score = findViewById(R.id.Score);
        addScore = (Button) findViewById(R.id.addScore);
        endScore = (Button) findViewById(R.id.endScore);

        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                UserName.setText(value.getString("UserName:"));
                Score.setText("Score: " + score);
/* value.getString( */
                addScore.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        score++;
                        UserName.setText(value.getString("UserName:"));
                        Score.setText("Score: " + score);
                    }
                });

                endScore.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putInt("lastScore", score);
                        editor.apply();
                        Intent intent = new Intent(getApplicationContext(), LeaderboardsHistory.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        });
    }
}

