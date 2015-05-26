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
public class BarTest {
    private Bar bar;
    @Before
    public void setup(){
        bar=new Bar();
    }

    @Test
    public void testGetterSetterBarID(){
        bar.setID(6);
        Assert.assertEquals(bar.getID(),6);
    }

    @Test
    public void testGetterSetterBarName(){
        bar.setName("hubenduben");
        Assert.assertEquals(bar.getName(),"hubenduben");
    }

    @Test
    public void testGetterSetterOrt(){
        bar.setOrt("Karlsruhe");
        Assert.assertEquals(bar.getOrt(),"Karlsruhe");
    }

    @Test
    public void testGetterSetterAdresse(){
        bar.setAdresse("hans");
        Assert.assertEquals(bar.getAdresse(),"hans");
    }

    @Test
    public void testGetterSetterPLZ(){
        bar.setPLZ("77187");
        Assert.assertEquals(bar.getPLZ(),"77187");
    }

    @Test
    public void testGetterSetterBeschreibung(){
        bar.setBeschreibung("hallialla");
        Assert.assertEquals(bar.getBeschreibung(),"hallialla");
    }

    @Test void testGetterSetterLink(){
        bar.setLink("hans.de");
        Assert.assertEquals(bar.getLink(),"hans.de");
    }

}