package skype.teach.np.collection;

import com.google.common.base.Stopwatch;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
/**
 * @author NPrilepa
 */
public abstract class NpSetWithWatchTest {
    protected abstract <T> NpSet<T> createInstance();
    @Before
    public void warmUp() {
        System.out.println("warmUp start");
        NpSet<String> string_set = createInstance();
        for (int i = 0; i < 100; i++) {
            string_set.add("element"+i);
        }

        for (int i = 0; i < 100; i++) {
            string_set.delete("element"+i);
        }
        System.out.println("warmUp end");
    }
    private void add_element(int listSize) {
        NpSet<String> string_set = createInstance();

        Stopwatch sw = Stopwatch.createUnstarted();

        for (int i = 0; i < listSize; i++) {
            sw.start();
            string_set.add("element"+i);
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

    private void delete_element(int listSize) {
        NpSet<String> string_set = createInstance();
        for (int i = 0; i < listSize; i++) {
            string_set.add("element"+i);
        }
        Stopwatch sw = Stopwatch.createUnstarted();

        for (int i = 0; i < listSize; i++) {

                sw.start();
                string_set.delete("element"+i);
                sw.stop();

        }
        System.out.println("Delete " + listSize + " items: " + sw.elapsed(TimeUnit.NANOSECONDS) / listSize + " NANOSECONDS");
    }

    @Test
    public void delete_1000_element() {
        delete_element(1000);
    }
    @Test
    public void delete_1000000_element() {
        delete_element(1000000); }

    @Test
    public void delete_100000000_element() {
        delete_element(100000000);    }

    private void contains_element(int listSize) {
        NpSet<String> string_set = createInstance();
        for (int i = 0; i < listSize; i++) {
            string_set.add("element"+i);
        }
        Stopwatch sw = Stopwatch.createUnstarted();

        for (int i = 0; i < listSize; i++) {

            sw.start();
            string_set.contains("element"+i);
            sw.stop();

        }
        System.out.println("Contains " + listSize + " items: " + sw.elapsed(TimeUnit.NANOSECONDS) / listSize + " NANOSECONDS");
    }

    @Test
    public void contains_1000_element() {
        contains_element(1000);
    }
    @Test
    public void contains_1000000_element() {
        contains_element(1000000); }

    @Test
    public void contains_100000000_element() {
        contains_element(100000000);    }
}
