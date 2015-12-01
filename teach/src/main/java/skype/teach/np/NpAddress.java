package skype.teach.np;

/**
 * @author NPrilepa
 *         Class Address override method Equals(Address adr)
 */
class Address {
    private String cityName;
    private String streetName;
    private String streetType;
    private int houseNum;
    private int flatNum;
    private int indexNum;

    Address(String cityName, String streetName, String streetType, int houseNum, int flatNum, int indexNum) {
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
        if (!(obj instanceof Address)) {
            return false;
        }
        Address addr = (Address) obj;
        /*indexNum not important for result
         if cityName equals or both of String field cityName == null */
        if ((this.cityName == null && addr.cityName == null)||this.cityName.equals(addr.cityName)) {
            if ((this.streetName != null) && (addr.streetName != null)) {
                //      "." and case in streetName is not important for result
                if (this.streetName.trim().toLowerCase().equals(addr.streetName.trim().toLowerCase().replace(".", ""))) {
                    if (equalsAddress(this.streetType, addr.streetType, this.houseNum, addr.houseNum, this.flatNum, addr.flatNum)) {
                        return true;
                    }
                }
            } else if ((this.streetName == null) && (addr.streetName == null)) {
                if (equalsAddress(this.streetType, addr.streetType, this.houseNum, addr.houseNum, this.flatNum, addr.flatNum)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean equalsAddress(String type, String type1, int house, int house1, int flat, int flat1) {
        if ((type != null) && (type1 != null)) {
        /* "." and case in streetType is not important for result.
            Length of streetType is not important too...  */
            if ((type.toLowerCase().replace(".", "").
                    contains(type1.toLowerCase().replace(".", ""))
                    || type1.toLowerCase().replace(".", "").contains(type.toLowerCase().replace(".", ""))) &&
                    house == house1
                    && flat == flat1) {
                return true;
            }
        } else if ((type == null) && (type1 == null)) {
            if ((house == house1)
                    && (flat == flat1)) {
                return true;
            }
        }
        return false;
    }
}
