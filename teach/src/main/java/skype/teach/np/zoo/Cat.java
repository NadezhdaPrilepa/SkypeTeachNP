package skype.teach.np.zoo;

/**
 * @author NPrilepa
 */
public class Cat extends Animal {
    public static final String VOICE_CAT = "meau";
    public static final String EAT_CAT = "milk";

    public Cat(String name) {
        super(name, true, VOICE_CAT, EAT_CAT);
    }

    @Override
    public Cat sick() {
        if (!getVoice().equals(VOICE_CAT)) {
            return this;
        }
        return null;
    }


}
