package skype.teach.np.zoo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author NPrilepa
 */
public class ZooTest {
    Zoo zooBerlin = new Zoo();

    Wolf wf = new Wolf();
    Dog dog = new Dog();
    Cat cat = new Cat();

    @Test
    public void addAnimalTest() {
        zooBerlin.addAnimal(cat);
        assertSame("zooBerlin.addAnimal()", 1, zooBerlin.getAnimalCount());
    }
    @Test
    public void removeAnimalTest() {
        zooBerlin.addAnimal(dog);
        zooBerlin.removeAnimal(dog);
        assertSame("zooBerlin.removeAnimal()", 0, zooBerlin.getAnimalCount());
        zooBerlin.removeAnimal(dog);
        assertSame("zooBerlin.removeAnimal()", 0, zooBerlin.getAnimalCount());
    }
    @Test
    public void removeAnimalCatTest() {
        zooBerlin.addAnimal(cat);
        zooBerlin.removeAnimal(cat);
        assertSame("zooBerlin.removeAnimal()", 1, zooBerlin.getAnimalCount());
        zooBerlin.removeAnimal((Animal) cat);
        assertSame("zooBerlin.removeAnimal()", 0, zooBerlin.getAnimalCount());

    }
    @Test
    public void isPetZooTest() {
        zooBerlin.addAnimal(cat);
        assertEquals("zooBerlin.isPetZoo()", true, zooBerlin.isPetZoo());
        zooBerlin.addAnimal(wf);
        assertEquals("zooBerlin.isPetZoo()", false, zooBerlin.isPetZoo());
        zooBerlin.addAnimal(dog);
        assertEquals("zooBerlin.isPetZoo()", false, zooBerlin.isPetZoo());
    }
    @Test
    public void zooVoiceTest() {
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
    public void zooEatTest() {
        zooBerlin.addAnimal(wf);
        zooBerlin.addAnimal(dog);
        zooBerlin.addAnimal(cat);
        assertEquals("zooBerlin.zooVoice()", "Zoo eat is: meat dog food milk", zooBerlin.zooEat());
        zooBerlin.removeAnimal((Animal)cat);
        assertEquals("zooBerlin.zooVoice()", "Zoo eat is: meat dog food", zooBerlin.zooEat());
        zooBerlin.removeAnimal(wf);
        assertEquals("zooBerlin.zooVoice()", "Zoo eat is: dog food", zooBerlin.zooEat());

    }
    @Test
    public void hasCatTest() {
        zooBerlin.addAnimal(wf);
        assertEquals("zooMoscow.getCat()", false, zooBerlin.hasCat());
        zooBerlin.addAnimal(cat);
        assertEquals("zooMoscow.getCat()", true, zooBerlin.hasCat());
        zooBerlin.removeAnimal(cat);
        assertEquals("zooMoscow.getCat()", true, zooBerlin.hasCat());
        zooBerlin.removeAnimal((Animal) cat);
        assertEquals("zooMoscow.getCat()", false, zooBerlin.hasCat());
    }
    @Test
      public void removeSickAnimalTest() {
        zooBerlin.addAnimal(wf);
        zooBerlin.addAnimal(dog);
        zooBerlin.addAnimal(cat);
        wf.setVoice("gav");
        zooBerlin.removeSickAnimal();
        assertSame("zooBerlin.removeSickAnimal()", 2, zooBerlin.getAnimalCount());
        cat.setVoice("gav");
        zooBerlin.removeSickAnimal();
        assertSame("zooBerlin.removeSickAnimal()", 1, zooBerlin.getAnimalCount());
    }
    @Test
    public void removeSickAnimalTest_() {
        zooBerlin.addAnimal(wf);
        zooBerlin.addAnimal(dog);
        zooBerlin.addAnimal(cat);
        zooBerlin.removeSickAnimal();
        assertSame("zooBerlin.removeSickAnimal()", 3, zooBerlin.getAnimalCount());
    }
    @Test
    public void closeZooTest() {
        zooBerlin.addAnimal(wf);
        zooBerlin.addAnimal(dog);
        zooBerlin.addAnimal(cat);
        zooBerlin.closeZoo();
        assertSame("zooBerlin.closeZoo()",0, zooBerlin.getAnimalCount());
    }

}
