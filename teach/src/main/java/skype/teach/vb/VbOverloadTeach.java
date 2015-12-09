package skype.teach.vb;

/**
 * @author NPrilepa
 */
public class VbOverloadTeach {
    public static void main(String[] args) {
        VbOverloadTeach vbot = new VbOverloadTeach();

        vbot.print(5);
        vbot.print((Integer) null);
        A a = new A();
        vbot.print(a);
        a = new B();
        vbot.print((B)a);
    }

    public void print(Integer x) {
        System.out.println("x: " + x);
    }

    public void print(String name) {
        System.out.println("name: " + name);
    }

    public void print(A a) {
        System.out.println("a: " + a);
    }

    public void print(B b) {
        System.out.println("b: " + b);
    }

}

class A {

}

class B extends A {

}