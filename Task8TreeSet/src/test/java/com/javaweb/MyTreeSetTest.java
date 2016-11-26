package com.javaweb;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Unit test for simple MyTreeSet.
 */
public class MyTreeSetTest {
    private MyTreeSet<Integer> treeSet;

    @Before
    public void setUp() throws Exception {
        treeSet = new MyTreeSet<>(Arrays.asList(1, 5, 7, 2, 34, 10, 6, 6));
    }

    @Test
    public void testSize() throws Exception {
        Assert.assertEquals(treeSet.size(), 7);
    }

    @Test
    public void testIsEmpty() throws Exception {
        Assert.assertFalse(treeSet.isEmpty());
        treeSet.clear();
        Assert.assertTrue(treeSet.isEmpty());
    }

    @Test
    public void testContains() throws Exception {
        Assert.assertTrue(treeSet.contains(5));
        Assert.assertFalse(treeSet.contains(100500));
    }

    @Test
    public void testAddAll() throws Exception {
        Assert.assertArrayEquals(treeSet.toArray(),
                new Object[]{2, 6, 10, 34, 7, 5, 1});
    }

    @Test
    public void testAdd() throws Exception {
        treeSet.add(100500);
        Assert.assertFalse(treeSet.find(100500) == null);
    }

    @Test
    public void testToArray() throws Exception {
        Assert.assertArrayEquals(treeSet.toArray(),
                new Object[]{2, 6, 10, 34, 7, 5, 1});
    }

    @Test
    public void testRemove() throws Exception {
        treeSet.remove(10);
        Assert.assertTrue(treeSet.size() == 6);
        Assert.assertArrayEquals(treeSet.toArray(), new Object[]{2, 6, 34, 7, 5, 1});
    }

}
