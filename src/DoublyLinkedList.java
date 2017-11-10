/*
 * Implements the ListInterface
 * using doubly linked list
 */
public class DoublyLinkedList<T> implements ListInterface<T> {

    protected Node<T> first;
    protected Node<T> last;
    protected int size;

    @Override
    public void add(T element) {
        if (first == null) {
            first = new Node<>(null, element, null);
            last = first;
        } else {
            last.next = new Node<>(last, element, null);
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

        if (index == size - 1) {
            return removeNode(last);
        } else if (index < size / 2) {
            Node<T> node = first;
            for (int i = 0; i < index-1; i++) {
                node = node.next;
            }
            return removeNode(node);
        } else {//search from the last to speed up
            Node<T> node = last;
            for (int i = 0; i < size - index - 1; i++) {
                node = node.prev;
            }
            return removeNode(node);
        }
    }

    @Override
    public boolean remove(T element) {
        if (last.value.equals(element)) {
            removeNode(last);
            return true;
        } else {
            Node<T> node = first;
            while (node != last) {
                if (node.value.equals(element)) {
                    removeNode(node);
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    /**
     * Private method removes passed node
     * and returns its value
     * @param node node to remove
     * @return node.value
     */
    private T removeNode(Node<T> node) {
        if (node == first) {
            first = first.next;
            if (first != null) {
                first.prev = null;
            } else {
                last = null;
            }
        } else if (node == last) {
            last = last.prev;
            last.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
        return node.value;
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
        private Node<T> prev;
        private Node<T> next;
        private T value;

        public Node(Node<T> prev, T value, Node<T> next) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }
}
