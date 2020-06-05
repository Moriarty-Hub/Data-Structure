package chapter03.example;

public interface MyArrayListInterface<T> extends Iterable<T>{

    void ensureCapacity(int capacity);

    T get(int index);

    void set(int index, T object);

    int size();

    boolean isEmpty();

    void clear();

    T remove(int index);

    int remove(T object);

    void add(T object);

    void add(int index, T object);

    void trimToSize();
}
