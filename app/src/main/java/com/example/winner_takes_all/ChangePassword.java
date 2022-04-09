package com.example.winner_takes_all;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ChangePassword extends AppCompatActivity {

    FirebaseAuth auth;
    ProgressDialog dialog;
    private FirebaseAuth mAuth;
    TextView Cpass;
    public ProgressDialog login;
    ProgressDialog load;

    //main
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        dialog = new ProgressDialog(this);
        auth = FirebaseAuth.getInstance();
        mAuth = FirebaseAuth.getInstance();

        getSupportActionBar().setTitle("Login");
        Cpass=findViewById(R.id.button6);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        login=new ProgressDialog(this);
        Cpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //resetPassword;
            }
        });

    }




    //new class to reset the password and send dialog
    class resetPassword{
        private void PasswordResetDialog() {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("Enter Email");
            LinearLayout linearLayout=new LinearLayout(this);
            final EditText emailtext= new EditText(this);
            emailtext.setText("");
            emailtext.setMinEms(16);
            emailtext.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
            linearLayout.addView(emailtext);
            linearLayout.setPadding(15,15,15,15);
            builder.setView(linearLayout);
            builder.setPositiveButton("Change", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String emaill=emailtext.getText().toString().trim();
                    ChangePass(emaill);
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.create().show();
        }
    }


    //new class to change the password to a new one
    class changepass{
        private void ChangePass(String emailUser) {
            //load=new ProgressDialog(this);
            load.setMessage("Sending Reset Email");
            load.setCanceledOnTouchOutside(false);
            load.show();
            mAuth.sendPasswordResetEmail(emailUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    load.dismiss();
                    if(task.isSuccessful())
                    {
                        Toast.makeText(ChangePassword.this,"Sent Email",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(ChangePassword.this,"Error",Toast.LENGTH_LONG).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception error) {
                    load.dismiss();
                    Toast.makeText(ChangePassword.this,"Error",Toast.LENGTH_LONG).show();
                }
            });
        }
    }

}