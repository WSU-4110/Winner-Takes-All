package com.example.winner_takes_all;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firestore.v1.WriteResult;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ApiConnectionTest extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_connection_test);

    }

    public void showNBA(View view) {
        NBAButton();
    }

    public void showNFL(View view) {
        NFLButton();
    }

    public void showNHL(View view) {
        NHLButton();
    }

    public void showMLB(View view) {
        MLBButton();
    }


    public void NBAButton() {


        ArrayList<String> games = new ArrayList<String>();


        OkHttpClient client = new OkHttpClient();

        Date cdate = new Date();
        String CurrentDate = new SimpleDateFormat("yyyy-MM-dd").format(cdate);
        String URL = String.format("https://sportspage-feeds.p.rapidapi.com/games?league=NBA&date=%s", CurrentDate);

        Request request = new Request.Builder()
                //.url("https://sportspage-feeds.p.rapidapi.com/games?league=NBA&date=2022-02-15")
                .url(URL)
                .get()
                .addHeader("x-rapidapi-host", "sportspage-feeds.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "2ff220ae4bmshbac83d35a82e673p100415jsn8883f8b8d881")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
                call.cancel();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {


                if (response.isSuccessful()) {


                    final String myResponse = response.body().string();

                    ApiConnectionTest.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                            try {
                                JSONObject json = new JSONObject(myResponse);
                                JSONArray jarray = json.getJSONArray("results");


                                for (int i = 0; i < jarray.length(); i++) {
                                    JSONObject obj = jarray.getJSONObject(i);
                                    String match = obj.getString("summary");

                                    games.add(match);

                                }
                                PrintGames(games,"NBA");


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }
            }
        });

    }

    ;


    public void NFLButton() {
        ArrayList<String> games = new ArrayList<String>();

        OkHttpClient client = new OkHttpClient();

        Date cdate = new Date();
        String CurrentDate = new SimpleDateFormat("yyyy-MM-dd").format(cdate);
        String URL = String.format("https://sportspage-feeds.p.rapidapi.com/games?league=NFL&date=%s", CurrentDate);


        Request request = new Request.Builder()
                //.url("https://sportspage-feeds.p.rapidapi.com/games?league=NFL&date=2022-02-13")
                .url(URL)
                .get()
                .addHeader("x-rapidapi-host", "sportspage-feeds.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "2ff220ae4bmshbac83d35a82e673p100415jsn8883f8b8d881")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
                call.cancel();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                if (response.isSuccessful()) {

                    //String myResponse=response.toString();
                    final String myResponse = response.body().string();

                    ApiConnectionTest.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            try {
                                JSONObject json = new JSONObject(myResponse);
                                JSONArray jarray = json.getJSONArray("results");


                                for (int i = 0; i < jarray.length(); i++) {
                                    JSONObject obj = jarray.getJSONObject(i);
                                    String match = obj.getString("summary");

                                    games.add(match);

                                }
                                PrintGames(games,"NFL");


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }
            }
        });
    }

    ;

    public void NHLButton() {

        ArrayList<String> games = new ArrayList<String>();

        OkHttpClient client = new OkHttpClient();

        Date cdate = new Date();
        String CurrentDate = new SimpleDateFormat("yyyy-MM-dd").format(cdate);
        String URL = String.format("https://sportspage-feeds.p.rapidapi.com/games?league=NHL&date=%s", CurrentDate);

        Request request = new Request.Builder()
                //.url("https://sportspage-feeds.p.rapidapi.com/games?league=NHL&date=2022-02-15")
                .url(URL)
                .get()
                .addHeader("x-rapidapi-host", "sportspage-feeds.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "2ff220ae4bmshbac83d35a82e673p100415jsn8883f8b8d881")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
                call.cancel();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                if (response.isSuccessful()) {


                    final String myResponse = response.body().string();

                    ApiConnectionTest.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            try {
                                JSONObject json = new JSONObject(myResponse);
                                JSONArray jarray = json.getJSONArray("results");


                                for (int i = 0; i < jarray.length(); i++) {
                                    JSONObject obj = jarray.getJSONObject(i);
                                    String match = obj.getString("summary");

                                    games.add(match);

                                }
                                PrintGames(games,"NHL");


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }
            }
        });
    }



    public void MLBButton() {

        ArrayList<String> games = new ArrayList<String>();

        OkHttpClient client = new OkHttpClient();

        Date cdate = new Date();
        String CurrentDate = new SimpleDateFormat("yyyy-MM-dd").format(cdate);
        String URL = String.format("https://sportspage-feeds.p.rapidapi.com/games?league=MLB&date=%s", CurrentDate);

        Request request = new Request.Builder()
                //.url("https://sportspage-feeds.p.rapidapi.com/games?league=MLB&date=2021-10-15")
                .url(URL)
                .get()
                .addHeader("x-rapidapi-host", "sportspage-feeds.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "2ff220ae4bmshbac83d35a82e673p100415jsn8883f8b8d881")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
                call.cancel();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                if (response.isSuccessful()) {


                    final String myResponse = response.body().string();

                    ApiConnectionTest.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            try {
                                JSONObject json = new JSONObject(myResponse);
                                JSONArray jarray = json.getJSONArray("results");


                                for (int i = 0; i < jarray.length(); i++) {
                                    JSONObject obj = jarray.getJSONObject(i);
                                    String match = obj.getString("summary");

                                    games.add(match);

                                }
                                PrintGames(games,"MLB");


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }
            }
        });
    }

    ;


    public void PrintGames(ArrayList<String> games,String league ) {
        setContentView(R.layout.activity_api_connection_test);
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
        RadioGroup rg2 = new RadioGroup(this);
        rg2.setOrientation(LinearLayout.VERTICAL);
        //ArrayList<RadioButton> buttons = new ArrayList<RadioButton>();


        for (int i = 0; i < games.size(); i++) {

            RadioGroup rg = new RadioGroup(this);
            rg.setOrientation(LinearLayout.VERTICAL);

            RadioButton button = new RadioButton(this);
            RadioButton button2 = new RadioButton(this);
            button.setText("Home");
            button2.setText("Away");
            button.setId(View.generateViewId());
            button2.setId(View.generateViewId());
            TextView textbutton = new TextView(this);
            rg.addView(textbutton);
            rg.addView(button);
            rg.addView(button2);
            ///////////////////////////////////////////
            button.setTextColor(Color.rgb(0,0,0));
            button2.setTextColor(Color.rgb(0,0,0));
            button.setTextSize(20);

            button2.setTextSize(20);
            textbutton.setText(""+games.get(i));
            textbutton.setTextSize(25);

            textbutton.setTextColor(Color.rgb(17,92,86));
            /////////////////////////////////////////////////
            textbutton.setText("" + games.get(i));
            rg2.addView(rg);
        }

        layout.addView(rg2);


        if (games.isEmpty()) {
            TextView nogames = new TextView(this);
            nogames.setText("No Games today");
            layout.addView(nogames);
        } else {
            Button submit = new Button(this);
            submit.setText("Submit");
            submit.setBackgroundColor(Color.rgb(255,0,0));
            submit.setTextColor(Color.rgb(255,255,255));
            layout.addView(submit);
            //on click listner
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Store(rg2,league);
                }
            });
        }
    }


    public void Store(RadioGroup rg,String league) {

        //FirebaseFirestore fStore = FirebaseFirestore.getInstance();
        FirebaseAuth fAuth= FirebaseAuth.getInstance();
        String userID = fAuth.getCurrentUser().getUid();
        FirebaseFirestore db =FirebaseFirestore.getInstance();
        ArrayList<String> ChoicesArray = new ArrayList<String>();

        int count = rg.getChildCount();

        for (int i = 0; i < count; i++) {
            View o = rg.getChildAt(i);


            if (o instanceof RadioGroup) {
                for (int y = 0; y < ((RadioGroup) o).getChildCount(); y++) {
                    View inside = ((RadioGroup) o).getChildAt(y);
                    if (inside instanceof RadioButton) {
                        if (((RadioButton) inside).isChecked()) {
                            String choice = ((RadioButton) inside).getText().toString();
                            ChoicesArray.add(choice);
                        }

                    }
                }
            }

        }

        System.out.println(ChoicesArray.size());

        System.out.println("hello");

        if(league=="NBA")
        {
            DocumentReference documentReference = db.collection("users").document(userID);
            Map<String, Object> updates = new HashMap<>();
            //Collections.addAll(ChoicesArray);
            updates.put("NBA", ChoicesArray);
            documentReference.update(updates);



        }

        if(league=="NFL")
        {
            DocumentReference documentReference = db.collection("users").document(userID);
            Map<String, Object> updates = new HashMap<>();
            //Collections.addAll(ChoicesArray);
            updates.put("NFL", ChoicesArray);
            documentReference.update(updates);

        }
        if(league=="NHL")
        {
            DocumentReference documentReference = db.collection("users").document(userID);
            Map<String, Object> updates = new HashMap<>();
            //Collections.addAll(ChoicesArray);
            updates.put("NHL", ChoicesArray);
            documentReference.update(updates);
        }
        if(league=="MLB")
        {
            DocumentReference documentReference = db.collection("users").document(userID);
            Map<String, Object> updates = new HashMap<>();
            //Collections.addAll(ChoicesArray);
            updates.put("MLB", ChoicesArray);
            documentReference.update(updates);

        }





        }


    }


