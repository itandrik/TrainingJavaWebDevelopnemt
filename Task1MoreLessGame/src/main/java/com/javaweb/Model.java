package com.javaweb;

import java.util.ArrayList;

/**
 * Model.java
 * <p>
 * It is class of business logic.
 * It makes game "Guess the number".
 * Main functions is to create correct limits,
 * to generate pseudo-random number and to verify
 * it with input value.
 *
 * @author Andrii Chernysh {itcherry97@gmail.com}
 * @version 1.0 29 Oct 2016
 */
public class Model {
    /**
     * Minimum number for numbers diapason
     */
    private int leftLimit;

    /**
     * Maximum number for numbers diapason
     */
    private int rightLimit;

    /**
     * Number that player should guess
     * It generates by randomiser.
     */
    private int guessNumber;

    /**
     * Array for statistic. Inner ArrayList will
     * include lower limit, upper limit and input number
     * from console in each stage of the game
     * Inner ArrayList entity : 0 - inputNumber;
     * 1 - leftLimit;
     * 2 - rightLimit;
     */
    private ArrayList<ArrayList<Integer>> statisticArray;

    /**
     * Default constructor. It generates number and limits
     * using const values from interface Const.
     */
    Model() {
        statisticArray = new ArrayList<>();

        //Somebody can change our constants and we will have problems
        if(Const.RAND_MIN < Const.RAND_MAX) {
            leftLimit = Const.RAND_MIN;
            rightLimit = Const.RAND_MAX;
            guessNumber = getRandomNumber();
        }else{
            leftLimit = Const.RAND_MAX;
            rightLimit = Const.RAND_MIN;
            guessNumber = getRandomNumber(Const.RAND_MIN,Const.RAND_MAX);
        }
    }

    /**
     * Constructor with parameters. It generates number and limits
     * using input values from console.
     *
     * @param min minimum limit for generating number
     * @param max maximum limit for generating number
     */
    Model(int min, int max) {
        statisticArray = new ArrayList<>();
        if (min < max) {
            leftLimit = min;
            rightLimit = max;
        } else {
            leftLimit = max;
            rightLimit = min;
        }
        guessNumber = getRandomNumber(leftLimit, rightLimit);
    }

    /**
     * Method, which we will use to show new diapason
     *
     * @return upper limit of our diapason
     */
    int getRightLimit() {
        return rightLimit;
    }

    /**
     * Method, which we will use to show new diapason
     *
     * @return lower limit of our diapason
     */
    int getLeftLimit() {
        return leftLimit;
    }

    /**
     * This program create statistic of the game.
     * Here we can get from the business logic.
     *
     * @return array with statistic values
     */
    ArrayList<ArrayList<Integer>> getStatisticArray() {
        return statisticArray;
    }

    /**
     * This method generates random number in specific diapason
     * It has package visibility, because somebody can use it in the future
     *
     * @param min lower limit of our diapason
     * @param max upper limit of our diapason
     * @return random number from diapason
     */
    int getRandomNumber(int min, int max) {
        if(max < min){
            int temp = min;
            min = max;
            max = temp;
        }
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

    /**
     * This method generates random number in diapason, which we make
     * using our constants from Const interface
     * It has package visibility, because somebody can use it in the future
     *
     * @return random number from diapason
     */
    int getRandomNumber() {
        int range = Math.abs(Const.RAND_MAX - Const.RAND_MIN) + 1;
        return (int) (Math.random() * range) + Const.RAND_MIN;
    }

    /**
     * Most important method in Model class.
     * It check our diapason limits and says is it our guess number or not
     *
     * @param inputNumber is player number from console
     * @return is it correct number or not
     */
    boolean isCorrectNumber(int inputNumber) {
        if ((inputNumber > rightLimit) || (inputNumber < leftLimit)) {
            return false;
        }

        /*In standart case it is bigger probability
         to get incorrect input value
          */
        if (guessNumber != inputNumber) {
            if (guessNumber > inputNumber) {
                leftLimit = inputNumber;        //Making limits for statistic
            } else {
                rightLimit = inputNumber;
            }
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method save all statistic in ArrayList
     *
     * @param inputNumber to save input number in array
     */
     void addToStatistic(int inputNumber) {
        ArrayList<Integer> newItem = new ArrayList<>();
        newItem.add(Const.INPUT_NUMBER_STATISTIC, inputNumber);
        newItem.add(Const.LEFT_LIMIT_STATISTIC, leftLimit);
        newItem.add(Const.RIGHT_LIMIT_STATISTIC, rightLimit);
        statisticArray.add(newItem);
    }
}
