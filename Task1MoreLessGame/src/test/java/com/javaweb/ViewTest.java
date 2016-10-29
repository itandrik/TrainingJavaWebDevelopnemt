package com.javaweb;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * ViewTest.java
 * <p>
 * This module include testing of exceptions in View class
 * Some functions can throw exception because of format.
 * Almost all methods in has String type, because this class
 * only for writing text information to the console
 *
 * @author Andrii Chernysh 29 Oct 2016
 * @version 1.0
 */
public class ViewTest {
    /**
     * Object of View class
     */
    private static View testView;

    /**
     * Rule, which we use to check expected exceptions
     */
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    /**
     * Creating object testView only 1 time before testing methods;
     */
    @BeforeClass
    public static void setUp() {
        testView = new View();
    }

    /**
     * Check NullPointerException while executing method showStatistic
     */
    @Test
    public void showStatistic() {
        expectedException.expect(NullPointerException.class);
        testView.showStatistic(null);
    }

}