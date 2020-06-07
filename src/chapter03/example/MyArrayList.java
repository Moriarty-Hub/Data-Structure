package chapter03.example;

import java.util.Iterator;

public class MyArrayList<T> implements MyArrayListInterface<T> {

    private int size;
    private int capacity;
    private T[] array;

    private static final int DEFAULT_ARRAY_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        size = 0;
        capacity = DEFAULT_ARRAY_CAPACITY;
        array = (T[]) new Object[DEFAULT_ARRAY_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new NegativeArraySizeException("The capacity of array cannot be negative");
        }
        size = 0;
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    @Override
    public void ensureCapacity(int capacity) {
        if (capacity < 0) {
            throw new NegativeArraySizeException("The capacity of array cannot be negative");
        }
        if (capacity > this.capacity) {
            T[] newArray = (T[]) new Object[capacity];
            System.arraycopy(this.array, 0, newArray, 0, this.size);
            this.capacity = capacity;
            this.array = newArray;
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("The given index has out of bounds of array");
        } else {
            return array[index];
        }
    }

    @Override
    public void set(int index, T object) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("The given index has out of bounds of array");
        } else {
            array[index] = object;
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

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        size = 0;
        array = (T[]) new Object[DEFAULT_ARRAY_CAPACITY];
        capacity = DEFAULT_ARRAY_CAPACITY;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("The given index has out of bounds of array");
        }
        T returnValue = array[index];
        if (size - 1 - index >= 0) {
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        size--;
        return returnValue;
    }

    @Override
    public int remove(T object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                if (size - 1 - i >= 0) {
                    System.arraycopy(array, i + 1, array, i, size - 1 - i);
                }
                size--;
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(T object) {
        add(size, object);
    }

    @Override
    public void add(int index, T object) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("The given index has out of bounds of array");
        }
        if (size == capacity) {
            ensureCapacity(capacity * 2);
        }
        if (size - index >= 0) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = object;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void trimToSize() {
        if (size != capacity) {
            T[] newArray = (T[]) new Object[size];
            System.arraycopy(this.array, 0, newArray, 0, size);
            this.capacity = size;
            this.array = newArray;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T> {

        private int current = -1;

        @Override
        public boolean hasNext() {
            return current < size - 1;
        }

        @Override
        public T next() {
            return array[++current];
        }

    }
}
