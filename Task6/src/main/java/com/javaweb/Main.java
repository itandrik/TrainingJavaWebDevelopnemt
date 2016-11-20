package com.javaweb;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Dron on 20-Nov-16.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> al =  new ArrayList<>(Arrays.asList(1,2,3,4,5,6,1,8));
        System.out.println(al.subList(3,5).toString());
        al.remove(1);
        System.out.println(al.toString());
    }
}
