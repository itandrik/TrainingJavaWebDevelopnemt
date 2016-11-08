package com.javaweb.entity;


import javax.naming.SizeLimitExceededException;

public class Matrix {

    public static final int DEFAULT_MATRIX_SIZE = 4;
    private double[][] matrix;
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

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public double[][] getMatrix() {
        return matrix;
    }

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
}

