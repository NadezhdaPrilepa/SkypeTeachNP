package skype.teach.np.zoo;

/**
 * @author NPrilepa
 */
public class Dog extends Wolf {
    public static final String VOICE_DOG;
    public static final String EAT_DOG;

    static {
        VOICE_DOG = "gav";
        EAT_DOG = "dog food";
    }
    @Override
    public boolean isPet() {
        return true;
    }

    @Override
    public String getVoice() {
        return VOICE_DOG;
    }

    @Override
    public String getEat() {
        return EAT_DOG;
    }

}
