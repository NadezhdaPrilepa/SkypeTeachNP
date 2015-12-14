package skype.teach.np.zoo;

/**
 * @author NPrilepa
 */
public class Wolf extends Animal {

    public static String VOICE_WOLF;

    static {
        VOICE_WOLF = "u-u-u";
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
        return "meat";
    }

}
