package com.javaweb;

import java.util.ArrayList;

/**
 * Created by Dron on 02-Nov-16.
 */
public class ArraySolver {

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
        for (int i = 1; i < array.length; i++) {
            if (array[i] > result[ELEMENT_VALUE]) {
                result[ELEMENT_INDEX] = i;
                result[ELEMENT_VALUE] = array[i];
            }
        }
        return result;
    }

    public int[] findMin() {
        int[] result = new int[RESULT_ARRAY_SIZE];
        result[ELEMENT_INDEX] = 0;
        result[ELEMENT_VALUE] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < result[ELEMENT_VALUE]) {
                result[ELEMENT_INDEX] = i;
                result[ELEMENT_VALUE] = array[i];
            }
        }
        return result;
    }

    public double getAverage() {
        return array.length != 0 ? ((double) this.sumElements() / array.length) : 0.0;

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
            if (array[i] == value) {
                resultArraySize++;
            }
        }
        int[] resultArray = new int[resultArraySize];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                resultArray[j++] = i;
            }
        }
        return resultArray;
    }

    public boolean isSortedAsc(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isSortedDesc(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void shiftRightArray(int count) {
        if (count == array.length) {
            return;
        } else if (count > array.length) {
            count -= array.length;
        }
        for (int i = 0; i < count; i++) {
            int temp = array[array.length - 1];
            for (int j = array.length - 2; j >= 0; j--) {
                array[j + 1] = array[j];
            }
            array[0] = temp;
        }
    }

    public int getCountValuesMoreAverage() {
        int count = 0;
        double average = getAverage();
        for (int elem : array) {
            if (elem > average) {
                count++;
            }
        }
        return count;
    }

    public ArrayList<Integer> getElemsArrayNotInSecondArray(int[] secondArray) {
        ArrayList<Integer> result = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            while ((secondArray[j++] != array[i]) && (j < secondArray.length)) {
            }
            if (j >= secondArray.length) {
                result.add(array[i]);
            }
            j = 0;
        }
        return result;
    }

    public int getCountOfElementsEqualsFirst() {
        return getCountEquals(array[0]);
    }

    public ArrayList<Integer> makeSortedArrayFromTwo(int[] array1, int[] array2) {
        ArrayList<Integer> result = new ArrayList<>();
        if (isSortedAsc(array1) && isSortedAsc(array2)) {
            int j = 0;
            for (int i = 0; i < array1.length; i++) {
                while ((j < array2.length) && (array2[j] <= array1[i])) {
                    result.add(array2[j]);
                    j++;
                }
                result.add(array1[i]);
            }
        } else if (isSortedDesc(array1) && isSortedDesc(array2)) {
            int j = 0;
            for (int i = 0; i < array1.length; i++) {
                while ((j < array2.length) && (array2[j] >= array1[i])) {
                    result.add(array2[j]);
                    j++;
                }
                result.add(array1[i]);
            }
        } else {
            return null;
        }
        return result;
    }

    public void changeFirstPositiveWithLastMirror() {
        int i = 0;
        int j = array.length - 1;
        while ((i <= array.length / 2) &&
                (j >= array.length / 2 + 1)) {
            if(array[i] < 0){
                i++;
            }
            if(array[j] < 0){
                j--;
            }
            if(array[i] >= 0 && array[j] >= 0){
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }
}
