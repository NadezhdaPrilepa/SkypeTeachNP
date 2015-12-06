package skype.teach.vb;

/**
 * @author NPrilepa
 */
public class VbAccessTeach {
    public int num;
    private static VbAccessTeach instance=new VbAccessTeach();

    public static VbAccessTeach getInstance() {
        return instance;
    }

    public VbAccessTeach() {
        this.num = num;

    }

    public static void main(String[] args) {
        VbAccessTeach vbat = new VbAccessTeach();
        System.out.println("vbat.num: " + vbat.num);
    }

    protected int getNum() {
        return num;
    }
}
