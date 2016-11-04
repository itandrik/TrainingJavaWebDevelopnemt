package com.javaweb;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * ControllerTest.java
 * <p>
 * This module include testing of exceptions in Controller class
 * Some functions can throw exception because of type.
 *
 * @author Andrii Chernysh 29 Oct 2016
 * @version 1.0
 */
public class ControllerTest {
    /**
     * Implementation of Controller class
     */
    private static Controller testController;

    /**
     * Rule, which we use to check expected exceptions
     */
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    /**
     * Creating object testController only 1 time before testing methods;
     */
    @BeforeClass
    public static void setUp() {
        View view = new View();
        testController = new Controller(view);
    }

    /**
     * Checking on nullPointerException while Scanner == null
     */
    @Test
    public void inputIntValueWithScanner() {
        expectedException.expect(NullPointerException.class);
        testController.inputIntValueWithScanner(null);
    }

    /**
     * Checking on nullPointerException while Scanner == null
     */
    @Test
    public void inputValueWithScannerForMenu() {
        expectedException.expect(NullPointerException.class);
        testController.inputIntValueWithScanner(null);
    }

}