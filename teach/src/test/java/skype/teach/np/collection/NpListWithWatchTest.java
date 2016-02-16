package skype.teach.np.collection;

import com.google.common.base.Stopwatch;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * @author NPrilepa
 */
public abstract class NpListWithWatchTest {
    protected abstract <T> NpList<T> createInstance();

    @Before
    public void warmUp() {
        System.out.println("warmUp start");
        NpList<String> string_list = createInstance();
        for (int i = 0; i < 100; i++) {
            string_list.add("element");
        }

        for (int i = 0; i < 100; i++) {
            string_list.delete(0);
        }
        System.out.println("warmUp end");
    }


    private void add_element(int listSize) {
        NpList<String> string_list = createInstance();

        Stopwatch sw = Stopwatch.createUnstarted();

        for (int i = 0; i < listSize; i++) {
            sw.start();
            string_list.add("element");
            sw.stop();
        }
        System.out.println("Adding "+listSize+" items: " + sw.elapsed(TimeUnit.NANOSECONDS) / listSize + " NANOSECONDS");
    }

    @Test
    public void add_1000_element()
    {
        add_element(1000);
    }

    @Test
    public void add_1000000_element() {
        add_element(1000000);
    }

    @Test
    public void add_100000000_element() {
        add_element(100000000);
    }


    private void delete_last_element(int listSize) {
        NpList<String> string_list = createInstance();
        for (int i = 0; i < listSize; i++) {
            string_list.add("element");
        }
        Stopwatch sw = Stopwatch.createUnstarted();

        for (int i = 0; i < listSize; i++) {
            if (string_list.size() - 1 >= 0) {
                sw.start();
                string_list.delete(string_list.size() - 1);
                sw.stop();
            }
        }
        System.out.println("Delete " + listSize + " last items: " + sw.elapsed(TimeUnit.NANOSECONDS) / listSize + " NANOSECONDS");
    }
    @Test
    public void delete_1000_last_element() {
        delete_last_element(1000);
    }
    @Test
    public void delete_1000000_last_element() {
        delete_last_element(1000000);  }

    @Test
    public void delete_100000000_last_element() {
        delete_last_element(100000000);
    }


    private void delete_element(int listSize) {
        NpList<String> string_list = createInstance();
        for (int i = 0; i < listSize; i++) {
            string_list.add("element");
        }
        Stopwatch sw = Stopwatch.createUnstarted();

        for (int i = 0; i < listSize; i++) {
            if (string_list.size() - 1 > 0) {
                sw.start();
                string_list.delete(string_list.size() % 2 == 0 ? string_list.size() / 2 : (string_list.size() + 1) / 2);
                sw.stop();
            }
        }
        System.out.println("Delete " + listSize + " inside items: " + sw.elapsed(TimeUnit.NANOSECONDS) / listSize + " NANOSECONDS");
    }
    @Test
    public void delete_1000_element() {
        delete_element(1000);
    }
    @Test
    public void delete_1000000_element() {
        delete_element(1000000); }

    /*@Test
    public void delete_100000000_element() {
        delete_element(100000000);    }
*/

    private void delete_first_element(int listSize) {
        NpList<String> string_list = createInstance();
        for (int i = 0; i < listSize; i++) {
            string_list.add("element");
        }
        Stopwatch sw = Stopwatch.createUnstarted();

        for (int i = 0; i < listSize; i++) {
            sw.start();
            string_list.delete(0);
            sw.stop();
        }
        System.out.println("Delete first " + listSize + " items: " + sw.elapsed(TimeUnit.NANOSECONDS) / listSize + " NANOSECONDS");
    }

    @Test
    public void delete_first_1000_element() {
        delete_first_element(1000);
    }

    @Test
    public void delete_first_1000000_element() {
        delete_first_element(1000000);
    }

   /*  @Test
      public void delete_first_100000000_element() {
         delete_first_element(100000000);
     }
*/

    private void iterator_element(int listSize) {
        NpList<String> string_list = createInstance();
        for (int i = 0; i < listSize; i++) {
            string_list.add("element");
        }
        Stopwatch sw = Stopwatch.createUnstarted();

        Iterator it = string_list.iterator();
        sw.start();
        while (it.hasNext()) {
            it.next();
        }
        sw.stop();

        System.out.println("iterator " + listSize + " items: " + sw.elapsed(TimeUnit.NANOSECONDS) / listSize + " NANOSECONDS");
    }

    @Test
    public void iterator_1000_element() {
        iterator_element(1000);
    }
    @Test
    public void iterator_1000000_element() {
        iterator_element(1000000); }

    @Test
    public void iterator_100000000_element() {
        iterator_element(100000000);
    }

    private void iterable_element(int listSize) {
        NpList<String> string_list = createInstance();
        for (int i = 0; i < listSize; i++) {
            string_list.add("element");
        }
        Object elements;
        Stopwatch sw = Stopwatch.createUnstarted();
        sw.start();
        for(Object element: string_list)
        {
            elements=element;
        }
        sw.stop();
        System.out.println("iterable " + listSize + " items: " + sw.elapsed(TimeUnit.NANOSECONDS) / listSize + " NANOSECONDS");
    }

    @Test
    public void iterable_1000_element() {
        iterable_element(1000);
    }
    @Test
    public void iterable_1000000_element() {
        iterable_element(1000000); }

    @Test
    public void iterable_100000000_element() {
        iterable_element(100000000);
    }

    private void iterator_delete_element(int listSize) {
        NpList<String> string_list = createInstance();
        for (int i = 0; i < listSize; i++) {
            string_list.add("element");
        }
        Stopwatch sw = Stopwatch.createUnstarted();
        Iterator it = string_list.iterator();
        sw.start();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        sw.stop();
        System.out.println("iterator delete " + listSize + " items: " + sw.elapsed(TimeUnit.NANOSECONDS) / listSize + " NANOSECONDS");
    }

    @Test
    public void iterator_delete_1000_element() {
        iterator_delete_element(1000);
    }
    @Test
    public void iterator_delete_1000000_element() {
        iterator_delete_element(1000000); }

    /*@Test
    public void iterator_delete_100000000_element() {
        iterator_delete_element(100000000);
    }*/

}
