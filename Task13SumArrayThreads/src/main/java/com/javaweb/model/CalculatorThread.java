package com.javaweb.model;

/**
 * Class, that calculates sum of elements of part of array
 *
 * @author Andrii Chernysh on 24-Dec-16.
 *         E-Mail : itcherry97@gmail.com
 */
public class CalculatorThread extends Thread implements IArrayThread{
    /**
     * Start index of part of array
     */
    private int fromIndex;
    /**
     * End index of part of array
     */
    private int toIndex;
    /**
     * Array, that needs to calculate sum of elements
     */
    private int []array;
    /**
     * Sum elements of part of array
     */
    private long sum = 0L;

    /**
     * @param fromIndex start index of part of array
     * @param toIndex end index of part of array
     * @param array array, that needs to calculate sum of elements
     */
    public CalculatorThread(int fromIndex, int toIndex, int[] array) {
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
        this.array = array;
    }

    /**
     * Calculating sum elements of part of array
     */
    @Override
    public void run() {
        super.run();
        if(toIndex > array.length){
            toIndex = array.length;
        } else if((fromIndex > toIndex) ||
                (fromIndex > array.length)){
            return;
        }
        for (int i = fromIndex; i < toIndex; i++) {
            sum += array[i];
        }
    }

    public void setFromIndex(int fromIndex) {
        this.fromIndex = fromIndex;
    }

    public void setToIndex(int toIndex) {
        this.toIndex = toIndex;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public long getSum() {
        return sum;
    }
}
