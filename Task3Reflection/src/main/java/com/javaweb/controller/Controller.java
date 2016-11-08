package com.javaweb.controller;

import com.javaweb.entity.LinearSystem;
import com.javaweb.entity.Matrix;
import com.javaweb.entity.interfaces.IMatrix;
import com.javaweb.proxy.InvocationHandlerMatrix;
import com.javaweb.view.View;

import java.lang.reflect.Proxy;


public class Controller {
    private View view;
    private Matrix matrix;
    private LinearSystem linearSystem;

    public Controller(View view) {
        this.view = view;
    }

    public void processUser() {
        /* 1 task : create Parent and child classes and show
            working both of them
         */
        task1ShowWorkingMatrix();

        /* 2-3 task : create and check methods by
           annotations. Using reflection, invoke methods with
           annotation. Furthermore, show name of class, fields data,
           methods data.
         */
        task2ShowReflectionResult();

        /* Extra task 1 : create proxy (for immutability).
           It throws exception when setter was invoked*/
        extraTask1ProxySetters();
    }


    private void task1ShowWorkingMatrix() {
        matrix = new Matrix(GlobalVariables.ARRAY_MATRIX);
        view.showMatrix(matrix);
        view.printlnMessage(View.DETERMINANT_STRING +
                matrix.getDeterminant());

        linearSystem = new LinearSystem(
                GlobalVariables.ARRAY_MATRIX,
                GlobalVariables.COLUMN_FREE_TERMS);
        view.showMatrix(linearSystem);
        view.showRootsLinearSystem(linearSystem.getSolve());
        view.showMatrix(linearSystem);
    }

    private void task2ShowReflectionResult() {
        ReflectionRunner reflectionRunner =
                new ReflectionRunner(view);
        reflectionRunner.showMatrixReflection(matrix);
        reflectionRunner.showMatrixReflection(linearSystem);
    }

    private void extraTask1ProxySetters() {
        IMatrix matrixProxy = (IMatrix) Proxy.newProxyInstance(
                Matrix.class.getClassLoader(),
                Matrix.class.getInterfaces(),
                new InvocationHandlerMatrix(matrix));

        matrixProxy.setMatrix(GlobalVariables.ARRAY_MATRIX);
        view.printlnMessage(View.DETERMINANT_STRING +
                matrixProxy.getDeterminant());
    }
}
