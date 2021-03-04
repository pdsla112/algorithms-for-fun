package BinarySearchTreeImplementation;

import java.util.ArrayList;
import java.util.List;

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
            if (root.left != null && root.right == null) {
                System.out.println(root.key + " with the left branch being: " + root.left.key + ", and the right branch being: " + null);
            } else if (root.left == null && root.right != null) {
                System.out.println(root.key + " with the left branch being: " + null + ", and the right branch being: " + root.right.key);
            } else if (root.left != null && root.right != null) {
                System.out.println(root.key + " with the left branch being: " + root.left.key + ", and the right branch being: " + root.right.key);
            } else {
                System.out.println(root.key + " with the left branch being: " + null + ", and the right branch being: " + null);
            }
        } else if (key > root.key) {
            root.right = addRecursively(key, root.right);
            if (root.left != null && root.right == null) {
                System.out.println(root.key + " with the left branch being: " + root.left.key + ", and the right branch being: " + null);
            } else if (root.left == null && root.right != null) {
                System.out.println(root.key + " with the left branch being: " + null + ", and the right branch being: " + root.right.key);
            } else if (root.left != null && root.right != null) {
                System.out.println(root.key + " with the left branch being: " + root.left.key + ", and the right branch being: " + root.right.key);
            } else {
                System.out.println(root.key + " with the left branch being: " + null + ", and the right branch being: " + null);
            }
        }
        System.out.println("This is the root: " + root.key);
        return root;
    }

    /**
     * Deletes the relevant node (according to the key inputted by the user), using two helper functions:
     * getNodeToDelete(int deleteKey, Node root) and getMinRight(Node nodeToDelete).
     * @param key
     */
    public void delete(int key) {
        if (root.left == null && root.right == null) {
            if (root.key == key) {
                root = null;
                System.out.println("It reached the first if-statement of the delete() method.");
            }
        }
        List<List> nodeData = getNodeToDelete(key, root, root, null);
        List<Node> nodes = nodeData.get(0);
        Node nodeToDelete = nodes.get(0);
        Node parentNode = nodes.get(1);
        List<String> directionData = nodeData.get(1);
        String direction = directionData.get(0);
        System.out.println("This is the node to delete: " + nodeToDelete.key);
        if (nodeToDelete.right == null && nodeToDelete.left == null) {  //If the nodeToDelete is a leaf.
            if (direction == "left") {
                parentNode.left = null;
            } else {
                parentNode.right = null;
            }
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


    /**
     * Assumption: the key does exist in the tree.
     * Returns the node that the user wants to delete, based on the key that the user inputs.
     * @param deleteKey
     * @param startingRoot
     * @return
     */
    public List<List> getNodeToDelete(int deleteKey, Node startingRoot, Node parentNode, String directionFlag) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(startingRoot);
        nodes.add(parentNode);

        List<List> nodeData = new ArrayList<>();
        nodeData.add(nodes);
        List<String> direction = new ArrayList<>();
        direction.add(directionFlag);

        nodeData.add(direction);

        if (startingRoot == null) {
            return null;
        }

        if (startingRoot.key == deleteKey) {
            System.out.println("This is node that is FINALLY RETURNED " + startingRoot.key);
            return nodeData;
        }

        if (deleteKey < startingRoot.key) {
            System.out.println("This is node that is returned " + startingRoot.key);
            return getNodeToDelete(deleteKey, startingRoot.left, startingRoot, "left");
        }

        System.out.println("This is node that is returned " + startingRoot.key);
        return getNodeToDelete(deleteKey, startingRoot.right, startingRoot, "right");
    }

    public int getMin() {
        if (root == null) {
            return 0;
        }
        Node minNode = root;
        if (minNode.left == null) {
            return minNode.key;
        }

        while (minNode.left != null) {
            minNode = minNode.left;
        }
        return minNode.key;
    }

    public int getMax() {
        if (root == null) {
            return 0;
        }
        Node maxNode = root;
        if (maxNode.right == null) {
            return maxNode.key;
        }

        while (maxNode.right != null) {
            maxNode = maxNode.right;
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
