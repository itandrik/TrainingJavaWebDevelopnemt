package com.javaweb;

/**
 * Custom HashMap, that contains all basic methods,
 * like {@link java.util.HashMap} from Collection API
 *
 * @author Andrii Chernysh
 */
public class MyHashMap<K, V> {
    /**
     * Array with elements of HashMap
     */
    private Node<K, V>[] buckets;
    /**
     * Quantity of elements in HashMap
     */
    private int size;
    /**
     * Default capacity for HashMap is 16;
     * It is initial array size;
     */
    private static final int DEFAULT_CAPACITY = 16;
    /**
     * Constant for initialising load factor of HashMap
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    /**
     * Same as buckets.length
     */
    private int capacity;
    /**
     * when size more then threshold, we should
     * increase size of array
     */
    private int threshold;

    /**
     * Element of array
     *
     * @param <K> key
     * @param <V> value
     */
    class Node<K, V> {
        Node next;
        int hash;
        K key;
        V value;

        public Node(Node next, int hash, K key, V value) {
            this.next = next;
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        @Override
        public int hashCode() {
            return key.hashCode() ^ value.hashCode();
        }
    }

    /**
     * Initial constructor
     */
    public MyHashMap() {
        clear();
    }

    /**
     * Constructor with initial putting entries
     *
     * @param map some entries of map
     */
    public MyHashMap(MyHashMap map) {
        clear();
        putAll(map);
    }

    /**
     * Computes key.hashCode().
     * Because the table uses power-of-two masking, sets of
     * hashes that vary only in bits above the current mask will
     * always collide.
     *
     * @param key key of element
     * @return hash code for buckets array
     */
    private int hash(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % capacity);
    }

    /**
     * When size becomes more than threshold,
     * HashMap should be increased
     */
    private void checkSize() {
        if (size >= threshold) {
            Node<K, V>[] bucketsTemp = new Node[capacity];
            for (int i = 0; i < capacity; i++) {
                bucketsTemp[i] = buckets[i];
            }
            buckets = new Node[capacity + threshold];
            size = 0;
            capacity = buckets.length;
            threshold = (int) (capacity * DEFAULT_LOAD_FACTOR);
            for (Node<K, V> aBucketsTemp : bucketsTemp) {
                if (aBucketsTemp != null) {
                    Node<K, V> curNode = aBucketsTemp;
                    while (curNode != null) {
                        put(curNode.key, curNode.value);
                        curNode = curNode.next;
                    }
                }
            }
        }
    }

    public void clear() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
        capacity = buckets.length;
        threshold = (int) (capacity * DEFAULT_LOAD_FACTOR);
    }

    public V put(K key, V value) {
        int hash = hash(key);
        if (key == null) {
            V previousValue = null;
            if (buckets[hash] != null) {
                previousValue = buckets[hash].value;
                buckets[hash].value = value;
            } else {
                buckets[hash] = new Node<>(null, 0, null, value);
                size++;
                checkSize();
            }
            return previousValue;
        }
        Node<K, V> curNode = buckets[hash];
        if (curNode == null) {
            buckets[hash] = new Node<>(null, key.hashCode(), key, value);
            size++;
            checkSize();
            return value;
        }
        Node<K, V> previousNode = curNode;
        while (curNode != null) {
            previousNode = curNode;
            if (key.equals(curNode.key)) {
                previousNode.value = curNode.value;
                curNode.value = value;
                return previousNode.value;
            }
            curNode = curNode.next;
        }
        previousNode.next = new Node<>(null, key.hashCode(), key, value);
        size++;
        checkSize();
        return null;
    }

    public void putAll(MyHashMap<K, V> map) {
        for (int i = 0; i < map.capacity; i++) {
            if (map.buckets[i] != null) {
                put(map.buckets[i].key, map.buckets[i].value);
            }
        }
    }

    public V get(K key) {
        int hash = hash(key);
        if (key == null) {
            return buckets[hash].value;
        }
        Node<K, V> curNode = buckets[hash];
        while (curNode != null) {
            if (key.equals(curNode.key)) {
                return curNode.value;
            }
            curNode = curNode.next;
        }
        return null;
    }

    public V remove(K key) {
        int hash = hash(key);
        Node<K, V> curNode = buckets[hash];
        if (curNode == null) {
            return null;
        }
        Node<K, V> prevNode = curNode;
        if (key == null) {
            buckets[hash] = curNode.next;
            size--;
            return prevNode.value;
        }
        while (curNode != null) {
            if (key.equals(curNode.key)) {
                prevNode.next = curNode.next;
                size--;
                return curNode.value;
            }
            prevNode = curNode;
            curNode = curNode.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        Node<K, V> curNode;
        for (int i = 0; i < buckets.length; i++) {
            curNode = buckets[i];
            if (curNode == null) {
                sb.append("bucket [" + i + "] = null\n");
            } else {
                sb.append("bucket [" + i + "] : \n");
                while (curNode != null) {
                    sb.append("\tbucket [" + (j++) + "] = (" + curNode.key + "," + curNode.value + ");\n");
                    curNode = curNode.next;
                }
                j = 0;
            }
        }
        sb.append("Size : " + size);
        return sb.toString();
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map
     */
    public int size() {
        return size;
    }

    /**
     * Returns <tt>true</tt> if this map contains no key-value mappings.
     *
     * @return <tt>true</tt> if this map contains no key-value mappings
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(K key) {
        int hash = hash(key);
        Node<K, V> curNode = buckets[hash];
        if (curNode == null) {
            return false;
        }
        if (key == null && curNode.key == null) {
            return true;
        } else {
            while (curNode != null) {
                if (key != null && key.equals(curNode.key)) {
                    return true;
                }
                curNode = curNode.next;
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                Node<K, V> curNode = buckets[i];
                while (curNode != null) {
                    if (((value == null) && (curNode.value == null)) ||
                            ((value != null) && (value.equals(curNode.value)))) {
                        return true;
                    }
                    curNode = curNode.next;
                }
            }
        }
        return false;
    }
}
