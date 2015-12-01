package skype.teach.vb;

/**
 * @author NPrilepa
 */
public class VbObjectTeach {

    public static void main(String[] args) throws Exception {
        Object obj = new Object();
        Object obj1 = obj;
        obj = new Object();
        obj1 = null;
        String str = obj.toString();
        System.out.println(obj);
        String str1 = "Hello " + obj;
        Class c = obj.getClass();
        String name = "java.lang.Object";
        Object obj2 = Class.forName(name).newInstance();
        System.out.println("obj2.getClass().getName() = " + obj2.getClass().getName());

    }
}
