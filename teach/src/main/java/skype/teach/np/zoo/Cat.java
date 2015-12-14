package skype.teach.np.zoo;

/**
 * @author NPrilepa
 */
public class Cat extends Animal {
    public static String VOICE_CAT;

    static {
        VOICE_CAT = "meau";
    }
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
    public String getVoice() {
        return VOICE_CAT;
    }

    @Override
    public String getEat() {
        return "milk";
    }

}
