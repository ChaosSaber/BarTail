package com.example.karsten_adolf.bartail_demo;

import android.app.Activity;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.fest.assertions.api.ANDROID.assertThat;

/**
 * Created by René on 25.05.2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class HomeActivityTest {

    private HomeActivity activity;
    @Before
    public void setup() {
        activity = Robolectric.buildActivity(HomeActivity.class).create().get();
    }

    @Test
    public void testActivityFound() {
        Assert.assertNotNull(activity);
    }

    @Test
    public void HomeActivityAppearsAsExpected(){
        assertThat(activity.buttonBrowse).hasText("Browsen");
        assertThat(activity.buttonSearch).hasText("Suchen");
        assertThat(activity.buttonAddBar).hasText("Bar hinzufügen");
    }

    /*@Test
    public void clickingOnClickBrowsen(){
       // activity.buttonBrowse.performClick();
    }*/


    /*
    private MyActivity mActivity;
    @Test
    public void myActivityAppearsAsExpectedInitially() {
        assertThat(mActivity.mClickMeButton).hasText("Click me!");
        assertThat(mActivity.mHelloWorldTextView).hasText("Hello world!");
    }

    @Test
    public void clickingClickMeButtonChangesHelloWorldText() {
        assertThat(mActivity.mHelloWorldTextView).hasText("Hello world!");
        mActivity.mClickMeButton.performClick();
        assertThat(mActivity.mHelloWorldTextView).hasText("HEY WORLD");
    }
     */
}