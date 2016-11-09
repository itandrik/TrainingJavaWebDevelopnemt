package com.javaweb.entity.interfaces;

/**
 * Interface for class {@link com.javaweb.entity.LinearSystem}
 * Using by Proxy.
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 09 Nov 2016
 */
public interface ILinearSystem {
    double[] getSolve();

    /**
     * Setting values for our LinearSystem
     * That values, which are after sign '='
     *
     * @param colFreeTerms array with values
     */
    void setColFreeTerms(double[] colFreeTerms);

    /**
     * If our matrix was 4X4, in linear system it will be
     * 4X5, because of column free terms.
     *
     * @param linearSystem array for linear system.
     */
    void setLinearSystem(double[][] linearSystem);

    double[][] getLinearSystem();
}
