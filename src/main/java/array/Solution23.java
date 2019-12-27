package array;

import java.util.Arrays;

class Solution23 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <= 0) {
            return;
        }

        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int temp;
        int len = (end - start + 1) / 2;
        for (int i = 0; i < len; i++) {
            temp = nums[end - i];
            nums[end - i] = nums[start + i];
            nums[start + i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Solution23().rotate(nums, 4);
        System.out.println(Arrays.toString(nums));
    }
}