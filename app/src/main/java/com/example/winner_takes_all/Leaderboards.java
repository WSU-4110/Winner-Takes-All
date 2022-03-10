package com.example.winner_takes_all;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Leaderboards extends AppCompatActivity {

    private RecyclerView recyclerView;
    peopleAdapter adapter;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboards);

        database = FirebaseDatabase.getInstance().getReference();

        recyclerView = findViewById(R.id.List1);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));

        FirebaseRecyclerOptions<people> options
                = new FirebaseRecyclerOptions.Builder<people>()
                .setQuery(database, people.class)
                .build();
        adapter = new peopleAdapter(options);
        recyclerView.setAdapter(adapter);
    }
    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }
    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }
}
