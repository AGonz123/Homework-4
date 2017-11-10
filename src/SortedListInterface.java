/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lil' Memesto
 */
public interface SortedListInterface {
 /**
 * An interface for the ADT sorted list.
 * Extends the ListInterface
 * Implementation of this interface should store
 * elements in ascending order
 * @author
 * @version 1.0
 */
public interface SortedListInterface<T extends Comparable<? super T>> extends ListInterface<T> {
}
   
}
