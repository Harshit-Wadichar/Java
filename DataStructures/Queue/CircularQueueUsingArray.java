public class CircularQueueUsingArray {

    static class Queue{
        static int array[];
        static int size;
        static int rear = -1;
        static int front = -1;

        Queue(int n){
            array = new int[n];
            this.size = n;
        }

        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        public static boolean isFull(){
            return (rear + 1)%size == front;
        }

        //Enqueue method to add data to queue
        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            if(front == -1){
                front=0;
            }
            rear = (rear + 1) % size;
            array[rear] = data;
        }

        //dequeue to remove elements from the queue
        public static int remove(){
            if(rear == -1){
                System.out.println("Queue is empty");
                return -1;
            }
            int result = array[front];
            if(rear==front){
                rear = front = -1;
            }else{
                front = (front + 1) % size;
            }
            return result;
        }

        public static int peek(){
            if(rear == -1){
                System.out.println("Queue is empty");
                return -1;
            }

            return array[front];
        }

    }
    public static void main(String args[]){
        QueueUsingArray.Queue q = new QueueUsingArray.Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q.remove());
        q.add(6);
        System.out.println(q.remove());
        q.add(7);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

    }

}
