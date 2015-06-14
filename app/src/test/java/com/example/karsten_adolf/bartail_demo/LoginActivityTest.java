package com.example.karsten_adolf.bartail_demo;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * Created by René on 25.05.2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class LoginActivityTest {
    private LoginActivity activity;
    @Before
    public void setup() {
        activity = Robolectric.buildActivity(LoginActivity.class).create().get();
    }

    @Test
    public void testActivityFound() {
        Assert.assertNotNull(activity);
    }

}