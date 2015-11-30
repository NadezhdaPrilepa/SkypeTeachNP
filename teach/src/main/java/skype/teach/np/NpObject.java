package skype.teach.np;

/**
 * @author NPrilepa
 *         Create mimimal cycle objects and then delete links on this objects
 */
public class NpObject {
    NpObject npObj = null;

    public static void main(String[] args) {
        // Start create cycle objects
        NpObject npObj1 = new NpObject();
        NpObject npObj2 = new NpObject();
        npObj1.npObj = npObj2;
        npObj2.npObj = npObj1;
        // End of create cycle objects
        // Start delete links on npObj1,npObj2
        NpObject npObj3 = new NpObject();
        npObj1 = npObj3;
        npObj2 = npObj3;
        // End

    }
}
