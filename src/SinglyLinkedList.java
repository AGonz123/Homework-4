/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lil' Memesto
 */
/**
 * Implements the ListInterface
 * using singly linked list
 */
public class SinglyLinkedList<T> implements ListInterface<T> {

    protected Node<T> first;
    protected Node<T> last;
    protected int size;

    @Override
    public void add(T element) {
        if (first == null) {
            first = new Node<>(null, element);
            last = first;
        } else {
            last.next = new Node<>(null, element);
            last = last.next;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            return removeFirst();
        } else {
            Node<T> node = first;
            for (int i = 0; i < index-1; i++) {
                node = node.next;
            }
            return removeNextTo(node);
        }
    }

    @Override
    public boolean remove(T element) {
        if (element.equals(first.value)) {
            removeFirst();
            return true;
        } else {
            Node<T> node = first;
            while (node.next != null) {
                if (node.next.value.equals(element)) {
                    removeNextTo(node);
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    /**
     * Private method removes the first
     * node
     * @return value of the removed node
     */
    private T removeFirst() {
        T element = first.value;
        first = first.next;
        if (first == null) {
            last = null;
        }
        size--;
        return element;
    }


    /**
     * Private method removes the next node
     * to passed one
     * @return value of the removed node
     */
    private T removeNextTo(Node<T> node) {
        T element = node.next.value;
        node.next = node.next.next;
        if (node.next == null) {
            last = node;
        }
        size--;
        return element;
    }

    @Override
    public boolean contains(T element) {
        Node<T> node = first;
        while (node != null) {
            if (node.value.equals(element)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int indexOf(T element) {
        Node<T> node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(element)) {
                return i;
            }
            node = node.next;
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
        first = null;
        last = null;
        size = 0;
    }

    protected static class Node<T> {
        protected Node<T> next;
        protected T value;

        public Node(Node<T> next, T value) {
            this.next = next;
            this.value = value;
        }
    }
}