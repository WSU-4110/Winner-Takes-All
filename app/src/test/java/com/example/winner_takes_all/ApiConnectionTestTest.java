package com.example.winner_takes_all;



import static com.google.common.base.Verify.*;
import static org.junit.jupiter.api.Assertions.*;

import org.testng.IMethodInstance;
import org.testng.annotations.Test;

class ApiConnectionTestTest {

    @Test
    public void showNBA() {

        showNBA();
    }

    @Test
    void showNFL() {
        showNFL();
    }

    @Test
    void showNHL() {
        showNHL();
    }

    @Test
    void showMLB() {
        showMLB();
    }

    @Test
    void NBAButton() {
        NBAButton();
    }
}