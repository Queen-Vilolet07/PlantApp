package com.example.plantzone.activities;

import static org.junit.Assert.*;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import com.example.plantzone.R;
import com.example.plantzone.models.ViewAllModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class NavCategoryActivityTest {

    @Rule
    public ActivityTestRule< NavCategoryActivity> navCategoryActivityTestRule= new ActivityTestRule< NavCategoryActivity>(NavCategoryActivity.class);

    NavCategoryActivity navCategoryActivity=null;


    @Before
    public void setUp() throws Exception {

        navCategoryActivity=navCategoryActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){

        View view=navCategoryActivity.findViewById(R.id.nav_cat_det_rec);

        assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {
        navCategoryActivity=null;
    }
}