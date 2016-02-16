package skype.teach.np.collection;

import java.util.Iterator;

/**
 * Resizable parametrized ordered collection, i.e. there is a possibility to access an element by its index
 * A repetition of list items. Do not need to defined size when creating collection. Default size=0.
 * The index of the collection starts from zero. Attempt to remove and get an element with a
 * non-existent index will result in IndexOutOfBoundsException.
 *
 * @author NPrilepa
 */
interface NpList<T> extends Iterable {

    /**
     * Appends the specified element to the end of this list
     *
     * @param element element to be appended to this list
     */
    void add(T element);

    /**
     * Removes the element at the specified position in this list
     *
     * @param i the index of the element to be removed
     * @throws IndexOutOfBoundsException if index is non-existent (index>size of collection)
     */
    void delete(int i) throws IndexOutOfBoundsException;

    /**
     * Returns the element at the specified position in this list
     *
     * @param i index of the element to be get
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if index is non-existent (index>size of collection)
     */
    T getByIndex(int i) throws IndexOutOfBoundsException;

    /**
     * get index of the first occurrence of the specified element
     * in this list
     *
     * @param element to search for
     * @return -1 if this list does not contain the element
     */
    int getIndexByElement(T element);

    /**
     * Returns the number of elements in this list.
     *
     * @return number of elements in this list
     */
    int size();

    /**
     * Returns the iterator of over the elements in this list
     * @return iterator the iterator of over the elements in this list
     */
    Iterator<T> iterator();

    /**
     * Return true if list contains element
     * @param element
     * @return false if list not contains element
     */
    boolean contains(T element);

    /**
     * Removes the element at this list
     *
     * @param  element to be removed
     * @throws false if element is non-existent
     */
    boolean delete(T element);

}
