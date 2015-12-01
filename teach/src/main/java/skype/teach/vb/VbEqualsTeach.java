package skype.teach.vb;

import javax.swing.text.html.HTML;

/**
 * @author NPrilepa
 */
public class VbEqualsTeach {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Emma", 25);
        Employee emp2 = new Employee("Emma", 25);
        Employee emp3 = new Employee("Emma", 30);
        Employee emp4 = emp1;

        System.out.println("emp1.equals(emp2): (expected true): " + emp1.equals(emp2));
        System.out.println("emp1.equals(emp3): " + emp1.equals(emp3));
        System.out.println("emp1.equals(emp1): " + emp1.equals(emp1));
        System.out.println("emp1.equals(emp4): " + emp1.equals(emp4));

        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println("str1==str2: " + str1 == str2);
        System.out.println("str1.equals(str2): " + str1.equals(str2));

    }
}

class Employee {
    private String name;
    private int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee emp = (Employee) obj;
        if (this.name.equals(emp.name) && this.age == emp.age) {
            return true;
        }
        return false;
    }
}
