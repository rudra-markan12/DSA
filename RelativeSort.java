import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class RelativeSort {
   
    public static int[] helper(int arr1[] , int arr2[]){

       HashMap<Integer , Integer> map = new HashMap<>();

       for (int num : arr1) {
        map.put(num, map.getOrDefault(num, 0)+1);
       }

       int index = 0 ; 
      
       for (int num : arr1) {
        
       }
    }
    public static void main(String[] args) {
        int arr1[] = {2,3,1,3,2,4,6,7,9,2,19};
        int arr2[] = {2,1,4,3,9,6};
    }
}
