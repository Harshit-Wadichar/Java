//Problem 1 - remove nth node from last node

package datastructures;
public class LLProblem1 {

    private int size;

    LLProblem1() {
        this.size = 0;
    }

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            size += 1;
        }
    }

    Node head;

    // adding node at first position
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // adding node at last position
    public void addLast(int data) {
        Node newNode = new Node(data);
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

    // remove nth node from last node
    public Node removeNthNodeFromEnd(Node head, int n) {
        // if n = 1 (only one node in linked list)
        if (head.next == null) {
            return null;
        }
        // size of linked list
        int size = 0;
        Node currNode = head;
        while (currNode != null) {
            currNode = currNode.next;
            size++;
        }

        // if n = size of linked list (if we need to delete the head node)
        if (n == size) {
            head = head.next;
            return head;
        }

        // getting the previous node of node to be deleted as we have to find the node
        // to be deleted by iterating from the head node
        int indexToSearch = size - n;
        Node prevNode = head;
        int i = 1;
        while (i < indexToSearch) {
            prevNode = prevNode.next; // getting previous node of node to be deleted
            i++;
        }
        prevNode.next = prevNode.next.next; // removing the node to be deleted
        return head;
    }

    // print the linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]) {
        LLProblem1 list = new LLProblem1();
        list.addFirst(1);
        list.addLast(2);
        list.addFirst(0);
        list.addLast(3);
        list.printList();
        list.head = list.removeNthNodeFromEnd(list.head, 2); // (head, position of node to be deleted from last node)
        list.printList();
    }
}