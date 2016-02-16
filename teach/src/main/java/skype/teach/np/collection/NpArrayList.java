package skype.teach.np.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Resizable parametrized array implementation of the List interface. A repetition of list items.
 * Elements of collection can be null.Do not need to defined size when creating collection.
 * Default size=0. The index of the collection starts from zero. Attempt to remove an element with a
 * non-existent index will result in IndexOutOfBoundsException. Attempt to get an element with a
 * non-existent index will result in IndexOutOfBoundsException.
 * Initially, when you create an ArrayList, you can specify in the constructor arguments the
 * size of the array. If this is not done then the array will be created with a long is 10.
 * When you try to add an element which does not have any free space to create the new array
 * When you delete element at index copying creates a new array with smaller length.
 * When you remove from the end only changes the size of the array
 *
 * @author NPrilepa
 */
public class NpArrayList<T> implements NpList<T> {
    private T[] array;

    private static Object[] EMPTY_ARRAY = {};
    private static int DEFAULT_SIZE = 10;


    private int size;

    public NpArrayList() {
        this(0);
        /*array = {};
        size=0;*/
    }

    public NpArrayList(int size) {
        array = (T[]) new Object[size];

        // this.size = size;
    }

    public boolean contains(T element) {
        if (element == null) {
            for (int i = 0; i < size; i++)
                if (array[i] == null)
                    return true;
        } else {
            for (int i = 0; i < size; i++)
                if (element.equals(array[i]))
                    return true;
        }
        return false;
    }

    public boolean delete(T element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    delete(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(array[i])) {
                    delete(i);
                    return true;
                }
            }
        }
        return false;
    }


    private void checkSizeOfArray(int checkSize) {

        if (array.length == 0) {
            checkSize = Math.max(DEFAULT_SIZE, checkSize);
        }
        if (checkSize > array.length) {
            int oldSize = array.length;
            int newSize = oldSize + (oldSize >> 1);
            if (newSize < checkSize) {
                newSize = checkSize;
            }
            array = Arrays.copyOf(array, newSize);
        }

    }

    /**
     * Appends the specified element to the end of this list
     * element can be null
     *
     * @param element element to be appended to this list
     */
    public void add(T element) {

        checkSizeOfArray(size + 1);

        array[size++] = element;

    }

    /**
     * Removes the element at the specified position in this list
     *
     * @param i the index of the element to be removed
     * @throws IndexOutOfBoundsException if index is non-existent (index>size of collection)
     */
    public void delete(int i) throws IndexOutOfBoundsException {
        if (i >= size) {
            throw new IndexOutOfBoundsException();
        }
        int sizeDelete = size - i - 1;
        if (sizeDelete > 0) {
            System.arraycopy(array, i + 1, array, i,
                    sizeDelete);
        }
        array[--size] = null;

    }

    /**
     * Returns the element at the specified position in this list
     *
     * @param i index of the element to be get
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if index is non-existent (index>size of collection)
     */
    public T getByIndex(int i) throws IndexOutOfBoundsException {
        if (i >= size)
            throw new IndexOutOfBoundsException();
        return array[i];
    }

    /**
     * get index of the first occurrence of the specified element
     * in this list
     *
     * @param element to search for
     * @return -1 if this list does not contain the element
     */
    public int getIndexByElement(Object element) {

        if (element == null) {
            for (int i = 0; i < size; i++)
                if (array[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (element.equals(array[i]))
                    return i;
        }
        return -1;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns the iterator of over the elements in this ArrayList
     *
     * @return NpLinkedIteratorImpl object - the iterator of over the elements in this ArrayList
     */
    public Iterator<T> iterator() {
        return new NpArrayIteratorImpl<T>(this);
    }

    private static class NpArrayIteratorImpl<T> implements Iterator<T> {
        private int i;
        private NpList<T> list;

        NpArrayIteratorImpl(NpList<T> list) {
            i = 0;
            this.list = list;
        }

        /**
         * Checks the next item in the list
         *
         * @return true if next item exist
         */
        public boolean hasNext() {
            return (i < list.size());
        }

        /**
         * Get next item of list
         *
         * @return next item of list
         */
        public T next() {
            T value;
            try {
                value = list.getByIndex(i);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();

            }
            i++;
            return value;

        }
        /*
        Remove item from list
         */
        public void remove()
        {
            try {
            list.delete(i-1);
            i--;
            }
            catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();

            }

        }
    }
}
