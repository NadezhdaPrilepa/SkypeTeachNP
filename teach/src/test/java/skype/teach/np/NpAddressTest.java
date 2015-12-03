package skype.teach.np;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author NPrilepa
 */
public class NpAddressTest {
    @Test
    public void testEqualsAddress() {

        Address adr = new Address("Moscow", "Stoleshnikov", "per.", 23, 34, 1234);
        Address adr1 = new Address("Moscow", "Stoleshnikov", "per.", 23, 35, 1234);
        Address adr2 = new Address("Moscow", "Stoleshnikov", "per.", 23, 35, 1234);
        Address adr3 = new Address(null, "Stoleshnikov", "per.", 23, 35, 1234);

        Address adr4 = new Address("Moscow", "Stoleshnikov", null, 23, 35, 1234);

        Address adr5 = new Address("Moscow", "Stoleshnikov", "p.", 23, 34, 1234);
        Address adr6 = new Address("Moscow", " Stoleshnikov ", "per", 23, 34, 1234);
        Address adr7 = new Address("Moscow", "Stoleshnikov", "per.", 23, 34, 123445);

        Address adr8 = new Address("Moscow", null, "p", 23, 34, 1234);
        Address adr9 = new Address("Moscow", "stoleshnikov", "per", 23, 34, 1234);
        Address adr10 = new Address("S.-Pb", "stoleshnikov", "p", 23, 34, 1234);
        Address adr11 = new Address(null, "Stoleshnikov", "per.", 23, 35, 1234);
        Address adr12 = new Address("Moscow", "Stoleshnikov", null, 23, 35, 1234);
        Address adr13 = new Address("Moscow", null, "p", 23, 34, 1234);
        Address adr14 = new Address("", null, "p", 23, 34, 1234);
        Address adr15 = new Address(" ", null, "p", 23, 34, 1234);
        Object obj = new Object();

        assertEquals("test different flatNum: adr.equals(adr1)", false, adr.equals(adr1));
        assertEquals("test different flatNum: adr.hashCode()==adr1.hashCode()", false, adr.hashCode() == adr1.hashCode());

        assertEquals("test the same Address: adr.equals(adr)", true, adr.equals(adr));
        assertEquals("test the same Address: adr.hashCode()==adr.hashCode()", true, adr.hashCode() == adr.hashCode());

        assertEquals("test adr=null: adr.equals(null)", false, adr.equals(null));

        assertEquals("test different instance of object: adr.equals(obj)", false, adr.equals(obj));
        assertEquals("test different instance of object: adr.hashCode()==obj.hashCode()", false, adr.hashCode() == obj.hashCode());

        assertEquals("test identical Address: adr1.equals(adr2)", true, adr1.equals(adr2));
        assertEquals("test identical Address: adr1.hashCode()==adr2.hashCode()", true, adr1.hashCode() == adr2.hashCode());

        assertEquals("test cityName = null: adr.equals(adr3)", false, adr.equals(adr3));
        assertEquals("test cityName = null: adr.hashCode()==adr3.hashCode()", false, adr.hashCode() == adr3.hashCode());

        assertEquals("test streetType = null: adr.equals(adr4)", false, adr.equals(adr4));
        assertEquals("test streetType = null: adr.hashCode()==adr4.hashCode()", false, adr.hashCode() == adr4.hashCode());

        assertEquals("test symmetry: adr.equals(adr4)", false, adr4.equals(adr));

        assertEquals("test contains of \".\" in streetType: adr.equals(adr5)", false, adr.equals(adr5));
        assertEquals("test contains of \".\" in streetType: adr.hashCode()==adr5.hashCode():", false, adr.hashCode() == adr5.hashCode());

        assertEquals("test symmetry contains of \".\" in streetType: adr5.equals(adr)", false, adr5.equals(adr));

        assertEquals("test \" \" in streetName: adr.equals(adr6)", true, adr.equals(adr6));
        assertEquals("test \" \" in streetName: adr.hashCode()==adr6.hashCode(): "+adr.hashCode() +"-"+adr6.hashCode(), true, adr.hashCode() == adr6.hashCode());

        assertEquals("test not important index: adr.equals(adr7)", true, adr.equals(adr7));
        assertEquals("test not important index: adr.hashCode()==adr7.hashCode()", true, adr.hashCode() == adr7.hashCode());

        assertEquals("test streetName=null: adr.equals(adr8)", false, adr.equals(adr8));
        assertEquals("test streetName=null: adr.hashCode()==adr8.hashCode()", false, adr.hashCode() == adr8.hashCode());

        assertEquals("test not important case streetName: adr.equals(adr9)", true, adr.equals(adr9));
        assertEquals("test not important case streetName: adr.hashCode()==adr9.hashCode()", true, adr.hashCode() == adr9.hashCode());

        assertEquals("test different cityName: adr9.equals(adr10)", false, adr9.equals(adr10));
        assertEquals("test different cityName: adr9.hashCode()==adr10.hashCode()", false, adr9.hashCode() == adr10.hashCode());

        assertEquals("test both cityName = null: adr3.equals(adr11)", true, adr3.equals(adr11));
        assertEquals("test both cityName = null: adr3.hashCode()==adr11.hashCode()", true, adr3.hashCode() == adr11.hashCode());

        assertEquals("test both streetName = null: adr8.equals(adr13)", true, adr8.equals(adr13));
        assertEquals("test both streetName = null: adr8.hashCode()==adr13.hashCode()", true, adr8.hashCode() == adr13.hashCode());

        assertEquals("test both streeType = null: adr4.equals(adr12)", true, adr4.equals(adr12));
        assertEquals("test both streeType = null: adr4.hashCode()==adr12.hashCode()", true, adr4.hashCode() == adr12.hashCode());

        assertEquals("test trim() for cityName: adr14.equals(adr15)", true, adr14.equals(adr15));
        assertEquals("test trim() for cityName: adr14.hashCode()==adr15.hashCode()", true, adr14.hashCode() == adr15.hashCode());
    }

}
