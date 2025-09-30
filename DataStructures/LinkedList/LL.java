import java.util.LinkedList;

public class LL {
    public static void main(String args[]){
      LinkedList<String> list = new LinkedList<String>();

      list.addFirst("can");
      list.addFirst("harshit");

      System.out.println(list);

      list.addLast("do");
      list.add("anything");

      System.out.println(list);

      System.out.println(list.size());

      for(int i = 0; i<=list.size()-1; i++){
          System.out.println(list.get(i) + "--->");
      }
      System.out.println("null");

        list.removeFirst();
        System.out.println(list);

        list.removeLast();
        System.out.println(list);

      list.remove(0);
      System.out.println(list);
    }
}
