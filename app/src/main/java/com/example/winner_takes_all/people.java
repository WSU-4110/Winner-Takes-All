package com.example.winner_takes_all;

import android.widget.ArrayAdapter;

import com.google.firebase.database.Exclude;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class people {
    private String documentId;
    String Email;
    String UserName;
    int Score;
    List<String> details;

    ArrayList<String> mlbdetails;
    List<String> nhldetails;
    List<String> nfldetails;
    List<String> nbadetails;

    public people(){ }

    public people(String UserName, int Score, List<String> details, ArrayList<String> mlbdetails){
        this.UserName = UserName;
        this.Score = Score;
        this.details = details;
        this.mlbdetails = mlbdetails;
    }


    @Exclude
    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getEmail()
    {
        return Email;
    }
    public void setEmail(String email)
    {
        this.Email = email;
    }

    public String getUsername() { return UserName; }

    public void setUsername(String user)
    {
        this.UserName = UserName;
    }

    public int getScore()
    {
        return Score;
    }
    public void setScore(int score)
    {
        this.Score = score;
    }

    public List<String> details(){
        return details;
    }

    public ArrayList<String> mlb_api() {return mlbdetails;}
    public List<String> nba_api() {return nbadetails;}
    public List<String> nhl_api() {return nhldetails;}
    public List<String> nfl_api() {return nfldetails;}
}
