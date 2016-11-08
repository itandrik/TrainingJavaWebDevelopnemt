package com.javaweb.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MatrixTest {
    private Matrix matrix;
    private double[][] matrixArray;
    private double determinant;

    public MatrixTest(double[][] matrixArray, double determinant) {
        this.matrixArray = matrixArray;
        this.determinant = determinant;
    }

    @Before
    public void setUp() {
        matrix = new Matrix(matrixArray);
    }

    @Test
    public void testSetMatrix() {
        //stub
    }

    @Test
    public void testGetMatrix() {
        Assert.assertArrayEquals(matrixArray,matrix.getMatrix());
    }

    @Test
    public void testGetDeterminant() {
        Assert.assertTrue(matrix.getDeterminant() == determinant);
    }

    @Test
    public void testGetMatrixSize() {
        //stub
        Assert.assertSame(matrix.getMatrixSize(),matrix.getMatrix().length);
    }

    @Test
    public void equals() {
        try {
            Matrix newMatrix = (Matrix) matrix.clone();
            Assert.assertSame(newMatrix,matrix);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestDataForMatrix() {
        return Arrays.asList(new Object[][]{
                {new double[][]{
                        {14, 7, 18, 12},
                        {3, 38, 20, 14},
                        {0, 7, 19, 11},
                        {1, 18, 6, 3}
                }, -13499.0},
                {new double[][]{
                        {2, 15, 25},
                        {3, 35, 40},
                        {12, 30, 12}
                }, -3150.0},
        });
    }

}