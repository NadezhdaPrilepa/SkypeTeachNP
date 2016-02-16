package skype.teach.np.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;


/**
 * @author NPrilepa
 */
public abstract class NpListTest {
    protected abstract <T> NpList<T> createInstance();

    // -------for Integer------------------------------------------
    @Test(expected = IndexOutOfBoundsException.class)
    public void exception_index_out_of_bounds_empty_int() {
        NpList<Integer> int_list = createInstance();
        int_list.delete(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void exception_index_out_of_bounds_not_empty_int() {
        NpList<Integer> int_list = createInstance();
        int_list.add(12);
        int_list.delete(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void exception_index_out_of_bounds_not_empty_int_get() {
        NpList<Integer> int_list = createInstance();
        int_list.add(12);
        int_list.getByIndex(1);
    }

    @Test
    public void size_empty_int() {
        NpList<Integer> int_list = createInstance();
        assertTrue("int_list.size()", int_list.size() == 0);
    }

    @Test
    public void add_element_to_empty_array_int() {
        NpList<Integer> int_list = createInstance();
        int_list.add(12);
        assertTrue("add_element_to_empty_array int_num.size()", int_list.size() == 1);
        assertTrue("add_element_to_empty_array int_list.getByIndex(0).equals(\"element1\")", int_list.getByIndex(0).equals(12));
        assertTrue("add_element_to_empty_array int_list.getIndexByElement(\"element1\")==0", int_list.getIndexByElement(12) == 0);
        int_list.delete(0);
        assertTrue("add_element_to_empty_array int_num.size()", int_list.size() == 0);
    }

    @Test
    public void add_same_element_int() {
        NpList<Integer> int_list = createInstance();
        int_list.add(12);
        int_list.add(12);
        assertTrue("add_same_element_int int_num.size()", int_list.size() == 2);
        assertTrue("add_same_element_int int_list.getByIndex(0).equals(\"element1\")", int_list.getByIndex(0).equals(12));
        assertTrue("add_same_element_int int_list.getIndexByElement(\"element1\")==0", int_list.getIndexByElement(12) == 0);
        int_list.delete(0);
        assertTrue("add_same_element_int int_num.size()", int_list.size() == 1);
    }

    @Test
    public void delete_not_first_element_int() {
        NpList<Integer> int_list = createInstance();
        int_list.add(12);
        int_list.add(23);
        int_list.add(4);
        int_list.add(8);
        assertTrue("delete_not_first_element_int string_num.size()", int_list.size() == 4);
        int_list.delete(2);
        assertTrue("delete_not_first_element_int string_num.size()", int_list.size() == 3);
        assertTrue("delete_not_first_element_int string_list.getByIndex(2).equals(\"element1\")", int_list.getByIndex(2).equals(8));
    }

    @Test
    public void get_index_non_existing_element_int() {
        NpList<Integer> int_list = createInstance();
        int_list.add(12);
        assertTrue("get_index_non_existing_element string_num.size()", int_list.size() == 1);
        assertTrue("get_index_non_existing_element string_list.getIndexByElement(\"element2\")==-1", int_list.getIndexByElement(13) == -1);
    }

    @Test
    public void get_index_null_int() {
        NpList<Integer> int_list = createInstance();
        int_list.add(12);
        assertTrue("get_index_null_int string_num.size()", int_list.size() == 1);
        assertTrue("get_index_null_int string_list.getIndexByElement(\"element2\")==-1", int_list.getIndexByElement(null) == -1);
    }

    //-------------for String-------------------------------------
    @Test(expected = IndexOutOfBoundsException.class)
    public void exception_index_out_of_bounds_empty() {
        NpList<String> string_list = createInstance();
        string_list.delete(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void exception_index_out_of_bounds_not_empty() {
        NpList<String> string_list = createInstance();
        string_list.add("element1");
        string_list.delete(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void exception_index_out_of_bounds_not_empty_get() {
        NpList<String> string_list = createInstance();
        string_list.add("element1");
        string_list.getByIndex(1);
    }

    @Test
    public void size_empty() {
        NpList<String> string_list = createInstance();
        assertTrue("string_list.size()", string_list.size() == 0);
    }

    @Test
    public void add_element_to_empty_array() {
        NpList<String> string_list = createInstance();
        string_list.add("element1");
        assertTrue("add_element_to_empty_array string_num.size()", string_list.size() == 1);
        assertTrue("add_element_to_empty_array string_list.getByIndex(0).equals(\"element1\")", string_list.getByIndex(0).equals("element1"));
        assertTrue("add_element_to_empty_array string_list.getIndexByElement(\"element1\")==0", string_list.getIndexByElement("element1") == 0);
        string_list.delete(0);
        assertTrue("add_element_to_empty_array string_num.size()", string_list.size() == 0);
    }

    @Test
    public void delete_not_first_element() {
        NpList<String> string_list = createInstance();
        string_list.add("element1");
        string_list.add("element2");
        string_list.add("element3");
        string_list.add("element4");
        assertTrue("delete_not_first_element string_num.size()", string_list.size() == 4);
        string_list.delete(2);
        assertTrue("delete_not_first_element string_num.size()", string_list.size() == 3);
        assertTrue("delete_not_first_element string_list.getByIndex(2).equals(\"element1\")", string_list.getByIndex(2).equals("element4"));
    }

    @Test
    public void get_index_non_existing_element() {
        NpList<String> string_list = createInstance();
        string_list.add("element1");
        assertTrue("get_index_non_existing_element string_num.size()", string_list.size() == 1);
        assertTrue("get_index_non_existing_element string_list.getIndexByElement(\"element2\")==-1", string_list.getIndexByElement("element2") == -1);
    }

    @Test
    public void get_index_null() {
        NpList<String> string_list = createInstance();
        string_list.add("element1");
        assertTrue("get_index_non_existing_element string_num.size()", string_list.size() == 1);
        assertTrue("get_index_non_existing_element string_list.getIndexByElement(\"element2\")==-1", string_list.getIndexByElement(null) == -1);
    }

    @Test
    public void add_same_element() {
        NpList<String> string_list = createInstance();
        string_list.add("element1");
        string_list.add("element1");
        assertTrue("add_same_element string_num.size()", string_list.size() == 2);
        assertTrue("add_same_element string_list.getByIndex(0).equals(\"element1\")", string_list.getByIndex(0).equals("element1"));
        assertTrue("add_same_element string_list.getIndexByElement(\"element1\")==0", string_list.getIndexByElement("element1") == 0);
        string_list.delete(0);
        assertTrue("add_same_element string_num.size()", string_list.size() == 1);
    }

    @Test
    public void iterator_empty() {
        NpList<String> string_list = createInstance();
        Iterator it = string_list.iterator();
        assertFalse("iterator_empty it.hasNext()=false", it.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_empty_exception() {
        NpList<String> string_list = createInstance();
        Iterator it = string_list.iterator();
        assertFalse("iterator_empty_exception it.next()", it.next() == null);
    }

    @Test
    public void iterator_one_element() {
        NpList<String> string_list = createInstance();
        string_list.add("element1");
        Iterator it = string_list.iterator();
        assertTrue("iterator_one_element it.hasNext()=true", it.hasNext());
        assertTrue("iterator_one_element it.next().equals(\"element1\")", it.next().equals("element1"));
        assertFalse("iterator_one_element it.hasNext()=false", it.hasNext());
    }

    @Test
    public void iterator_some_element() {
        NpList<String> string_list = createInstance();
        string_list.add("element1");
        string_list.add("element2");
        Iterator it = string_list.iterator();
        assertTrue("iterator_some_element it.hasNext()=true", it.hasNext());
        assertTrue("iterator_some_element it.next().equals(\"element1\")", it.next().equals("element1"));
        assertTrue("iterator_some_element it.hasNext()=true", it.hasNext());
        assertTrue("iterator_some_element it.next().equals(\"element2\")", it.next().equals("element2"));
        assertFalse("iterator_some_element it.hasNext()=false", it.hasNext());
    }

    @Test
    public void iterator_same_element() {
        NpList<String> string_list = createInstance();
        string_list.add("element1");
        string_list.add("element1");
        Iterator it = string_list.iterator();
        assertTrue("iterator_same_element it.hasNext()=true", it.hasNext());
        assertTrue("iterator_same_element it.next().equals(\"element1\")", it.next().equals("element1"));
        assertTrue("iterator_same_element it.hasNext()=true", it.hasNext());
        assertTrue("iterator_same_element it.next().equals(\"element1\")", it.next().equals("element1"));
        assertFalse("iterator_same_element it.hasNext()=false", it.hasNext());
    }

    @Test
    public void iterator_null_element() {
        NpList<String> string_list = createInstance();
        string_list.add(null);
        string_list.add("element1");
        Iterator it = string_list.iterator();
        assertTrue("iterator_null_element it.hasNext()=true", it.hasNext());
        assertNull("iterator_null_element it.next()==null", it.next());
        assertTrue("iterator_null_element it.hasNext()=true", it.hasNext());
        assertEquals("iterator_null_element it.next().equals(\"element1\")", "element1", it.next());
        assertFalse("iterator_null_element it.hasNext()=false", it.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_delete_empty_element() {
        NpList<String> string_list = createInstance();
        Iterator it = string_list.iterator();
        it.remove();
    }

    @Test
    public void iterator_delete_one_element() {
        NpList<String> string_list = createInstance();
        string_list.add("element1");
        Iterator it = string_list.iterator();
        if (it.hasNext()) {
            it.next();
            it.remove();
        }
        assertFalse("iterator_delete_one_element it.hasNext()=false", it.hasNext());
        assertTrue("iterator_delete_one_element string_list.size()==0", string_list.size() == 0);
    }

    @Test
    public void iterator_delete_some_element() {
        NpList<String> string_list = createInstance();
        string_list.add("element1");
        string_list.add("element1");
        string_list.add("element1");

        Iterator it = string_list.iterator();
        it.hasNext();
        it.next();
        it.remove();


        assertTrue("iterator_delete_some_element it.hasNext()=true", it.hasNext());
        assertTrue("iterator_delete_some_element string_list.size()==2", string_list.size() == 2);
        assertTrue("iterator_delete_some_element string_list.contains(\"element1\")", string_list.contains("element1"));
        it.hasNext();
        it.next();
        it.remove();
        assertTrue("iterator_delete_some_element it.hasNext()=true", it.hasNext());
        assertTrue("iterator_delete_some_element string_list.size()==1", string_list.size() == 1);
        assertTrue("iterator_delete_some_element string_list.contains(\"element1\")", string_list.contains("element1"));
        it.hasNext();
        it.next();
        it.remove();
        assertFalse("iterator_delete_some_element it.hasNext()=false", it.hasNext());
        assertTrue("iterator_delete_some_element string_list.size()==0", string_list.size() == 0);
    }

    @Test
    public void iterator_delete_null_element() {
        NpList<String> string_list = createInstance();
        string_list.add(null);
        string_list.add("element1");
        string_list.add("element2");

        Iterator it = string_list.iterator();
        it.hasNext();
        it.next();
        it.remove();

        assertTrue("iterator_delete_null_element it.hasNext()=true", it.hasNext());
        assertTrue("iterator_delete_null_element string_list.size()==2", string_list.size() == 2);
        assertTrue("iterator_delete_null_element string_list.size()==2", string_list.getIndexByElement("element1") == 0);
        assertTrue("iterator_delete_null_element string_list.size()==2", string_list.getIndexByElement("element2") == 1);
        it.hasNext();
        it.next();
        it.remove();

        assertTrue("iterator_delete_null_element it.hasNext()=true", it.hasNext());
        assertTrue("iterator_delete_null_element string_list.size()==1", string_list.size() == 1);
        assertTrue("iterator_delete_null_element string_list.size()==2", string_list.getIndexByElement("element2") == 0);
        it.hasNext();
        it.next();
        it.remove();

        assertFalse("iterator_delete_null_element it.hasNext()=false", it.hasNext());
        assertTrue("iterator_delete_null_element string_list.size()==0", string_list.size() == 0);
    }


}
