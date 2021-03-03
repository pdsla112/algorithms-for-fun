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
//            System.out.println(root.key + " with the left branch being: " + root.left + ", and the right branch being: " + root.right);
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

        Node nodeToDelete = getNodeToDelete(key, root);
        System.out.println("This is the node to delete: " + nodeToDelete.key);
        if (nodeToDelete.right == null && nodeToDelete.left == null) {  //If the nodeToDelete is a leaf.
            nodeToDelete = null;
//            System.out.println("This is the key of the deleted node: " + nodeToDelete.key);
            return;
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
     * @param startingRoot
     * @return
     */
    public Node getNodeToDelete(int deleteKey, Node startingRoot) {
        int i = 0;
        if (startingRoot.key == deleteKey) {
//            System.out.println(root.key);
            i++;
            System.out.println("Step " + i + ". This is what is FINALLY returned from the getNodeToDelete() method: " + startingRoot.key);
            return startingRoot;
        }

        if (deleteKey < startingRoot.key) {
            i++;
            System.out.println("Step " + i + ". This is what is returned from the getNodeToDelete() method: " + startingRoot.key);
            getNodeToDelete(deleteKey, startingRoot.left);
        } else if (deleteKey > startingRoot.key) {
            i++;
            System.out.println("Step " + i + ". This is what is returned from the getNodeToDelete() method: " + startingRoot.key);
            getNodeToDelete(deleteKey, startingRoot.right);
        }
        i++;
        System.out.println("Step " + i + ". This is what is returned from the getNodeToDelete() method: " + startingRoot.key);
        return startingRoot;
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
