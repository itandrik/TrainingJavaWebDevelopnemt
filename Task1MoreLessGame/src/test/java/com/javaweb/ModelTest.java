package com.javaweb;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * ModelTest.java
 * <p>
 * This module include all methods from class with
 * business logic. Getters also covered. This class
 * use @RunWith annotation to make code clear and
 * put different parameters to functions automatically.
 * It reduce code and make it clear;
 *
 * @author Andrii Chernysh 29 Oct 2016
 * @version 1.0
 */
@RunWith(Parameterized.class)
public class ModelTest {
    /**
     * Object that we need to test
     */
    private Model testModel;

    /**
     * Parameters, which takes automatically from
     * {@link #getTestDataForRandom()}
     */
    public int minParameterForRandom;
    public int maxParameterForRandom;

    /**
     * Constructor that wee need to make for parameters
     *
     * @param minParameterForRandom similar to RAND_MIN
     * @param maxParameterForRandom similar to RAND_MAX
     */
    public ModelTest(int minParameterForRandom, int maxParameterForRandom) {
        this.minParameterForRandom = minParameterForRandom;
        this.maxParameterForRandom = maxParameterForRandom;
    }

    /**
     * Creating model object
     */
    @Before
    public void setUp() {
        testModel = new Model();
    }

    /**
     * Getter upper bound testing
     */
    @Test
    public void testGetRightLimit() {
        int rightLimit = testModel.getRightLimit();
        Assert.assertEquals(rightLimit, Const.RAND_MAX);
    }

    /**
     * Getter lower bound testing
     */
    @Test
    public void testGetLeftLimit() {
        int leftLimit = testModel.getLeftLimit();
        Assert.assertEquals(leftLimit, Const.RAND_MIN);
    }

    /**
     * Testing array that wee need to show statistic.
     * This method it is similar with {@link #testAddToStatistic()}
     */
    @Test
    public void testGetStatisticArray() {
        ArrayList<ArrayList<Integer>> testArray = new ArrayList<>();
        ArrayList<Integer> testStatisticArray = new ArrayList<>();
        testStatisticArray.add(minParameterForRandom);
        testStatisticArray.add(Const.RAND_MIN);
        testStatisticArray.add(Const.RAND_MAX);
        testModel.addToStatistic(minParameterForRandom);
        testArray.add(testStatisticArray);

        Assert.assertArrayEquals(
                testArray.toArray(),
                testModel.getStatisticArray().toArray());
    }

    /**
     * Testing random number without parameters
     * based on constant variables
     */
    @Test
    public void testGetRandomNumber() {
        int randomNumber = testModel.getRandomNumber();
        Assert.assertTrue((randomNumber >= Const.RAND_MIN) &&
                (randomNumber <= Const.RAND_MAX));
    }

    /**
     * Testing randomising with parameters, which we got
     * using @RunWith annotation and {@link Parameterized}
     * class. It checks bound of our random number
     */
    @Test
    public void testGetRandomNumberWithParameters() {
        int min = minParameterForRandom;
        int max = maxParameterForRandom;
        int randomNumber =
                testModel.getRandomNumber(min, max);
        if (min > max) {
            int tmp = max;
            max = min;
            min = tmp;
        }
        Assert.assertTrue((randomNumber >= min) &&
                (randomNumber <= max));
    }

    /**
     * Generating parameters for our class
     *
     * @return array of parameters
     */
    @Parameterized.Parameters
    public static Collection<Object[]> getTestDataForRandom() {
        return Arrays.asList(new Object[][]{
                {0, 100},       // min < max
                {100, 0},       // min > max
                {12, 13},       // max - min == 1
                {12, 12}        // max = min
        });
    }

    /**
     * Testing our input value out of limits
     */
    @Test
    public void testIsCorrectNumber() {
        int inputValue = Const.RAND_MAX + 1;
        Assert.assertFalse(testModel.isCorrectNumber(inputValue));
    }

    /**
     * Testing array that wee need to add statistic to model,
     * in order to save data.
     * This method it is similar with {@link #testGetStatisticArray()}
     */
    @Test
    public void testAddToStatistic() {
        testModel.addToStatistic(minParameterForRandom);

        ArrayList<Integer> newItem = new ArrayList<>();
        newItem.add(Const.INPUT_NUMBER_STATISTIC, minParameterForRandom);
        newItem.add(Const.LEFT_LIMIT_STATISTIC,
                testModel.getLeftLimit());
        newItem.add(Const.RIGHT_LIMIT_STATISTIC,
                testModel.getRightLimit());
        ArrayList<ArrayList<Integer>> testArray = new ArrayList<>();

        testArray.add(newItem);
        Assert.assertArrayEquals(testArray.toArray(),
                testModel.getStatisticArray().toArray());
    }

}