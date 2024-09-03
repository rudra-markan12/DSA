// public class FirstMissingLetter {
//     public static int msisingnum(int arr[])
//     {
//         int n = arr.length;
//         boolean contain_one = false;
//         for (int i = 0; i < arr.length; i++) {
//             if (arr[i] == 1) {
//                 contain_one = true;
//             }
//         }

//         if (!contain_one) {
//             return  1;
//         }

//         if (n == 1) {
//             return 2;
//         }

//         for (int i = 0; i < arr.length; ++i) {
//             if (arr[i] <=0 || arr[i] > n) {
//                 arr[i] = 1;
//             }
//         }

//         for (int i = 0; i < arr.length; ++i) {
//             int x = Math.abs(arr[i]);

//             if (arr[x-1] > 0) {
//                 arr[x-1] *= -1;
//             }
//         }

//         for (int i = 0; i < arr.length; ++i) {
//             if (arr[i] > 0) {
//                 return i+1;
//             }
//         }

//         return n+1;
//     }
// public static void main(String[] args) {
//     int arr[] = {1 ,2  , 0};
//     System.out.println(msisingnum(arr));
// }    
// }
import java.util.List;
class Solution {
    public boolean helper(String small, String big) {
      if (small.length() > big.length())
        return false;
  
      for (int i = 0; i < small.length(); i++) {
        if (small.charAt(i) != big.charAt(i)) {
          return false;
        }
      }
  
      return true;
    }
  
    public String replaceWords(List<String> dictionary, String sentence) {
  
      String[] list = sentence.split(" ");
      StringBuilder src = new StringBuilder();
      for (int i = 0; i < list.length; i++) {
        String word = list[i];
        String replace = word;
  
        for (String s : dictionary) {
          if(helper(s , word) && s.length() < word.length()){
            replace = s;
           
          }
        }
       list[i] = replace;
      
      }
  
      return String.join(" " , list);
    }
  }