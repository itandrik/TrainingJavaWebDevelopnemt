package com.javaweb;

import java.util.*;

/**
 * MyLinkedList.java
 * <t>
 * Class, that implements List<E> interface and has such
 * logic as usual {@link LinkedList}. It has almost all
 * similar methods.
 *
 * @param <E> generic type
 * @author Andrii Chernysh
 * @version 1.0, 22 Nov 2016
 */
public class MyLinkedList<E> implements List<E> {
    private static final String INDEX_OUT_OF_BOUND_MSG =
            "Index %d is out of bound!!";
    public static final String NO_SUCH_ELEMENT_MSG =
            "No such element!!!";
    /**
     * Size of custom linked list
     */
    private int size = 0;
    /**
     * Pointer to first element of linked list
     */
    private Node<E> first;
    /**
     * Pointer to last element of linked list
     */
    private Node<E> last;
    /**
     * This variable solver concurrency problems
     */
    private int modCount = 0;

    public MyLinkedList() {

    }

    public MyLinkedList(Collection<? extends E> c) {
        addAll(c);
    }

    /**
     * All elements of our list has such structure,
     * like this class.
     * There are pointer to next and previous node and
     * exactly value of generic type <E>.
     *
     * @param <E> generic type
     */
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
        modCount++;
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
        modCount++;
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
        modCount++;
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
        modCount++;
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
        modCount++;
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
        modCount++;
        return element;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    String.format(INDEX_OUT_OF_BOUND_MSG, index));
        }
    }

    public E getFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException(NO_SUCH_ELEMENT_MSG);
        return f.item;
    }

    public E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException(NO_SUCH_ELEMENT_MSG);
        return l.item;
    }

    public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException(NO_SUCH_ELEMENT_MSG);
        return unlinkFirst(f);
    }

    public E removeLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException(NO_SUCH_ELEMENT_MSG);
        return unlinkLast(l);
    }

    public void addFirst(E e) {
        linkFirst(e);
    }
    
    public void addLast(E e) {
        linkLast(e);
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
        for (Node<E> iter = first; iter != null; iter = iter.next) {
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

        Node<E> predictNode, successiveNode;
        if (index == size) {
            successiveNode = null;
            predictNode = last;
        } else {
            successiveNode = getNode(index);
            predictNode = successiveNode.previous;
        }

        for (Object o : c.toArray()) {
            @SuppressWarnings("unchecked") E e = (E) o;
            Node<E> newNode = new Node<>(predictNode, e, null);
            if (predictNode == null)
                first = newNode;
            else
                predictNode.next = newNode;
            predictNode = newNode;
        }

        if (successiveNode == null) {
            last = predictNode;
        } else {
            predictNode.next = successiveNode;
            successiveNode.previous = predictNode;
        }

        size += c.size();
        modCount++;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        c.stream().forEach(elem -> {
            while (this.contains(elem)) {
                this.remove(this.indexOf(elem));
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
                unlink(elem);
                elem = temp;
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
        unlink(temp);
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

    /**
     * Custom iterator for {@link MyLinkedList}
     *
     * @param <E> generic type
     */
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

    /**
     * Custom list iterator for {@link MyLinkedList}.
     * It extends custom iterator {@link MyIterator} and has
     * more methods, which is needed to iterate custom
     * linked list
     */
    private class MyListIterator extends MyIterator<E> implements ListIterator<E> {
        private int expectedModCount = modCount;

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
            if (next == null) {
                next = last;
            } else {
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
            return index - 1;
        }

        @Override
        public void remove() {
            checkForComodification();
            Node<E> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                index--;
            lastReturned = null;
            expectedModCount++;
        }

        @Override
        public void set(E e) {
            checkForComodification();
            lastReturned.item = e;
        }

        @Override
        public void add(E e) {
            checkForComodification();
            lastReturned = null;
            if (next == null)
                linkLast(e);
            else
                linkBefore(e, next);
            index++;
            expectedModCount++;
        }

        void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
}
