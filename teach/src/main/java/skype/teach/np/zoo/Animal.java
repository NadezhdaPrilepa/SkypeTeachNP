package skype.teach.np.zoo;

/**
 * @author NPrilepa
 */
public abstract class Animal {
    private boolean pet;
    private String voice;
    private String eat;
    private String name;

    protected Animal(String name, boolean pet, String voice, String eat) {
        this.voice = voice;
        this.eat = eat;
        this.pet = pet;
        this.name = name;
    }

    public boolean isPet() {

        return pet;
    }

    public String getVoice() {

        return voice;
    }

    public String getEat() {
        return eat;
    }

    public void setVoice(String voice) {

        this.voice = voice;
    }

    public abstract Animal sick();

    public String getName() {
        return name;
    }

}
