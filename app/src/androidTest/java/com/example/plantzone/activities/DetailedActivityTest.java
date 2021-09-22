package com.example.plantzone.activities;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

import android.app.Activity;
import android.view.View;

import androidx.test.rule.ActivityTestRule;

import com.example.plantzone.R;
import com.example.plantzone.models.ViewAllModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class DetailedActivityTest {

    @Rule
    public ActivityTestRule< DetailedActivity> detailedActivityTestRule= new ActivityTestRule< DetailedActivity>( DetailedActivity.class);

    DetailedActivity detailedActivity=null;
    ViewAllModel viewAllModel=null;


    @Before
    public void setUp() throws Exception {

        detailedActivity=detailedActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){

        View view=detailedActivity.findViewById(R.id.detailed_img);

        assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {
        detailedActivity=null;
    }
}