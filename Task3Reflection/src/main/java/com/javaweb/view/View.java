package com.javaweb.view;

import com.javaweb.entity.LinearSystem;
import com.javaweb.entity.Matrix;


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
    public static final String EMPTY_STRING =
            "< empty >";
    public static final String SEPARATOR_STRING =
            "___________________________________";
    public static final String ERROR_STRING =
            "Error creating Matrix instance!";

    public static final String MODIFIER_PUBLIC = "public";
    public static final String MODIFIER_PRIVATE = "private";
    public static final String MODIFIER_PROTECTED = "protected";
    public static final String MODIFIER_FINAL = "final";
    public static final String MODIFIER_ABSTRACT = "abstract";
    public static final String MODIFIER_SYNCHRONIZED = "synchronized";
    public static final String MODIFIER_STATIC = "static";

    public static final String REFLECTION_STRING =
            "Reflection : ";
    public static final String NAME_OF_CLASS_STRING =
            "Name of class : ";
    public static final String NAME_OF_SUPERCLASS_STRING =
            "Name of superclass : ";
    public static final String METHODS_STRING =
            "All methods : ";
    public static final String CALL_METHOD_WITH_ANNOTATION =
            "%s method has annotation %s! Invoke this method!";
    public static final String LIST_OF_INTERFACES =
            "List of interfaces that implements this class : ";
    public static final String LIST_OF_FIELDS =
            "List all of declared fields in this class(only) : ";
    public static final String FIELD_FORMATTER =
            "Name of field : %s; Type : %s; Modifier : %s; Annotation : %s";

    /**
     * Message for InvocationException
     */
    public static final String INVOCATION_EXCEPTION_MESSAGE =
            "ERROR : setters are not available, class immutable!!!";

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
