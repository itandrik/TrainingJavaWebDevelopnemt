package com.javaweb;

import com.javaweb.model.Attempt;
import com.javaweb.model.Model;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

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
     * Testing random number without parameters
     * based on constant variables
     */
    @Test
    public void testGetRandomNumber() {
        for (int i = 0; i < maxParameterForRandom * maxParameterForRandom; i++) {
            int randomNumber = testModel.getRandomNumber();
            Assert.assertTrue((randomNumber >= Const.RAND_MIN) &&
                    (randomNumber <= Const.RAND_MAX));
        }
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
        for (int i = 0; i < maxParameterForRandom * maxParameterForRandom; i++) {
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
    }

    @Test
    public void testConstValues() {
        Assert.assertTrue(Const.RAND_MIN < Const.RAND_MAX);
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
     */
    @Test
    public void testAddToStatistic() {
        Attempt attempt = new Attempt(1, Const.RAND_MIN, Const.RAND_MAX);
        testModel.addToStatistic(1);

        Attempt statisticAttempt = testModel.getStatisticArray().get(0);
        Assert.assertArrayEquals(new int[]{
                attempt.getInputNumber(),
                attempt.getLeftLimit(),
                attempt.getRightLimit()},
                new int[]{statisticAttempt.getInputNumber(),
                        statisticAttempt.getLeftLimit(),
                        statisticAttempt.getRightLimit()});
    }

}