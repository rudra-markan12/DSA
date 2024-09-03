/**
 * FindPivotIndex
 */
public class FindPivotIndex {
    public static int Pivot(int n)
    {
        for (int i = 1; i <=n; i++) {
        int left_sum  = (i*(i+1))/2;
        int right_sum = (n*(n+1)/2) - (i*(i-1))/2;  // idhr pehle multiply hua hai phir divide hua hai for ex n = 8  --> 8*9 = 72 then 72/2 = 36

        if (left_sum == right_sum) {
            
            return i;
        }
        }
        return -1;
    }
    public static int sum(int start , int end)
    {
        int sum =  0 ;
        for (int i = start; i <=end; i++) {
            sum += i;
        }
        

        return sum;
    }
    public static int calculate(int n)
    {
     for (int i = 1; i <=n; i++) {  
        
       int lsum = sum(0, i);
       int rsum = sum(i, n);

       if (lsum == rsum) {
        return i;
       }
       
     }
     return -1;
    }
    public static void main(String[] args) {
        // System.out.println(Pivot(4));
        System.out.println(calculate(8));
    }
}