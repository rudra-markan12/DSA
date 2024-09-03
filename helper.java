
// public class helper {
//     public static void main(String[] args) {
//         int n = 12;
//         int rev = 0;
//         while (n > 0) {
//             int rem = n % 10;
//             rev = (rem + 10) + rem;
//             n /= 10;
//         }
//         System.out.println(rev);
//     }
// }
class Solution {
  public int getLucky(String s, int k) {
      

   
      while(k>0){
       
        int sum  = 0 ;
      
        for(int i = 0 ;i < s.length(); i++){
         
          int h = s.charAt(i) -'a';

          if (h > 9) {
           sum = h/10 + h % 10;
          }
          else{
            sum+=h;
          }


        }
       
        if (k > 0) {
          sum = sum/10 + sum%10;
        }
      }
    
  }
}