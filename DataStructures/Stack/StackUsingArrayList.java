import java.util.ArrayList;

//stack implementation using ArrayList
public class StackUsingArrayList {

    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();

        public static Boolean isEmpty(){
            return list.size() == 0;
        }

        public static void push(int data){
            list.add(data);
        }

        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(top);
            return top;
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.size()-1;
        }
    }

    public static void main(String args[]){
        StackUsingLL.Stack s = new StackUsingLL.Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
