public class LLProblem2 {
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
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    // finding the middle node of linked list using hare-turtle approach
    public Node findMiddle(Node head) {
        Node turtle = head;
        Node hare = head;

        while (hare.next != null && hare.next.next != null) {
            turtle = turtle.next; // goes to each node
            hare = hare.next.next; // goes to next node's next node
        }
        return turtle; // middle of LL or end of first half of Linked List
    }

    // Reversing the second half of linked list
    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; // new head of second half of linked list
    }

    // Checking the linked list is palindrome or not
    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node middle = findMiddle(head); // 1st half end node
        Node secondHalfStart = reverse(middle.next);

        Node firstHalfStart = head;
        while (secondHalfStart != null) {
            // checking both the half linked list nodes
            if (firstHalfStart.val != secondHalfStart.val) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }

    // printing the linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
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
        LLProblem2 list = new LLProblem2();
        list.addFirst(8);
        list.addLast(2);
        list.addLast(1);
        list.addFirst(1);
        list.printList();
        // checking the linked list is palidrome or not
        System.out.println(list.isPalindrome(list.head) == true ? "List is Palindrome" : "List is not Palindrome");
    }
}