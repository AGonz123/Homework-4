/*
 * Implements the SortedListInterface
 * using Previous ListInterface
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

