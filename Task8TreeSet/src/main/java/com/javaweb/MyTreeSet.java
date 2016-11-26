package com.javaweb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Custom {@link java.util.TreeSet}. Basic knowledge
 * has been taken from book "Data structures and algorithms.
 * Robert Lafore". It is container, which use tree for saving
 * data of generic type
 *
 * @param <E> generic type
 * @author Andrii Chernysh
 * @version 1.0 , 26 Nov 2016
 */
public class MyTreeSet<E> {
    /**
     * String for RuntimeException in the method {@link #find(Object)}
     */
    private static final String EMPTY_TREE_MSG =
            "Tree is empty!!!";
    /**
     * Size of tree
     */
    private int size = 0;
    /**
     * Root of tree
     */
    private Node root;
    /**
     * Comparator for tree
     */
    private final Comparator<? super E> comparator;

    /**
     * Default constructor
     */
    public MyTreeSet() {
        comparator = null;
    }

    /**
     * Constructor, that add all elements from some collection
     *
     * @param c collection to add
     */
    public MyTreeSet(Collection<? extends E> c) {
        comparator = null;
        addAll(c);
    }

    /**
     * Initializing container with comparator
     *
     * @param comparator
     */
    public MyTreeSet(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    /**
     * Node structure for tree.
     * It has relations with children and data field.
     * Also it contains flag isDeleted. It is for easy
     * deleting elements from TreeSet.
     *
     * @param <E> generic type
     */
    private class Node<E> {
        E data;
        Node<E> leftChild;
        Node<E> rightChild;
        boolean isDeleted;

        public Node(Node<E> leftChild, E data, Node<E> rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            isDeleted = false;
        }
    }

    /**
     * @return size of TreeSet
     */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        Node<E> current = root;
        if (comparator != null) {
            current = getNodeUsingComparator(element, current);
        } else {
            current = find(element);

        }
        return current != null;
    }

    public Node<E> find(E element) {
        if (!isEmpty()) {
            Node<E> current = root;
            if (comparator != null) {
                return getNodeUsingComparator(element, current);
            } else {
                Comparable<? super E> cmp = (Comparable<? super E>) element;
                while (current != null) {
                    int cmpValue = cmp.compareTo(current.data);
                    if (cmpValue < 0) {
                        current = current.leftChild;
                    } else if (cmpValue > 0) {
                        current = current.rightChild;
                    } else if (!current.isDeleted) {
                        return current;
                    }
                }
                return null;
            }
        } else {
            throw new RuntimeException(EMPTY_TREE_MSG);
        }
    }

    private Node<E> getNodeUsingComparator(E element, Node<E> current) {
        while (current != null) {
            int cmpValue = comparator.compare(element, current.data);
            if (cmpValue < 0) {
                current = current.leftChild;
            } else if (cmpValue > 0) {
                current = current.rightChild;
            } else {
                return current;
            }
        }
        return null;
    }

    public void addAll(Collection<? extends E> c) {
        c.forEach(this::add);
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(null, element, null);
        if (root == null) {
            root = newNode;
            size++;
        } else {
            Node<E> current = root;
            Node<E> parent;
            while (true) {
                parent = current;
                Comparable<? super E> cmp = (Comparable<? super E>) element;
                int cmpValue = cmp.compareTo(current.data);
                if (cmpValue < 0) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        size++;
                        return;
                    }
                } else if (cmpValue > 0) {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        size++;
                        return;
                    }
                } else {
                    return;
                }
            }
        }

    }

    public Object[] toArray() {
        List<Object> result = new ArrayList<>();
        if (!isEmpty()) {
            Node<E> current = root;
            recurToArray(result, current);
        }
        return result.toArray();
    }

    private void recurToArray(List<Object> result, Node<E> current) {
        if (current.leftChild != null) {
            recurToArray(result, current.leftChild);
        }
        if (current.rightChild != null) {
            recurToArray(result, current.rightChild);
        }
        if (!current.isDeleted) {
            result.add(current.data);
        }
    }

    public boolean remove(E element) {
        Node<E> node = find(element);
        if (node != null) {
            node.isDeleted = true;
            size--;
            return true;
        }
        return false;
    }
    /*public boolean remove(E element) {
        Node<E> current = root;
        Node<E> parent = root;
        boolean isLeftChild = true;
        Comparable<? super E> cmp = (Comparable<? super E>) element;
        int cmpValue;
        while ((cmpValue = cmp.compareTo(current.data)) != 0) {
            parent = current;
            if (cmpValue < 0) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null)
                return false;


            if (current.leftChild == null &&
                    current.rightChild == null) {
                if (current == root)
                    root = null;
                else if (isLeftChild)
                    parent.leftChild = null;
                else
                    parent.rightChild = null;
            }
            else if (current.rightChild == null)
                if (current == root)
                    root = current.leftChild;
                else if (isLeftChild)
                    parent.leftChild = current.leftChild;
                else
                    parent.rightChild = current.leftChild;
            else if (current.leftChild == null)
                if (current == root)
                    root = current.rightChild;
                else if (isLeftChild)
                    parent.leftChild = current.rightChild;
                else
                    parent.rightChild = current.rightChild;
            else {
                Node<E> successor = getSuccessor(current);
                if (current == root)
                    root = successor;
                else if (isLeftChild)
                    parent.leftChild = successor;
                else
                    parent.rightChild = successor;
           //     return true;
            }
        }
        return false;
    }

    private Node<E> getSuccessor(Node<E> delNode) {
        Node<E> successorParent = delNode;
        Node<E> successor = delNode;
        Node<E> current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }*/
}
