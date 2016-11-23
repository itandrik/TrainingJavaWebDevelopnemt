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
 * JUnit test class. Here custom LinkedList
 * has been tested. Almost all methods are covered.
 *
 * @author Andrii Chernysh
 * @version 1.0, 22 Nov 2016
 */
public class MyLinkedListTest {
    public MyLinkedList<Integer> linkedList;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        linkedList = new MyLinkedList<>();
        linkedList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 1, 8));
    }

    @Test
    public void indexOf() {
        Assert.assertEquals("Find index of element", linkedList.indexOf(1), 0);
        Assert.assertEquals("No such element", linkedList.indexOf(9), -1);
        Assert.assertEquals("No null", linkedList.indexOf(null), -1);
    }

    @Test
    public void lastIndexOf() {
        Assert.assertEquals("Find last index of element",
                linkedList.lastIndexOf(1), 6);
        Assert.assertEquals("No such element", linkedList.indexOf(9), -1);
        Assert.assertEquals("No null", linkedList.indexOf(null), -1);
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(linkedList.toArray(),
                new Object[]{1, 2, 3, 4, 5, 6, 1, 8});
        Assert.assertNotSame(linkedList.toArray(),
                new Object[]{1, 2, null, 4, 5, 6, 1, 8});
    }

    @Test
    public void subList() {
        List<Integer> list = linkedList.subList(3, 5);
        System.out.println(list.toString());
        Assert.assertArrayEquals(list.toArray(),
                Arrays.asList(4, 5).toArray());
    }

    @Test
    public void subListWithError() {
        expectedException.expect(IndexOutOfBoundsException.class);
        linkedList.subList(-1, 8);
    }

    @Test
    public void set() {
        linkedList.set(1, 100500);
        Assert.assertArrayEquals(linkedList.toArray(), new Object[]{
                1, 100500, 3, 4, 5, 6, 1, 8});

    }

    @Test
    public void setWithError() {
        expectedException.expect(IndexOutOfBoundsException.class);
        linkedList.set(-1, 100500);
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
        Assert.assertSame(linkedList.size(), 8);
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(linkedList.isEmpty());
    }

    @Test
    public void contains() {
        Assert.assertTrue(linkedList.contains(2));
        Assert.assertFalse(linkedList.contains(null));
        Assert.assertFalse(linkedList.contains(-5));
    }

    @Test
    public void removeWithIndex() {
        linkedList.remove(1);
        Assert.assertArrayEquals(linkedList.toArray(),
                new Object[]{1, 3, 4, 5, 6, 1, 8});
    }

    @Test
    public void removeWithObject() {
        linkedList.remove((Object) 1);
        Assert.assertArrayEquals(linkedList.toArray(),
                new Object[]{2, 3, 4, 5, 6, 1, 8});
    }

    @Test
    public void clear() {
        linkedList.clear();
        Assert.assertTrue(linkedList.size() == 0);
    }

    @Test
    public void get() {
        Assert.assertSame(linkedList.get(3), 4);
    }

    @Test
    public void getWithError() {
        expectedException.expect(IndexOutOfBoundsException.class);
        Assert.assertNotSame(linkedList.get(-1), 4);
    }

    @Test
    public void addAll() {
        linkedList.addAll(Arrays.asList(10, 11, 12));
        Assert.assertArrayEquals(linkedList.toArray(),
                new Object[]{1, 2, 3, 4, 5, 6, 1, 8, 10, 11, 12});
    }

    @Test
    public void addAllWithIndex() {
        linkedList.addAll(3, Arrays.asList(10, 11, 12));
        Assert.assertArrayEquals(linkedList.toArray(),
                new Object[]{1, 2, 3, 10, 11, 12, 4, 5, 6, 1, 8});
    }

    @Test
    public void retainAll() {
        linkedList.retainAll(Arrays.asList(1, 3, 4, 11, 12, 13));
        Assert.assertArrayEquals(linkedList.toArray(),
                new Object[]{1, 3, 4, 1});
    }

    @Test
    public void removeAll() {
        linkedList.removeAll(Arrays.asList(1, 3, 4));
        Assert.assertArrayEquals(linkedList.toArray(),
                new Object[]{2, 5, 6, 8});
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(linkedList.containsAll(Arrays.asList(1, 3, 4)));
        Assert.assertFalse(linkedList.containsAll(Arrays.asList(100500, 3, 4)));
    }

    @Test
    public void iteratorHasNext() {
        Iterator<Integer> iterator = linkedList.iterator();
        Assert.assertTrue(iterator.hasNext());
    }

    @Test
    public void iteratorNext() {
        Iterator<Integer> iterator = linkedList.iterator();
        Assert.assertNotSame(iterator.next(), 2);
    }
}
