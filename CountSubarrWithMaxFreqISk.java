// Input: nums = [1,3,2,3,3], k = 2
// Output: 6
import java.util.ArrayList;
public class CountSubarrWithMaxFreqISk {
    public static int helper(int arr[] , int k)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        int ans = 0;
        for (Integer a : arr) {
            max = Math.max(max, a);
        }

        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i]) {
                list.add(i);
            }

            int size = list.size();

           if (list.size() >=k) {
            ans+= list.get(list.size()-k)+1;
           }
        }
         return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1 , 3 , 2 , 3 , 3};
        int k = 2;
    }
}
