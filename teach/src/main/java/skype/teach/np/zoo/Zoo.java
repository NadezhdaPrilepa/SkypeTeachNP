package skype.teach.np.zoo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author NPrilepa
 */
public class Zoo {
    private Collection zoo = new CopyOnWriteArrayList();

    public void addAnimal(Animal animal) {
        this.zoo.add(animal);
    }

    public void removeAnimal(Animal animal) {
        this.zoo.remove(animal);
    }

    public void removeAnimal(Cat animal) {
        //do nothing
    }

    public boolean getCat() {
        Iterator i = this.zoo.iterator();
        while (i.hasNext()) {
            Animal animal = (Animal) i.next();
            if (animal instanceof Cat) {
                return true;
            }
        }
        return false;
    }

    public void removeSickAnimal() {
        Iterator i = this.zoo.iterator();
        while (i.hasNext()) {
            Animal animal = (Animal) i.next();
            if (animal.sick() != null) {
                removeAnimal(animal.sick());
            }
        }
    }


    public void closeZoo()

    {
        this.zoo.clear();
    }

    public boolean isPetZoo() {
        Iterator i = zoo.iterator();
        while (i.hasNext()) {
            Animal animal = (Animal) i.next();
            if (!animal.isPet()) {
                return false;
            }
        }
        return true;
    }


    public String zooVoice() {
        String result = "Zoo voice is:";
        Iterator i = zoo.iterator();
        while (i.hasNext()) {
            Animal animal = (Animal) i.next();

            result = result.concat(" '" + animal.getVoice() + "'");
        }
        return result;
    }

    public String zooEat() {
        String result = "Zoo eat is:";
        Iterator i = zoo.iterator();
        while (i.hasNext()) {
            Animal animal = (Animal) i.next();
            result = result.concat(" " + animal.getEat());
        }
        return result;
    }
}
