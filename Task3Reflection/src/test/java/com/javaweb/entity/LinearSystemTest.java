package com.javaweb.entity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LinearSystemTest {
    private LinearSystem linearSystem;

    private double[] colFreeTerms;
    private double[] roots;
    private double[][] linearSystemArray;

    public LinearSystemTest(double[][] linearSystemArray,
                            double[] colFreeTerms,
                            double[] roots) {
        this.colFreeTerms = colFreeTerms;
        this.linearSystemArray = linearSystemArray;
        this.roots = roots;
        linearSystem = new LinearSystem(linearSystemArray,colFreeTerms);
    }

    @Test
    public void testSetColFreeTerms(){
        //stub
    }

    @Test
    public void testSetLinearSystem(){
        //stub
        linearSystem.setLinearSystem(linearSystemArray);
        Assert.assertArrayEquals(linearSystemArray,linearSystem.getLinearSystem());
    }

    @Test
    public void testGetSolve(){
        Assert.assertArrayEquals(linearSystem.getSolve(), roots, 1.0);
    }

    @Test
    public void testGetLinearSystem(){
        int newArraySize = linearSystemArray.length;
        double[][] newLinearSystem =
                new double[newArraySize][newArraySize+1];
        for (int i = 0; i < newArraySize; i++) {
            int j = 0;
            while (j < newArraySize) {
                newLinearSystem[i][j] = linearSystemArray[i][j];
                j++;
            }
            newLinearSystem[i][j] = colFreeTerms[i];
        }

        Assert.assertArrayEquals(newLinearSystem,linearSystem.getLinearSystem());
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestDataForMatrix() {
        return Arrays.asList(new Object[][]{
                {new double[][]{
                        {14, 7, 18, 12},
                        {3, 38, 20, 14},
                        {0, 7, 19, 11},
                        {1, 18, 6, 3}},
                        new double[]{139, 222, 111, -83},
                        new double[]{-9.092, -3.813, -52.350, 102.939}}
        });
    }
}