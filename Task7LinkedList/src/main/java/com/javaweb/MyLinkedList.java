package com.javaweb;

import java.util.*;

/**
 * @param <E>
 */
public class MyLinkedList<E> implements List<E> {
    private static final String INDEX_OUT_OF_BOUND_MSG =
            "Index %d is out of bound!!";
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> previous;

        public Node(Node<E> previous, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

    /**
     * Links e as first element.
     */
    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.previous = newNode;
        size++;
    }

    /**
     * Links e as last element.
     */
    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    /**
     * Inserts element e before non-null Node succ.
     */
    private void linkBefore(E e, Node<E> succ) {
        // assert succ != null;
        final Node<E> pred = succ.previous;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.previous = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    /**
     * Unlinks non-null first node f.
     */
    private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.previous = null;
        size--;
        return element;
    }

    /**
     * Unlinks non-null last node l.
     */
    private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        final E element = l.item;
        final Node<E> prev = l.previous;
        l.item = null;
        l.previous = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return element;
    }

    /**
     * Unlinks non-null node x.
     */
    private E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.previous;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.previous = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.previous = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    private void checkIndex(int index) {
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException(
                    String.format(INDEX_OUT_OF_BOUND_MSG, index));
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node iter = first; iter != null; iter = iter.next) {
            result[i++] = iter.item;
        }
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        int i = 0;
        Object[] result = a;
        for (Node<E> x = first; x != null; x = x.next)
            result[i++] = x.item;

        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator iter = c.iterator();
        while (iter.hasNext()) {
            if (!this.contains(iter.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        checkIndex(index);

        if (c.size() == 0)
            return false;

        Node<E> previousNode;
        Node<E> nextNode = null;
        if (index == 0) {
            E first = (E) c.stream().findFirst();
            previousNode = new Node<>(null, first, null);
        } else if (index == size) {
            previousNode = this.last;
        } else {
            previousNode = getNode(index);
            nextNode = previousNode.next;
        }

        for (E elem : c) {
            Node<E> node = new Node<>(previousNode, elem, null);
            previousNode.next = node;
            previousNode = node;
        }

        if (index == 0) {
            previousNode.next = this.first;
        } else if (index == size) {
            previousNode.next = null;
        } else {
            previousNode.next = nextNode;
        }

        size += c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        c.stream().forEach(elem -> {
            while (this.contains(elem)) {
                this.remove(this.indexOf(elem));
                size--;
            }
        });
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Node<E> elem = this.first;
        while (elem != null) {
            if (!c.contains(elem.item)) {
                Node<E> temp = elem.next;
                remove(elem);
                elem = temp;
                size--;
            } else {
                elem = elem.next;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.previous = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    private Node<E> getNode(int index) {
        checkIndex(index);
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.previous;
            return x;
        }
    }

    @Override
    public E get(int index) {
        return getNode(index).item;
    }

    @Override
    public E set(int index, E element) {
        Node<E> temp = getNode(index);
        E result = temp.item;
        temp.item = element;
        return result;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, getNode(index));
    }

    @Override
    public E remove(int index) {
        Node<E> temp = getNode(index);
        E result = temp.item;
        remove(temp);
        return result;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size;
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.previous) {
                index--;
                if (x.item == null)
                    return index;
            }
        } else {
            for (Node<E> x = last; x != null; x = x.previous) {
                index--;
                if (o.equals(x.item))
                    return index;
            }
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>(0);
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        checkIndex(toIndex);
        checkIndex(fromIndex);
        if (fromIndex < toIndex) {
            Object[] result = new Object[toIndex - fromIndex];
            int k = 0;
            for (Node<E> x = getNode(fromIndex); x != getNode(toIndex); x = x.next) {
                result[k++] = x.item;
            }
            return Arrays.asList(result);
        } else {
            return new MyLinkedList<>();
        }
    }

    private class MyIterator<E> implements Iterator<E> {
        protected Node<E> lastReturned;
        protected Node<E> next;
        protected int index;

        public MyIterator(int index) {
            next = (index == size) ? null : (Node<E>) getNode(index);
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return (index < size) && (next != null);
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            lastReturned = next;
            next = next.next;
            index++;
            return lastReturned.item;
        }
    }
    private class MyListIterator<E> extends MyIterator<E> implements ListIterator<E>{

        public MyListIterator(int index) {
            super(index);
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
            if(next == null){
                next = (Node<E>)last;
            }else{
                next = next.previous;
            }
            lastReturned = next;
            index--;
            return lastReturned.item;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index-1;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }
    }
}
