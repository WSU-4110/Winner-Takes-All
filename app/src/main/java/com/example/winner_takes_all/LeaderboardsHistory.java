
package com.example.winner_takes_all;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.Arrays;

public class LeaderboardsHistory extends AppCompatActivity {
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    TextView UserName, Score, YourScore, UserI, TheirScore;
    int lastScore;
    int best1, best2, best3;
    int score = lastScore;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_history);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        UserI = findViewById(R.id.useRID);
        userID = fAuth.getCurrentUser().getUid();
        UserName = findViewById(R.id.Name);
        Score = findViewById(R.id.Score);
        YourScore = findViewById(R.id.YourScore);
        TheirScore = findViewById(R.id.TheirScore);

        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                lastScore = preferences.getInt("lastScore", 0);
                best1 = preferences.getInt("best1", 0);
                best2 = preferences.getInt("best2", 0);
                best3 = preferences.getInt("best3", 0);

                /* UserName.setText(value.getString("UserName:"));
                Score.setText("Score: " + score);
                UserName.setText(value.getString("UserName:"));
                Score.setText("Score: " + score); */

                YourScore.setText(value.getString("UserName:") + "'s " + ("Score: " + lastScore));
                /* TheirScore.setText(value.getString("UserName:")+ "'s " + ("Score: " + score)); */

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
