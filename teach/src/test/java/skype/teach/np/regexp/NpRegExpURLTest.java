package skype.teach.np.regexp;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author NPrilepa
 */
public class NpRegExpURLTest {
    @Test
    public void isValid()
    {
        NpRegExpURL regExp = new NpRegExpURL();
        assertTrue("http://site1.site.ru/page/page1", regExp.isValid("http://site1.site.ru/page/page1"));
        assertFalse(" http://site1.site.ru/page/page1", regExp.isValid(" http://site1.site.ru/page/page1"));
        assertTrue("https://site1.site.ru/page/page1", regExp.isValid("https://site1.site.ru/page/page1"));
        assertTrue("https://site1.site.ru/page/page1/", regExp.isValid("https://site1.site.ru/page/page1/"));
        assertTrue("https://site1.site.net/page/page~/", regExp.isValid("https://site1.site.net/page/page=a/"));
        assertTrue("https://site1.ru/", regExp.isValid("https://site1.ru/"));
        assertTrue("https://site1.ru", regExp.isValid("https://site1.ru"));
        assertTrue("https://site1.ru/a/::", regExp.isValid("https://site1.ru/::"));
        assertTrue("https://site1.ru/?a=1&b=2&q=http://site.ru", regExp.isValid("https://site1.ru/?a=1&b=2&q=http://site.ru"));
        assertFalse("https://site1.ru//", regExp.isValid("https://site1.ru//"));
        assertFalse("https://Site1.ru/page", regExp.isValid("https://Site1.ru/page"));
    }

}
