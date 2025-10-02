// Problem 3 - Checking presence of cycle(loop) in a Linked List
public class LLProblem3 {
    public class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head;

    // adding node at first position
    public void addFirst(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // adding node at last position
    public void addLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    // Checking if the linked list has cycle (loop) or not
    public boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }
        Node hare = head; // fast(takes 2 steps)
        Node turtle = head; // slow(takes 1 step)

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
            // if both are at same node then the cycle exists
            if (hare == turtle) {
                return true;
            }
        }
        return false;
    }

    // printing the linked list
    public void printList() {
        if (head == null) {
            System.out.println("The List is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.val + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]) {
        LLProblem3 list = new LLProblem3();
        list.addFirst(1);
        list.addLast(2);
        list.addFirst(0);
        list.addLast(3);
        list.addLast(4);
        list.addFirst(5);
        list.printList();
        System.out.println(list.hasCycle(list.head));

        Node currNode = list.head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = list.head; // connecting the last node with the head node to form a cycle
        System.out.println(list.hasCycle(list.head));
    }
}