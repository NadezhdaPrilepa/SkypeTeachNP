package skype.teach.np.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author NPrilepa
 */
public class NpAdapterList<T> implements NpList {
    List list;

    public boolean contains(Object element) {
        return list.contains(element);
    }

    public boolean delete(Object element) {
        return list.remove(element);
    }

    public Iterator iterator() {
        return list.iterator();
    }

    public NpAdapterList(List inputList) {
        list = inputList;
    }

    public void add(Object element) {
        list.add(element);
    }

    public void delete(int i) throws IndexOutOfBoundsException {
        list.remove(i);
    }

    public Object getByIndex(int i) throws IndexOutOfBoundsException {
        return list.get(i);
    }

    public int getIndexByElement(Object element) {
        return list.indexOf(element);
    }

    public int size() {
        return list.size();
    }
}
