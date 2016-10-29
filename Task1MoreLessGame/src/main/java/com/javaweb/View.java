package com.javaweb;

import java.util.ArrayList;

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
        printlnMessage(Const.MENU_STRINGS);
    }

    /**
     * Show message about incorrect number from diapason
     *
     * @param leftLimit  lower bound
     * @param rightLimit upper bound
     */
    public void printIncorrectInputNumber(int leftLimit, int rightLimit) {
        printlnMessage(
                Const.INCORRECT_INPUT_NUMBER_STRING,
                String.valueOf(leftLimit) +
                        Const.BETWEEN_NUMBERS_STRING +
                        String.valueOf(rightLimit)
        );
    }

    /**
     * Format printing of statistic of the game.
     *
     * @param statisticArray
     */
    public void showStatistic(ArrayList<ArrayList<Integer>> statisticArray) {
        printlnMessage(Const.STATISTIC_HEADER_STRING);

        /* To show statistic on each stage*/
        int moveCounter = 1;
        for (ArrayList<Integer> arr : statisticArray) {
            printlnMessage(
                    Const.TAB_STRING +
                    String.valueOf(moveCounter++) +
                    Const.NUMBER_OF_MOVE_STRING);
            printlnMessage(
                    Const.INPUT_NUMBER_STRING + arr.get(Const.INPUT_NUMBER_STATISTIC),
                    Const.TAB_STRING + Const.DIAPASON_STRING +
                    arr.get(Const.LEFT_LIMIT_STATISTIC) +
                    Const.BETWEEN_NUMBERS_STRING +
                    arr.get(Const.RIGHT_LIMIT_STATISTIC));
        }

        if(moveCounter > 1) {
            printlnMessage(String.valueOf(moveCounter) + // Normal win string
                    Const.MOVE_QUANTITY_STRING);
        }else if(moveCounter == 1){
            printlnMessage(Const.PERFECT_WIN_STRING);   // Win by 1 move
        }else {
            throw new IndexOutOfBoundsException();      //If somebody set counter to negative
        }

    }
}
