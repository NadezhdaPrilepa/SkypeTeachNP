package skype.teach.np.regexp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author NPrilepa
 */
public class NpYandexLink {

    public List<String> getLinks(String path) throws IOException {
        List<String> links = new ArrayList<String>();
        String pattern_links = "<span class=\"serp-url__item\"><a class=\"link serp-url__link\" target=\"_blank\" href=\"(https?://[:a-z\\./-]+)";
        Pattern p = Pattern.compile(pattern_links);
        Matcher m = p.matcher(readHTML(path));

        while (m.find()) {
            for (int i = 1; i <= m.groupCount(); i++) {
                // System.out.println("m.group(" + i + ") :" + m.group(i));
                links.add(m.group(i));

            }
        }
        return links;
    }

    public String readHTML(String fileName) throws IOException {

        StringBuilder sb = new StringBuilder();
        exists(fileName);
        File file = new File(fileName);

        BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
        try {
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s);
                //sb.append("\n");
                sb.append(" ");
            }
        } finally {
            in.close();
        }
        return sb.toString();
    }

    private void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
    }

}
