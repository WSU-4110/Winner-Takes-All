package com.example.winner_takes_all;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Leaderboards extends AppCompatActivity {
    FirebaseAuth fAuth;
  /*  private RecyclerView recyclerView; */
    peopleAdapter adapter;
    DatabaseReference database;
    TextView UserName, Score;
    Button addScore, endScore;

    int score = 0;
    private Object User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserName = findViewById(R.id.UserName);
        Score = findViewById(R.id.Score);
        fAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_leaderboards);
        database = FirebaseDatabase.getInstance().getReference();


        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String currentid = user.getUid();
        DocumentReference reference;
        reference = firestore.collection("user").document(currentid);
        String nameResult = FirebaseFirestore.class.getName();


        UserName = (TextView) findViewById(R.id.UserName);
        Score = (TextView) findViewById(R.id.Score);
        addScore = (Button) findViewById(R.id.addScore);
        endScore = (Button) findViewById(R.id.endScore);

        UserName.setText("Username: " + User);

        Score.setText("SCORE: " + score);
        addScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                Score.setText("Score: " + score);
            }
        });

        endScore.setOnClickListener(new View.OnClickListener() {
            @Override
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


 /*   @Override protected void onStart() {
         // Best activity
        setContentView(R.layout.activity_leaderboard_history);
        super.onStart();
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        String currentid = user.getUid();
        DocumentReference reference;
        reference = firestore.collection("user").document(currentid);

        reference.get()
                .addOnCompleteListener(task -> {
                    if (task.getResult().exists()){
                        String nameResult = task.getResult().getString("Username");
                        String scoreResult = task.getResult().getString("Score");

                        fUser.setText(nameResult);
                        Score.setText(scoreResult);

                    }else{
                        Intent intent = new Intent(getApplicationContext(),people.class);
                        startActivity(intent);
                    }
                });
    }

    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    } */

}
