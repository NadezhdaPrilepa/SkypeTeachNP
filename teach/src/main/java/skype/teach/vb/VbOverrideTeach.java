package skype.teach.vb;

/**
 * @author NPrilepa
 */
public class VbOverrideTeach {
    public static void main(String[] args) {
        C c = new C();
        c.print(5);
        c.print("hello");
        c = new D();
        c.print(6);
        c.print("hello");

    }
}

class C {
    public void print(int x) {
        System.out.println("c.x: " + x);
    }

    public C print(String name) {
        System.out.println("c.name: " + name);
        return this;
    }
}

class C1 extends C {
    @Override
    public C1 print(String name) {
        // super.print(name + " from C1");
        System.out.println("c1.name: " + name);
        return this;
    }
}

class D extends C1 {
    @Override
    public void print(int x) {
        System.out.println("d.x: " + x);
    }
}
