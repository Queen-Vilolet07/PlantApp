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

public class RegistrationActivityTest {

    @Rule
    public ActivityTestRule<RegistrationActivity> registrationActivityTestRule= new ActivityTestRule<RegistrationActivity>(RegistrationActivity.class);

    private RegistrationActivity registrationActivity=null;

    Instrumentation.ActivityMonitor monitor=getInstrumentation().addMonitor(LoginActivity.class.getName(),null,false);
    Instrumentation.ActivityMonitor monitor2=getInstrumentation().addMonitor(MainActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        registrationActivity=registrationActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){

        View view=registrationActivity.findViewById(R.id.imageView_reg);
        assertNotNull(view);
    }

    @Test
    public void testLaunchOfRegisterButton(){

        assertNotNull(registrationActivity.findViewById(R.id.button_reg));

        onView(withId(R.id.name_reg)).perform(typeText("Munmun"));
        onView(withId(R.id.email_reg)).perform(typeText("munmun09@gmail.com"));
        onView(withId(R.id.password_reg)).perform(typeText("123456"));
        onView(withId(R.id.button_reg)).perform(click());
        Activity mainActivity=getInstrumentation().waitForMonitorWithTimeout(monitor2,5000);
        assertNotNull(mainActivity);
        mainActivity.finish();
    }

    @Test
    public void testLaunchOfSignInButton(){

        assertNotNull(registrationActivity.findViewById(R.id.sign_in_reg));

        onView(withId(R.id.sign_in_reg)).perform(click());
        Activity lActivity=getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(lActivity);
        lActivity.finish();
    }


    @After
    public void tearDown() throws Exception {
        registrationActivity=null;
    }
}