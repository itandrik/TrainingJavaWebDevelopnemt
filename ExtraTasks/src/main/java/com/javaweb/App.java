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
        int[] maxElement = solver.findMax();
        System.out.println("Max element : array[" +
                maxElement[ArraySolver.ELEMENT_INDEX] + "] = " +
                maxElement[ArraySolver.ELEMENT_VALUE] + ";");

        //3
        int[] minElement = solver.findMin();
        System.out.println("Min element : array[" +
                minElement[ArraySolver.ELEMENT_INDEX] + "] = " +
                minElement[ArraySolver.ELEMENT_VALUE] + ";");

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

        //13
        System.out.println("Last negative element : " +
                solver.getLastNegativeElement());

        //14
        System.out.println("Get indexes of value 0 : " +
                Arrays.toString(solver.getIndexesOfValue(0)));

        //15
        //-----------------------------------------------------
        // new values of array
        int[] array2 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        solver.setArray(array2);
        System.out.println("Reset array, array : " +
                Arrays.toString(solver.getArray()));

        System.out.println("is sorted asc : " + solver.isSortedAsc(array2));

        //16
        System.out.println("is sorted desc : " + solver.isSortedDesc(array2));

        //17
        System.out.println("Your array before shift right 4: " +
                Arrays.toString(solver.getArray()));
        solver.shiftRightArray(4);
        System.out.println("Your array after shift right 4: " +
                Arrays.toString(solver.getArray()));

        //18 - need to ask

        //19
        System.out.println("Get count values more than average number : " +
                solver.getCountValuesMoreAverage());

        //20 - need to ask

        //21
        int[] secondArray = {6, 10, 7, 9, 11};
        System.out.println("First array : " +
                Arrays.toString(solver.getArray()));
        System.out.println("Second array : " +
                Arrays.toString(secondArray));
        System.out.println("get elements from array which are not in" +
                " second array : " +
                solver.getElemsArrayNotInSecondArray(secondArray).toString());

        //22
        System.out.println("Count of elements, which equals with first :" +
                solver.getCountOfElementsEqualsFirst());

        //23
        int[] arrayFirst = {3, 4, 5, 9, 10, 100, 200};
        int[] arraySecond = {0, 1, 2, 5, 11, 23, 45, 101};
        System.out.println("\t\tMake sorted third array from : ");
        System.out.println("First array : " + Arrays.toString(arrayFirst));
        System.out.println("Second array : " + Arrays.toString(arraySecond));
        System.out.println("Third array : " +
                solver.makeSortedArrayFromTwo(arrayFirst, arraySecond).toString());

        //24
        int[] arrayFor24 = {-1,-2,3,4,-3,5,10,-15,-20,-30,-40,10,7};
        solver.setArray(arrayFor24);
        System.out.println("Array before swap first and last positive : " +
                Arrays.toString(arrayFor24));
        solver.changeFirstPositiveWithLastMirror();
        System.out.println("Array after swap first and last positive : " +
                Arrays.toString(solver.getArray()));


    }
}
