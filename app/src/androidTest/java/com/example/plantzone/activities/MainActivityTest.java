package com.example.plantzone.activities;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import androidx.test.rule.ActivityTestRule;

import com.example.plantzone.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> MainActivityTestRule= new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mainActivity=null;


    @Before
    public void setUp() throws Exception {
        mainActivity=MainActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){

        assertNotNull(mainActivity.findViewById(R.id.scroll_view));
    }

    @Test
    public void testLaunchOfAppBarMain(){

        assertNotNull(mainActivity.findViewById(R.id.app_bar_main));
    }

    @After
    public void tearDown() throws Exception {
        mainActivity=null;
    }
}