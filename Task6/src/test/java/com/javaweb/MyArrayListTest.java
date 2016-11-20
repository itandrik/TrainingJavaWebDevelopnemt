package com.javaweb;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Dron on 20-Nov-16.
 */
public class MyArrayListTest {
    private MyArrayList<Integer> arrayList;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp(){
        arrayList = new MyArrayList<>();
        arrayList.addAll(Arrays.asList(1,2,3,4,5,6,1,8));
    }
    @Test
    public void indexOf(){
        Assert.assertEquals("Find index of element",arrayList.indexOf(1),0);
        Assert.assertEquals("No such element",arrayList.indexOf(9),-1);
        Assert.assertEquals("No null",arrayList.indexOf(null),-1);
    }

    @Test
    public void lastIndexOf(){
        Assert.assertEquals("Find last index of element",arrayList.lastIndexOf(1),6);
        Assert.assertEquals("No such element",arrayList.indexOf(9),-1);
        Assert.assertEquals("No null",arrayList.indexOf(null),-1);
    }

    @Test
    public void toArray(){
        Assert.assertArrayEquals(arrayList.toArray(),new Object[]{1,2,3,4,5,6,1,8});
        Assert.assertNotSame(arrayList.toArray(),new Object[]{1,2,null,4,5,6,1,8});
    }

    @Test
    public void subList(){
        List<Integer> list = arrayList.subList(3,5);
        Assert.assertArrayEquals(list.toArray(),Arrays.asList(4,5).toArray());
    }

    @Test
    public void subListWithError() {
        expectedException.expect(IndexOutOfBoundsException.class);
        arrayList.subList(-1,8);
    }

    @Test
    public void set(){
        arrayList.set(1,100500);
        Assert.assertArrayEquals(arrayList.toArray(),new Object[]{
                1,100500,3,4,5,6,1,8});

    }

    @Test
    public void setWithError(){
        expectedException.expect(IndexOutOfBoundsException.class);
        arrayList.set(-1,100500);
    }
    //check
    @Test
    public void add(){

    }

    @Test
    public void addWithIndex(){

    }

    @Test
    public void size() {
        Assert.assertSame(arrayList.size(),8);
    }

    @Test
    public void isEmpty(){
        Assert.assertFalse(arrayList.isEmpty());
    }

    @Test
    public void contains(){
        Assert.assertTrue(arrayList.contains(2));
    }

    @Test
    public void containsWithError(){
        expectedException.expect(NullPointerException.class);
        Assert.assertFalse(arrayList.contains(null));
    }

    @Test
    public void removeWithIndex(){
        arrayList.remove(1);
        Assert.assertArrayEquals(arrayList.toArray(),
                new Object[]{1, 3, 4, 5, 6, 1, 8});
    }

    @Test
    public void removeWithObject(){
        arrayList.remove((Object)1);
        Assert.assertArrayEquals(arrayList.toArray(),
                new Object[]{2, 3, 4, 5, 6, 1, 8});
    }

    @Test
    public void clear(){
        arrayList.clear();
        Assert.assertTrue(arrayList.size() == 0);
    }

    @Test
    public void get(){

    }

    @Test
    public void remove1(){

    }

    @Test
    public void addAll() throws Exception {

    }

    @Test
    public void addAll1() throws Exception {

    }

    @Test
    public void retainAll() throws Exception {

    }

    @Test
    public void removeAll() throws Exception {

    }

    @Test
    public void containsAll() throws Exception {

    }

    @Test
    public void toArray1() throws Exception {

    }

    @Test
    public void listIterator() throws Exception {

    }

    @Test
    public void listIterator1() throws Exception {

    }

    @Test
    public void iterator() throws Exception {

    }

}