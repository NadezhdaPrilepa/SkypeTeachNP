package skype.teach.vb;

/**
 * @author NPrilepa
 */
public class VbHashCodeTeach {
    public static void main(String[] args) {
        VbPoint point1 = new VbPoint(1, 2, "p");
        VbPoint point2 = new VbPoint(1, 2, "P");
        VbPoint point3 = new VbPoint(2, 1, "pp");

        System.out.println("point1.equals(point2): (expected true): " + point1.equals(point2));
        System.out.println("point1.hashCode()==point2.hashCode(): (expected true): " + (point1.hashCode() == point2.hashCode()));

        System.out.println("point1.hashCode(): " + point1.hashCode());
        System.out.println("point2.hashCode(): " + point2.hashCode());
        System.out.println("point3.hashCode(): " + point3.hashCode());

        System.out.println("point1.equals(point3): (expected false): " + point1.equals(point3));
        System.out.println("point1.hashCode()==point3.hashCode(): (expected true or false): " + (point1.hashCode() == point3.hashCode()));

    }

}

class VbPoint {
    private int x;
    private int y;
    private String name;

    public VbPoint(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VbPoint vbPoint = (VbPoint) o;

        if (x != vbPoint.x) return false;
        if (!name.equalsIgnoreCase(vbPoint.name)) return false;
        return y == vbPoint.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + name.toLowerCase().hashCode();

        return result;
    }
}
