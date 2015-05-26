package com.example.karsten_adolf.bartail_demo;

import android.widget.Button;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * Created by Ren� on 25.05.2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class MainActivityTest {
    private MainActivity activity;
    Button login, registrieren;
    @Before
    public void setup() {
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
        login=(Button)activity.findViewById(R.id.but_login);
        registrieren=(Button)activity.findViewById(R.id.but_reg);
    }

    @Test
    public void testActivityFound() {
        Assert.assertNotNull(activity);
    }

    @Test
    public void testOnClickLogin(){
        login.performClick();
        //TODO herasufinden wie man an´bfragt in welcher activity man gerade ist.
    }

}