package skype.teach.np.zoo;

/**
 * @author NPrilepa
 */
public class Cat extends Animal {
    String kind;

    public Cat() {
    }

    public Cat(String kind) {
        this.kind = kind;
    }

    @Override
    public boolean isPet() {
        if (kind == null) {
            return true;
        }
        if (kind.equalsIgnoreCase("lynx")) {
            return false;
        }
        return true;
    }

    @Override
    public String voice() {
        return "meau";
    }

    @Override
    public String eat() {
        return "milk";
    }

}
