package com.example.winner_takes_all;

public class people {
    private String Email;
    private String UserName = "UserName";
    private String Score = "Score";
    public people() {}

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
        this.UserName = user;
    }

    public String getScore()
    {
        return Score;
    }
    public void setScore(String score)
    {
        this.Score = score;
    }

}
