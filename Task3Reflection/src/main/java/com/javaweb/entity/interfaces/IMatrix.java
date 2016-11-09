package com.javaweb.entity.interfaces;

/**
 * Interface for class {@link com.javaweb.entity.Matrix}
 * Using by Proxy.
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 09 Nov 2016
 */
public interface IMatrix {
    /**
     * Setting array with matrix
     *
     * @param matrix array of double
     */
    void setMatrix(double[][] matrix);

    /**
     * @return array of double
     */
    double[][] getMatrix();

    /**
     * Calculating of determinant for some matrix
     *
     * @return determinant value
     */
    double getDeterminant();

    /**
     * @return
     */
    int getMatrixSize();
}
