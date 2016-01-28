package skype.teach.np.regexp;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;
/**
 * @author NPrilepa
 */
public class NpYandexLinkTest {

    @Test
    public void getLinksTest() throws IOException {
        NpYandexLink yLinks = new NpYandexLink();
        List<String> linksList = yLinks.getLinks("D://GitHub/SkypeTeachNP/teach/src/main/resources/htmlPage.html");
        assertEquals("linksList.size() equal 10",10,linksList.size());
        NpRegExpURL regExp = new NpRegExpURL();
        for (int i = 1; i < linksList.size(); i++) {
            assertTrue("linksList.get("+i+") is valid URL", regExp.isValid(linksList.get(i)));
            System.out.println("linksList.get("+i+"): "+linksList.get(i));
        }

    }

    @Test (expected = FileNotFoundException.class)
    public void getLinksTestEmptyPass() throws IOException {
        NpYandexLink yLinks = new NpYandexLink();
        List<String> linksList = yLinks.getLinks("");
    }

}
