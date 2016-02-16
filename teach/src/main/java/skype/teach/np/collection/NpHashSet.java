package skype.teach.np.collection;

import java.util.Iterator;

/**
 * @author NPrilepa
 */
public class NpHashSet<T> implements NpSet<T> {
    private NpList<T>[] set;
    private int size;

    public NpHashSet() {
        set = new NpList[100];
    }

    private NpList getList() {
        return new NpLinkedList<T>();
    }

    public boolean add(T element) {
        int numList;
        if (element == null) {
            numList = 0;
        } else {
            numList = Math.abs(element.hashCode()) % set.length;
        }

        NpList<T> list = set[numList];
        if (list == null) {
            list = getList();
            list.add(element);
            set[numList] = list;
            size++;
            return true;
        }
        if (list.getIndexByElement(element) == -1) {
            list.add(element);
            size++;
            return true;
        } else {
            return false;
        }
    }

    private int getListNumber(T element) {
        int numList;
        if (element == null) {
            numList = 0;
        } else {
            numList = Math.abs(element.hashCode()) % set.length;
        }
        return numList;
    }

    public boolean delete(T element) {
        int listNum = getListNumber(element);
        if (set.length <= listNum) {
            return false;
        }
        NpList<T> list = set[getListNumber(element)];
        if (list == null) {
            return false;
        }
        if (list.delete(element)) {
            size--;
            return true;
        }
        return false;
    }

    public boolean contains(T element) {
        int i = 0;
        while (i < set.length) {
            NpList<T> list = set[i];
            if (list == null) {
                i++;
                continue;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (element == null) {
                    if (it.next() == null)
                        return true;
                }
                if (it.next().equals(element)) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    public int size() {
        return size;
    }


}
