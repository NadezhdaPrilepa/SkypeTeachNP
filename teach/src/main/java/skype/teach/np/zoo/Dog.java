package skype.teach.np.zoo;

/**
 * @author NPrilepa
 */
public class Dog extends Wolf {
    public static String VOICE_DOG;

    static {
        VOICE_DOG = "gav";
    }
    @Override
    public boolean isPet() {
        return pet;
    }

    @Override
    public String getVoice() {
        return VOICE_DOG;
    }

    @Override
    public String getEat() {
        return "dog food";
    }

}
