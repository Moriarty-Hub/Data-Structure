package chapter03.example.test;

import chapter03.example.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {

    private Field privateFieldSize;
    private Field privateFieldCapacity;
    private Field privateFieldArray;
    private MyArrayList<Integer> sampleArrayList;
    private MyArrayList<Integer> emptyArrayList;

    @BeforeEach
    public void setUp() throws NoSuchFieldException {
        privateFieldSize = MyArrayList.class.getDeclaredField("size");
        privateFieldSize.setAccessible(true);

        privateFieldCapacity = MyArrayList.class.getDeclaredField("capacity");
        privateFieldCapacity.setAccessible(true);

        privateFieldArray = MyArrayList.class.getDeclaredField("array");
        privateFieldArray.setAccessible(true);

        sampleArrayList = new MyArrayList<>();
        sampleArrayList.add(9);
        sampleArrayList.add(8);
        sampleArrayList.add(0);
        sampleArrayList.add(2);
        sampleArrayList.add(2);
        sampleArrayList.add(1);

        emptyArrayList = new MyArrayList<>();
    }

    @Test
    public void testConstructorWithoutParameter() throws IllegalAccessException {
        MyArrayList<Integer> arrayList = new MyArrayList<>();

        assertEquals(0, arrayList.size());
        assertEquals(10, privateFieldCapacity.get(arrayList));
    }

    @Test
    public void test1ConstructorWithCapacity() throws IllegalAccessException {
        MyArrayList<Integer> arrayList = new MyArrayList<>(20);

        assertEquals(0, arrayList.size());
        assertEquals(20, privateFieldCapacity.get(arrayList));
    }

    @Test
    public void test2ConstructorWithCapacity() {
        assertThrows(NegativeArraySizeException.class, () -> new MyArrayList<Integer>(-5));
    }

    @Test
    public void test1EnsureCapacity() throws IllegalAccessException {
        assertEquals(10, privateFieldCapacity.get(sampleArrayList));
        sampleArrayList.ensureCapacity(20);
        assertEquals(20, privateFieldCapacity.get(sampleArrayList));
    }

    @Test
    public void test2EnsureCapacity() throws IllegalAccessException {
        assertEquals(10, privateFieldCapacity.get(sampleArrayList));
        sampleArrayList.ensureCapacity(5);
        assertEquals(10, privateFieldCapacity.get(sampleArrayList));
    }

    @Test
    public void test3EnsureCapacity() throws IllegalAccessException {
        assertEquals(10, privateFieldCapacity.get(sampleArrayList));
        assertThrows(NegativeArraySizeException.class, () -> sampleArrayList.ensureCapacity(-10));
    }

    @Test
    public void test4EnsureCapacity() {
        assertEquals(10, sampleArrayList.size());
        sampleArrayList.ensureCapacity(10);
        assertEquals(10, sampleArrayList.size());
    }

    @Test
    public void test1Get() {
        assertEquals(9, sampleArrayList.get(0));
        assertEquals(1, sampleArrayList.get(5));
    }

    @Test
    public void test2Get() {
        assertThrows(IndexOutOfBoundsException.class, () -> sampleArrayList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> sampleArrayList.get(6));
    }

    @Test
    public void test1Set() throws IllegalAccessException {
        assertEquals(9, ((int[])privateFieldArray.get(sampleArrayList))[0]);
        sampleArrayList.set(0, 3);
        assertEquals(3, ((int[])privateFieldArray.get(sampleArrayList))[0]);

        assertEquals(1, ((int[])privateFieldArray.get(sampleArrayList))[5]);
        sampleArrayList.set(5, 4);
        assertEquals(4, ((int[])privateFieldArray.get(sampleArrayList))[5]);
    }

    @Test
    public void test2Set() {
        assertThrows(IndexOutOfBoundsException.class, () -> sampleArrayList.set(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> sampleArrayList.set(6, 0));
    }

    @Test
    public void testSize() throws IllegalAccessException {
        assertEquals(6, privateFieldSize.get(sampleArrayList));
        assertEquals(0, privateFieldSize.get(emptyArrayList));
    }

    @Test
    public void testIsEmpty() {
        assertFalse(sampleArrayList.isEmpty());
        assertTrue(emptyArrayList.isEmpty());
    }

    @Test
    public void testClear() throws IllegalAccessException {
        assertEquals(6, privateFieldSize.get(sampleArrayList));
        assertEquals(10, privateFieldCapacity.get(sampleArrayList));
        sampleArrayList.clear();
        assertEquals(0, privateFieldSize.get(sampleArrayList));
        assertEquals(10, privateFieldSize.get(sampleArrayList));

        assertEquals(0, privateFieldSize.get(emptyArrayList));
        assertEquals(10, privateFieldCapacity.get(emptyArrayList));
        privateFieldCapacity.set(emptyArrayList, 20);
        assertEquals(20, privateFieldCapacity.get(emptyArrayList));
        emptyArrayList.clear();
        assertEquals(0, privateFieldSize.get(emptyArrayList));
        assertEquals(10, privateFieldCapacity.get(emptyArrayList));
    }

    @Test
    public void test1RemoveByIndex() throws IllegalAccessException {
        assertEquals(6, privateFieldSize.get(sampleArrayList));
        assertArrayEquals(new int[]{9, 8, 0, 2, 2, 1}, (int[]) privateFieldArray.get(sampleArrayList));
        assertEquals(9, sampleArrayList.remove(0));
        assertEquals(5, privateFieldSize.get(sampleArrayList));
        assertArrayEquals(new int[]{8, 0, 2, 2, 1}, (int[]) privateFieldArray.get(sampleArrayList));
        assertEquals(1, sampleArrayList.remove(4));
        assertEquals(4, privateFieldSize.get(sampleArrayList));
        assertArrayEquals(new int[]{8, 0, 2, 2}, (int[]) privateFieldArray.get(sampleArrayList));
    }

    @Test
    public void test2RemoveByIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> sampleArrayList.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> sampleArrayList.remove(6));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyArrayList.remove(0));
    }

    @Test
    public void test1RemoveByObject() throws IllegalAccessException {
        assertEquals(6, privateFieldSize.get(sampleArrayList));
        assertArrayEquals(new int[]{9, 8, 0, 2, 2, 1}, (int[]) privateFieldArray.get(sampleArrayList));
        assertEquals(0, sampleArrayList.remove(Integer.valueOf(9)));
        assertEquals(5, privateFieldSize.get(sampleArrayList));
        assertArrayEquals(new int[]{8, 0, 2, 2, 1}, (int[]) privateFieldArray.get(sampleArrayList));
        assertEquals(2, sampleArrayList.remove(Integer.valueOf(2)));
        assertEquals(4, privateFieldSize.get(sampleArrayList));
        assertArrayEquals(new int[]{8, 0, 2, 1}, (int[]) privateFieldArray.get(sampleArrayList));
    }

    @Test
    public void test2RemoveByObject() throws IllegalAccessException {
        assertEquals(6, privateFieldSize.get(sampleArrayList));
        assertArrayEquals(new int[]{9, 8, 0, 2, 2, 1}, (int[]) privateFieldArray.get(sampleArrayList));
        assertEquals(-1, sampleArrayList.remove(Integer.valueOf(3)));
        assertEquals(6, privateFieldSize.get(sampleArrayList));
        assertArrayEquals(new int[]{9, 8, 0, 2, 2, 1}, (int[]) privateFieldArray.get(sampleArrayList));
        assertEquals(-1, sampleArrayList.remove(Integer.valueOf(7)));
        assertEquals(6, privateFieldSize.get(sampleArrayList));
        assertArrayEquals(new int[]{9, 8, 0, 2, 2, 1}, (int[]) privateFieldArray.get(sampleArrayList));
    }

    @Test
    public void testAddWithoutIndex() throws IllegalAccessException {
        assertEquals(6, privateFieldSize.get(sampleArrayList));
        assertArrayEquals(new int[]{9, 8, 0, 2, 2, 1}, (int[]) privateFieldArray.get(sampleArrayList));
        sampleArrayList.add(3);
        assertEquals(7, privateFieldSize.get(sampleArrayList));
        assertArrayEquals(new int[]{9, 8, 0, 2, 2, 1, 3}, (int[]) privateFieldArray.get(sampleArrayList));

        sampleArrayList.add(4);
        sampleArrayList.add(5);
        sampleArrayList.add(6);
        assertEquals(10, privateFieldCapacity.get(sampleArrayList));
        sampleArrayList.add(7);
        assertEquals(20, privateFieldCapacity.get(sampleArrayList));
        assertEquals(11, privateFieldSize.get(sampleArrayList));
        assertArrayEquals(new int[]{9, 8, 0, 2, 2, 1, 3, 4, 5, 6, 7}, (int[]) privateFieldArray.get(sampleArrayList));

        assertEquals(0, privateFieldSize.get(emptyArrayList));
        emptyArrayList.add(1);
        assertEquals(1, privateFieldSize.get(emptyArrayList));
        assertArrayEquals(new int[]{1}, (int[]) privateFieldArray.get(emptyArrayList));
    }

    @Test
    public void test1AddWithIndex() throws IllegalAccessException {
        assertEquals(6, privateFieldSize.get(sampleArrayList));
        assertArrayEquals(new int[]{9, 8, 0, 2, 2, 1}, (int[]) privateFieldArray.get(sampleArrayList));
        sampleArrayList.add(0, 7);
        assertEquals(7, privateFieldSize.get(sampleArrayList));
        assertArrayEquals(new int[]{7, 9, 8, 0, 2, 2, 1}, (int[]) privateFieldArray.get(sampleArrayList));
        sampleArrayList.add(7, 3);
        assertEquals(8, privateFieldSize.get(sampleArrayList));
        assertArrayEquals(new int[]{7, 9, 8, 0, 2, 2, 1, 3}, (int[]) privateFieldArray.get(sampleArrayList));

        assertEquals(0, privateFieldSize.get(emptyArrayList));
        emptyArrayList.add(0, 1);
        assertEquals(1, privateFieldSize.get(emptyArrayList));
        assertArrayEquals(new int[]{1}, (int[]) privateFieldArray.get(emptyArrayList));
    }

    @Test
    public void test2AddWithIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> sampleArrayList.add(-1, 7));
        assertThrows(IndexOutOfBoundsException.class, () -> sampleArrayList.add(6, 8));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyArrayList.add(1, 2));
    }

    @Test
    public void testTrimToSize() throws IllegalAccessException {
        assertEquals(10, privateFieldCapacity.get(sampleArrayList));
        sampleArrayList.trimToSize();
        assertEquals(6, privateFieldCapacity.get(sampleArrayList));

        assertEquals(10, privateFieldCapacity.get(emptyArrayList));
        emptyArrayList.trimToSize();
        assertEquals(0, privateFieldCapacity.get(emptyArrayList));
    }
}
