import java.util.Arrays;

public class Maxabsdiff {
    public static void main(String[] args) {
        int arr[] = {8 , 2 , 4 , 7};

        Arrays.sort(arr);

        System.out.println(arr[arr.length-1] - arr[0]);
    }
}
