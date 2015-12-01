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
        // indexNum not important for result
        if (this.cityName.equals(addr.cityName)) {
            if ((this.streetName != null) && (addr.streetName != null)) {
//               "." and case in streetName is not important for result
                if (this.streetName.trim().toLowerCase().equals(addr.streetName.trim().toLowerCase().replace(".", ""))) {
                    if ((this.streetType != null) && (addr.streetType != null)) {
//                       "." and case in streetType is not important for result.
//                        Length of streetType is not important too...
                        if ((this.streetType.toLowerCase().replace(".", "").
                                contains(addr.streetType.toLowerCase().replace(".", ""))
                                || addr.streetType.toLowerCase().replace(".", "").contains(this.streetType.toLowerCase().replace(".", ""))) &&
                                this.houseNum == addr.houseNum
                                && this.flatNum == addr.flatNum) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
