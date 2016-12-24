package com.javaweb.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * Class, that describes sum of array.
 * Here are functions of initialisation,
 * creation array, sum of elements with threads and
 * without them.
 * @author Andrii Chernysh on 24-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class SumArray {
    /**
     * Array, that is needed to calculate sum of elements
     */
    private int[] array;
    /**
     * Size of array
     */
    private int size;
    /**
     * Size of array with default initialization of class
     */
    private static final int DEFAULT_ARRAY_SIZE = 100059999;

    /**
     * Default constructor
     */
    public SumArray() {
        size = DEFAULT_ARRAY_SIZE;
        array = new int[DEFAULT_ARRAY_SIZE];
    }

    /**
     * Custom constructor
     *
     * @param size custom size of array
     */
    public SumArray(int size) {
        this.size = size;
        array = new int[size];
    }

    /**
     * @return size of array
     */
    public int size() {
        return array.length;
    }

    /**
     * Initialization of array by range of integers
     * from 0 to size of array. Index == value.
     */
    public void initArray() {
        array = IntStream.range(0, size).toArray();
    }


    public void setArray(int[] array) {
        this.array = array;
    }

    /**
     * Calculating sum of elements using some quantity of threads.
     *
     * @param countThreads quantity of threads
     * @return sum of elements in array
     */
    public long getSumOfArrayParallel(int countThreads) {
        Objects.requireNonNull(array);
        // Array with threads is needed to join every
        // thread and get sum of elements of every thread
        IArrayThread[] arrayOfThreads = new IArrayThread[countThreads];
        int diapason = (int) Math.ceil((double)array.length / countThreads);
        int startIndex = 0;
        for (int i = 0; i < countThreads; i++) {
            CalculatorThread thread = new CalculatorThread(
                    startIndex, startIndex + diapason, array);
            thread.start();
            arrayOfThreads[i] = thread;
            startIndex += diapason;
        }
        try {
            for (IArrayThread thread : arrayOfThreads) {
                ((CalculatorThread) thread).join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.stream(arrayOfThreads).mapToLong(IArrayThread::getSum).sum();
    }

    /**
     * Calculating sum of elements without multithreading
     *
     * @return sum of elements using streams
     */
    public long getSumOfArraySequential() {
        Objects.requireNonNull(array);
        return Arrays.stream(array).mapToLong(elem -> elem).sum();
    }
}
