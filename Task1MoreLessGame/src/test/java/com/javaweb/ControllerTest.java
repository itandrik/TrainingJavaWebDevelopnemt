package com.javaweb;

import com.javaweb.model.Model;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.*;

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
    private Controller controller;

    private Model model;
    private ScannerAdapter scanner;
    private View view;

    /**
     * Rule, which we use to check expected exceptions
     */
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    /**
     * Rule, which we use to check System.exit()
     */
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    /**
     * Initialising mocks and controller instance
     */
    @Before
    public void setUp() {
        view = mock(View.class);
        model = spy(new Model());
        controller = new Controller(view);
        scanner = mock(ScannerAdapter.class);
        controller.setScanner(scanner);

        /* Setting model not in controller's constructor is needed
           to create model instance according to menu item */
        controller.setModel(model);
    }

    /**
     * Test for main method, which shows game step-by-step
     */
    @Test
    public void run() {
        when(model.getRandomNumber(0, 100)).thenReturn(5);
        when(model.getGuessNumber()).thenReturn(5);
        when(scanner.hasNextInt())
                .thenReturn(true);
        when(scanner.nextInt())
                .thenReturn(100500)  //Menu item
                .thenReturn(50)
                .thenReturn(40)
                .thenReturn(10)
                .thenReturn(30)
                .thenReturn(6)
                .thenReturn(5);

        controller.run();
        verify(view).printIncorrectInputNumber(0, 100);
        verify(view).printIncorrectInputNumber(0, 50);
        verify(view).printIncorrectInputNumber(0, 40);
        verify(view, times(2))
                .printIncorrectInputNumber(0, 10);
        verify(view).printIncorrectInputNumber(0, 6);

        verify(view).printlnMessage(View.WIN_STRING);
        verify(view).printlnMessage(View.GUESS_NUMBER_STRING +
                String.valueOf(5));

    }

    /**
     * Test method to check entering integer value from console
     */
    @Test
    public void inputIntValueWithScanner() {
        exit.expectSystemExitWithStatus(0);
        when(scanner.hasNext("exit"))
                .thenReturn(false)
                .thenReturn(true);
        when(scanner.hasNextInt())
                .thenReturn(true);
        when(scanner.nextInt())
                .thenReturn(12);


        int result = controller.inputIntValueWithScanner();
        verify(view).printlnMessage(View.INPUT_INT_DATA_STRING);
        Assert.assertEquals(12, result);

        controller.inputIntValueWithScanner();
        verify(view).printlnMessage(View.EXIT_STRING);


        when(scanner.hasNextInt())
                .thenReturn(false);
        verify(view).printlnMessage(View.ERROR_MESSAGE +
                View.INPUT_INT_DATA_STRING);
        verify(scanner).next();
    }

    /**
     * Test method to check entering integer value from console only for menu
     * (only 1 - 3)
     */
    @Test
    public void inputValueWithScannerForMenu() throws Exception {

        when(scanner.hasNextInt()).thenReturn(true);
        when(scanner.nextInt())
                .thenReturn(0)
                .thenReturn(1)
                .thenReturn(2);

        int result = controller.inputValueWithScannerForMenu();
        verify(view, times(2)).printMenu();
        verify(view).printlnMessage(View.ERROR_MESSAGE);
        Assert.assertEquals(1, result);

        result = controller.inputValueWithScannerForMenu();
        Assert.assertEquals(2, result);

    }


}