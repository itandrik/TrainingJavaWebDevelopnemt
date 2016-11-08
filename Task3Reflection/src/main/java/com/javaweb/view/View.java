package com.javaweb.view;

import com.javaweb.entity.LinearSystem;
import com.javaweb.entity.Matrix;

/**
 * Created by Dron on 08-Nov-16.
 */
public class View {
    public static final String MATRIX_STRING =
            "Your matrix : ";
    public static final String LINSYS_STRING =
            "Your linear system : ";
    public static final String DETERMINANT_STRING =
            "Your determinant : ";
    public static final String MATRIX_FORMATTER =
            "%.3f\t";
    public static final String ROOTS_STRING =
            "Roots of your matrix are : ";

    public static final String REFLECTION_MATRIX =
            "Matrix reflection : ";
    public static final String NAME_OF_CLASS_STRING =
            "Name of class : ";
    public static final String METHODS_STRING =
            "All methods : ";
    public static final String METHODS_WITHOUT_ANNOTATION =
            "All methods without annotation";
    public static final String LIST_OF_INTERFACES =
            "List of interfaces that implements this class : ";
    public static final String LIST_OF_FIELDS =
            "List all of declared fields in this class(only) : ";

    /**
     * @param message - array of strings for printing
     *                to console without next line symbol.
     */
    public void printMessage(Object... message) {
        for (Object str : message) {
            System.out.print(str);
        }
    }

    /**
     * @param message message for printing
     *                to console without next line symbol.
     */
    public void printMessage(Object message) {
        System.out.print(message);
    }

    /**
     * @param message - array of strings for printing
     *                to console with next line symbol.
     */
    public void printlnMessage(Object... message) {
        for (Object str : message) {
            System.out.println(str);
        }
    }

    /**
     * @param message - string for printing
     *                to console with next line symbol.
     */
    public void printlnMessage(Object message) {
        System.out.println(message);
    }

    public void showMatrix(Matrix matrix) {
        double[][] matr;
        if (matrix instanceof LinearSystem) {
            matr = ((LinearSystem) matrix).getLinearSystem();
            printlnMessage(LINSYS_STRING);
        }else{
            matr = matrix.getMatrix();
            printlnMessage(MATRIX_STRING);
        }

        for (int i = 0; i < matr.length; i++) {
            printMessage("|\t");
            for (int j = 0; j < matr[i].length; j++) {
                printMessage(String.format(
                        MATRIX_FORMATTER, matr[i][j]));

            }
            printMessage("|\n");
        }
    }

    public void showRootsLinearSystem(double[] roots) {
        printMessage(ROOTS_STRING);
        for (double root : roots) {
            printMessage(String.format(MATRIX_FORMATTER,root));
        }
        printMessage("\n");
    }
}
