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
 * Implements the PriorityQueueInterface
 * using singly linked list
 */
public class PriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {

    private Node<T> first;
    private int size;

    @Override
    public void add(T newEntry) {
        size++;
        Node<T> node = first;
        if (node == null) {
            first = new Node<>(null, newEntry);
        } else if (newEntry.compareTo(node.value) <= 0) {
            first = new Node<>(first, newEntry);
        } else while (true) {
            if (node.next == null) {
                node.next = new Node<>(null, newEntry);
                return;
            }
            if (newEntry.compareTo(node.next.value) <= 0) {
                node.next = new Node<>(node.next, newEntry);
                return;
            }
            node = node.next;
        }
    }

    @Override
    public T remove() {
        if (first != null) {
            T value = first.value;
            first = first.next;
            size--;
            return value;
        }
        return null;
    }

    @Override
    public T peek() {
        return first.value;
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
        size = 0;
    }

    private static class Node<T extends Comparable<? super T>> {
        private Node<T> next;
        private T value;

        public Node(Node<T> next, T value) {
            this.next = next;
            this.value = value;
        }
    }
}
