import java.util.Queue;
import java.util.LinkedList;

public class Queue1 {
    public static void main(String args[]) {
        //Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
/*
🔹 1. Queue<Integer> q = new LinkedList<Integer>();

Backed by a doubly linked list.

Each element is stored in a node containing references to next & previous.

Operations:

add() → O(1)

remove() → O(1)

peek() → O(1)

Features:

Can also be used as a List (because LinkedList implements both Queue and List).

Allows null elements.

Extra memory overhead (each node stores pointers).

Good when you need frequent insertions/removals in the middle (but not common in queues).

🔹 2. Queue<Integer> q = new ArrayDeque<>();

Backed by a resizable array (like ArrayList but used as a deque).

Uses a circular buffer internally.

Operations:

add() → Amortized O(1)

remove() → O(1)

peek() → O(1)

Features:

Faster than LinkedList for queue operations (better cache locality, no node overhead).

Does not allow null elements (will throw NullPointerException).

Cannot be used as a List (only as Queue or Deque).
🔹 Which one to use?

If you just need a Queue/Deque → ArrayDeque is usually faster & preferred.

If you also need List-like operations (random access, iteration, insertion at arbitrary positions) → use LinkedList.
 */