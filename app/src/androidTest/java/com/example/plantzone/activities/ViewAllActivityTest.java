package com.example.plantzone.activities;

import static org.junit.Assert.*;


import android.view.View;


import androidx.test.rule.ActivityTestRule;

import com.example.plantzone.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ViewAllActivityTest {

    @Rule
    public ActivityTestRule< ViewAllActivity> viewAllActivityTestRule= new ActivityTestRule< ViewAllActivity>( ViewAllActivity.class);

    ViewAllActivity  viewAllActivity=null;


    @Before
    public void setUp() throws Exception {

        viewAllActivity=viewAllActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){

        View view=viewAllActivity.findViewById(R.id.view_all_rec);

        assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {
        viewAllActivity=null;
    }
}