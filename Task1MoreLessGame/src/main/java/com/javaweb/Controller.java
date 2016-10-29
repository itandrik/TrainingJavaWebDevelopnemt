package com.javaweb;

import java.util.Scanner;

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
    Model model;

    /**
     * Object of view, which we initialise instantly in constructor
     */
    View view;

    /**
     * Default constructor with view object initializing
     */
    public Controller() {
        view = new View();
    }

    /**
     * Main function in this class.
     * Main thread call this method from Main{@link Main}
     * This method makes menu and input all data from console
     * in correct way. Also it makes and show statistic using
     * data, which we create during playing the game
     */
    public void run() {
        /* Scanner to makes input from console */
        Scanner scanner = new Scanner(Const.INPUT_STREAM);
        /* Header in console */
        view.printlnMessage(Const.GREETING_STRING);

        /* Show menu in the console and choosing item */
        int menuItem = inputValueWithScannerForMenu(scanner);
        switch (menuItem) {
            /* Choosing custom limits and verifying min == max */
            case Const.FIRST_MENU_ITEM:
                int min;
                int max;
                do {
                    view.printlnMessage(Const.ENTER_MINIMUM_STRING);
                    min = inputIntValueWithScanner(scanner);
                    view.printlnMessage(Const.ENTER_MAXIMUM_STRING);
                    max = inputIntValueWithScanner(scanner);
                } while (min == max);
                model = new Model(min, max);
                break;
            case Const.SECOND_MENU_ITEM:
                model = new Model();        // Default constructor
                break;
            case Const.THIRD_MENU_ITEM:
                System.exit(0);             // Exit from program
                break;
        }

        /* Game engine. Working while not win or exit. */
        int inputValue;
        while (!model.isCorrectNumber(
                inputValue = inputIntValueWithScanner(scanner))) {
            model.addToStatistic(inputValue);
            view.printIncorrectInputNumber(
                    model.getLeftLimit(),
                    model.getRightLimit());
        }
        view.printlnMessage(Const.WIN_STRING);
        view.showStatistic(model.getStatisticArray());
        view.printlnMessage(Const.GUESS_NUMBER_STRING + String.valueOf(inputValue));
    }


    /**
     * Checking input values.
     * Verifying on integer digits.
     *
     * @param sc Scanner, which has created in {@see Controller.run}
     * @return integer value of number from console
     */
    public int inputIntValueWithScanner(Scanner sc) {
        view.printlnMessage(Const.INPUT_INT_DATA_STRING);

        // User have to have exit possibility
        if (sc.hasNext("exit")) System.exit(0);

        while (!sc.hasNextInt()) {
            view.printlnMessage(Const.ERROR_MESSAGE +
                    Const.INPUT_INT_DATA_STRING);
            sc.next();
        }
        return sc.nextInt();
    }

    /**
     * Checking input values.
     * Verifying on integer digits.
     *
     * @param sc Scanner, which has created in {@see Controller.run}
     * @return integer value of number from console
     */
    public int inputValueWithScannerForMenu(Scanner sc) {
        view.printMenu();
        while (true) {
            /* Integer values verifying */
            while (!sc.hasNextInt()) {
                view.printlnMessage(Const.ERROR_MESSAGE);
                view.printMenu();
                sc.next();
            }

            /* Verifying values, which should be in menu diapason */
            int nextInt = sc.nextInt();
            if ((nextInt > 0) && (nextInt <= Const.MENU_STRINGS.length))
                return nextInt;
            else {
                view.printlnMessage(Const.ERROR_MESSAGE);
                view.printMenu();
            }
        }
    }
}