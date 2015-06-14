package com.example.karsten_adolf.bartail_demo;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by René on 26.05.2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class UserTest {
    private User nutzer;
    @Before
    public void setup() {
        nutzer=new User();
    }

    @Test
    public void testGetterSetterUsername() {
        nutzer.setUsername("Mark");
        Assert.assertEquals(nutzer.getUsername(),"Mark");
    }

    @Test
    public void testGetterSetterUserID(){
        nutzer.setUser_ID(2);
        Assert.assertEquals(nutzer.getUser_ID(),2);
    }

    @Test
    public void testGetterSetterEMail(){
        nutzer.setE_mail("foo@foo.de");
        Assert.assertEquals(nutzer.getE_mail(),"foo@foo.de");
    }

    @Test
    public void testGetterSetterPasswort(){
        nutzer.setPasswort("pa55wort");
        Assert.assertEquals(nutzer.getPasswort(),"pa55wort");
    }

    @Test
    public void testLoginSucces(){
        nutzer.setPasswort("pa55wort");
        Assert.assertTrue(nutzer.login("pa55wort"));
    }

    @Test
    public void testLoginFail(){
        nutzer.setPasswort("pa55wort");
        Assert.assertFalse(nutzer.login("Pa55wort"));
    }

    @Test
    public void testConstructor(){
        User nutzer2=new User("Mark","foo@foo.de","pa55wort");
        Assert.assertEquals(nutzer2.getUsername(),"Mark");
        Assert.assertEquals(nutzer2.getPasswort(),"pa55wort");
        Assert.assertEquals(nutzer2.getE_mail(),"foo@foo.de");
    }

}