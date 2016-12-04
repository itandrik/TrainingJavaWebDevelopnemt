package com.javaweb;

import com.javaweb.model.Attempt;
import com.javaweb.model.Model;

import java.util.List;
import java.util.Scanner;

import static com.javaweb.View.*;

/**
 * Controller.java
 * <p>
 * It is class for engine of the game.
 * Here we take view methods to show information about game, menu, etc.
 * Also we take model methods to use business logic of this game.
 * Here are some input verifications
 *
 * @author Andrii Chernysh {itcherry97@gmail.com}
 * @version 1.0 29 Oct 2016
 */
public class Controller {
    /**
     * Object of model, which we will initialise later
     */
    private Model model;

    /**
     * Object of view, which we initialise instantly in constructor
     */
    private View view;
    /**
     * Scanner to makes input from console
     */
    private ScannerAdapter scanner = new ScannerAdapter(new Scanner(System.in));

    /**
     * Default constructor with view object initializing
     */
    public Controller(View view) {
        this.view = view;
    }


    /**
     * Main function in this class.
     * Main thread call this method from Main{@link Main}
     * This method makes menu and input all data from console
     * in correct way. Also it makes and show statistic using
     * data, which we create during playing the game
     */
    public void run() {

        /* Header in console */
        view.printlnMessage(View.GREETING_STRING);

        if(model == null) {
            model = getModelFromMenu();
        }

        view.printlnMessage(View.INPUT_INT_DATA_STRING,
                String.valueOf(model.getLeftLimit()) +
                        BETWEEN_NUMBERS_STRING +
                        String.valueOf(model.getRightLimit()));

        processUser();
        showWinMessage();
    }

    /**
     * One of the main procedure in controller.
     * It takes input number from console and check it
     * in the model class. Furthermore, it makes statistic array
     */
    private void processUser() {
        int inputValue;
        while (!model.isCorrectNumber(
                inputValue = inputIntValueWithScanner())) {
            model.addToStatistic(inputValue);
            view.printIncorrectInputNumber(
                    model.getLeftLimit(),
                    model.getRightLimit());
        }
    }

    /**
     * Writing message after {@link #processUser()} loop
     */
    private void showWinMessage() {
        view.printlnMessage(View.WIN_STRING);
        showStatistic(model.getStatisticArray());
        view.printlnMessage(View.GUESS_NUMBER_STRING +
                String.valueOf(model.getGuessNumber()));
    }

    /**
     * Format printing of statistic of the game.
     *
     * @param statisticArray array, which we take from model
     */
    private void showStatistic(List<Attempt> statisticArray)
            throws IndexOutOfBoundsException {
        view.printlnMessage(STATISTIC_HEADER_STRING);

        /* To show statistic on each stage*/
        int moveCounter = 1;
        for (Attempt arr : statisticArray) {
            view.printlnMessage(
                    TAB_STRING +
                            String.valueOf(moveCounter++) +
                            NUMBER_OF_MOVE_STRING);
            view.printlnMessage(
                    INPUT_NUMBER_STRING + arr.getInputNumber(),
                    TAB_STRING + DIAPASON_STRING + arr.getLeftLimit() +
                            BETWEEN_NUMBERS_STRING + arr.getRightLimit());
        }

        if (moveCounter > 1) {
            view.printlnMessage(String.valueOf(moveCounter) + // Normal win string
                    MOVE_QUANTITY_STRING);
        } else if (moveCounter == 1) {
            view.printlnMessage(PERFECT_WIN_STRING);   // Win by 1 move
        } else {
            throw new IndexOutOfBoundsException();      //If somebody set counter to negative
        }
    }

    /**
     * Menu item 1 : custom diapason for randomiser;
     * 2 : default diapason for randomiser;
     * 3 : exit;
     *
     * @return model object based on menu item
     */
    private Model getModelFromMenu() {
        /* Show menu in the console and choosing item */
        int menuItem = inputValueWithScannerForMenu();
        switch (menuItem) {
            /* Choosing custom limits and verifying min == max */
            case Const.FIRST_MENU_ITEM:
                int min;
                int max;
                do {
                    view.printlnMessage(View.ENTER_MINIMUM_STRING);
                    min = inputIntValueWithScanner();
                    view.printlnMessage(View.ENTER_MAXIMUM_STRING);
                    max = inputIntValueWithScanner();
                } while (min >= max);
                return new Model(min, max);
            case Const.SECOND_MENU_ITEM:
                return new Model();        // Default constructor
            case Const.THIRD_MENU_ITEM:
                System.exit(0);// Exit from program
        }

        return null;
    }

    /**
     * Checking input values.
     * Verifying on integer digits.
     *
     * @return integer value of number from console
     */
    public int inputIntValueWithScanner() {
        view.printlnMessage(View.INPUT_INT_DATA_STRING);

        // User have to have exit possibility
        if (scanner.hasNext(View.EXIT_STRING)) System.exit(0);

        while (!scanner.hasNextInt()) {
            view.printlnMessage(View.ERROR_MESSAGE +
                    View.INPUT_INT_DATA_STRING);
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Checking input values.
     * Verifying on integer digits.
     *
     * @return integer value of number from console
     */
    public int inputValueWithScannerForMenu() {
        view.printMenu();
        while (true) {
            /* Integer values verifying */
            while (!scanner.hasNextInt()) {
                view.printlnMessage(View.ERROR_MESSAGE);
                view.printMenu();
                scanner.next();
            }

            /* Verifying values, which should be in menu diapason */
            int nextInt = scanner.nextInt();
            if ((nextInt > 0) && (nextInt <= View.MENU_STRINGS.length))
                return nextInt;
            else {
                view.printlnMessage(View.ERROR_MESSAGE);
                view.printMenu();
            }
        }
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setScanner(ScannerAdapter scanner) {
        this.scanner = scanner;
    }
}