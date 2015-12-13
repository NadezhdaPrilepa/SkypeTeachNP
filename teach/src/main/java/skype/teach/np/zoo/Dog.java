package skype.teach.np.zoo;

/**
 * @author NPrilepa
 */
public class Dog extends Wolf {
    private boolean pet = true;

    @Override
    public boolean isPet() {
        return pet;
    }

    @Override
    public String voice() {
        return "gav";
    }

    @Override
    public String eat() {
        return "dog food";
    }

}
