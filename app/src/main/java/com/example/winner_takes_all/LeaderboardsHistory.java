package com.example.winner_takes_all;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LeaderboardsHistory extends AppCompatActivity {

    TextView Score;
    int lastScore;
    int best1, best2, best3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_history);

        Score = (TextView) findViewById(R.id.Score);
        // load previous score history
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        lastScore = preferences.getInt("lastScore", 0);
        best1 = preferences.getInt("best1", 0);
        best2 = preferences.getInt("best2", 0);
        best3 = preferences.getInt("best3", 0);

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

        // display scores
        Score.setText("LAST SCORE: " + lastScore + "\n" +
        "BEST1: " + best1 + "\n" +
                "BEST2: " + best2 + "\n" +
                "BEST3: " + best3);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(getApplicationContext(), Leaderboards.class);
        startActivity(intent);
        finish();
    }
}
