import java.util.Arrays;

public class HandOfStraight {
    public static boolean ischeck(int arr[], int groupSize, int i) {

        int x = arr[i];

        arr[i] = -1;
        i++;
        int count = 1;
        while (count < groupSize && i < arr.length) {

            if (arr[i] == x + 1) {
                x++;
                count++;
                arr[i] = -1;
            }
            i++;
        }

        if (count == groupSize) {
            return true;
        }

        return false;
    }

    public static boolean helper(int arr[], int groupSize) {
        if (arr.length % groupSize != 0) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                if (!ischeck(arr, groupSize, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
        int groupSize = 3;
        Arrays.sort(arr);
        System.out.println(helper(arr, groupSize));
    }
}
