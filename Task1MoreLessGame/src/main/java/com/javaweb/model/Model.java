package com.javaweb.model;

import com.javaweb.Const;

import java.util.ArrayList;
import java.util.List;

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
 * @version 2.0
 * @since 29 Oct 2016
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
    private List<Attempt> statisticArray;

    /**
     * Default constructor. It generates number and limits
     * using const values from interface Const.
     */
    public Model() {
        statisticArray = new ArrayList<>();
        leftLimit = Const.RAND_MIN;
        rightLimit = Const.RAND_MAX;
        guessNumber = getRandomNumber(leftLimit, rightLimit);
    }

    /**
     * Constructor with parameters. It generates number and limits
     * using input values from console.
     *
     * @param min minimum limit for generating number
     * @param max maximum limit for generating number
     */
    public Model(int min, int max) {
        statisticArray = new ArrayList<>();
        leftLimit = min;
        rightLimit = max;
        guessNumber = getRandomNumber(leftLimit, rightLimit);
    }

    /**
     * This method generates random number in specific diapason
     * It has package visibility, because somebody can use it in the future
     *
     * @param min lower limit of our diapason
     * @param max upper limit of our diapason
     * @return random number from diapason
     */
    public int getRandomNumber(int min, int max) {
        if (max < min) {
            int temp = min;
            min = max;
            max = temp;
        }
        return (int) Math.ceil(Math.random() *
                (max - min - 1) + min);
    }

    /**
     * This method generates random number in diapason, which we make
     * using our constants from Const interface
     * It has package visibility, because somebody can use it in the future
     *
     * @return random number from diapason
     */
    public int getRandomNumber() {
        return (int) Math.ceil(Math.random() *
                (Const.RAND_MAX - Const.RAND_MIN - 1) + Const.RAND_MIN);
    }

    /**
     * Most important method in Model class.
     * It check our diapason limits and says is it our guess number or not
     *
     * @param inputNumber is player number from console
     * @return is it correct number or not
     */
    public boolean isCorrectNumber(int inputNumber) {
        if ((inputNumber > rightLimit) || (inputNumber < leftLimit)) {
            return false;
        }

        /*In standart case it is bigger probability
         to get incorrect input value
          */
        if (getGuessNumber() != inputNumber) {
            if (getGuessNumber() > inputNumber) {
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
    public void addToStatistic(int inputNumber) {
        Attempt attempt = new Attempt(inputNumber, leftLimit, rightLimit);
        statisticArray.add(attempt);
    }

    /**
     * It is not good idea as for me to get secret value, but
     * it doesn't matter because of reflection. Don't think about
     * security in this step. Use this value for JUnit.
     *
     * @return random number from diapason
     */
    public int getGuessNumber() {
        return this.guessNumber;
    }

    public int getRightLimit() {
        return rightLimit;
    }

    public int getLeftLimit() {
        return leftLimit;
    }

    public List<Attempt> getStatisticArray() {
        return statisticArray;
    }


}
