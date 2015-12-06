package skype.teach.np;

/**
 * @author NPrilepa
 */
 class NpAddressEA {
    static boolean  equalsAddress(String type, String type1, int house, int house1, int flat, int flat1) {
        if ((type != null) && (type1 != null)) {
        /* "." and case in streetType is not important for result.
            Length of streetType is not important too...  */

            if ((type.replace(".", "").
                    equalsIgnoreCase(type1.replace(".", ""))))
            {
                return house == house1 ? flat == flat1 : false;
            }
        } else if ((type == null) && (type1 == null)) {
            return house == house1 ? flat == flat1 : false;
        }
        return false;
    }

}
