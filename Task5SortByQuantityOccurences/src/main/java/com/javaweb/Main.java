package com.javaweb;

import java.util.*;

/**
 * Simple class, that sort array by number element's occurrences
 */
public class Main {
    public static void main(String[] args) {
        /* Array to sort */
        int[] array = {1, 4, 7, 3, 7, 8, 4, 12, 2, 5, 1, 2, 3, 4, 5, 6, 7, 8};
        //1,1,2,2,3,3,4,4,4,5,5,6,7,7,7,8,8,12
        //12,6,1,1,2,2,3,3,5,5,8,8,4,4,4,7,7,7

        sortByQuantityOccurrences(array);
    }

    /**
     * Firstly, we should create HashMap, where key - element,
     * value - number of occurrences. Secondly, we should make
     * TreeMap<Integer,Set<Integer>>, where key - number of occurrences,
     * value - set of elements, which has such quantity of occurrences.
     * Next we just create List with our result
     *
     * @param array Array to sort
     */
    private static void sortByQuantityOccurrences(int[] array) {
        Map<Integer, Set<Integer>> occurrenceTree = new TreeMap<>();
        Map<Integer, Integer> occurrenceMap = new HashMap<>();

        /* Firstly, we should create HashMap, where key - element,
         * value - number of occurrences. */
        for (int i = 0; i < array.length; i++) {
            if (occurrenceMap.containsKey(array[i])) {
                occurrenceMap.replace(array[i], occurrenceMap.get(array[i]),
                        occurrenceMap.get(array[i]) + 1);
            } else {
                occurrenceMap.put(array[i], 1);
            }
        }

        /* Secondly, we should make
         * TreeMap<Integer,Set<Integer>>, where key - number of occurrences,
         * value - set of elements, which has such quantity of occurrences. */
        for (Integer elem : occurrenceMap.keySet()) {
            if (!occurrenceTree.containsKey(occurrenceMap.get(elem))) {
                Set<Integer> set = new HashSet<>();
                set.add(elem);
                occurrenceTree.put(occurrenceMap.get(elem), set);
            } else {
                occurrenceTree.get(occurrenceMap.get(elem)).add(elem);
            }
        }
        // Simple show message to see is all right.
        for (Integer i : occurrenceTree.keySet()) {
            System.out.println("occurrence number : " + i);
            System.out.println("Set : " + occurrenceTree.get(i).toString());
        }
        // Next we just create List with our result
        List<Integer> result = new ArrayList<>();
        for (Integer occurrenceNumber : occurrenceTree.keySet()) {
            for (Integer setElement : occurrenceTree.get(occurrenceNumber)) {
                for (int i = 0; i < occurrenceNumber; i++) {
                    result.add(setElement);
                }
            }
        }

        // Writing to console
        System.out.println("Result array : " + result.toString());
    }
}
