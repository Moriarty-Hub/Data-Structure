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

    @Override
    public void ensureCapacity(int capacity) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void set(int index, T object) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int remove(T object) {
        return 0;
    }

    @Override
    public void add(T object) {

    }

    @Override
    public void add(int index, T object) {

    }

    @Override
    public void trimToSize() {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
