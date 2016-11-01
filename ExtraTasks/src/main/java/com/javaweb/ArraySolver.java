package com.javaweb;

/**
 * Created by Dron on 02-Nov-16.
 */
public class ArraySolver {
    public static final int ARRAY_SIZE = 30;

    /**
     * Indexes and size for array, which i will use in
     * {@link #findMax() and #findMin}
     */
    public static final int RESULT_ARRAY_SIZE = 2;
    public static final int ELEMENT_INDEX = 0;
    public static final int ELEMENT_VALUE = 1;

    private int[] array;

    public ArraySolver(int[] array) {
        this.array = array;
    }

    public int sumElements() {
        int result = 0;
        for (int elem : array) {
            result += elem;
        }
        return result;
    }

    public int[] findMax() {
        int[] result = new int[RESULT_ARRAY_SIZE];
        result[ELEMENT_INDEX] = 0;
        result[ELEMENT_VALUE] = array[0];
        boolean flag = false;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                result[ELEMENT_INDEX] = i;
                result[ELEMENT_VALUE] = array[i];
                flag = true;
            }
        }
        return flag ? result : null;
    }

    public int[] findMin() {
        int[] result = new int[RESULT_ARRAY_SIZE];
        result[ELEMENT_INDEX] = 0;
        result[ELEMENT_VALUE] = array[0];
        boolean flag = false;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                result[ELEMENT_INDEX] = i;
                result[ELEMENT_VALUE] = array[i];
                flag = true;
            }
        }
        return flag ? result : null;
    }

    public double getAverage() {
        return array.length != 0 ? (this.sumElements() / array.length) : 0.0;

    }

    public int getCountEquals(int value) {
        int result = 0;
        for (int elem : array) {
            if (elem == value) {
                result++;
            }
        }
        return result;
    }

    public int getCountZero() {
        return getCountEquals(0);
    }

    public int getCountPositive() {
        int result = 0;
        for (int elem : array) {
            if (elem >= 0) {
                result++;
            }
        }
        return result;
    }

    public void mulArrayByValue(int value) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= value;
        }
    }

    public void addIndexToElements() {
        for (int i = 0; i < array.length; i++) {
            array[i] += i;
        }
    }

    public void setEvenToZero() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i] = 0;
            }
        }
    }

    public void setValuesWithOddIndexToZero() {
        for (int i = 1; i < array.length; i += 2) {
            array[i] = 0;
        }
    }

    public int getFirstPositiveElement() {
        for (int elem : array) {
            if (elem >= 0) {
                return elem;
            }
        }
        return -1;
    }

    public int getLastNegativeElement() {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] < 0) {
                return array[i];
            }
        }
        return 0;
    }

    public int[] getIndexesOfValue(int value) {
        int resultArraySize = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == value){
                resultArraySize++;
            }
        }
        int [] resultArray = new int[resultArraySize];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == value){
                resultArray[j++] = i;
            }
        }
        return resultArray;
    }

    public boolean isSortedAsc(){
        for (int i = 0; i < array.length-1; i++) {
            if(array[i] < array[i + 1]){
                return false;
            }
        }
        return true;
    }

    public boolean isSortedDesc(){
        for (int i = 0; i < array.length-1; i++) {
            if(array[i] > array[i + 1]){
                return false;
            }
        }
        return true;
    }
    
   /* public void shiftRightArray(int count){
        int temp = array[count-1];
        for (int i = 0; i < count; i++) {
            array[count - ]
        }
    }*/

    public int[] getArray() {
        return array;
    }
}
