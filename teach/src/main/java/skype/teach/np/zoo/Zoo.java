package skype.teach.np.zoo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author NPrilepa
 */
public class Zoo {
    private Collection zoo = new ArrayList();

    public void addAnimal(Animal animal) {
        this.zoo.add(animal);
    }

    public void removeAnimal(Animal animal) {
        this.zoo.remove(animal);
    }

    public void closeZoo()

    {
        this.zoo.clear();
    }

    public boolean isPetZoo() {
        Iterator i = zoo.iterator();
        do {
            if (!i.hasNext()) {
                break;
            }
            Animal animal = (Animal) i.next();
            if (!animal.isPet()) {
                return false;
            }
        } while (true);
        return true;
    }


    public String zooVoice() {
        String result = "Zoo voice is:";
        Iterator i = zoo.iterator();
        do {
            if (!i.hasNext())
                break;
            Animal animal = (Animal) i.next();

            result = result.concat(" '" + animal.getVoice() + "'");
        } while (true);
        return result;
    }

    public String zooEat() {
        String result = "Zoo eat is:";
        Iterator i = zoo.iterator();
        do {
            if (!i.hasNext())
                break;
            Animal animal = (Animal) i.next();
            result = result.concat(" " + animal.getEat());
        } while (true);
        return result;
    }
}
