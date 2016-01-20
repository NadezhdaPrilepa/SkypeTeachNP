package skype.teach.vb;

import javafx.print.Collation;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author NPrilepa
 */
public class VbComparatorTeach {

    public static void main(String[] args) {
        VbMoney money1 = new VbMoney(100, 1900);
        VbMoney money2 = new VbMoney(50, 2000);
        VbMoney money3 = new VbMoney(75, 2100);
        List<VbMoney> moneylist = Arrays.asList(money1, money2, money3);
        System.out.println("moneylist(before sorting): " + moneylist);
        Collections.sort(moneylist, new Comparator<VbMoney>() {
            public int compare(VbMoney m1, VbMoney m2) {
                return m1.value - m2.value;
            }
        });
        System.out.println("moneylist(sorting by value): " + moneylist);
        Collections.sort(moneylist, new Comparator<VbMoney>() {
            public int compare(VbMoney m1, VbMoney m2) {
                return m1.year - m2.year;
            }
        });
        System.out.println("moneylist(sorting by year): " + moneylist);
        Collections.sort(moneylist, new MoneyComparatorByValue());
        System.out.println("moneylist(sorting by value): " + moneylist);

    }

    private static class VbMoney {
        private int value;
        private int year;

        public VbMoney(int value, int year) {
            this.value = value;
            this.year = year;
        }

        @Override
        public String toString() {
            return value + "-" + year;
        }
    }
  static class MoneyComparatorByValue implements Comparator<VbMoney>
   {
       public int compare(VbMoney m1, VbMoney m2) {
           return m1.value - m2.value;
       }
   }

}





