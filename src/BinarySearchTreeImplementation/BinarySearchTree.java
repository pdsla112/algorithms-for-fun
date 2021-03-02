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

    /**
     * Deletes the relevant node (according to the key inputted by the user), using two helper functions:
     * getNodeToDelete(int deleteKey, Node root) and getMinRight(Node nodeToDelete).
     * @param key
     */
    public void delete(int key) {
        if (root.left == null && root.right == null) {
            if (root.key == key)
                root = null;
        }

        Node nodeToDelete = getNodeToDelete(key, root);
        if (nodeToDelete.right == null && nodeToDelete.left == null) {  //If the nodeToDelete is a leaf.
            nodeToDelete = null;
        } else if (nodeToDelete.right == null) {  //If the nodeToDelete has an empty right tree.
            Node immediateLeftNode = nodeToDelete.left;
            nodeToDelete.key = immediateLeftNode.key;
            nodeToDelete.left = immediateLeftNode.left;
            nodeToDelete.right = immediateLeftNode.right;
        } else if (nodeToDelete.right != null) {  //If the nodeToDelete has a non-empty right tree
            if (nodeToDelete.right.left == null) {  //If the left branch of the right branch of nodeToDelete is empty.
                nodeToDelete.key = nodeToDelete.right.key;
                nodeToDelete.right = nodeToDelete.right.right;
            } else {
                Node replacementNode = getMinRight(nodeToDelete);
                nodeToDelete.key = replacementNode.key;
            }
        }
    }

    /**
     * Returns the replacement node, and manages the branch locally in that area of the tree.
     * @param nodeToDelete
     * @return
     */
    public Node getMinRight(Node nodeToDelete) {
        if (nodeToDelete.left == null) {
            if (nodeToDelete.right == null) {
                Node result = nodeToDelete;
                nodeToDelete = null;
                return result;
            } else {
                Node result = nodeToDelete;
                nodeToDelete.key = nodeToDelete.right.key;
                nodeToDelete.right = nodeToDelete.right.right;
                return result;
            }
        } else {
            getMinRight(nodeToDelete.left);
        }
        return nodeToDelete;
    }

//    public int getMinImmediateRight(Node node) {
//        Node immediateRightNode = node.right;
//        if (immediateRightNode.left == null) {
//            Node rightSubTree = immediateRightNode.right;
//            node.key = immediateRightNode.key;
//            node.right = rightSubTree;
//            return node.key;
//        }
//    }

    /**
     * Assumption: the key does exist in the tree.
     * Returns the node that the user wants to delete, based on the key that the user inputs.
     * @param deleteKey
     * @param root
     * @return
     */
    public Node getNodeToDelete(int deleteKey, Node root) {
        if (root.key == deleteKey) {
            return root;
        }

        if (deleteKey < root.key) {
            getNodeToDelete(deleteKey, root.left);
        } else if (deleteKey > root.key) {
            getNodeToDelete(deleteKey, root.right);
        }
        return root;
    }

    public int getMin() {
        Node minNode = root;
        if (root.left == null) {
            return minNode.key;
        }

        while (root.left != null) {
            minNode = root.left;
        }
        return minNode.key;
    }

    public int getMax() {
        Node maxNode = root;
        if (root.right == null) {
            return maxNode.key;
        }

        while (root.right != null) {
            maxNode = root.right;
        }
        return maxNode.key;
    }

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
