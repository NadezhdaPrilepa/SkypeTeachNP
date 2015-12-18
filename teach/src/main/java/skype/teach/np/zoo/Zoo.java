package skype.teach.np.zoo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**class working with animal collection
 * @author NPrilepa
 */
public class Zoo {
    private Collection zoo = new CopyOnWriteArrayList();

    /**
     * @return int count of animal collection
     */
    public int getAnimalCount() {

        return this.zoo.size();
    }

    /**
     * add animal to animal collection
     * @param animal
     */
    public void addAnimal(Animal animal) {
        this.zoo.add(animal);
    }

    /**
     * remove animal from animal collection
     * @param animal
     */
    public void removeAnimal(Animal animal) {
        this.zoo.remove(animal);
    }

    /**
     * overload method removeAnimal(Animal animal)
     * if animal = Cat - nothing to do
     * @param animal
     */
    public void removeAnimal(Cat animal) {
        //do nothing
    }

    /**
     * Check if collection of animals contains cat
     * @return true if cat exists in collection
     */
    public boolean hasCat() {
        Iterator i = this.zoo.iterator();
        while (i.hasNext()) {
            Animal animal = (Animal) i.next();
            if (animal instanceof Cat) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove from animal collection sick animal.
     * Animal is sick if its voice is not correct, else
     * sick() return null and animal stay in animal collection
     */
    public void removeSickAnimal() {
        Iterator i = this.zoo.iterator();
        while (i.hasNext()) {
            Animal animal = (Animal) i.next();
            if (animal.sick() != null) {
                removeAnimal(animal.sick());
            }
        }
    }

    /**
     * Clear all animals from collection
     */
    public void closeZoo()

    {
        this.zoo.clear();
    }

    /**
     * Check, if all animals of animal collection is Pet, return true
     * @return
     */
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

    /**
     * concat to String voices of all members animal collection
     * @return String like "Zoo voice is: 'gav' 'meau'", if there is no members in collection return "Zoo voice is:"
     */
    public String zooVoice() {
        String result = "Zoo voice is:";
        Iterator i = zoo.iterator();
        while (i.hasNext()) {
            Animal animal = (Animal) i.next();

            result = result.concat(" '" + animal.getVoice() + "'");
        }
        return result;
    }

    /**
     * concat to String eat of all members animal collection
     * @return String like "Zoo eat is: meat milk", if there is no members in collection return "Zoo eat is:"
     */
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
