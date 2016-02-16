package skype.teach.np.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * @author NPrilepa
 */
public abstract class NpSetTest {

    protected abstract <T> NpSet<T> createInstance();

    @Test
    public void size_empty() {
        NpSet<String> string_set = createInstance();
        assertTrue("size_empty string_set.size()", string_set.size() == 0);
        assertFalse("size_empty string_set.delete(\"element1\")", string_set.delete("element1"));
        assertFalse("size_empty string_set.contains(\"element1\")", string_set.contains("element1"));
    }

    @Test
    public void add_element_to_empty_set() {
        NpSet<String> string_set = createInstance();
        assertTrue("add_element_to_empty_set string_set.add(\"element1\")", string_set.add("element1"));
        assertTrue("add_element_to_empty_set string_set.size() == 1", string_set.size() == 1);
        assertTrue("add_element_to_empty_set string_set.contains(\"element1\")", string_set.contains("element1"));
         }

    @Test
      public void add_same_element_to_empty_set() {
        NpSet<String> string_set = createInstance();
        assertTrue("add_same_element_to_empty_set string_set.add(\"element1\")", string_set.add("element1"));
        assertFalse("add_same_element_to_empty_set string_set.add(\"element1\")", string_set.add("element1"));
        assertTrue("add_same_element_to_empty_set string_set.size() == 1", string_set.size() == 1);
        assertTrue("add_same_element_to_empty_set string_set.contains(\"element1\")", string_set.contains("element1"));
    }

    @Test
    public void add_null_element_to_empty_set() {
        NpSet<String> string_set = createInstance();
        assertTrue("add_same_element_to_empty_set string_set.add(\"element1\")", string_set.add(null));
        assertTrue("add_same_element_to_empty_set string_set.size() == 1", string_set.size() == 1);
        assertTrue("add_same_element_to_empty_set string_set.contains(\"element1\")", string_set.contains(null));
    }

    @Test
    public void delete_element_from_set() {
        NpSet<String> string_set = createInstance();
        assertTrue("delete_element_from_set string_set.add(\"element1\")", string_set.add("element1"));
        assertTrue("delete_element_from_set string_set.size() == 1", string_set.size() == 1);
        assertTrue("delete_element_from_set string_set.contains(\"element1\")", string_set.contains("element1"));
        assertTrue("delete_element_from_set string_set.delete(\"element1\")", string_set.delete("element1"));
        assertTrue("delete_element_from_set string_set.size() == 0", string_set.size() == 0);
        assertFalse("delete_element_from_set string_set.contains(\"element1\")", string_set.contains("element1"));
    }

    @Test
    public void delete_null_element_from_set() {
        NpSet<String> string_set = createInstance();
        assertTrue("delete_element_from_set string_set.add(null)", string_set.add(null));
        assertTrue("delete_element_from_set string_set.size() == 1", string_set.size() == 1);
        assertTrue("delete_element_from_set string_set.contains(null)", string_set.contains(null));
        assertTrue("delete_element_from_set string_set.delete(null)", string_set.delete(null));
        assertTrue("delete_element_from_set string_set.size() == 0", string_set.size() == 0);
        assertFalse("delete_element_from_set string_set.contains(null)", string_set.contains(null));
    }





}
