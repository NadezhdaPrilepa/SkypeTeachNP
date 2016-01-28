package skype.teach.np.regexp;

import java.util.regex.Pattern;

/**
 * Pattern of URL expression
 *
 * @author NPrilepa
 */
public class NpRegExpURL {
    /**
     * Checks input expression for correctness of the URL
     * URL must begin from http or https, next chars "://",
     * then expression must be divided by "/"
     * example:
     * http://site.ru/page
     * https://site.ru/page
     * http://site1.site.ru/page
     * http://site1.site.ru/page/page1
     *
     * @param expr input expression
     * @return if expr matches to patter of URL
     */
    public boolean isValid(String expr) {
        String PROTOCOL = "https?";
        String DOMAIN = "([a-z0-9-]{1,128}\\.)+[a-z]{2,3}";
        String PATH = "(/(?!/)[a-z0-9-.,:_@%&?+=~/]*)*";
        String QUERY = "(&[a-z]=[a-z]+])*";
        String URL = "^"+PROTOCOL+"://"+DOMAIN+PATH+QUERY;
//        Pattern p = Pattern.compile("^https?://([a-z0-9-]{1,128}\\.)+[a-z]{2,3}(/(?!/)[a-z0-9-.,:_@%&?+=~/]*)*");
        Pattern p = Pattern.compile(URL);
        return p.matcher(expr).matches();
    }

}
