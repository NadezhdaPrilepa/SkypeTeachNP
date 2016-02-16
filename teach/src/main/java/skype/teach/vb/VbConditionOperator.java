package skype.teach.vb;

/**
 * @author NPrilepa
 */
public class VbConditionOperator {
    public static void main(String[] args) {

    }

    public static int getValue(String str) {
        int result = str.startsWith("A")
                ? 0 : str.endsWith("Q")
                ? 1 : str.length() == 3
                ? 2 : 3;

        if (str.startsWith("A")) {
            return 0;
        }
        if (str.endsWith("Q")) {
            return 1;
        }
        if (str.length() == 3) {
            return 2;
        } else {
            return 3;
        }
    }
}
