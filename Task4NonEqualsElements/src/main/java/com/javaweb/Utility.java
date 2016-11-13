package com.javaweb;

import java.util.*;

/**
 * Class for finding different numbers in two arrays.
 * In "Set Theory" it is symmetric difference.
 * Here are 3 algorithms : with sorting arrays
 * (it will be at least O(log(n)) {@link #findNonEqualsSorted(int[], int[])}.
 * Without sorting {@link #findNonEqualsNonSorted(int[], int[])}.
 * And using collection HashSet
 * {@link #findNonEqualsWithCollection(int[], int[])}
 */
public class Utility {
    /**
     * Find symmetric difference no using sorting
     * and collections.
     *
     * @param array1 first array;
     * @param array2 second array;
     * @return array with symmetric difference of
     * array1 and array2;
     */
    public List<Integer> findNonEqualsNonSorted(
            int[] array1, int[] array2) {
        List<Integer> result = new ArrayList<>();
        // find different elements in first array
        findDifferentInOneArray(result, array1, array2);
        // find different elements in second array
        findDifferentInOneArray(result, array2, array1);
        return result;
    }

    /**
     * Helper method for {@link #findNonEqualsNonSorted(int[], int[])}
     *
     * @param result array with symmetric difference of
     *               array1 and array2;
     * @param array1 first array;
     * @param array2 second array;
     */
    private void findDifferentInOneArray(
            List<Integer> result, int[] array1, int[] array2) {
        for (int i = 0; i < array2.length; i++) {
            if (!result.contains(array2[i])) {
                int j = 0;
                while (j < array1.length) {
                    if (array2[i] == array1[j]) {
                        break;
                    }
                    j++;
                }
                if (j == array1.length) {
                    result.add(array2[i]);
                }
            }
        }
    }

    /**
     * Find symmetric difference using collection HashSet.
     *
     * @param array1 first array;
     * @param array2 second array;
     * @return array with symmetric difference of
     * array1 and array2;
     */
    public List<Integer> findNonEqualsWithCollection(
            int[] array1, int[] array2) {
        Set<Integer> arrList1 = new HashSet<>();
        for (int elem : array1) {
            arrList1.add(elem);
        }
        Set<Integer> arrList2 = new HashSet<>();
        for (int elem : array2) {
            arrList2.add(elem);
        }

        // Union minus intersection(discrete mathematics)
        List<Integer> result = new ArrayList<>(arrList1);
        result.addAll(arrList2);
        arrList1.retainAll(arrList2);
        result.removeAll(arrList1);
        return result;
    }

    /**
     * Find symmetric difference using sorting
     *
     * @param array1 first array;
     * @param array2 second array;
     * @return array with symmetric difference of
     * array1 and array2;
     */
    public List<Integer> findNonEqualsSorted(
            int[] array1, int[] array2) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(array1);
        Arrays.sort(array2);

        int firstIndex = 0;
        int secondIndex = 0;

        while ((firstIndex < array1.length) && (secondIndex < array2.length)) {
            while (secondIndex < array2.length - 1 && array2[secondIndex] == array2[secondIndex + 1]) {
                secondIndex++;
            }
            while (firstIndex < array1.length - 1 && array1[firstIndex] == array1[firstIndex + 1]) {
                firstIndex++;
            }
            if ((array1[firstIndex] != array2[secondIndex])) {
                result.add(array1[firstIndex++]);
                result.add(array2[secondIndex++]);
            } else {
                firstIndex++;
                secondIndex++;
            }
            /* If one array is larger than another */
            if (firstIndex >= array1.length) {
                while (secondIndex < array2.length) {
                    result.add(array2[secondIndex++]);
                }
            } else if (secondIndex >= array2.length) {
                while (firstIndex < array1.length) {
                    result.add(array1[firstIndex++]);
                }
            }

        }
        return result;
    }
}
