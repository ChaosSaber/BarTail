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
 * Created by Rene on 25.05.2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class BewertenActivityTest {

    private BewertenActivity activity;
    @Before
    public void setup() {
        activity = Robolectric.buildActivity(BewertenActivity.class).create().get();
    }

    @Test
    public void testActivityFound() {
        Assert.assertNotNull(activity);
    }
}