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

public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityActivityTestRule= new ActivityTestRule<LoginActivity>(LoginActivity.class);

    private LoginActivity loginActivity=null;

    Instrumentation.ActivityMonitor monitor=getInstrumentation().addMonitor(RegistrationActivity.class.getName(),null,false);
    Instrumentation.ActivityMonitor monitor2=getInstrumentation().addMonitor(MainActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        loginActivity=loginActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){

        View view=loginActivity.findViewById(R.id.imageView3);
        assertNotNull(view);
    }

    @Test
    public void testLaunchOfSignInButton(){

        assertNotNull(loginActivity.findViewById(R.id.button_log));
        onView(withId(R.id.email_log)).perform(typeText("munmun07@gmail.com"));
        onView(withId(R.id.password_log)).perform(typeText("123456"));
        onView(withId(R.id.button_log)).perform(click());
        Activity mainActivity=getInstrumentation().waitForMonitorWithTimeout(monitor2,5000);
        assertNotNull(mainActivity);
        mainActivity.finish();
    }

    @Test
    public void testLaunchOfRegisterButton(){

        assertNotNull(loginActivity.findViewById(R.id.reg_log));

        onView(withId(R.id.reg_log)).perform(click());
        Activity rActivity=getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(rActivity);
        rActivity.finish();
    }


    @After
    public void tearDown() throws Exception {
        loginActivity=null;
    }
}