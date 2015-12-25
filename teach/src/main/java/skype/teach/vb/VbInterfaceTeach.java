package skype.teach.vb;

import java.util.Collection;

/**
 * @author NPrilepa
 */
public class VbInterfaceTeach {
    public static void main(String[] args) {

    }

    public void printShape(Shape shape) {
        System.out.println("shape.getSquare() " + shape.getSquare());
    }

}

 interface Shape {
    double getSquare();


}
