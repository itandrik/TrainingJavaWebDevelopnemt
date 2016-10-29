package com.javaweb;

import java.io.InputStream;

/**
 * Const.java
 * <p>
 * It is interface for constant values for the game.
 * Here are a lot of Strings, which we will put in external
 * file later. It is made for internationalization.
 * Also here are some integer values to reduce hardcoding.
 *
 * @author Andrii Chernysh {itcherry97@gmail.com}
 * @version 1.0 29 Oct 2016
 */
public interface Const {
    public static final InputStream INPUT_STREAM = System.in;
    public static final int RAND_MAX = 100; // Don't write here :
    public static final int RAND_MIN = 0;   // RAND_MAX < RAND_MIN!!!

    /* Header string and menu string array */
    public static final String GREETING_STRING =
            "#------------- Game \"Guess the number\" -------------#";
    public static final String[] MENU_STRINGS = {
            "1. Input limits by myself;",
            "2. Choose standart limits(" + RAND_MIN + ", " + RAND_MAX + ");",
            "3. Exit;"
    };

    /* Menu items */
    public static final int FIRST_MENU_ITEM = 1;
    public static final int SECOND_MENU_ITEM = 2;
    public static final int THIRD_MENU_ITEM = 3;

    /* Items for statistic Array */
    public static final int INPUT_NUMBER_STATISTIC = 0;
    public static final int LEFT_LIMIT_STATISTIC = 1;
    public static final int RIGHT_LIMIT_STATISTIC = 2;

    /* Inpput data from console */
    public static final String INPUT_INT_DATA_STRING =
            "Enter your number(or \"exit\" to quit the program) : ";

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
    /** Strings for statistic output */
    public static final String STATISTIC_HEADER_STRING =
            "Now look at your game statistic : ";
    public static final String NUMBER_OF_MOVE_STRING = " move";
    public static final String DIAPASON_STRING = "\tDiapason : ";
    public static final String INPUT_NUMBER_STRING = "\tInput number : ";
    public static final String GUESS_NUMBER_STRING = " Guess number is : ";
}
