
public class PallindromeSubString {
    public static boolean isPallindrome(String s)
    {
     int i = 0;
     int j = s.length()-1;
     while (i < j) {
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
        i++;
        j--;
     }  
     return true;
    }
    public static int subarr(String s)
    {
     
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
        for (int j = i; j < s.length(); j++) {
            if (isPallindrome(s.substring(i , j+1))) {
                count++;
            }
        }
    }
    return count;
    }
public static void main(String[] args) {
    String s = "aaa";
    System.out.println(subarr(s));
}
    
}
































// import java.util.HashMap;
// /**
//  * PallindromeSubString
//  */
// public class PallindromeSubString {
//     public static int helper(int arr[])
//     {
//     HashMap<Integer , Integer> map = new HashMap<>();
//     int zero = 0;
//     int ones = 0;
//     map.put(0, -1);
//      int max = 0;
//     for(int i = 0;i<arr.length; i++)
//     {
//         if (arr[i] == 1) {
//              ones++;
//         }
//         else 
//         zero++;      
//         int diff = ones - zero;
//         if (map.containsKey(diff)) {   
//             max = Math.max(max, i - diff);
//         }
//         else 
//         {
//             map.put(diff, i);
//         }
//     }
//     return max;
//     }
//     public static void main(String[] args) {
//      int arr[] ={0,1,0,1};   
//      System.out.println(helper(arr));    
//     }
// }