package com.example.winner_takes_all;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;

public class Leaderboards extends AppCompatActivity {
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;

    private RecyclerView recyclerView;
    peopleAdapter adapter;
    DatabaseReference database;
    ImageView imageView;
    TextView UserName, Score;
    Button addScore, endScore;
    int score = 0;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboards);
        UserName = findViewById(R.id.UserName);
        Score = findViewById(R.id.Score);
        addScore = (Button) findViewById(R.id.addScore);
        endScore = (Button) findViewById(R.id.endScore);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        database = FirebaseDatabase.getInstance().getReference();

        userId = fAuth.getCurrentUser().getUid();
        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException error) {

                UserName.setText(documentSnapshot.getString("UserName" + userId)); /* + User */
                Score.setText(documentSnapshot.getString("Score" + score));
                /* Buttons for add score & end score. Change these to score values later */
                UserName.setText("UserName: " + userId);
                Score.setText("Score: " + score);
                addScore.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        score++;
                        UserName.setText("UserName: " + userId);
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

