package com.example.winner_takes_all;

import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import junit.framework.TestCase;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class deleteAccountTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();

        String user = "test@gmail.com";
        String alternateUser = "user@gmail.com";


    }

    public void tearDown() throws Exception {
    }

    @Test
    public void testOnCreate() {
        final String email="userName";
        final String password="password";

        int length =    password.length();
        int lengthVal = 8;
        assertEquals(length,lengthVal);

        int length1 =    email.length();
        int lengthVal1 = 8;
        assertEquals(length1,lengthVal1);

    }

    @Test
    public void testdeletea(){
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String other = "user@gmail.com";
        assertEquals(other,user);

    }

    @Test
    public void testOnClick() {
        String user = "testUser";
        user.getBytes(StandardCharsets.UTF_8);
        String password = "testPass";
            int length =    password.length();
            int lengthVal = 8;
        assertEquals(length,lengthVal);
    }

    @Test
    public void testOnComplete() {
        boolean task1 = false;
        boolean task2 = true;

        assertEquals(task1,task2);
    }
}