import java.lang.reflect.Array;
import java.util.ArrayList;
public class kadansAlgorithim {
    public static ArrayList<ArrayList<Integer>> subArrayList(int nums[])
    {
         ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i< nums.length; i++)
        {

            for (int j = i; j < nums.length; j++) {

                ArrayList<Integer> list = new ArrayList<>();
                for (int j2 = i; j2 <= j; j2++) {
                    list.add(nums[j2]);
                }
                result.add(list);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5 };
        // int max = nums[0], min = nums[0], ans = nums[0];

        // for (int i = 1; i < nums.length; i++) {
        //     // if (nums[i] < 0) {
        //     //     int temp = max;
        //     //     max = min;
        //     //     min = temp;
        //     // }

        //     max = Math.max(nums[i], max * nums[i]);
        //     min = Math.min(nums[i], min * nums[i]);

        //     ans = Math.max(ans, max);
        // }
        // System.out.println(ans);

        ArrayList<ArrayList<Integer>> result = subArrayList(nums);


        for (int i = 0; i < result.size(); i++) {
        System.out.println(result.get(i) + " ");
        }

    }
}
