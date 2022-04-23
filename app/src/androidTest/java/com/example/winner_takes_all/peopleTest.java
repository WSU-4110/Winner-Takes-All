package com.example.winner_takes_all;

import junit.framework.TestCase;

import org.junit.Before;

import java.util.List;

public class peopleTest extends TestCase {
    private String documentId;
    String Email;
    String UserName;
    int Score;
    List<String> details;
    private people Email1;
    private people doc1;
    private people UserName1;
    private people Score1;
    private people details1;

    public void testGetDocumentId() {
        String actual = doc1.getDocumentId();
        String expected = documentId;
        assertEquals(expected, actual);
    }

    public void testSetDocumentId() {
        assertEquals(documentId, doc1);
        doc1.setDocumentId(documentId);
    }

    public void testGetEmail() {
        String actual = Email1.getEmail();
        String expected = Email;
        assertEquals(expected,actual);
    }

    public void testSetEmail() {
        assertEquals(Email, Email1);
        Email1.setEmail(Email);
    }

    public void testGetUsername() {
        String actual = UserName1.getUsername();
        String expected = UserName;
        assertEquals(expected, actual);
    }

    public void testSetUsername(){
        assertEquals(UserName, UserName1);
        UserName1.setUsername(UserName);
    }

    public void testGetScore() {
        int actual = Score1.getScore();
        int expected = Score;
        assertEquals(expected, actual);
    }

    public void testSetScore() {
        assertEquals(Score,Score1);
        Score1.setScore(Score);
    }

    public void testDetails() {
        List<String> actual = details1.details();
        List<String> expected = details;
        assertEquals(expected,actual);
    }
}