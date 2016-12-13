package com.javaweb.view;

/**
 * @author Andrii Chernysh on 14-Dec-16.
 *         E-Mail : itcherry97@gmail.com
 */
public class View {
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
