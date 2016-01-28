package skype.teach.vb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author NPrilepa
 */
public class VbArrayCopyTeach {
    public static void main(String[] args) {
        List<String> list1 =new ArrayList<String>();
        String[] array = new String[100];

        array[0] = "str";
        array[1] = "str1";
        Object obj = array;
        //String str = array;
        List<String> list = Arrays.asList(array);
        String[] array2 = Arrays.copyOf(array, 200);
        String[] array3 = new String[200];
        for (int i = 0; i < array.length; i++) {
            array3[i] = array[i];
        }

        System.arraycopy(list, 5, array3, 100, 20);
    }
}
