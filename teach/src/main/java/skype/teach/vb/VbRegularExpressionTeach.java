package skype.teach.vb;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author NPrilepa
 */
public class VbRegularExpressionTeach {
    public static void main(String[] args) {

        String pattern_fio = "(([A-Z])[a-z]+) (([A-Z])[a-z]+) (([A-Z])[a-z]+)";
        Pattern p = Pattern.compile(pattern_fio);
        Matcher m = p.matcher("Ivan Sergeevich Andreev, Fedor Vasilyevich Makarov");
        while (m.find()) {
            System.out.println("-------");
            System.out.println("m.groupCount(): " + m.groupCount());
            System.out.println("m.group(): " + m.group());
            for (int i = 1; i <= m.groupCount(); i++) {
                System.out.println("m.group(" + i + "): " + m.group(i));

            }
        }
        System.out.println("Ivan Ivanych Ivanov: " + p.matcher("Ivan Ivanych Ivanov").matches());

    }

    public static void main2(String[] args) {


        //Pattern p = Pattern.compile("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}");
        //Pattern p = Pattern.compile("\\d{1,3}(\\.\\d{1,3}){3}");
        Pattern p = Pattern.compile("^(?!\\.)((\\.|^)\\d{1,3}){4}");
        System.out.println("127.0.0.1: " + p.matcher("127.0.0.1").matches());
        System.out.println("127.0.a.1: " + p.matcher("127.0.a.1").matches());
        System.out.println("1278.0.0.1: " + p.matcher("1278.0.0.1").matches());
        System.out.println("127,0.0.1: " + p.matcher("127,0.0.1").matches());
        System.out.println("127.0.0.1.: " + p.matcher("127.0.0.1.").matches());
        System.out.println(".127.0.0.1: " + p.matcher(".127.0.0.1").matches());

        Pattern emailPattern = Pattern.compile("");
        Pattern userName = Pattern.compile("\\w+");
        System.out.println("userName_" + userName.matcher("userName_").matches());
        System.out.println("userName_@" + userName.matcher("userName_@").matches());
        System.out.println(" userName_" + userName.matcher(" userName_").matches());

    }

}
