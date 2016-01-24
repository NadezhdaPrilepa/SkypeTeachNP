package skype.teach.vb;

/**
 * @author NPrilepa
 */
public class VbGenericMethodTeach {
    public static void main(String[] args) {
        String s = printStatistic("");
        Integer s2 = printStatistic2();
        printStatistic2();

    }

    public static <T> T printStatistic(T t) {
        return t;
    }

    public static <T> T printStatistic2() {
        return null;
    }
}
