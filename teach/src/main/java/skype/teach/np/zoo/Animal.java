package skype.teach.np.zoo;

/**
 * @author NPrilepa
 */
public class Animal {
    private boolean pet;
    private String voice;
    private String eat;


    public Animal() {

        this.pet = false;
    }

    public boolean isPet() {

        return pet;
    }

    public boolean isPet(boolean pet) {

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

    public void getEat(String eat) {
        this.eat = eat;
    }


}
