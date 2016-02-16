package skype.teach.np.collection;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author NPrilepa
 */
public class NpLinkedListTest extends NpListTest {
    @Override
    protected <T> NpList<T> createInstance() {
        return new NpLinkedList<T>();
    }

    @Test
    public void add_null_element_to_empty_array_int() {
        NpList<Integer> int_list = createInstance();
        int_list.add(null);
        assertTrue("add_null_element_to_empty_array_int int_num.size()", int_list.size() == 1);
        assertTrue("add_null_element_to_empty_array_int int_list.getByIndex(0).equals(\"element1\")", int_list.getByIndex(0) == null);
        assertTrue("add_null_element_to_empty_array_int int_list.getIndexByElement(\"element1\")==0", int_list.getIndexByElement(null) == 0);
        int_list.delete(0);
        assertTrue("add_null_element_to_empty_array_int int_num.size()", int_list.size() == 0);
    }


    @Test
    public void get_index_not_null_element() {
        NpList<String> string_list = createInstance();
        string_list.add(null);
        string_list.add("element");
        assertTrue("get_index_null_element string_list.size()", string_list.size() == 2);
        assertTrue("get_index_null_element string_list.getIndexByElement(\"element\")==1", string_list.getIndexByElement("element") == 1);
    }

    }
