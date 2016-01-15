package skype.teach.vb;

import skype.teach.vb.VbExternalClass.VbStaticInternalClass;
import skype.teach.vb.VbExternalClass.VbNonStaticInternalClass;


/**
 * @author NPrilepa
 */
public class VbInternalClassTeach {

    public static void main(String[] args) {
        VbStaticInternalClass vbStaticInt = new VbStaticInternalClass();
        vbStaticInt.print();
        VbExternalClass vbExt = new VbExternalClass();
        VbNonStaticInternalClass vbNonStaticInt = vbExt.new VbNonStaticInternalClass();
        VbNonStaticInternalClass vbNonStaticInt2 = vbExt.new VbNonStaticInternalClass();
        vbNonStaticInt.print();
        vbNonStaticInt2.print();
        vbNonStaticInt.print();
        System.out.println("getObj:" + vbExt.getObj());
        vbNonStaticInt.deleteObj();
        System.out.println("getObj:" + vbExt.getObj());
        Object obj = vbExt.createAnonymousObj();
        System.out.println("call toString from anonymous class " + obj);

    }
}

class VbExternalClass {
    private int count;
    private Object obj = new Object();

    public Object getObj() {
        return obj;
    }

    public void setCount()
    {
        class VbLocalClass{
            public void setCount(int count)
            {
                VbExternalClass.this.count = count;
            }
        }
        VbLocalClass vbLocal = new VbLocalClass();
        vbLocal.setCount(10);
    }
    public static void printStaticStatistic()
    {
        class VbLocalClass{
            public void setCount(int count)
            {
              //  VbExternalClass.this.count = count;
            }
        }
    }

    public VbNonStaticInternalClass createInternalObj() {
        VbNonStaticInternalClass vbNonStaticInt = new VbNonStaticInternalClass();
        return vbNonStaticInt;
    }

    public Object createAnonymousObj() {
        Object obj = new Object() {
            @Override
            public String toString() {
                return "anonymous: " + count;
            }
        };

        return obj;
    }

    public void addCount() {
        count++;
    }

    public static class VbStaticInternalClass {

        public void print() {
            System.out.println("static");
            //count++;
        }
    }

    public class VbNonStaticInternalClass {
        public void deleteObj() {
            obj = null;
        }

        public void print() {
            System.out.println("non static: " + count);
            count++;
        }
    }


}

