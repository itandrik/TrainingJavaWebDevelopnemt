package com.javaweb;

/**
 * Test functions of custom HashMap
 *
 * @author Andrii Chernysh
 */
public class MyHashMapMain {
    public static void main(String[] args) {
        MyHashMap<String, Integer> hashMap = new MyHashMap<>();
        hashMap.put(null,123);
        hashMap.put(null,124);

        hashMap.put("1",1);
        hashMap.put("2",2);
        hashMap.put("3",3);
        hashMap.put("4",4);

        hashMap.put("5",1);
        hashMap.put("6",2);
        hashMap.put("7",3);
        hashMap.put("8",4);
        //hashMap.put("8",10);
        hashMap.put("8",100500);

        hashMap.put("9",1);
        hashMap.put("10",2);
        hashMap.put("11",3);
        hashMap.put("12",4);
        hashMap.put("13",23);

        System.out.println("remove : " + hashMap.remove(null));
        System.out.println("get : " + hashMap.get(null));

        System.out.println(hashMap.toString());
    }
}
