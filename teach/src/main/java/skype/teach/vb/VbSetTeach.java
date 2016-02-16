package skype.teach.vb;

import java.util.HashSet;
import java.util.Set;

/**
 * @author NPrilepa
 */
public class VbSetTeach {
    public static void main(String[] args) {
       VbBadHashCode s1 =new VbBadHashCode();
       VbBadHashCode s2 =new VbBadHashCode();
        Set hs = new HashSet();
    }
}
class VbBadHashCode{
    @Override
    public int hashCode() {
        return 1;
    }
}
