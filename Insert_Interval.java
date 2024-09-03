// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]

// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
import java.util.ArrayList;
import java.util.Arrays;

public class Insert_Interval {
    public static void Sorted2DMatrix(int matrix[][]) {
        int row = matrix.length;
        int col = matrix[0].length;
        int flatmatirx[] = new int[row * col];
        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                flatmatirx[k++] = matrix[i][j];
            }
        }
        Arrays.sort(flatmatirx);
        k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = flatmatirx[k++];
            }
        }
    }
    public static int[][] helper(int intervals[][], int newInterval[]) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] in : intervals) {
            if (in[1] < newInterval[0]) {
                list.add(in);
            } else if (in[0] > newInterval[1]) {
                list.add(in);
            } else {
                newInterval[0] = Math.min(newInterval[0], in[0]);
                newInterval[1] = Math.max(in[1], newInterval[1]);
            }
        }
        list.add(newInterval);
        int matrix[][] = list.toArray(new int[list.size()][]);
        Sorted2DMatrix(matrix);
        return matrix;
    }
    public static void main(String[] args) {
        int intervals[][] = { { 1, 3 }, { 6, 9 } };
        int newInterval[] = { 2, 5 };
        int matrix[][] = helper(intervals, newInterval);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}