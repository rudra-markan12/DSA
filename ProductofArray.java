public class ProductofArray {
    public static int[] helper(int arr[]) {
        int leftp[] = new int[arr.length];
        int rightp[] = new int[arr.length];

        leftp[0] = 1;
        for (int i = 1; i < leftp.length; i++) {

            leftp[i] = leftp[i - 1] * arr[i - 1];
        }

        rightp[arr.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            rightp[i] = rightp[i + 1] * arr[i + 1];
        }

        int product[] = new int[arr.length];

        for (int i = 0; i < product.length; i++) {
            product[i] = leftp[i] * rightp[i];
        }

        return product;
    }
    public static int[] pro(int arr[])
    {
        int lefarr[] = new int[arr.length];
        int rightarr[] = new int[arr.length];
        int nums[] = new int[arr.length];

        lefarr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            lefarr[i] = lefarr[i-1] * arr[i-1];
        }

        rightarr[arr.length-1] = 1;
        for (int i = arr.length-2; i >=0; i--) {
            rightarr[i] = rightarr[i+1] * arr[i+1];
        }

       for (int i = 0; i < nums.length; i++) {
        nums[i]  = lefarr[i] * rightarr[i];
       }

       return nums;
    }
    public static void main(String[] args) {
        int arr[] = { 1 , 2 , 3 , 4};
        // int result[] = helper(arr);
        // for (int i = 0; i < result.length; i++) {
        //     System.out.print(result[i] + " ");
        // }

        int list[] = pro(arr);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
      
    }
}
