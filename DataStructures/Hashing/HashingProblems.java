import java.util.HashMap;
import java.util.HashSet;

public class HashingProblems {
    public static void majorityElement(int nums[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i =0; i< n; i++){
            if(map.containsKey(nums[i])){
                //key already exists then insert key by increasing frequency of the current key by 1
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                //key does not exist in the hashmap so insert directly with frequency 1
                map.put(nums[i], 1);
            }
        }

        for(int key : map.keySet()){
            if(map.get(key) > n/3){//check if the key appears more than the defined frequency
                System.out.println(" "+key+" ");
            }
        }
    }

    public static int union(int arr1[],int arr2[]){
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i< arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int j =0; j< arr2.length; j++){
            set.add(arr2[j]);
        }

        return set.size();
    }

    public static int intersection(int arr1[] ,int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        for(int i =0; i< arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int j =0; j< arr2.length; j++){
            if(set.contains(arr2[j])){
                count++;
                set.remove(arr2[j]);
            }
        }

        return count;
    }

    public static String getStart(HashMap<String, String> tick){
        HashMap<String, String> revMap = new HashMap<>();

        for(String key: tick.keySet()){
            //key -> key , value -> tick.get(key)
            revMap.put(tick.get(key), key);
        }

        for(String key: tick.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }

        return null;
    }

    public static void main(String args[]){
        //que:1
        int nums[] = {1,2,3,5,1,3,1,5,1};

        System.out.println("The majority elements in nums array are: ");
        majorityElement(nums);

        //que2
        int arr1[] = {1,2,3,4,5};
        int arr2[] = {4,5,6,7,8};

        System.out.println("Union of two arrays have the length as: "+ union(arr1, arr2));

        //que3
        System.out.println("Intersection of two arrays have the length as: "+ intersection(arr1, arr2));


        //que4
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("chennai", "benglauru");
        tickets.put("mumbai","delhi");
        tickets.put("goa", "chennai");
        tickets.put("delhi", "goa");

        String start = getStart(tickets);

        System.out.println("for the given tickets our route is as follows");
        while(tickets.containsKey(start)){
            System.out.print(start+"--->");
            start = tickets.get(start);
        }
        System.out.println(start);


        //que:5
        int[] arr = {10, 2, -2, -20, 10}; // ans = 3
        int k = -10;
        HashMap<Integer, Integer> map = new HashMap<>(); // <Sum, Freq>

        map.put(0, 1); // empty subarray
        int sum = 0;
        int ans = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];

            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }

            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            }
            else{
                map.put(sum, 1);
            }
        }

        System.out.println(ans);
    }
}
