package com.javaweb.entity.interfaces;


public interface ILinearSystem {
    double[] getSolve();
    void setColFreeTerms(double[] colFreeTerms);
    void setLinearSystem(double[][] linearSystem);
    double[][] getLinearSystem();
}
