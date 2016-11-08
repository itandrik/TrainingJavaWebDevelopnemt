package com.javaweb.controller;


import com.javaweb.entity.LinearSystem;
import com.javaweb.entity.Matrix;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionRunner {
    Matrix matrix;
    LinearSystem linearSystem;

    public ReflectionRunner(Matrix matrix, LinearSystem linearSystem) {
        this.matrix = matrix;
        this.linearSystem = linearSystem;
    }

    public void showMatrixReflection(){

        if(matrix == null){
            try {
                Constructor constructor =
                        Matrix.class.getConstructor(double[][].class);
                matrix = (Matrix)constructor.newInstance(
                        (Object) GlobalVariables.ARRAY_MATRIX);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        Class matrixClass = matrix.getClass();
    }

    public void showLinearSystemReflection(){

    }
}
