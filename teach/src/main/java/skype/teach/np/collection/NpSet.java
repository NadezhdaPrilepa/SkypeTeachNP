package skype.teach.np.collection;

/**
 * @author NPrilepa
 */
interface NpSet<T> {
    boolean add(T element);

    boolean delete(T element);

    boolean contains(T element);

    int size();
}
