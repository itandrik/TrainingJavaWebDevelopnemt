package com.javaweb.view;

/**
 * Show information for user in the console
 *
 * @author Andrii Chernysh on 14-Dec-16.
 *         E-Mail : itcherry97@gmail.com
 */
public class View {
    public static final String SEQUENTIAL_SUM_TIME =
            "Time of sequential array sum : ";
    public static final String PARALLEL_SUM_TIME =
            "Time of parallel array sum : ";
    public static final String SUM_OF_ARRAY_ELEMENTS =
            "Sum of elements in array : ";
    public static final String PARALLEL =
            "PARALLEL SUM";
    public static final String SEQUENTIAL =
            "SEQUENTIAL SUM";
    public static final String SEPARATOR =
            "----------------------------------------";
    /**
     * @param message - array of strings for printing to console without next line symbol.
     */
    public void printMessage(Object... message) {
        for (Object str : message) {
            System.out.print(str);
        }
    }

    /**
     * @param message - array of strings for printing to console with next line symbol.
     */
    public void printlnMessage(Object... message) {
        for (Object str : message) {
            System.out.println(str);
        }
    }
}
