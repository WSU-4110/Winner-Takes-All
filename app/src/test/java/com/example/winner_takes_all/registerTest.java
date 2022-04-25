package com.example.winner_takes_all;

import junit.framework.TestCase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;



public class registerTest extends TestCase {

    public void testOnCreate() {

        final String email="userName";
        final String password="password";
        // runs test to check password legnth matches
        int length =    password.length();
        int lengthVal = 8;
        //length
        assertEquals(length,lengthVal);

        // runs test to check email legnth matches
        int length1 =    email.length();
        int lengthVal1 = 8;
        assertEquals(length1,lengthVal1);

        // runs test to check username legnth matches
        final String Username = "NAMEUSER";

        int length2 = Username.length();
        int lengthval2 = 8;
        assertEquals(length2,lengthval2);
        // runs test to check password legnth matches reenterpassword
        final String ReenterPassword = "password";
        int length3 = ReenterPassword.length();
        assertEquals(length3,lengthVal);

        //if password legnth not eqaul throw out error
        if (password.length() < ReenterPassword.length() || password.length() > ReenterPassword.length() )
            throw new IllegalArgumentException(password);


        //if email has no value
        if (email.length() == 0 )
            throw new IllegalArgumentException(password);

        //if username has no value
        if (Username.length() == 0 )
            throw new IllegalArgumentException(password);

        //if reenterpassword has no value
        if (ReenterPassword.length() == 0 )
            throw new IllegalArgumentException(password);

        //if password has no value
        if (password.length() == 0 )
            throw new IllegalArgumentException(password);





    }

    }




