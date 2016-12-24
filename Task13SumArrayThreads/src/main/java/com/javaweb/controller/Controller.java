package com.javaweb.controller;

import com.javaweb.model.SumArray;
import com.javaweb.model.TimeCalculator;
import com.javaweb.view.View;

/**
 * Calculating time of execution sum of elements in the array
 *
 * @author Andrii Chernysh on 24-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class Controller {
    /**
     * View instance
     */
    private View view;
    /**
     * SumArray instance
     */
    private SumArray model;
    /**
     * TimeCalculator instance
     */
    private TimeCalculator time;

    /**
     * @param view View instance
     * @param model SumArray instance
     * @param time TimeCalculator instance
     */
    public Controller(View view, SumArray model, TimeCalculator time) {
        this.view = view;
        this.model = model;
        this.time = time;
    }

    /**
     * Main method. Here are described work with model.
     * Calculating time of sum elements with and without multithreading
     */
    public void processUser(){
        model.initArray();
        // Sequential sum
        view.printlnMessage(View.SEQUENTIAL);

        time.start();
        long sequentialSum = model.getSumOfArraySequential();
        time.finish();

        view.printlnMessage(View.SUM_OF_ARRAY_ELEMENTS + sequentialSum);
        view.printlnMessage(View.SEQUENTIAL_SUM_TIME + time.getExecutionTime());
        view.printlnMessage(View.SEPARATOR);
        // Parallel sum
        view.printlnMessage(View.PARALLEL);

        time.start();
        long parallelSum = model.getSumOfArrayParallel(2);
        time.finish();

        view.printlnMessage(View.SUM_OF_ARRAY_ELEMENTS + parallelSum);
        view.printlnMessage(View.PARALLEL_SUM_TIME + time.getExecutionTime());
        view.printlnMessage(View.SEPARATOR);
    }
}
