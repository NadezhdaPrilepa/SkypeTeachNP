package skype.teach.np;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author NPrilepa
 */
public class NpAddressTest {
    @Test
    public void testEqualsAddress() {

        NpAddress adr = new NpAddress("Moscow", "Stoleshnikov", "per.", 23, 34, 1234);
        NpAddress adr1 = new NpAddress("Moscow", "Stoleshnikov", "per.", 23, 35, 1234);
        NpAddress adr2 = new NpAddress("Moscow", "Stoleshnikov", "per.", 23, 35, 1234);
        NpAddress adr3 = new NpAddress(null, "Stoleshnikov", "per.", 23, 35, 1234);

        NpAddress adr4 = new NpAddress("Moscow", "Stoleshnikov", null, 23, 35, 1234);

        NpAddress adr5 = new NpAddress("Moscow", "Stoleshnikov", "p.", 23, 34, 1234);
        NpAddress adr6 = new NpAddress("Moscow", " Stoleshnikov ", "per", 23, 34, 1234);
        NpAddress adr7 = new NpAddress("Moscow", "Stoleshnikov", "per.", 23, 34, 123445);

        NpAddress adr8 = new NpAddress("Moscow", null, "p", 23, 34, 1234);
        NpAddress adr9 = new NpAddress("Moscow", "stoleshnikov", "per", 23, 34, 1234);
        NpAddress adr10 = new NpAddress("S.-Pb", "stoleshnikov", "p", 23, 34, 1234);
        NpAddress adr11 = new NpAddress(null, "Stoleshnikov", "per.", 23, 35, 1234);
        NpAddress adr12 = new NpAddress("Moscow", "Stoleshnikov", null, 23, 35, 1234);
        NpAddress adr13 = new NpAddress("Moscow", null, "p", 23, 34, 1234);
        NpAddress adr14 = new NpAddress("", null, "p", 23, 34, 1234);
        NpAddress adr15 = new NpAddress(" ", null, "p", 23, 34, 1234);
        Object obj = new Object();

        assertEquals("test different flatNum: adr.equals(adr1)", false, adr.equals(adr1));
        assertEquals("test different flatNum: adr.hashCode()==adr1.hashCode()", false, adr.hashCode() == adr1.hashCode());
        assertEquals("adr.equalsAddress(adr.getStreetType(),adr1.getStreetType(), adr.getHouseNum(), adr1.getHouseNum(),adr.getFlatNum(), adr1.getFlatNum())", false, NpAddressEA.equalsAddress(adr.getStreetType(),adr1.getStreetType(), adr.getHouseNum(), adr1.getHouseNum(),adr.getFlatNum(), adr1.getFlatNum()));

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
        assertEquals("adr.equalsAddress(adr.getStreetType(),adr4.getStreetType(), adr.getHouseNum(), adr4.getHouseNum(),adr.getFlatNum(), adr4.getFlatNum())", false, NpAddressEA.equalsAddress(adr.getStreetType(), adr4.getStreetType(), adr.getHouseNum(), adr4.getHouseNum(), adr.getFlatNum(), adr4.getFlatNum()));

        assertEquals("test symmetry: adr.equals(adr4)", false, adr4.equals(adr));

        assertEquals("test contains of \".\" in streetType: adr.equals(adr5)", false, adr.equals(adr5));
        assertEquals("test contains of \".\" in streetType: adr.hashCode()==adr5.hashCode():", false, adr.hashCode() == adr5.hashCode());
        assertEquals("adr.equalsAddress(adr.getStreetType(),adr5.getStreetType(), adr.getHouseNum(), adr5.getHouseNum(),adr.getFlatNum(), adr5.getFlatNum())", false, NpAddressEA.equalsAddress(adr.getStreetType(), adr5.getStreetType(), adr.getHouseNum(), adr5.getHouseNum(), adr.getFlatNum(), adr5.getFlatNum()));

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
        assertEquals("adr4.equalsAddress(adr4.getStreetType(),adr12.getStreetType(), adr4.getHouseNum(), adr12.getHouseNum(),adr4.getFlatNum(), adr12.getFlatNum())", true, NpAddressEA.equalsAddress(adr4.getStreetType(), adr12.getStreetType(), adr4.getHouseNum(), adr12.getHouseNum(), adr4.getFlatNum(), adr12.getFlatNum()));

        assertEquals("test trim() for cityName: adr14.equals(adr15)", true, adr14.equals(adr15));
        assertEquals("test trim() for cityName: adr14.hashCode()==adr15.hashCode()", true, adr14.hashCode() == adr15.hashCode());

        assertEquals("adr.equalsAddress(adr.getStreetType(),adr11.getStreetType(), adr.getHouseNum(), adr11.getHouseNum(),adr.getFlatNum(), adr11.getFlatNum())", false, NpAddressEA.equalsAddress(adr.getStreetType(),adr11.getStreetType(), adr.getHouseNum(), adr11.getHouseNum(),adr.getFlatNum(), adr11.getFlatNum()));
    }

}
