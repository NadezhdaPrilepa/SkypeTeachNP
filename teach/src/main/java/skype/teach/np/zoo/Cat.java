package skype.teach.np.zoo;

/**
 * @author NPrilepa
 */
public class Cat extends Animal {
    public static final String  VOICE_CAT;
    public static final String EAT_CAT;

    static {
        VOICE_CAT = "meau";
        EAT_CAT = "milk";
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
        return EAT_CAT;
    }

}
