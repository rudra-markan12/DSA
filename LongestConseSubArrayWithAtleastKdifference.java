import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
@SuppressWarnings("unused")
public class LongestConseSubArrayWithAtleastKdifference {
    public static int maxAbsdiff(ArrayList<Integer> list) {
        if (list.size()  == 0) {
            return 0;
        }
        else if (list.size() == 1) {
            return list.get(0);
        }
        Collections.sort(list, (a, b) -> a - b);

        return list.get(list.size() - 1) - list.get(0);

    }

    public static void helper(int arr[], int i, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {

        if (i == arr.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[i]);
        helper(arr, i + 1, list, result);
        list.remove(list.size() - 1);
        helper(arr, i + 1, list, result);
    }

    public static int get(int arr[], int k) {

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int count = 0;
        helper(arr, 0, list, result);
        for (int i = 0; i < result.size(); i++) {
            if (maxAbsdiff(list) > 0) {
                if (maxAbsdiff(list) < k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 8, 2, 4, 7 };
        int k = 4;
        // System.out.println(get(arr, k));

      

    }
}
