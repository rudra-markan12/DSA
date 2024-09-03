import java.util.Arrays;

public class SpcialNo {
    public static int helper(int l, int r) {
     int lim = (int) Math.sqrt(r);
     boolean arr[] = new boolean[lim+1];
     Arrays.fill(arr, true);
       arr[0] = true;
       arr[1] = true;
     for (int i = 2; i*i<=lim; i++) {-
        if (arr[i]) {
            for (int j = i*i; j <=lim; j+=i) {
                arr[i] = false;
            }
        }
     }

     int count = 0;
     for (int i = 2; i <=lim; i++) {
        if (arr[i]) {
            int sq = i*i;

            if (sq >= l && sq<=r) {
                count++;
            }
        }
     }

     int tc = r-l+1;

     return tc - count;
    }

    public static void main(String[] args) {
        int l = 4;
        int r = 16;
        // special no -> square of prime no were called special no
    }
}