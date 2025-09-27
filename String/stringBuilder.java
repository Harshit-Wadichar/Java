public class stringBuilder {
    public static void main(String[] args){

        StringBuilder sb = new StringBuilder("Tony");
        System.out.println(sb);

        //char at index 0
        System.out.println(sb.charAt(0));

        //set char at index 0
        sb.setCharAt(0, 'P');
        System.out.println(sb);

        //to insert a character at 0th index
        sb.insert(2, 'n');
        System.out.println(sb);

        //delete the extra n
        sb.delete(2,3);
        System.out.println(sb);

        //to append a letter at last of the string
        StringBuilder h = new StringBuilder("h");
        h.append('e');
        h.append('l');
        h.append('l');
        h.append('o');
        System.out.println(h);
        System.out.println(h.length());

        //to reverse a string
        StringBuilder hello = new StringBuilder("hello");

        for(int i =0; i < hello.length()/2; i++){
            int front = i;
            int back = hello.length() - 1 - i;

            char Front = hello.charAt(front);
            char Back = hello.charAt(back);

            hello.setCharAt(front, Back);
            hello.setCharAt(back, Front);
        }

        System.out.println(hello);
     }
}
