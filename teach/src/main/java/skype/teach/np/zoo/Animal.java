package skype.teach.np.zoo;

/**
 * @author NPrilepa
 */
public class Animal {
    boolean pet;
    String voice;
    String eat;

    public Animal() {

    }

    public Animal(boolean pet, String voice, String eat) {
        this.voice = voice;
        this.eat = eat;
        this.pet = pet;
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


    public Animal sick() {
        return this;
    }


}
