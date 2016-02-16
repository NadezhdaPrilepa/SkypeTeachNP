package skype.teach.vb;

import java.util.LinkedList;
import java.util.List;

/**
 * @author NPrilepa
 */
public class VbLinkedTeach {
    public static void main(String[] args) {

        String str1 = "1";
        String str2 = "2";
        String str3 = "3";
        VbNode firstNode;
        VbNode node1 = new VbNode(str1);
        VbNode node2 = new VbNode(str2);
        VbNode node3 = new VbNode(str3);

        node1.setNext(node2);
        node2.setNext(node3);
        VbNode currentNode = node1;
        firstNode = node1;
        print(firstNode);
        VbNode node4 = new VbNode("4");
        node4.setNext(node2.getNext());
        node2.setNext(node4);
        firstNode = node1;
        print(node1);
        VbNode node5 = new VbNode("5");
        node5.setNext(node1);
        firstNode = node1;
        print(firstNode);
        node4.setNext(null);
        firstNode = node1;
        print(firstNode);
        node1.setNext(node4);
        firstNode = node1;
        print(firstNode);
List list = new LinkedList();
        list.iterator();

    }

    private static void print(VbNode currentNode) {
        System.out.println("----------");
        while (currentNode != null) {
            System.out.println("currentNode.getValue(): " + currentNode.getValue());
            currentNode = currentNode.getNext();
        }
    }
}

class VbNode {
    private String value;
    private VbNode next;
    private VbNode prev;

    public VbNode getPrev() {
        return prev;
    }

    public void setPrev(VbNode prev) {
        this.prev = prev;
    }

    public void setNext(VbNode next) {
        this.next = next;
    }

    public VbNode getNext() {

        return next;
    }

    public VbNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
