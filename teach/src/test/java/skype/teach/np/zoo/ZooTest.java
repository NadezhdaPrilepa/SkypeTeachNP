package skype.teach.np.zoo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author NPrilepa
 */
public class ZooTest {
    Zoo zooBerlin = new Zoo();
    Zoo zooMoscow = new Zoo();
    Wolf wf = new Wolf();
    Dog dog = new Dog();
    Cat cat = new Cat();


    @Test
    public void ZooTest() {

        zooBerlin.addAnimal(wf);
        zooBerlin.addAnimal(dog);
        zooBerlin.addAnimal(cat);

        assertEquals("zooBerlin.isPetZoo()", false, zooBerlin.isPetZoo());
        zooBerlin.removeAnimal(wf);
        zooBerlin.removeAnimal(dog);
        assertEquals("zooBerlin.isPetZoo()", true, zooBerlin.isPetZoo());
        cat.setVoice("gav");
        assertEquals("zooBerlin.zooVoice()", "Zoo voice is: 'gav'", zooBerlin.zooVoice());
        assertEquals("zooBerlin.zooEat()", "Zoo eat is: milk", zooBerlin.zooEat());
        zooBerlin.closeZoo();

        zooMoscow.addAnimal(wf);
        zooMoscow.addAnimal(dog);
        zooMoscow.addAnimal(cat);

        assertEquals("zooMoscow.isPetZoo()", false, zooMoscow.isPetZoo());
        assertEquals("zooMoscow.zooVoice()", "Zoo voice is: 'u-u-u' 'gav' 'gav'", zooMoscow.zooVoice());
        assertEquals("zooMoscow.zooEat()", "Zoo eat is: meat dog food milk", zooMoscow.zooEat());
        zooMoscow.removeAnimal(cat);
        assertEquals("zooMoscow.getCat()", true, zooMoscow.getCat());
        zooMoscow.removeSickAnimal();
        assertEquals("zooMoscow.getCat()", false, zooMoscow.getCat());
        assertEquals("zooMoscow.zooEat()", "Zoo eat is: meat dog food", zooMoscow.zooEat());
        wf.setVoice("gav");
        zooMoscow.removeSickAnimal();
        assertEquals("zooMoscow.isPetZoo()", true, zooMoscow.isPetZoo());
        dog.setVoice("meau");
        zooMoscow.addAnimal(cat);
        cat.setVoice("meau");
        zooMoscow.removeSickAnimal();
        zooMoscow.closeZoo();
    }


}
