import java.util.ArrayList;
import java.util.Collections;

public class arrayList {
   public static void main( String args[]){
       ArrayList<Integer> list = new ArrayList<Integer>();

       //add function
       list.add(1);
       list.add(2);
       list.add(3);
       System.out.println(list);

       //get function
       int element = list.get(0);
       System.out.println(element);

       //to add element in between
       list.add(1, 1); // add(at which index, what element) function
       System.out.println(list);

       //set element at given index change the element at given index
       list.set(0, 3);
       System.out.println(list);

       //remove element of given index
       list.remove(3);
       System.out.println(list);

       //to know the size of ArrayList
       int size = list.size();
       System.out.println(size);

       //to iterate over the ArrayList items using loop
       System.out.println("Items of ArrayList");
       for(int i =0; i < list.size(); i++){
           System.out.println(list.get(i));
       }

       //sorting
       Collections.sort(list);
       System.out.println(list);

   }
}
