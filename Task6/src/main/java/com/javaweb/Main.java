package com.javaweb;

import java.util.Arrays;

/**
 * Main.java
 * <p>
 * Test methods from custom ArrayList {@link MyArrayList}.
 *
 * @author Andrii Chernysh
 * @version 1.0, 20 Nov 2016
 */
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> al =  new MyArrayList<>(Arrays.asList(1,2,3,4,5,6,1,8));
        System.out.println(al.subList(3,5).toString());
        al.retainAll(Arrays.asList(1,3,4,11,12,13));
        System.out.println(al.toString());
    }
}
