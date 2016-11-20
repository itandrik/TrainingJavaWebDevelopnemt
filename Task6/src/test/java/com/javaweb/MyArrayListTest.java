package com.javaweb;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * MyArrayListTest.java
 * <t>
 * JUnit test class. Here custom ArrayList {@link MyArrayList}
 * has been tested. Almost all methods are covered.
 *
 * @author Andrii Chernysh
 * @version 1.0, 20 Nov 2016
 */
public class MyArrayListTest {
    private MyArrayList<Integer> arrayList;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        arrayList = new MyArrayList<>();
        arrayList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 1, 8));
    }

    @Test
    public void indexOf() {
        Assert.assertEquals("Find index of element", arrayList.indexOf(1), 0);
        Assert.assertEquals("No such element", arrayList.indexOf(9), -1);
        Assert.assertEquals("No null", arrayList.indexOf(null), -1);
    }

    @Test
    public void lastIndexOf() {
        Assert.assertEquals("Find last index of element",
                arrayList.lastIndexOf(1), 6);
        Assert.assertEquals("No such element", arrayList.indexOf(9), -1);
        Assert.assertEquals("No null", arrayList.indexOf(null), -1);
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(arrayList.toArray(),
                new Object[]{1, 2, 3, 4, 5, 6, 1, 8});
        Assert.assertNotSame(arrayList.toArray(),
                new Object[]{1, 2, null, 4, 5, 6, 1, 8});
    }

    @Test
    public void subList() {
        List<Integer> list = arrayList.subList(3, 5);
        Assert.assertArrayEquals(list.toArray(),
                Arrays.asList(4, 5).toArray());
    }

    @Test
    public void subListWithError() {
        expectedException.expect(IndexOutOfBoundsException.class);
        arrayList.subList(-1, 8);
    }

    @Test
    public void set() {
        arrayList.set(1, 100500);
        Assert.assertArrayEquals(arrayList.toArray(), new Object[]{
                1, 100500, 3, 4, 5, 6, 1, 8});

    }

    @Test
    public void setWithError() {
        expectedException.expect(IndexOutOfBoundsException.class);
        arrayList.set(-1, 100500);
    }

    //check
    @Test
    public void add() {

    }

    @Test
    public void addWithIndex() {

    }

    @Test
    public void size() {
        Assert.assertSame(arrayList.size(), 8);
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(arrayList.isEmpty());
    }

    @Test
    public void contains() {
        Assert.assertTrue(arrayList.contains(2));
        Assert.assertFalse(arrayList.contains(null));
        Assert.assertFalse(arrayList.contains(-5));
    }

    @Test
    public void removeWithIndex() {
        arrayList.remove(1);
        Assert.assertArrayEquals(arrayList.toArray(),
                new Object[]{1, 3, 4, 5, 6, 1, 8});
    }

    @Test
    public void removeWithObject() {
        arrayList.remove((Object) 1);
        Assert.assertArrayEquals(arrayList.toArray(),
                new Object[]{2, 3, 4, 5, 6, 1, 8});
    }

    @Test
    public void clear() {
        arrayList.clear();
        Assert.assertTrue(arrayList.size() == 0);
    }

    @Test
    public void get() {
        Assert.assertSame(arrayList.get(3), 4);
    }

    @Test
    public void getWithError() {
        expectedException.expect(IndexOutOfBoundsException.class);
        Assert.assertNotSame(arrayList.get(-1), 4);
    }

    @Test
    public void addAll() {
        arrayList.addAll(Arrays.asList(10, 11, 12));
        Assert.assertArrayEquals(arrayList.toArray(),
                new Object[]{1, 2, 3, 4, 5, 6, 1, 8, 10, 11, 12});
    }

    @Test
    public void addAllWithIndex() {
        arrayList.addAll(3, Arrays.asList(10, 11, 12));
        Assert.assertArrayEquals(arrayList.toArray(),
                new Object[]{1, 2, 3, 10, 11, 12, 4, 5, 6, 1, 8});
    }

    @Test
    public void retainAll() {
        arrayList.retainAll(Arrays.asList(1, 3, 4, 11, 12, 13));
        Assert.assertArrayEquals(arrayList.toArray(),
                new Object[]{1, 3, 4, 1});
    }

    @Test
    public void removeAll() {
        arrayList.removeAll(Arrays.asList(1, 3, 4));
        Assert.assertArrayEquals(arrayList.toArray(),
                new Object[]{2, 5, 6, 8});
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(arrayList.containsAll(Arrays.asList(1, 3, 4)));
        Assert.assertFalse(arrayList.containsAll(Arrays.asList(100500, 3, 4)));
    }

    @Test
    public void iteratorHasNext() {
        Iterator<Integer> iterator = arrayList.iterator();
        Assert.assertTrue(iterator.hasNext());
    }

    @Test
    public void iteratorNext() {
        Iterator<Integer> iterator = arrayList.iterator();
        Assert.assertNotSame(iterator.next(), 2);
    }
}