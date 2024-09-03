import java.lang.reflect.Array;

public class BurstBallons {
    public static int helper(int arr[][])
    {
        int arrows  = 1;
        int checkingNextPoint = arr[0][1];
        for(int[] ballons : arr)
        {
        if (ballons[0] > checkingNextPoint) {
            arrows++;
            ballons[0] = checkingNextPoint;
        }
        else{
            checkingNextPoint = Math.min(checkingNextPoint ,ballons[1]);
        }
        }
        return arrows;
    }
 public static void main(String[] args) {
    // Input: points = [[10,16],[2,8],[1,6],[7,12]]
    // Output: 2
    int arr[][] = {{10 , 16 } , {2 , 8} , {1 , 6} , {7 , 12}}; 
    System.out.println(helper(arr));         
 }   
}
