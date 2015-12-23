package skype.teach.np.zoo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author NPrilepa
 */
public class ZooTest {
    Zoo zooBerlin = new Zoo();

    Wolf wf = new Wolf("wolf");
    Dog dog = new Dog("dog");
    Cat cat = new Cat("cat");

    @Test
    public void addAnimal() {
        zooBerlin.addAnimal(cat);
        zooBerlin.addAnimal(null);
        assertEquals("zooBerlin.addAnimal()", "cat", zooBerlin.getAnimal());
    }

    @Test
    public void removeAnimal() {
        zooBerlin.addAnimal(dog);
        zooBerlin.removeAnimal(dog);
        assertEquals("zooBerlin.removeAnimal()", "", zooBerlin.getAnimal());
        zooBerlin.removeAnimal(dog);
        assertEquals("zooBerlin.removeAnimal()", "", zooBerlin.getAnimal());
        zooBerlin.removeAnimal(null);
        assertEquals("zooBerlin.removeAnimal()", "", zooBerlin.getAnimal());
    }

    @Test
    public void removeAnimalCat() {
        zooBerlin.addAnimal(cat);
        zooBerlin.removeAnimal(cat);
        assertEquals("zooBerlin.removeAnimal()", "cat", zooBerlin.getAnimal());
        zooBerlin.removeAnimal((Animal) cat);
        assertEquals("zooBerlin.removeAnimal()", "", zooBerlin.getAnimal());

    }

    @Test
    public void isPetZoo() {
        zooBerlin.addAnimal(cat);
        assertTrue("zooBerlin.isPetZoo()", zooBerlin.isPetZoo());
        zooBerlin.addAnimal(wf);
        assertFalse("zooBerlin.isPetZoo()", zooBerlin.isPetZoo());
        zooBerlin.addAnimal(dog);
        assertFalse("zooBerlin.isPetZoo()", zooBerlin.isPetZoo());
    }

    @Test
    public void zooVoice() {
        zooBerlin.addAnimal(wf);
        zooBerlin.addAnimal(dog);
        zooBerlin.addAnimal(cat);
        assertEquals("zooBerlin.zooVoice()", "Zoo voice is: 'u-u-u' 'gav' 'meau'", zooBerlin.zooVoice());
        zooBerlin.removeAnimal(wf);
        assertEquals("zooBerlin.zooVoice()", "Zoo voice is: 'gav' 'meau'", zooBerlin.zooVoice());
        zooBerlin.removeAnimal(dog);
        assertEquals("zooBerlin.zooVoice()", "Zoo voice is: 'meau'", zooBerlin.zooVoice());
    }

    @Test
    public void zooEat() {
        zooBerlin.addAnimal(wf);
        zooBerlin.addAnimal(dog);
        zooBerlin.addAnimal(cat);
        assertEquals("zooBerlin.zooVoice()", "Zoo eat is: meat dog food milk", zooBerlin.zooEat());
        zooBerlin.removeAnimal((Animal) cat);
        assertEquals("zooBerlin.zooVoice()", "Zoo eat is: meat dog food", zooBerlin.zooEat());
        zooBerlin.removeAnimal(wf);
        assertEquals("zooBerlin.zooVoice()", "Zoo eat is: dog food", zooBerlin.zooEat());

    }

    @Test
    public void hasCat() {
        zooBerlin.addAnimal(wf);
        assertFalse("zooMoscow.getCat()", zooBerlin.hasCat());
        zooBerlin.addAnimal(cat);
        assertTrue("zooMoscow.getCat()", zooBerlin.hasCat());
        zooBerlin.removeAnimal(cat);
        assertTrue("zooMoscow.getCat()", zooBerlin.hasCat());
        zooBerlin.removeAnimal((Animal) cat);
        assertFalse("zooMoscow.getCat()", zooBerlin.hasCat());
    }

    @Test
    public void removeSickAnimal() {
        zooBerlin.addAnimal(wf);
        zooBerlin.addAnimal(dog);
        zooBerlin.addAnimal(cat);
        wf.setVoice("gav");
        zooBerlin.removeSickAnimal();
        assertEquals("zooBerlin.removeSickAnimal()", "dog,cat", zooBerlin.getAnimal());
        cat.setVoice("gav");
        zooBerlin.removeSickAnimal();
        assertEquals("zooBerlin.removeSickAnimal()", "dog", zooBerlin.getAnimal());
        dog.setVoice("meau");
        zooBerlin.removeSickAnimal();
        assertEquals("zooBerlin.removeSickAnimal()", "", zooBerlin.getAnimal());
    }

    @Test
    public void removeSickAnimal_() {
        zooBerlin.addAnimal(wf);
        zooBerlin.addAnimal(dog);
        zooBerlin.addAnimal(cat);
        zooBerlin.removeSickAnimal();
        assertEquals("zooBerlin.removeSickAnimal()", "wolf,dog,cat", zooBerlin.getAnimal());
    }

    @Test
    public void closeZoo() {
        zooBerlin.addAnimal(wf);
        zooBerlin.addAnimal(dog);
        zooBerlin.addAnimal(cat);
        zooBerlin.closeZoo();
        assertEquals("zooBerlin.closeZoo()", "", zooBerlin.getAnimal());
    }

}
