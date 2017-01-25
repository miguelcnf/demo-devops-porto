package com.devops.porto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyControllerTest {

    private MyController subject;

    @Before
    public void setUp() throws Exception {
        subject = new MyController();
    }

    @Test
    public void alive() throws Exception {
        assertEquals("Yes I am!", subject.alive());
    }

    @Test
    public void hi() throws Exception {
        assertEquals("Hi miguel", subject.hi("miguel"));

    }

}