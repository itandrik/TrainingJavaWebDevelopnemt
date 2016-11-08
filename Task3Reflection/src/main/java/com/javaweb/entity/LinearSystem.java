package com.javaweb.entity;


import com.javaweb.annotations.FieldUsable;
import com.javaweb.annotations.MethodUsable;
import com.javaweb.entity.interfaces.ILinearSystem;

import java.util.Arrays;
public final class LinearSystem extends Matrix implements ILinearSystem {
    @FieldUsable
    private double[] colFreeTerms;
    @FieldUsable
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

    @MethodUsable()
    public void setColFreeTerms(double[] colFreeTerms) {
        this.colFreeTerms = colFreeTerms;
    }
    @MethodUsable()
    public void setLinearSystem(double[][] linearSystem) {
        this.linearSystem = linearSystem;
    }

    @MethodUsable(enabled = true)
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

    @MethodUsable(enabled = true)
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

    @MethodUsable(enabled = true)
    public double[][] getLinearSystem() {
        return linearSystem;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        LinearSystem that = (LinearSystem) o;

        return Arrays.equals(colFreeTerms, that.colFreeTerms);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(colFreeTerms);
        return result;
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName() + "{" +
                "colFreeTerms=" + Arrays.toString(colFreeTerms) +
                ", linearSystem=" + Arrays.toString(linearSystem) +
                '}';
    }
}
