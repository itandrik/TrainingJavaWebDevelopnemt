package com.javaweb.entity;


import com.javaweb.entity.annotations.FieldUsable;
import com.javaweb.entity.annotations.FinaliseVariable;
import com.javaweb.entity.annotations.MethodUsable;

import javax.naming.SizeLimitExceededException;
import java.util.Arrays;

public class Matrix {
    @FinaliseVariable
    public static final int DEFAULT_MATRIX_SIZE = 4;

    @FieldUsable
    private double[][] matrix;

    @FieldUsable
    private double determinant;
    private int matrixSize;

    public Matrix() {
        matrixSize = DEFAULT_MATRIX_SIZE;
        matrix = new double[matrixSize][matrixSize];
        determinant = calculateDeterminant(matrix,matrixSize);
    }

    public Matrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i].length != matrix.length){
                try {
                    throw new SizeLimitExceededException();
                } catch (SizeLimitExceededException e) {
                    e.printStackTrace();
                }
            }
        }
        matrixSize = matrix.length;
        this.matrix = matrix;
        determinant = calculateDeterminant(matrix, matrixSize);
    }

    public Matrix(int matrixSize){
        matrixSize = matrix.length;
        matrix = new double[matrixSize][matrixSize];
        determinant = calculateDeterminant(matrix,matrixSize);
    }

    @MethodUsable()
    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    @MethodUsable(enabled = true)
    public double[][] getMatrix() {
        return matrix;
    }

    @MethodUsable(enabled = true)
    private double calculateDeterminant(double matrix[][], int n) {
        determinant = 0;
        int sign = 1;
        int p;
        int q;
        if (n == 1) {
            determinant = matrix[0][0];
        } else {
            double b[][] = new double[n - 1][n - 1];
            for (int x = 0; x < n; x++) {
                p = 0;
                q = 0;
                for (int i = 1; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (j != x) {
                            b[p][q++] = matrix[i][j];
                            if (q % (n - 1) == 0) {
                                p++;
                                q = 0;
                            }
                        }
                    }
                }
                determinant = determinant + matrix[0][x] *
                        this.calculateDeterminant(b, n - 1) *
                        sign;
                sign = -sign;
            }
        }
        return determinant;
    }

    public double getDeterminant() {
        return determinant;
    }

    public int getMatrixSize() {
        return matrixSize;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        double[][] newMatrix = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, matrix.length);
        }
        return newMatrix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix1 = (Matrix) o;

        if (Double.compare(matrix1.determinant, determinant) != 0) return false;
        if (matrixSize != matrix1.matrixSize) return false;
        return Arrays.deepEquals(matrix, matrix1.matrix);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = Arrays.deepHashCode(matrix);
        temp = Double.doubleToLongBits(determinant);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + matrixSize;
        return result;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrix=" + Arrays.toString(matrix) +
                ", determinant=" + determinant +
                ", matrixSize=" + matrixSize +
                '}';
    }
}

