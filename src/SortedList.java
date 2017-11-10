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
 * Implements the SortedListInterface
 * and extends the SinglyLinkedList
 * Elements are added to list in ascending order
 */
public class SortedList<T extends Comparable<? super T>> extends SinglyLinkedList<T> implements SortedListInterface<T> {

    /**
     * Adds the passed element to this list
     * in ascending order
     * @param element An object to be added.
     */
    @Override
    public void add(T element) {
        size++;
        Node<T> node = first;
        if (node == null) {
            first = new Node<>(null, element);
        } else if (element.compareTo(node.value) <= 0) {
            first = new Node<>(first, element);
        } else while (true) {
            if (node.next == null) {
                node.next = new Node<>(null, element);
                return;
            }
            if (element.compareTo(node.next.value) <= 0) {
                node.next = new Node<>(node.next, element);
                return;
            }
            node = node.next;
        }
    }
}

