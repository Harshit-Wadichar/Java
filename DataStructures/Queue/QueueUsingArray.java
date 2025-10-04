public class QueueUsingArray {
    static class Queue{
    static int array[];
    static int size;
    static int rear = -1;

    Queue(int n){
        array = new int[n];
        this.size = n;
    }

    public static boolean isEmpty(){
        return rear == -1;
    }

    //Enqueue method to add data to queue
    public static void add(int data){
        if(rear == size-1){
            System.out.println("Queue is full");
            return;
        }
        rear++;
        array[rear] = data;
    }

    //dequeue to remove elements from the queue
    public static int remove(){
        if(rear == -1){
            System.out.println("Queue is empty");
            return -1;
        }
        int front = array[0];
        for(int i =0; i<rear; i++){
            array[i] = array[i+1];
        }
        rear--;
        return front;
    }

    public static int peek(){
        if(rear == -1){
            System.out.println("Queue is empty");
            return -1;
        }

        return array[0];
    }

    }
    public static void main(String args[]){
        Queue q = new Queue(4);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

    }
}
