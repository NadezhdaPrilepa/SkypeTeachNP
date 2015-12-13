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
    Cat cat_lynx = new Cat("lynx");

    @Test
    public void ZooTest() {

        zooBerlin.addAnimal(wf);
        zooBerlin.addAnimal(dog);
        zooBerlin.addAnimal(cat);

        assertEquals("zooBerlin.isPetZoo()", false, zooBerlin.isPetZoo());
        zooBerlin.removeAnimal(wf);
        zooBerlin.removeAnimal(dog);
        assertEquals("zooBerlin.isPetZoo()", true, zooBerlin.isPetZoo());
        assertEquals("zooBerlin.zooVoice()", "Zoo voice is: 'meau'", zooBerlin.zooVoice());
        assertEquals("zooBerlin.zooEat()", "Zoo eat is: milk", zooBerlin.zooEat());
        zooBerlin.closeZoo();
        zooMoscow.addAnimal(wf);
        zooMoscow.addAnimal(dog);
        zooMoscow.addAnimal(cat_lynx);

        assertEquals("zooMoscow.isPetZoo()", false, zooMoscow.isPetZoo());

        assertEquals("zooMoscow.zooVoice()", "Zoo voice is: 'u-u-u' 'gav' 'meau'", zooMoscow.zooVoice());
        assertEquals("zooMoscow.zooEat()", "Zoo eat is: meat dog food milk", zooMoscow.zooEat());
        zooMoscow.removeAnimal(wf);
        assertEquals("zooMoscow.isPetZoo()", false, zooMoscow.isPetZoo());
        zooMoscow.closeZoo();
    }


}
