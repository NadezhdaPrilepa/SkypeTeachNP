package skype.teach.np.zoo;

/**
 * @author NPrilepa
 */
public class Wolf extends Animal {
    boolean pet = false;


    @Override
    public boolean isPetAnimal() {
        return false;
    }
    @Override
    public String voice()
    {
        return "u-u-u";
    }
    @Override
    public String eat()
    {
        return "meat";
    }

}
