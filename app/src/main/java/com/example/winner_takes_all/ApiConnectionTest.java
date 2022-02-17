package com.example.winner_takes_all;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

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


        mTextView=findViewById(R.id.textView);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://sportspage-feeds.p.rapidapi.com/games?date=2022-02-15")
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

                if (response.isSuccessful())
                {

                    //String myResponse=response.toString();
                    final String myResponse=response.toString();

                    ApiConnectionTest.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //mTextView.setText(myResponse);
                            //mTextView.setText(response);
                            //System.out.println(response.body().toString());
                           try {
                            JSONObject json = new JSONObject(myResponse);
                            mTextView.setText(json.toString());
                            } catch (JSONException e) {
                               e.printStackTrace();
                           }

                        }
                    });
                }
            }
        });

    }
}