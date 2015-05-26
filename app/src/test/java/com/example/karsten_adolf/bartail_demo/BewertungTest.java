package com.example.karsten_adolf.bartail_demo;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * Created by René on 26.05.2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class BewertungTest {
    private Bewertung bewertung;
    @Before
    public void setup(){
        bewertung=new Bewertung();
    }

    @Test
    public void testGetterSetterUserID(){
        bewertung.setUserid(2);
        Assert.assertEquals(bewertung.getUserid(),2);
    }

    @Test
    public void testGetterSetterBarID(){
        bewertung.setBarid(4);
        Assert.assertEquals(bewertung.getBarid(),4);
    }

    @Test
    public void testGetterSetterKommentar(){
        bewertung.setKommentar("Scheiße");
        Assert.assertEquals(bewertung.getKommentar(),"Scheiße");
    }

    @Test
    public void testGetterSetterRating(){
        bewertung.setRating(3);
        Assert.assertEquals(bewertung.getRating(),3);
    }

    @Test
    public void testConstructor(){
        Bewertung bewertung1=new Bewertung(2,3,4,"hsbdfhb");
        Assert.assertEquals(bewertung1.getUserid(),2);
        Assert.assertEquals(bewertung1.getBarid(),3);
        Assert.assertEquals(bewertung1.getRating(),4);
        Assert.assertEquals(bewertung1.getKommentar(),"hsbdfhb");
    }
}