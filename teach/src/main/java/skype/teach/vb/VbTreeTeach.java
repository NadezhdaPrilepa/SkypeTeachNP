package skype.teach.vb;

/**
 * @author NPrilepa
 */
public class VbTreeTeach {
    public static void main(String[] args) {
        VbTreeNode node = new VbTreeNode(0);
        VbTreeNode left = new VbTreeNode(1);
        node.setLeft(left);

        VbTreeNode right = new VbTreeNode(2);
        node.setRight(right);

        VbTreeNode right1 = new VbTreeNode(3);
        left.setRight(right1);
        VbTreeNode left1 = new VbTreeNode(4);
        left.setLeft(left1);


//           0
//       1      2
//     4   3

    }

}

class VbTreeNode {
    private int element;
    private VbTreeNode left;
    private VbTreeNode right;

    public VbTreeNode(int element) {
        this.element = element;
    }


    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public VbTreeNode getLeft() {

        return left;
    }

    public void setLeft(VbTreeNode left) {
        this.left = left;
    }

    public VbTreeNode getRight() {
        return right;
    }

    public void setRight(VbTreeNode right) {
        this.right = right;
    }
}
