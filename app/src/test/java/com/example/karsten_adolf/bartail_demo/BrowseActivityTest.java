package com.example.karsten_adolf.bartail_demo;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by René on 25.05.2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class BrowseActivityTest extends TestCase {
    private BrowseActivity activity;
    @Before
    public void setup() {
        activity = Robolectric.buildActivity(BrowseActivity.class).create().get();
    }

    @Test
    public void testActivityFound() {
        Assert.assertNotNull(activity);
    }


}