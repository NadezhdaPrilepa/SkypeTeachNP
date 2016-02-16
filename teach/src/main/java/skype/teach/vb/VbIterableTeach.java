package skype.teach.vb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author NPrilepa
 */
public class VbIterableTeach {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator it = list.iterator();
        while (it.hasNext())
        {
            it.remove();
            System.out.println("it.next(): "+ it.next());
        }

        for(Object element: list)
        {
            System.out.println("element: "+ element );
        }
        VbIterableList itList = new VbIterableList();
        for(Object element: itList)
        {
            System.out.println("element: "+ element );
        }

    }
}
class VbIterableList implements Iterable<String>{
    public Iterator<String> iterator() {
        return null;
    }

}

