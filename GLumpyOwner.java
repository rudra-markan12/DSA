public class GLumpyOwner {
    public static int helper(int cus[], int glumpy[], int min) {

        int maxprofit = 0;
        int satify_cus = 0;

        for (int i = 0; i < glumpy.length; i++) {
            if (glumpy[i] == 0) {
                satify_cus += cus[i];
            }
        }

        // int addtional_cus = 0;

        int left = 0;
        int right = min;

        while (right < glumpy.length) {
            int addtional_cus = 0;
            for (int i = left; i <= right; i++) {
                if (glumpy[i] == 1) {
                    addtional_cus += cus[i];
                }
            }

            maxprofit = Math.max(maxprofit, addtional_cus);

            left++;
            right++;
        }

        return maxprofit + satify_cus;
    }

    public static int helper2(int cus[], int glumpy[], int min) {
        int cus_profit = 0;
        int add_profit = 0;
        for (int i = 0; i < glumpy.length; i++) {
            if (glumpy[i] == 0) {
                cus_profit += cus[i];
            }

        }

        for (int i = 0; i < min; i++) {
            if (glumpy[i] == 1) {
                add_profit += cus[i];
            }
        }

      
        int max =   add_profit ;
        for (int i = min; i < glumpy.length; i++) {
            if (glumpy[i] == 1) {
                add_profit += cus[i];
            }

            if (glumpy[i - min] == 1) {
                add_profit -= glumpy[i - min];
            }

            max = Math.max(add_profit, max);
        }
        return  max + cus_profit;

       
    }

    public static void main(String[] args) {
        int cus[] = { 1,0,1,2,1,1,7,5};
        int glumpy[] = { 0, 1, 0, 1, 0, 1, 0, 1 };
        int min = 3;
        System.out.println(helper2(cus, glumpy, min));
    }
}
