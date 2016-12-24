package com.javaweb.model;

/**
 * Interface for Thread, that calculates sum of array
 *
 * @author Andrii Chernysh on 24-Dec-16. E-Mail : itcherry97@gmail.com
 */
public interface IArrayThread {
    /**
     * @return sum of elements of part of array
     */
    long getSum();

    /**
     * Override method from {@link Thread}
     */
    void run();
}
