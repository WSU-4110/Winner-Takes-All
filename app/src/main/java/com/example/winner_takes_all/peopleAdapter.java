package com.example.winner_takes_all;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class peopleAdapter extends FirebaseRecyclerAdapter<
        people, peopleAdapter.personsViewholder> {

    public peopleAdapter(
            @NonNull FirebaseRecyclerOptions<people> options)
    {
        super(options);
    }
    @Override
    protected void
    onBindViewHolder(@NonNull personsViewholder holder,
                     int position, @NonNull people model)
    {
        holder.Email.setText(model.getEmail());
        holder.Username.setText(model.getUsername());
        holder.Score.setText(model.getScore());
    }
    @NonNull
    @Override
    public personsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.people, parent, false);
        return new peopleAdapter.personsViewholder(view);
    }

    class personsViewholder
            extends RecyclerView.ViewHolder {
        TextView Email, Username, Score;
        public personsViewholder(@NonNull View itemView)
        {
            super(itemView);
            Email = itemView.findViewById(R.id.email);
            Username = itemView.findViewById(R.id.UserName);
            Score = itemView.findViewById(R.id.Score);
        }
    }
}
