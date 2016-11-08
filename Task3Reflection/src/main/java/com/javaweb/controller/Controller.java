package com.javaweb.controller;

import com.javaweb.entity.LinearSystem;
import com.javaweb.entity.Matrix;
import com.javaweb.view.View;

import static com.javaweb.controller.GlobalVariables.COLUMN_FREE_TERMS;


public class Controller {
    View view;

    public Controller(View view) {
        this.view = view;
    }

    public void processUser() {

        Matrix matrix = new Matrix(GlobalVariables.ARRAY_MATRIX);
        view.showMatrix(matrix);
        view.printlnMessage(View.DETERMINANT_STRING +
                matrix.getDeterminant());

        LinearSystem linearSystem = new LinearSystem(
                GlobalVariables.ARRAY_MATRIX,
                GlobalVariables.COLUMN_FREE_TERMS);
        view.showMatrix(linearSystem);
        view.showRootsLinearSystem(linearSystem.getSolve());
        view.showMatrix(linearSystem);

    }
}
