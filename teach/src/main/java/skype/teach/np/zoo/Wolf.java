package skype.teach.np.zoo;

/**
 * @author NPrilepa
 */
public class Wolf extends Animal {

    public static final String VOICE_WOLF;
    public static final String EAT_WOLF;

    static {
        VOICE_WOLF = "u-u-u";
        EAT_WOLF = "meat";
    }


    @Override
    public boolean isPet() {
        return false;
    }

    @Override
    public String getVoice() {
        return VOICE_WOLF;
    }

    @Override
    public String getEat() {
        return EAT_WOLF;
    }

}
