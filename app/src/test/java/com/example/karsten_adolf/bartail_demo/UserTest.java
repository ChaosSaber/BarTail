package com.example.karsten_adolf.bartail_demo;

import com.example.karsten_adolf.bartail_demo.DBFiles.User;

import junit.framework.TestCase;

/**
 * Created by Ren� on 19.05.2015.
 */
public class UserTest extends TestCase {

    public void testLogin() throws Exception {
        User nutzer = new User("mark","yaha","pa55wort");
        assertTrue(nutzer.login("pa55wort"));
        //assertTrue(nutzer.login("passwort"));
    }
}