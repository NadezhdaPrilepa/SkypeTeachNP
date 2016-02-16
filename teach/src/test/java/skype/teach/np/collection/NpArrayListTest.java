package skype.teach.np.collection;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author NPrilepa
 */
public class NpArrayListTest extends NpListTest {

    protected <T> NpList<T> createInstance(int size) {
        return new NpArrayList<T>(size);
    }
    @Test
    public void size_num() {
        NpList<String> string_list = createInstance(5);
        assertTrue("string_num.size()", string_list.size() == 0);
    }
    @Override
    protected <T> NpList<T> createInstance() {
        return new NpArrayList<T>();
    }

    @Test
    public void add_null_element_to_empty_array_int() {
        NpList<Integer> int_list = createInstance();
        int_list.add(null);
        assertTrue("add_null_element_to_empty_array_int int_num.size()", int_list.size() == 1);
        assertTrue("add_null_element_to_empty_array_int int_list.getByIndex(0).equals(\"element1\")", int_list.getByIndex(0)==null);
        assertTrue("add_null_element_to_empty_array_int int_list.getIndexByElement(\"element1\")==0", int_list.getIndexByElement(null) == 0);
        int_list.delete(0);
        assertTrue("add_null_element_to_empty_array_int int_num.size()", int_list.size() == 0);
    }

    @Test
    public void size_num_int() {
        NpList<Integer> int_list = createInstance(5);
        assertTrue("int_num.size()", int_list.size() == 0);
    }


}
