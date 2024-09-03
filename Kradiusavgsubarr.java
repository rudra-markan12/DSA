import java.util.Arrays;

public class Kradiusavgsubarr {
    public static void main(String[] args) {
        int nums[] = { 7, 4, 3, 9, 1, 8, 5, 2, 6 };
        int k = 3;
        int res[] = new int[nums.length];
        Arrays.fill(res, -1);
        int kk = k;
        int idx = 2 * k + 1;
        long wind = 0;
        for (int i = 0; i < idx; i++) {
            wind += nums[i];
        }
        res[kk] = (int) (wind / idx);

        for (int i = idx; i < nums.length; i++) {
            wind = wind - nums[i - idx] + nums[i];
            res[++k] = (int) (wind / idx);
        }

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    
    }
}
