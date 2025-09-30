public class LinkedList {

    Node head; // missing declaration
    private int size;

    LinkedList(){
        this.size = 0;
    }

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // add at first
    public void addFirst(String data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // add at last
    public void addLast(String data) {
        Node newNode = new Node(data);
        size++;
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

    // print linked list
    public void print() {
        if(head == null){
            System.out.println("There are no elements in the linkedList");
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " ---> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    //delete first
    public void deleteFirst(){
        if(head == null){
            System.out.println("linked list is empty");
            return;
        }
        size--;
        head = head.next;
    }

    //delete last
    public void deleteLast(){
        if(head == null){
            System.out.println("linked list is empty");
            return;
        }
        size--;
        if(head.next == null){
            head = null;
            return;
        }
        Node secondLast = head;
        Node lastNode = head.next;
        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    public int getSize(){
        return size;
    }

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.addFirst("can");
        list.addFirst("harshit");
        list.addLast("do");
        list.addLast("anything");
        list.print();

        list.deleteFirst();
        list.print();

        list.deleteLast();
        list.print();

        System.out.println(list.getSize());
    }
}
