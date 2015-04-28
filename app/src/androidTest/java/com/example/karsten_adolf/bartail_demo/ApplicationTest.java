package com.example.karsten_adolf.bartail_demo;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.InstrumentationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
/*public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }
}*/


public class ApplicationTest extends InstrumentationTestCase{
    public void logintest() throws Exception{
        final int expected=1;
        final int reality=5;
        assertEquals(expected,reality);
    }
}