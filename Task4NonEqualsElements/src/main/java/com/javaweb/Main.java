package com.javaweb;


public class Main {
    public static void main(String[] args) {
        /* Input data */
        int[] array1 = {0, 2, 4, 6, 0, 11, 9, 100};
        int[] array2 = {21, 41, 1, 6, 9, 1, 3, 3, 1, 0, 10, 55};

        /* Initialize Util class */
        Utility arrUtil = new Utility();

        /* Show result of our operation */
        System.out.println(arrUtil.findNonEqualsNonSorted(array1,array2));
        System.out.println(arrUtil.findNonEqualsWithCollection(array1,array2));
        System.out.println(arrUtil.findNonEqualsSorted(array1,array2));
    }
}
