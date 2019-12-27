package array;

import java.util.Arrays;

class Solution24 {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) return false;
        Arrays.sort(nums);
        int pos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        boolean b = new Solution24().containsDuplicate(nums);
        System.out.println(b);
    }
}