package DoublyLinkedListImplementation;

public class DoublyLinkedList {
    Node first;
    Node last;
    int size;

    public class Node {
        int key;
        Node prev;
        Node next;

        public Node(int key) {
            this.key = key;
            this.prev = null;
            this.next = null;
        }
    }

    public void add(int key) {
        Node newNode = new Node(key);

        if (first == null) {
            first = newNode;
            first.prev = null;
            first.next = null;
            first = last;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public int delete(int index) {
        int pointer = 1;
        Node nextNode = first.next;

        if (index == 0) {
            int resultIndex = first.key;
            first.next = first;
            first.prev = null;
            return resultIndex;
        }

        while (pointer != index) {
            nextNode = nextNode.next;
            pointer++;
        }

        if (pointer == index) {
            int resultIndex = nextNode.key;
            nextNode.next.prev = nextNode.prev;
            nextNode.prev.next = nextNode.next;
            return resultIndex;
        }
        return 0;
    }

    public void reverse() {
        if (first == null)
            return;


    }
}
