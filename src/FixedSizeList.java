/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew Gonzales
 */
/**
 * Implements the ListInterface
 * using fixed sized array of size 10
 * Throws IllegalStateException when adding element to the full list
 */
public class FixedSizeList<T> implements ListInterface<T> {

    private Object[] arr = new Object[10];
    private int size = 0;

    @Override
    public void add(T element) {
        if (size == 10)
            throw new IllegalStateException("List is full");

        arr[size++] = element;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        return (T) arr[index];
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        size--;
        T element = (T) arr[index];
        while (index < size)
            arr[index] = arr[++index];
        arr[index] = null;

        return element;
    }

    @Override
    public boolean remove(T element) {
        int index = indexOf(element);
        if (index > -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        while (size != 0) {
            remove(size-1);
        }
    }
}
