package strings;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/array-partition-i/solution/shu-zu-chai-fen-i-by-leetcode/
 */
class Solution784 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 3, 2};
        new Solution784().arrayPairSum(nums);
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}