import java.util.ArrayList;

public class SubArraySumDivisibleByK {
    public static int total(ArrayList<Integer> list){
        int sum = 0 ;
    for (int i = 0; i < list.size(); i++) {
        sum+= list.get(i);
    }

    return sum;
    }
    public static void helper(int arr[],  int k ,  int i, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {

        if (i == arr.length) {
           
            if (total(list) != 0 && k != 0) {
                if (   total(list) > k  && total(list) % k == 0) {
                    result.add(new ArrayList<>(list));
                }
            }
           
            return;
        }
       
       list.add(arr[i]);
       helper(arr, k-arr[i], i+1, list, result);
       list.remove(list.size()-1);
       helper(arr, k, i+1, list, result);   
    }

    public static void main(String[] args) {
        int arr[] = {4,5,0,-2,-3,1};
        int k = 5;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        helper(arr, k , 0, list, result);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

    }
}
