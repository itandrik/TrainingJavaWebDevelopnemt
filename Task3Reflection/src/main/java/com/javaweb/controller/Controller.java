package com.javaweb.controller;

import com.javaweb.entity.LinearSystem;
import com.javaweb.entity.Matrix;
import com.javaweb.view.View;


public class Controller {
    View view;

    public Controller(View view) {
        this.view = view;
    }

    public void processUser() {
        double[][] arrayMatrix = {{14, 7, 18, 12}, {3, 38, 20, 14}, {0, 7, 19, 11}, {1, 18, 6, 3}};
        Matrix matrix = new Matrix(arrayMatrix);
        view.showMatrix(matrix);
        view.printlnMessage(View.DETERMINANT_STRING + matrix.getDeterminant());
        double[] colFreeTerms = {139, 222, 111, -83};
        LinearSystem linearSystem = new LinearSystem(arrayMatrix, colFreeTerms);
        view.showMatrix(linearSystem);
        view.showRootsLinearSystem(linearSystem.getSolve());
        view.showMatrix(linearSystem);

    }
}
