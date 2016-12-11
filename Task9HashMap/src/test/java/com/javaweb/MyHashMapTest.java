package com.javaweb;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple MyHashMap.
 *
 * @author Andrii Chernysh
 */
public class MyHashMapTest{
    private MyHashMap<Integer, Integer> empty;
    private MyHashMap<Integer, Integer> map1;
    private MyHashMap<Integer, Integer> map2;
    private MyHashMap<Integer, Integer> map3;

    @Before
    public void init() {
        empty = new MyHashMap<>();
        map1 = new MyHashMap<Integer, Integer>() {{
            put(1, 11);
        }};
        map2 = new MyHashMap<Integer, Integer>() {{
            put(1, 11);
            put(2, 22);
        }};
        map3 = new MyHashMap<Integer, Integer>() {{
            put(1, 11);
            put(2, 22);
            put(3, 33);
        }};
    }


    @Test
    public void size() throws Exception {
        assertEquals("empty", 0, empty.size());
        assertEquals("1 entry", 1, map1.size());
        assertEquals("2 entry", 2, map2.size());
        assertEquals("3 entry", 3, map3.size());
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue("empty", empty.isEmpty());
        assertFalse("2 el", map2.isEmpty());
    }

    @Test
    public void containsKey() throws Exception {
        assertFalse("empty", empty.containsKey(1));
        assertTrue("1 el", map1.containsKey(1));
        assertTrue("3 el", map3.containsKey(2));
        assertFalse("3 el - no such el", map3.containsKey(54648641));
    }

    @Test
    public void containsValue() throws Exception {
        assertFalse("empty", empty.containsValue(11));
        assertTrue("1 el", map1.containsValue(11));
        assertTrue("3 el", map3.containsValue(22));
    }

    @Test
    public void get() throws Exception {
        assertEquals("1.",new Integer(11),map1.get(1));
        assertEquals("2.",new Integer(22),map3.get(2));
        assertEquals("3.",new Integer(33),map3.get(3));
        assertNull("null 1.",empty.get(1));
        assertNull("null 2.",map3.get(4));
    }

    @Test
    public void put() throws Exception {
        for (int i = -128; i < 128; i++) {
            empty.put(i, i * i);
            assertEquals("size=" + (i + 129), i + 129, empty.size());
        }
        System.out.println(empty);
        for (int i = -128; i < 128; i++) {
            assertTrue("contains key=" + i, empty.containsKey(i));
            assertTrue("contains value=" + i, empty.containsValue(i * i));
        }
    }

    @Test
    public void putEqualsHashCodes() throws Exception {
        int sizeCounter = 0;
        for (int i = -256; i <= 256; i = i + 16) {
            empty.put(i, i * i);
            sizeCounter++;
            assertEquals("size=" + sizeCounter, sizeCounter, empty.size());
        }

        for (int i = -256; i <= 256; i = i + 16) {
            assertTrue("contains key=" + i, empty.containsKey(i));
            assertTrue("contains value=" + i, empty.containsValue(i * i));
        }
    }

    @Test
    public void remove() throws Exception {
        int sizeCounter = 0;
        for (int i = -256; i <= 256; i = i + 16) {
            empty.put(i, i * i);
            sizeCounter++;
            assertEquals("size=" + sizeCounter, sizeCounter, empty.size());
        }

        for (int i = -256; i <= 256; i = i + 32) {
            assertEquals("key=" + i, new Integer(i * i), empty.remove(i));
            assertNull("key=" + (i + 1), empty.remove(i + 1));
        }
    }

    @Test
    public void clear() throws Exception {
        map3.clear();
        assertEquals("size=0", 0, map3.size());
        assertFalse("get key=1", map3.containsKey(1));
        assertFalse("get key=2", map3.containsKey(2));
        assertFalse("get key=3", map3.containsKey(3));
    }

    @Test
    public void putAll() throws Exception {
        empty.putAll(map3);
        assertTrue("1.", empty.containsKey(1));
        assertTrue("2.", empty.containsKey(2));
        assertTrue("3.", empty.containsKey(3));
    }
}
