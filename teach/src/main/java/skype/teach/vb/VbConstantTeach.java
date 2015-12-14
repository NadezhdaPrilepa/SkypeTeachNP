package skype.teach.vb;

/**
 * @author NPrilepa
 */
public class VbConstantTeach {

    public static final int NUMBER_OF_RECORDS;

    static {
        NUMBER_OF_RECORDS = 100;
    }

    public static final VbJavaBeanTeach BEAN_TEACH = new VbJavaBeanTeach();

    public static void main(String[] args) {
        //  NUMBER_OF_RECORDS = 90;
//        BEAN_TEACH =new VbJavaBeanTeach();
        BEAN_TEACH.setName("name");
    }
}
