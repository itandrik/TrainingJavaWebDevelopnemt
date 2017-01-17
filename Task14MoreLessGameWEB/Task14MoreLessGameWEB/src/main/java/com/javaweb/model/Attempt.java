package com.javaweb.model;

/**
 * Class for saving statistic of our game.
 * It will use in list of statistic attempt
 *
 * @author Andrii Chernysh
 * @version 2.0
 * @since 04 Nov 2016
 */
public class Attempt {
    /**
     * Value, which user input from console
     */
    private int inputNumber;

    private int leftLimit;

    private int rightLimit;

    /**
     * Constructor for quick adding attempt in list
     *
     * @param inputNumber Value, which user input from console
     * @param leftLimit   Minimum number in range
     * @param rightLimit  Maximum number in range
     */
    public Attempt(int inputNumber, int leftLimit, int rightLimit) {
        this.inputNumber = inputNumber;
        this.leftLimit = leftLimit;
        this.rightLimit = rightLimit;
    }

    public int getInputNumber() {
        return inputNumber;
    }

    public int getLeftLimit() {
        return leftLimit;
    }

    public int getRightLimit() {
        return rightLimit;
    }

}
