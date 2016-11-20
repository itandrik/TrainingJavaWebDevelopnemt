package com.javaweb;


import java.util.*;

/**
 * MyArrayList.java
 * <p>
 * This is class of custom ArrayList. It implements List interface.
 * It has all basic methods include getting iterator.
 * It works with different types, because of generic type.
 *
 * @param <E> generic type
 * @author Andrii Chernysh
 * @version 1.0, 20 Nov 2016
 */
public class MyArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final String OUT_OF_BOUND_MSG =
            "Index is out of bound! index : %d;";
    private static final String OUT_OF_MEMORY_MSG =
            "Your list is super huge. It is bigger than Integer.MAX_VALUE!";
    private Object[] data;
    private int size = 0;
    private int previousCapacity = 0;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initialCapacity) {
        previousCapacity = initialCapacity;
        data = new Object[initialCapacity];
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public MyArrayList(Collection<? extends E> c) {
        data = c.toArray();
        if ((size = data.length) != 0) {
            // c.toArray might (incorrectly) not return Object[] (see 6260652)
            if (data.getClass() != Object[].class)
                data = Arrays.copyOf(data, size, Object[].class);
        } else {
            // replace with empty array.
            this.data = new Object[]{};
        }
    }

    /**
     * Method for testing purposes
     *
     * @return capacity of data array
     */
    public int getCapacity() {
        return data.length;
    }

    private void ensureCapacityAdd(int size) {
        if (size >= data.length) {
            previousCapacity = data.length;
            int newCapacity = (data.length * 3) / 2 + 1;
            if (newCapacity >= MAX_ARRAY_SIZE) {
                throw new OutOfMemoryError(OUT_OF_MEMORY_MSG);
            } else {
                data = Arrays.copyOf(data, newCapacity);
            }
        }
    }

    private void ensureCapacityRemove(int size) {
        if (size >= DEFAULT_CAPACITY - 1) {
            if (size <= previousCapacity) {
                data = Arrays.copyOf(data, previousCapacity);
            }
        }
    }

    private void rangeCheck(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(
                    String.format(OUT_OF_BOUND_MSG, index));
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (data[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(data[i]))
                    return i;
        }
        return -1;

    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--)
                if (data[i] == null)
                    return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (o.equals(data[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    public List subList(int fromIndex, int toIndex) {
        rangeCheck(fromIndex);
        rangeCheck(toIndex);
        if (fromIndex < toIndex) {
            Object[] result = new Object[toIndex - fromIndex];
            int k = 0;
            for (int i = fromIndex; i < toIndex; i++) {
                result[k++] = data[i];
            }
            return Arrays.asList(result);
        } else {
            return new ArrayList<>();
        }
    }

    public Object set(int index, Object element) {
        Object result = data[index];
        data[index] = element;
        return result;
    }

    public void add(int index, E element) {
        rangeCheck(index);
        ensureCapacityAdd(++size);
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public boolean add(E o) {
        ensureCapacityAdd(size + 1);
        data[size++] = o;
        return true;
    }

    public boolean remove(Object o) {
        Objects.requireNonNull(o);
        int indexObject = indexOf(o);
        for (int i = indexObject; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        ensureCapacityRemove(--size);
        return true;
    }

    @Override
    public void clear() {
        // clear to let GC do its work
        for (int i = 0; i < size; i++)
            data[i] = null;

        size = 0;
        Arrays.copyOf(data, DEFAULT_CAPACITY);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        rangeCheck(index);
        return (E) data[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        rangeCheck(index);
        E result = (E) data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        ensureCapacityRemove(--size);
        return result;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityAdd(size + numNew);
        System.arraycopy(a, 0, data, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        rangeCheck(index);

        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityAdd(size + numNew);

        int numMoved = size - index;
        if (numMoved > 0)
            System.arraycopy(data, index, data, index + numNew,
                    numMoved);

        System.arraycopy(a, 0, data, index, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        for (int i = 0; i < size; i++) {
            if (!c.contains(data[i])) {
                this.remove(i--);
                ensureCapacityRemove(size);
            }
        }

        /*this.stream().forEach(elem ->{
            if(!c.contains(elem)){
                this.remove(elem);
            }
        });*/
        return true;
    }

    //перевірити роботу нормального методу ал і мого
    @Override
    @SuppressWarnings("unchecked")
    public boolean removeAll(Collection c) {
        c.stream().forEach(elem -> {
            while (this.contains(elem)) {
                this.remove(this.indexOf(elem));
            }
        });
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        Iterator iter = c.iterator();
        while (iter.hasNext()) {
            if (!this.contains(iter.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(data, size, a.getClass());
        System.arraycopy(data, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }

    @Override
    public ListIterator<E> listIterator() {
        return new MyListIterator<>();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new MyListIterator<>(index);
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>();
    }

    private class MyIterator<E> implements Iterator<E> {
        protected int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return ((currentIndex < size) && (data[currentIndex] != null));
        }

        @Override
        public E next() {
            return (E) data[currentIndex++];
        }
    }

    private class MyListIterator<E> extends MyIterator<E>
            implements ListIterator<E> {

        public MyListIterator() {

        }

        public MyListIterator(int index) {
            currentIndex = index;
        }

        @Override
        public boolean hasPrevious() {
            return ((currentIndex >= 0) && (data[currentIndex] != null));
        }

        @Override
        @SuppressWarnings("unchecked")
        public E previous() {
            return (E) data[currentIndex--];
        }

        @Override
        public int nextIndex() {
            return currentIndex + 1;
        }

        @Override
        public int previousIndex() {
            return currentIndex - 1;
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(currentIndex);
        }

        @Override
        public void set(E e) {
            MyArrayList.this.set(currentIndex, e);
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException(
                    "You can't add from iterator ha ha ha!!!");
        }

    }
}
