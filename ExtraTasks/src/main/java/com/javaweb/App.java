package com.javaweb;


import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        //MainInstanceTutorials.getInstance().checkInstance();
        int[] array = {0, 1, 15, 40, -1, 300, 24, 5, 6,
                7, 0, 1, 0, 3, 4, 9, 15, -2, -4, 0, -5, 100, 4, 10, 55, -55};
        ArraySolver solver = new ArraySolver(array);

        System.out.println("Your array : " + Arrays.toString(solver.getArray()));
        // 1
        System.out.println("Sum of elements : " + solver.sumElements());

        //2
        int [] maxElement = solver.findMax();
        System.out.println("Max element : array[" +
                maxElement[ArraySolver.ELEMENT_INDEX] + "] = " +
                maxElement[ArraySolver.ELEMENT_VALUE] + ";");

        //3
        int [] minElement = solver.findMin();
        System.out.println("Min element : array[" +
                maxElement[ArraySolver.ELEMENT_INDEX] + "] = " +
                maxElement[ArraySolver.ELEMENT_VALUE] + ";");

        //4
        System.out.println("Average : " + solver.getAverage());

        //5
        System.out.println("Count eqauls value 5 : " +
                solver.getCountEquals(5));

        //6
        System.out.println("Count zero : " + solver.getCountZero());

        //7
        System.out.println("Count positive : " + solver.getCountPositive());

        //8
        System.out.println("Your array before multiplying 5: " +
                Arrays.toString(solver.getArray()));
        solver.mulArrayByValue(5);
        System.out.println("Your array after multiplying 5: " +
                Arrays.toString(solver.getArray()));

        //9
        System.out.println("Your array before adding index: " +
                Arrays.toString(solver.getArray()));
        solver.addIndexToElements();
        System.out.println("Your array after adding index: " +
                Arrays.toString(solver.getArray()));

        //10
        System.out.println("Your array before set even to zero: " +
                Arrays.toString(solver.getArray()));
        solver.setEvenToZero();
        System.out.println("Your array after set even to zero: " +
                Arrays.toString(solver.getArray()));

        //11
        System.out.println("Your array before setValuesWithOddIndexToZero: " +
                Arrays.toString(solver.getArray()));
        solver.setValuesWithOddIndexToZero();
        System.out.println("Your array after setValuesWithOddIndexToZero: " +
                Arrays.toString(solver.getArray()));

        //12
        System.out.println("First positive element : " +
                solver.getFirstPositiveElement());
    }
}
