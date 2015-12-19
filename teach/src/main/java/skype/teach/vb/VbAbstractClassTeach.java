package skype.teach.vb;

/**
 * @author NPrilepa
 */
public class VbAbstractClassTeach {
    public static void main(String[] args) {
        IVbVehicle vbv = new VbCar();
        IVbPassengerVehicle vbc = new VbCar();
        vbv.repair();
        vbc.supportsPassengerCount();
    }
}

interface IVbVehicle {
    int getPrice();

    void repair();
}

interface IVbPassengerVehicle extends IVbVehicle {
    public boolean supportsPassengerCount();

}

abstract class VbVehicle implements IVbVehicle {
    private int price;

    public int getPrice() {
        return price;
    }

    // public abstract void repair();
}

abstract class VbPassengerVehicle extends VbVehicle implements IVbPassengerVehicle {
    private boolean passengerCount;

    public boolean supportsPassengerCount() {
        return passengerCount;
    }
}

abstract class VbTrunkVehicle extends VbVehicle {

    public abstract void putGruz();

}

final class VbCar extends VbPassengerVehicle implements IVbPassengerVehicle {
    // @Override
    public void repair() {
        System.out.println("Car repair!");

    }
}



