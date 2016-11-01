package com.javaweb;

import java.util.ArrayList;

import static com.javaweb.Const.RAND_MAX;
import static com.javaweb.Const.RAND_MIN;

/**
 * View.java
 * <p>
 * It is class for showing some information.
 * It print some game information.
 *
 * @author Andrii Chernysh {itcherry97@gmail.com}
 * @version 1.0 29 Oct 2016
 */
public class View {
    /* Header string and menu string array */
    public static final String GREETING_STRING =
            "#------------- Game \"Guess the number\" -------------#";
    public static final String[] MENU_STRINGS = {
            "1. Input limits by myself;",
            "2. Choose standart limits(" + RAND_MIN + ", " + RAND_MAX + ");",
            "3. Exit;"
    };

    /* Inpput data from console */
    public static final String INPUT_INT_DATA_STRING =
            "Enter your number(or \"exit\" to quit the program) : ";
    public static final String EXIT_STRING = "exit";
    /* Error while input from console */
    public static final String ERROR_MESSAGE = "Wrong input!!! Repeat please :";

    /* When finish game, message about win */
    public static final String WIN_STRING =
            "Yeeeep! You got it! Awesome game buddy:)";
    public static final String MOVE_QUANTITY_STRING =
            " moves! Good job.";
    public static final String PERFECT_WIN_STRING =
            "\t\tFantastic!!! Only 1 move. You are lucky.";

    /* Not guess number message */
    public static final String INCORRECT_INPUT_NUMBER_STRING =
            "No it is not correct number, but you are closer. New diapason : ";

    /* Just for pretty view in console =) */
    public static final String BETWEEN_NUMBERS_STRING = "____________________";

    /* Enter limits from console (when menu item 1)*/
    public static final String ENTER_MINIMUM_STRING =
            "\t\tEnter your minimum limit : ";
    public static final String ENTER_MAXIMUM_STRING =
            "\t\tEnter your maximum limit : ";

    public static final String TAB_STRING = "\t";
    /**
     * Strings for statistic output
     */
    public static final String STATISTIC_HEADER_STRING =
            "Now look at your game statistic : ";
    public static final String NUMBER_OF_MOVE_STRING = " move";
    public static final String DIAPASON_STRING = "\tDiapason : ";
    public static final String INPUT_NUMBER_STRING = "\tInput number : ";
    public static final String GUESS_NUMBER_STRING = " Guess number is : ";

    /**
     * Method for showing information on different threads
     * (not only out). If we will need to refactor output,
     * we can do this simple in one line.
     *
     * @param stringArray string sequence, which we will need to print
     */
    public void printlnMessage(String... stringArray) {
        for (String aStringArray : stringArray) {
            System.out.println(aStringArray);
        }
    }

    /**
     * Simple menu printing
     */
    public void printMenu() {
        printlnMessage(MENU_STRINGS);
    }

    /**
     * Show message about incorrect number from diapason
     *
     * @param leftLimit  lower bound
     * @param rightLimit upper bound
     */
    public void printIncorrectInputNumber(int leftLimit, int rightLimit) {
        printlnMessage(
                INCORRECT_INPUT_NUMBER_STRING,
                String.valueOf(leftLimit) +
                        BETWEEN_NUMBERS_STRING +
                        String.valueOf(rightLimit)
        );
    }

    /**
     * Format printing of statistic of the game.
     *
     * @param statisticArray array, which we
     *                       take from model through controller
     */
    public void showStatistic(ArrayList<ArrayList<Integer>> statisticArray) {
        printlnMessage(STATISTIC_HEADER_STRING);

        /* To show statistic on each stage*/
        int moveCounter = 1;
        for (ArrayList<Integer> arr : statisticArray) {
            printlnMessage(
                    TAB_STRING +
                            String.valueOf(moveCounter++) +
                            NUMBER_OF_MOVE_STRING);
            printlnMessage(
                    INPUT_NUMBER_STRING + arr.get(Const.INPUT_NUMBER_STATISTIC),
                    TAB_STRING + DIAPASON_STRING +
                            arr.get(Const.LEFT_LIMIT_STATISTIC) +
                            BETWEEN_NUMBERS_STRING +
                            arr.get(Const.RIGHT_LIMIT_STATISTIC));
        }

        if (moveCounter > 1) {
            printlnMessage(String.valueOf(moveCounter) + // Normal win string
                    MOVE_QUANTITY_STRING);
        } else if (moveCounter == 1) {
            printlnMessage(PERFECT_WIN_STRING);   // Win by 1 move
        } else {
            throw new IndexOutOfBoundsException();      //If somebody set counter to negative
        }

    }
}
