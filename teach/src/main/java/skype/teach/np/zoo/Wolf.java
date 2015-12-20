package skype.teach.np.zoo;

/**
 * @author NPrilepa
 */
public class Wolf extends Animal {

    public static final String VOICE_WOLF = "u-u-u";
    public static final String EAT_WOLF = "meat";


    public Wolf(String name) {

        this(name, false, VOICE_WOLF, EAT_WOLF);
    }

    protected Wolf(String name, boolean pet, String voice, String eat) {
        super(name, pet, voice, eat);
    }

    @Override
    public Wolf sick() {
        if (!getVoice().equals(VOICE_WOLF)) {
            return this;
        }
        return null;
    }




}
