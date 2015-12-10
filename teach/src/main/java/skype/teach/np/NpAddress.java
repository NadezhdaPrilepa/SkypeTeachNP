package skype.teach.np;

/**
 * @author NPrilepa
 *         Class NpAddress override method Equals(NpAddress adr)
 */

public class NpAddress {
    private String cityName;
    private String streetName;
    private String streetType;
    private int houseNum;
    private int flatNum;
    private int indexNum;

    NpAddress(String cityName, String streetName, String streetType, int houseNum, int flatNum, int indexNum) {
        this.cityName = cityName;
        this.streetName = streetName;
        this.streetType = streetType;
        this.houseNum = houseNum;
        this.flatNum = flatNum;
        this.indexNum = indexNum;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof NpAddress)) {
            return false;
        }
        NpAddress addr = (NpAddress) obj;
        /*indexNum not important for result
         if cityName equals or both of String field cityName == null */
        if ((this.cityName != null && addr.cityName != null) && (!this.cityName.trim().equalsIgnoreCase(addr.cityName.trim()))) {
            return false;
        }
        if ((this.streetName != null) && (addr.streetName != null)) {
            //      "." and case in streetName is not important for result
            if (this.streetName.trim().replace(".", "").equalsIgnoreCase(addr.streetName.trim().replace(".", ""))) {
                if (NpAddressEA.equalsAddress(this.streetType, addr.streetType, this.houseNum, addr.houseNum, this.flatNum, addr.flatNum)) {
                    return true;
                }
            }
        } else if ((this.streetName == null) && (addr.streetName == null)) {
            if (NpAddressEA.equalsAddress(this.streetType, addr.streetType, this.houseNum, addr.houseNum, this.flatNum, addr.flatNum)) {
                return true;
            }
        }

        return false;

    }

    //@Override
    public int hashCode() {
        int result = cityName != null ? cityName.trim().toLowerCase().hashCode() : 0;
        result = 31 * result + (streetName != null ? streetName.trim().toLowerCase().hashCode() : 0);
        result = 31 * result + (streetType != null ? streetType.trim().replace(".","").toLowerCase().hashCode() : 0);
        result = 31 * result + houseNum;
        result = 31 * result + flatNum;
        //indexNum is not important
        //result = 31 * result + indexNum;
        return result;

    }
    public String getStreetType()
    {
        return streetType;
    }
    public int getHouseNum()
    {
        return houseNum;
    }

    public int getFlatNum()
    {
        return flatNum;
    }

}
