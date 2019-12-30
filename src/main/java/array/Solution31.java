package array;

import java.util.Arrays;

class Solution31 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;

        // 调换对角元素
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][length - i - 1];
                matrix[length - j - 1][length - i - 1] = tmp;
                print(matrix);
            }
        }

        // 调换列元素
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new Solution31().rotate(nums);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(Arrays.toString(nums[i]));
//        }

    }

    private void print(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }
}