package com.example.winner_takes_all;

import com.google.firebase.database.Exclude;

import java.util.List;

public class people {
    private String documentId;
    String Email;
    String UserName;
    int Score;
    List<String> details;

    public people(){ }

    public people(String UserName, int Score, List<String> details){
        this.UserName = UserName;
        this.Score = Score;
        this.details = details;
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

}
