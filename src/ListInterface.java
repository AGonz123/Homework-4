
 //*An interface for the ADT list.
 //@author Andrew Gonzales
 //@version 1.0
 //*/
public interface ListInterface<T> {

    /** Adds a new entry to this list.
     * @param element An object to be added.
     */
    void add(T element);

    /**
     * Returns the element by its index
     * @param index index of the element to get
     */
    T get(int index);

    /**
     * Removes the element on specified index
     * and returns it
     * @param index index of the element to remove
     */
    T remove(int index);

    /**
     * Removes the passed element from the list
     * if it is present
     * @param element element to remove
     * @return true if element was found and removed
     */
    boolean remove(T element);

    /**
     * Checks whether this list contains the passed element
     * @param element element to look for
     * @return true/false
     */
    boolean contains(T element);

    /**
     * Returns the index of element or -1
     * if not found
     * @param element element to look for
     * @return the element index
     */
    int indexOf(T element);

    /**
     * Detects whether this list is empty.
     * @return True if the list is empty, or false otherwise.
     */
    boolean isEmpty();

    /**
     * Gets the size of this list.
     * @return The number of entries currently in the list.
     */
    int getSize();

    /**
     * Removes all entries from this list.
     */
    void clear();
}
  

