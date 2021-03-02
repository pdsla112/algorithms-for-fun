package BinarySearchTreeImplementation;

public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    public void add(int key) {
        root = addRecursively(key, root);
    }

    public Node addRecursively(int key, Node root) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = addRecursively(key, root.left);
        } else if (key > root.key) {
            root.right = addRecursively(key, root.right);
        }
        return root;
    }

//    public void delete(int key) {
//
//    }
//
//    public int minValue() {
//        return 0;
//    }
//
//    public int maxValue() {
//        return 0;
//    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(7);
        bst.add(17);
        bst.add(90);
        bst.add(101);
        bst.add(2);
        bst.add(3);
        bst.add(1);
        bst.add(-7);
        bst.add(77);
        System.out.println(bst);
    }
}
