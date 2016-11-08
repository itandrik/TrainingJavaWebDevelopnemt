package com.javaweb.entity;

public class LinearSystem extends Matrix implements Solvable {
    private double[] colFreeTerms;
    private double[][] linearSystem;

    public LinearSystem() {
        this.colFreeTerms = new double[getMatrixSize()];
        this.linearSystem = createLinearSystem();
    }

    public LinearSystem(double[][] matrix, double[] colFreeTerms) {
        super(matrix);
        this.colFreeTerms = colFreeTerms;
        this.linearSystem = createLinearSystem();
    }

    private double[][] createLinearSystem() {
        double[][] linearSystem = new double[getMatrixSize()][getMatrixSize()+1];
        for (int i = 0; i < getMatrixSize(); i++) {
            int j = 0;
            while (j < getMatrixSize()) {
                linearSystem[i][j] = getMatrix()[i][j];
                j++;
            }
            linearSystem[i][j] = colFreeTerms[i];
        }
        return linearSystem;
    }

    public double[] getSolve() {
        int row = getMatrixSize();
        int col = getMatrixSize() + 1;
        double temp;
        double temp2;
        for (int i = 0; i < row; i++) {
            temp = linearSystem[i][i];
            for (int j = i; j < col; j++)
                linearSystem[i][j] = linearSystem[i][j] / temp;
            for (int j = 0; j < row; j++) {
                temp2 = linearSystem[j][i];
                if (j == i) continue;
                for (int k = i; k < col; k++) {
                    linearSystem[j][k] -= (linearSystem[i][k] * temp2);
                }
            }
        }
        double[] roots = new double[row]; // change row
        for (int i = 0; i < row; i++) {
            roots[i] = linearSystem[i][col - 1];
        }
        return roots;
    }

    public double[][] getLinearSystem() {
        return linearSystem;
    }
}
