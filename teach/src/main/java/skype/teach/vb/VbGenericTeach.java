package skype.teach.vb;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NPrilepa
 */
public class VbGenericTeach {
    public static void main(String[] args) {
        VbGeneric2 generic = new VbGeneric2();
        generic.setValue(new ArrayList());
        generic.getValue();
        VbGeneric2<ArrayList> generic1 = new VbGeneric2<ArrayList>();
        generic1.setValue(new ArrayList());
        generic1.getValue();

        VbGeneric3<ArrayList> generic3 = new VbGeneric3<ArrayList>();
        generic3.setValue(new ArrayList());
        VbGeneric4<VbParent> generic4 = new VbGeneric4<VbParent>();
        generic4.f(new VbParent());
        VbGeneric5<VbParent, String> generic5 = new VbGeneric5<VbParent, String>();
        generic5.f(new VbParent(), "");
        /*VbGeneric4<? extends VbParent> generic6 = new VbGeneric4<ArrayList>();
        generic6.f(null);
        VbParent generic7 = generic6.f1();*/
    }
}

class VbGeneric1<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}

class VbGeneric2<T extends List> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class VbGeneric3<T extends List> extends VbGeneric1<T> {

}

class VbRoot {
}

class VbParent extends VbRoot {
}

class VbChild extends VbParent {

}

class VbGeneric4<T extends VbParent> {
    public void f(T t) {
    }

    public T f1() {
        return null;
    }
}

class VbGeneric5<T1 extends VbParent, T2> {
    public void f(T1 t1, T2 t2) {
    }
}

class VbGeneric6<F extends VbParent, T extends VbGeneric4<F>> {
}




/*class VbGeneric5<T super VbChild> {
    public void f(T t){}
}*/
