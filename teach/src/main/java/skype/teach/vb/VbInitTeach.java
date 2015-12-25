package skype.teach.vb;

/**
 * @author NPrilepa
 */
public class VbInitTeach {
    {
        str2 = "world";
        str3 = "world2";

        System.out.println("Init block " + toString());
    }

    private String str = "hello";

    private String str2 = "hello2";

    private static String str3;
    private final String STR4;

    {
        str2 = "world";

        str3 = "world2";
        System.out.println("Init block 2 " + toString());
    }

    static {
        System.out.println("Static init block");
    }

    public VbInitTeach() {
        STR4 = "hello7";
        System.out.println("Constructor:" + toString());

    }

    @Override
    public String toString() {
        return "VbInitTeach{" +
                "str='" + str + '\'' +
                ", str2='" + str2 + '\'' +
                '}';
    }

    public static void main(String[] args) {
        VbInitTeach vbit = new VbInitTeach();
        System.out.println("vbit: " + vbit);
    }
}
