package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

/**
 * Created by René on 25.05.2015.
 */
@RunWith(RobolectricTestRunner.class)
public class LoginActivityTest extends TestCase {

    @Before
    public void setup() {
        //do whatever is necessary before every test
    }

    @Test
    public void testActivityFound() {
        Activity activity = Robolectric.buildActivity(LoginActivity.class).create().get();

        Assert.assertNotNull(activity);
    }

}