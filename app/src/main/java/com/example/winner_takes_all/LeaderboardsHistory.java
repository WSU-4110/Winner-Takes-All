package com.example.winner_takes_all;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class LeaderboardsHistory extends AppCompatActivity {
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;

    private RecyclerView recyclerView;
    DatabaseReference database;
    TextView UserName, Score, YourScore;
    int lastScore;
    int best1, best2, best3;
    int score = lastScore;


    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_history);
        UserName = findViewById(R.id.UserName);
        Score = findViewById(R.id.Score);
        YourScore = findViewById(R.id.YourScore);


        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        database = FirebaseDatabase.getInstance().getReference();
        // load previous score history
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        lastScore = preferences.getInt("lastScore", 0); /* the score you just got */
        best1 = preferences.getInt("best1", 0);
        best2 = preferences.getInt("best2", 0);
        best3 = preferences.getInt("best3", 0);

        userId = fAuth.getCurrentUser().getUid();
        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @SuppressLint("SetTextI18n")
            public void onEvent (DocumentSnapshot documentSnapshot, FirebaseFirestoreException error){
                UserName.setText(documentSnapshot.getString("UserName" + userId));
                Score.setText(documentSnapshot.getString("Score" + score));
          /*      best1.orderBy(Score).limit(3); */


                // replace scores if new highscore
                if(lastScore > best3){
                    best3 = lastScore;
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt("best3", best3);
                    editor.apply();
                }
                if(lastScore > best2){
                    int temp = best2;
                    best2 = lastScore;
                    best3 = temp;
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt("best3", best3);
                    editor.putInt("best2", best2);
                    editor.apply();
                }
                if(lastScore > best1){
                    int temp = best1;
                    best1 = lastScore;
                    best2 = temp;
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt("best2", best2);
                    editor.putInt("best1", best1);
                    editor.apply();
                }
                // displays your userid and score
                YourScore.setText("UserName: " + userId + ":" + "\n" +
                        " Your Score: " + lastScore + "\n"
                );
                // displays top scores
                Score.setText("#1 on app: " + best1 + "\n" +
                        "#2 on app: " + best2 + "\n" +
                        "#3 on app: " + best3);

            }
        });
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(getApplicationContext(), Leaderboards.class);
        startActivity(intent);
        finish();
    }
}
