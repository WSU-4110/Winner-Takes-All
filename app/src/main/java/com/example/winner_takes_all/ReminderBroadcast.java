package com.example.winner_takes_all;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class ReminderBroadcast extends IntentService
{
    public ReminderBroadcast() {
        super("MyTestService");
    }

    public void profile(){
        Intent intent = new Intent (this, ApiConnectionTest.class);
        startActivity(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Do the task here
        Log.i("MyTestService", "Service running");


    }


}