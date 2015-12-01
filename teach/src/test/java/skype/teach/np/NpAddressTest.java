package skype.teach.np;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author NPrilepa
 */
public class NpAddressTest {
    @Test
    public void testEqualAddress() {

        Address adr = new Address("Moscow", "Stoleshnikov", "per.", 23, 34, 1234);
        Address adr1 = new Address("Moscow", "Stoleshnikov", "per.", 23, 35, 1234);
        Address adr2 = new Address("Moscow", "Stoleshnikov", "per.", 23, 35, 1234);
        Address adr3 = new Address(null, "Stoleshnikov", "per.", 23, 35, 1234);
        Address adr4 = new Address("Moscow", "Stoleshnikov", null, 23, 35, 1234);
        Address adr5 = new Address("Moscow", "Stoleshnikov", "p.", 23, 34, 1234);
        Address adr6 = new Address("Moscow", " Stoleshnikov ", "p", 23, 34, 1234);
        Address adr7 = new Address("Moscow", "Stoleshnikov", "per.", 23, 34, 123445);
        Address adr8 = new Address("Moscow", null, "p", 23, 34, 1234);
        Address adr9 = new Address("Moscow", "stoleshnikov", "p", 23, 34, 1234);
        Object obj = new Object();

        // test different flatNum
        assertEquals("adr.equals(adr1)", false, adr.equals(adr1));
        // test the same Address
        assertEquals("adr.equals(adr)", true, adr.equals(adr));
        // test adr=null
        assertEquals("adr.equals(null)", false, adr.equals(null));
        //test different instance of object
        assertEquals("adr.equals(obj)", false, adr.equals(obj));
        // test identical Address
        assertEquals("adr1.equals(adr2)", true, adr1.equals(adr2));
        //test cityName = null
        assertEquals("adr.equals(adr3)", false, adr.equals(adr3));
        //test streetType = null
        assertEquals("adr.equals(adr4)", false, adr.equals(adr4));
        //test symmetry
        assertEquals("adr.equals(adr4)", false, adr4.equals(adr));
        // test contains of "." in streetType
        assertEquals("adr.equals(adr5)", true, adr.equals(adr5));
        // test " " in streetName
        assertEquals("adr.equals(adr6)", true, adr.equals(adr6));
        //test not important index
        assertEquals("adr.equals(adr7)", true, adr.equals(adr7));
        //test streetName=null
        assertEquals("adr.equals(adr8)", false, adr.equals(adr8));
        // test not important case streetName
        assertEquals("adr.equals(adr9)", true, adr.equals(adr9));

    }
}
