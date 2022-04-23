package com.example.winner_takes_all;

import android.content.Intent;
import android.widget.Button;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class SettingsTest extends TestCase {

    private MainActivity mainActivity;
    private Button main;
    private Button main1;
    private Button main2;
    private Button main3;
    private Button main4;
    private Button main5;

    @Before
    public void setUp() throws Exception {
        main = (Button) mainActivity.findViewById(R.id.button);
    }
//-----------------------------------------------------------------------------
    @Test
    public void opensetuser() {
        //final boolean launchIntent = main.callOnClick();
        main = (Button) mainActivity.findViewById(R.id.button);
        //main1.callOnClick();
        assert main.callOnClick();
    }

    @Test
    public void changepass() {
        main1 = (Button) mainActivity.findViewById(R.id.button);
        //main1.callOnClick();
        assert main.callOnClick();
    }

    @Test
    public void changeTheme() {
        main2 = (Button) mainActivity.findViewById(R.id.button2);
        assert main2.callOnClick();
    }

    @Test
    public void deleteAccount() {
        main3 = (Button) mainActivity.findViewById(R.id.button3);
        assert main3.callOnClick();
    }

    @Test
    public void profile() {
        main4 = (Button) mainActivity.findViewById(R.id.button4);
        assert  main4.callOnClick();
    }

    @Test
    public void changeUserName() {
        main5 = (Button) mainActivity.findViewById(R.id.button5);
        assert main5.callOnClick();
    }
}