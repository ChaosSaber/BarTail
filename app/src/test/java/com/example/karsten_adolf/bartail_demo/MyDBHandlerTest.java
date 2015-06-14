package com.example.karsten_adolf.bartail_demo;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * Created by René on 14.06.2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class MyDBHandlerTest {
    @Before
    public void setup() {}

    @Test
    public void TestFindBarByName()
    {
        MyDBHandler dbHandler = new MyDBHandler(null, null, null, 1);
        Bar[] bars=dbHandler.findBarByName("Cocktailbar");
        Assert.assertTrue(true);
    }
}