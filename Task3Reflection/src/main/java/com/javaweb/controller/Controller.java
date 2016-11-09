package com.javaweb.controller;

import com.javaweb.entity.LinearSystem;
import com.javaweb.entity.Matrix;
import com.javaweb.entity.interfaces.IMatrix;
import com.javaweb.proxy.InvocationHandlerMatrix;
import com.javaweb.view.View;

import java.lang.reflect.Proxy;

/**
 * Class that shows all program logic.
 * Here are almost all tasks from reflection task.
 * Start controller by {@link #processUser()}.
 * There are calling methods, which contains logic of tasks.
 *
 * @author Andrii Chernysh
 * @since 09 Nov 2016
 * @version 1.0
 */
public class Controller {

    private View view;
    /**
     * Instance of matrix;
     */
    private Matrix matrix;

    /**
     * Instance of linear system
     */
    private LinearSystem linearSystem;

    /**
     * Creating instance of Controller and initializing
     * view field.
     *
     * @param view - instance of {@link View}.
     */
    public Controller(View view) {
        this.view = view;
    }

    /**
     * Main method in this class.
     * Here is calling helper methods to show torking of
     * each task.
     */
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

    /**
     * Creating matrix instance. Setting matrix from {@link GlobalVariables}
     * interface.
     */
    private void task1ShowWorkingMatrix() {
        /* Show matrix work */
        matrix = new Matrix(GlobalVariables.ARRAY_MATRIX);
        view.showMatrix(matrix);
        view.printlnMessage(View.DETERMINANT_STRING +
                matrix.getDeterminant());

        /* Show linear system work */
        linearSystem = new LinearSystem(
                GlobalVariables.ARRAY_MATRIX,
                GlobalVariables.COLUMN_FREE_TERMS);
        view.showMatrix(linearSystem);  // Before solving;
        view.showRootsLinearSystem(linearSystem.getSolve());
        view.showMatrix(linearSystem);  // After solving;
    }

    /**
     * Task 2 method. Here are using {@link ReflectionRunner}
     * class, which shows all reflection methods, which should be
     * implemented in my variant #5.
     */
    private void task2ShowReflectionResult() {
        ReflectionRunner reflectionRunner =
                new ReflectionRunner(view);
        reflectionRunner.showReflection(matrix);
        reflectionRunner.showReflection(linearSystem);
    }

    /**
     * Here is creating of proxy. Using proxy you can't use any
     * setter, due to InvocationHandler
     */
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
