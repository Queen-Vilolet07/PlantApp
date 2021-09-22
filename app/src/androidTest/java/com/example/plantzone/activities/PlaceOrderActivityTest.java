package com.example.plantzone.activities;

import static org.junit.Assert.*;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import com.example.plantzone.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class PlaceOrderActivityTest {

    @Rule
    public ActivityTestRule< PlaceOrderActivity> placeOrderActivityTestRule= new ActivityTestRule< PlaceOrderActivity>(PlaceOrderActivity.class);

    PlaceOrderActivity placeOrderActivity=null;


    @Before
    public void setUp() throws Exception {

        placeOrderActivity=placeOrderActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){

        View view=placeOrderActivity.findViewById(R.id.imageView7);

        assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {
        placeOrderActivity=null;
    }
}