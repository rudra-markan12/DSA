// import java.util.HashSet;
// public class CountinousSubarray {
//     public static int helper(int nums[])
//     {
//         HashSet<Integer> set = new HashSet<>();

//         for (int i = 0; i < nums.length; i++) {
//             set.add(nums[i]);
//         }
//         int count = 1;
//        for (Integer elem : set) {
//         if (elem+1 - elem == 1) {
//             count = count*2;
//         }
//        }

//        return count;
//        }
    
//     public static void main(String[] args) {
//         int nums[] = { 0, 1 , 0 , 1};
//         System.out.println(helper(nums));
//     }
// }
import java.util.HashMap;
class Solution {
    public boolean isSubsequence(String s, String t) {
        
        HashMap<Character , Integer> map = new HashMap<>();

        for(int i = 0 ; i< s.length(); i++)
        {
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) , 0)+1);
        }

        for(int i = 0 ; i < t.length(); i++)
        {
            map.put(t.charAt(i) , map.getOrDefault(t.charAt(i) , 0)+1);
        }
         Integer a = 0;
        for(Character ch : map.keySet())
        {
            if (map.get(ch) < 2) {
             map.remove(ch);
            }
        }

        if (map.size() == s.length()) {
            return true;
        }
        else 
        return false;
    }
}