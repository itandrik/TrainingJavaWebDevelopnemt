package com.javaweb.controller;

import com.javaweb.model.entity.Aircraft;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Dron on 12-Nov-16.
 */
public class Controller {
    public void processUser(){
        Comparator<Plane> comparator = (p1, p2) ->
                p1.quantityFuel - p2.quantityFuel;
        TreeSet<Plane> treeSet = new TreeSet<>(comparator);
        treeSet.add(new Plane(1));
        treeSet.add(new Plane(45));
        treeSet.add(new Plane(60));
        treeSet.add(new Plane(40));
        treeSet.add(new Plane(10));

        Iterator<Plane> iterator = treeSet.iterator();

        int i = 0;
        while(iterator.hasNext()){
            System.out.println("Plane " + ++i + " : " +
                    iterator.next().quantityFuel + ";");
        }
        for (Aircraft.ManufacturerCountry c: Aircraft.ManufacturerCountry.values()) {
            System.out.println(c);
        }

    }

    private class Plane{
        int quantityFuel;

        public Plane(int quantityFuel) {
            this.quantityFuel = quantityFuel;
        }
    }
}
