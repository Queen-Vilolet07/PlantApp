package com.example.plantzone.activities;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertNotNull;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import androidx.test.rule.ActivityTestRule;

import com.example.plantzone.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class WelcomeActivityTest {

    @Rule
    public ActivityTestRule<WelcomeActivity> welcomeActivityActivityTestRule= new ActivityTestRule<WelcomeActivity>(WelcomeActivity.class);

    private WelcomeActivity welcomeActivity=null;

    Instrumentation.ActivityMonitor monitor=getInstrumentation().addMonitor(LoginActivity.class.getName(),null,false);
    Instrumentation.ActivityMonitor monitor2=getInstrumentation().addMonitor(RegistrationActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        welcomeActivity=welcomeActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){

        View view=welcomeActivity.findViewById(R.id.textView2);
        assertNotNull(view);
    }

    @Test
    public void testLaunchOfLogInButton(){

        assertNotNull(welcomeActivity.findViewById(R.id.LogIn_wel));

        onView(withId(R.id.LogIn_wel)).perform(click());
        Activity LoginActivity=getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(LoginActivity);
        LoginActivity.finish();
    }

    @Test
    public void testLaunchOfRegisterButton(){

        assertNotNull(welcomeActivity.findViewById(R.id.Register_wel));

        onView(withId(R.id.Register_wel)).perform(click());
        Activity rActivity=getInstrumentation().waitForMonitorWithTimeout(monitor2,5000);
        assertNotNull(rActivity);
        rActivity.finish();
    }


    @After
    public void tearDown() throws Exception {
        welcomeActivity=null;
    }
}