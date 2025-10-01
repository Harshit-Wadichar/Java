package datastructures;
public class ReverseLL {
  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
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

  // deleting the first node of linked list
  public void deleteFirst() {
    if (head == null) {
      System.out.println("The list is empty");
    }
    head = head.next;
  }

  // deleting the last node of linked list
  public void deleteLast() {
    if (head == null) {
      System.out.println("List is empty");
    }
    if (head.next == null) {
      head = null;
      return;
    }
    Node secondLast = head;
    Node lastNode = head.next;
    while (lastNode.next != null) {
      lastNode = lastNode.next;
      secondLast = secondLast.next;
    }
    secondLast.next = null;
  }

  // reversing the linked list using iteration
  public void reverseIterate() {
    Node prevNode = head;
    Node currNode = head.next;
    while (currNode != null) {
      Node nextNode = currNode.next;
      currNode.next = prevNode;
      // update
      prevNode = currNode;
      currNode = nextNode;
    }
    head.next = null;
    head = prevNode;
  }

  // reversing the linked list using recursion
  public Node reverseRecursive(Node head) {
    if (head == null || head.next == null) {
      return head;
    }
    Node newHead = reverseRecursive(head.next);
    head.next.next = head; // 1 2 3 4 null
    head.next = null;
    return newHead;
  }

  // printing the linked list
  public void printList() {
    if (head == null) {
      System.out.println("List is empty");
    }
    Node currNode = head;
    while (currNode != null) {
      System.out.print(currNode.data + " -> ");
      currNode = currNode.next;
    }
    System.out.println("null");
  }

  public static void main(String args[]) {
    ReverseLL list = new ReverseLL();
    list.addFirst(1);
    list.addLast(2);
    list.addLast(3);
    list.addFirst(5);
    list.printList();
    // list.reverseIterate();
    list.head = list.reverseRecursive(list.head);
    list.printList();
  }
}