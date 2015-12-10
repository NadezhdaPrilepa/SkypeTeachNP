package skype.teach.np;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author NPrilepa
 */
public class NpAddressEATest {

    NpAddress adr = new NpAddress("Moscow", "Stoleshnikov", "per.", 23, 34, 1234);
    NpAddress adr1 = new NpAddress("Moscow", "Stoleshnikov", "per.", 23, 35, 1234);
    NpAddress adr4 = new NpAddress("Moscow", "Stoleshnikov", null, 23, 35, 1234);

    NpAddress adr5 = new NpAddress("Moscow", "Stoleshnikov", "p.", 23, 34, 1234);
    NpAddress adr11 = new NpAddress(null, "Stoleshnikov", "per.", 23, 35, 1234);
    NpAddress adr12 = new NpAddress("Moscow", "Stoleshnikov", null, 23, 35, 1234);
    NpAddressEA npea = new NpAddressEA();

    @Test
    public void EqualsAddressTest() {
        assertEquals("adr.equalsAddress("+adr.getStreetType()+","+adr1.getStreetType()+","+adr.getHouseNum()+","+ adr1.getHouseNum()+","+adr.getFlatNum()+","+ adr1.getFlatNum()+")", false, NpAddressEA.equalsAddress(adr.getStreetType(), adr1.getStreetType(), adr.getHouseNum(), adr1.getHouseNum(), adr.getFlatNum(), adr1.getFlatNum()));
        assertEquals("adr.equalsAddress("+adr.getStreetType()+","+adr4.getStreetType()+","+adr.getHouseNum()+","+ adr4.getHouseNum()+","+adr.getFlatNum()+","+ adr4.getFlatNum()+")", false, NpAddressEA.equalsAddress(adr.getStreetType(), adr4.getStreetType(), adr.getHouseNum(), adr4.getHouseNum(), adr.getFlatNum(), adr4.getFlatNum()));
        assertEquals("adr.equalsAddress("+adr.getStreetType()+","+adr5.getStreetType()+","+adr.getHouseNum()+","+ adr5.getHouseNum()+","+adr.getFlatNum()+","+ adr5.getFlatNum()+")", false, NpAddressEA.equalsAddress(adr.getStreetType(), adr5.getStreetType(), adr.getHouseNum(), adr5.getHouseNum(), adr.getFlatNum(), adr5.getFlatNum()));
        assertEquals("adr.equalsAddress("+adr.getStreetType()+","+adr11.getStreetType()+","+adr.getHouseNum()+","+ adr11.getHouseNum()+","+adr.getFlatNum()+","+ adr11.getFlatNum()+")", false, NpAddressEA.equalsAddress(adr.getStreetType(), adr11.getStreetType(), adr.getHouseNum(), adr11.getHouseNum(), adr.getFlatNum(), adr11.getFlatNum()));
        assertEquals("adr4.equalsAddress("+adr4.getStreetType()+","+adr12.getStreetType()+","+adr4.getHouseNum()+","+ adr12.getHouseNum()+","+adr4.getFlatNum()+","+ adr12.getFlatNum()+")", true, NpAddressEA.equalsAddress(adr4.getStreetType(), adr12.getStreetType(), adr4.getHouseNum(), adr12.getHouseNum(), adr4.getFlatNum(), adr12.getFlatNum()));

    }


}
