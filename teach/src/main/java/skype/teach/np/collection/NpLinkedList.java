package skype.teach.np.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Resizable parametrized ordered doubly-linked list implementation of the List interface. A repetition of list items.
 * Elements of collection can be null.Do not need to defined size when creating collection.
 * Default size=0. The index of the collection starts from zero. Attempt to remove an element with a
 * non-existent index will result in IndexOutOfBoundsException. Attempt to get an element with a
 * non-existent index will result in IndexOutOfBoundsException.
 * Each element in the structure contains pointers to the previous and next elements.
 * firstNode - first element of list
 * lastNode - Last element of list
 * When you try to add an element creating a list item, which link to the previous element is equal to lastNode
 * and the newly created element becomes lastNode
 * When you delete element the previous element link to the next set on the element following the deleted, and
 * the next element link to the previous set to the item which comes before the deleted
 * When you remove from the end previous element become lastNode
 * When you remove from the start next element become firstNode
 *
 * @author NPrilepa
 */
public class NpLinkedList<T> implements NpList<T> {
    private int size;
    private NpNode<T> firstNode;
    private NpNode<T> lastNode;


    public NpLinkedList() {
    }

    /**
     * Appends the specified element to the end of this list
     * element can be null
     *
     * @param element element to be appended to this list
     */
    public void add(T element) {
        NpNode<T> newNode = new NpNode<T>(element);
        if (lastNode == null) {
            firstNode = newNode;
        } else {
            lastNode.setNext(newNode);
        }
        newNode.setPrev(lastNode);
        lastNode = newNode;

        size++;
    }


    /**
     * Removes the element at the specified position in this list
     *
     * @param i the index of the element to be removed
     * @throws IndexOutOfBoundsException if index is non-existent (index>size of list)
     */

    public void delete(int i) throws IndexOutOfBoundsException {
        if (i >= size) {
            throw new IndexOutOfBoundsException();
        }
        NpNode<T> currentNode = getNode(i);
        NpNode<T> next = currentNode.next;
        NpNode<T> prev = currentNode.prev;

        if (next == null) {
            lastNode = prev;
        } else {
            next.prev=prev;
            currentNode.next =null;
        }
        if (prev == null) {
            firstNode = next;
        } else {
            prev.next = next;
            currentNode.prev =null;
        }
        currentNode.value = null;
        size--;
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

        return getNode(i).getValue();
    }


    private NpNode<T> getNode(int i) {
        if (i < size / 2) {
            NpNode<T> currentNode = firstNode;
            for (int j = 0; j < i; j++) {
                currentNode = currentNode.getNext();
            }
            return currentNode;
        } else {
            NpNode<T> currentNode = lastNode;
            for (int j = size - 1; j > i; j--) {
                currentNode = currentNode.getPrev();
            }
            return currentNode;
        }
    }


    /**
     * Get index of the first occurrence of the specified element
     * in this list
     *
     * @param element to search for
     * @return -1 if this list does not contain the element
     */
    public int getIndexByElement(T element) {
        int i = 0;
        NpNode<T> currentNode = firstNode;
        while (i < size) {
            if (element == null)
            {if (currentNode.getValue() == null) {
                return i;
            }
                i++;
                currentNode = currentNode.getNext();}
            else
            {
                if (currentNode.getValue() != null) {
                    if (currentNode.getValue().equals(element)) {
                        return i;
                    }
                }
                i++;
                currentNode = currentNode.getNext();
            }
        }

        return -1;
    }

    public void deleteNode(NpNode node)
    {
        NpNode next = node.next;
        NpNode prev = node.prev;

        if (next == null) {
            lastNode = prev;
        } else {
            next.prev=prev;
            node.next = null;
        }
        if (prev == null) {
            firstNode = next;
        } else {
            prev.next = next;
            node.prev =null;
        }
        node.value = null;



        size--;
    }

    public boolean delete(T element) {
        int i = 0;
        NpNode<T> currentNode = firstNode;
        while (i < size) {
            if (element == null)
            {if (currentNode.getValue() == null) {
                deleteNode(currentNode);
                return true;
            }
                i++;
                currentNode = currentNode.getNext();}
            else
            {
                if (currentNode.getValue() != null) {
                    if (currentNode.getValue().equals(element)) {
                        deleteNode(currentNode);
                        return true;
                    }
                }
                i++;
                currentNode = currentNode.getNext();
            }
        }
        return false;
    }

    public boolean contains(T element) {
        int i = 0;
        NpNode<T> currentNode = firstNode;
        while (i < size) {
            if (element == null)
            {if (currentNode.getValue() == null) {
                return true;
            }
                i++;
                currentNode = currentNode.getNext();}
            else
            {
                if (currentNode.getValue() != null) {
                    if (currentNode.getValue().equals(element)) {
                        return true;
                    }
                }
                i++;
                currentNode = currentNode.getNext();
            }
        }

        return false;
    }

    /**
     * Returns the iterator of over the elements in this LinkedList
     * @return NpLinkedIteratorImpl object - the iterator of over the elements in this LinkedList
     */
    public Iterator<T> iterator() {
        return new NpLinkedIteratorImpl<T>(this);
    }

    private static class NpLinkedIteratorImpl<T> implements Iterator<T> {
        private NpNode<T> currentNode;
        private NpNode<T> prevNode;

        NpLinkedList<T> list;

        public NpLinkedIteratorImpl(NpLinkedList list) {
            currentNode = list.firstNode;
            this.list = list;
        }

        /**
         * Checks the next item in the list
         * @return true if next item exist
         */
        public boolean hasNext() {
            return (currentNode != null);
        }

        /**
         * Get next item of list
         * @return next item of list
         *
         */
        public T next() {
            if (currentNode==null) {
                throw new NoSuchElementException();
            }
            T value = currentNode.getValue();
            prevNode = currentNode;
            currentNode = currentNode.getNext();
            return value;
        }

        /*
       Remove item from list
        */
        public void remove()
        {
            if (prevNode==null)
            {
                throw new NoSuchElementException();
            }

            list.deleteNode(prevNode);

        }
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return number of elements in this list
     */
    public int size() {
        return size;
    }

    private static class NpNode<T> {
        private T value;
        private NpNode next;
        private NpNode prev;

        public T getValue() {
            return value;
        }

        public NpNode getPrev() {
            return prev;
        }

        public void setPrev(NpNode prev) {
            this.prev = prev;
        }

        public NpNode(T value) {
            this.value = value;
        }

        public NpNode getNext() {
            return next;
        }

        public void setNext(NpNode next) {
            this.next = next;
        }
    }

}
