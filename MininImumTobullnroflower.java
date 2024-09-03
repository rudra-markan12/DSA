import java.util.Arrays;
import java.util.HashSet;

public class MininImumTobullnroflower {

    public static int helper(int arr[], int m, int k) {

        if (m * k > arr.length) {
            return -1;
        }
       
        int min = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (Integer s : set) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {

                if (s >= arr[i]) {
                    count++;
                }
            }
            if (count >= k * m) {
                min = Math.min(s, min);
            }
        }

       return min;
    }

    public static void main(String[] args) {
        int arr[] = { 1,10,3,10,2 };
        int m = 3;
        int k = 1;
        System.out.println(helper(arr, m, k));
    }
}
