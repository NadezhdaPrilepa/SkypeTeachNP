package skype.teach.np.zoo;

/**
 * @author NPrilepa
 */
public class Dog extends Wolf {
    public static final String VOICE_DOG = "gav";
    public static final String EAT_DOG = "dog food";

    public Dog(String name) {
        super(name,true, VOICE_DOG, EAT_DOG);
    }

    @Override
    public Dog sick() {
        if (!getVoice().equals(VOICE_DOG)) {
            return this;
        }
        return null;
    }


}
