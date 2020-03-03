package array;

import java.util.Arrays;

class Solution27 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        return plus(digits, len - 1);
    }

    private int[] plus(int[] nums, int idx) {
        if (nums[idx] == 9) {
            nums[idx] = 0;
            if (idx != 0) {
                nums = plus(nums, idx - 1);
            } else {
                int add[] = new int[nums.length + 1];
                add[0] = 1;
                return add;
            }
        } else {
            nums[idx] += 1;
        }
        return nums;
    }

    public int[] plusOneBest(int[] digits) {
        int[] resultNums = new int[digits.length + 1];
        for (int i = digits.length - 1; i >= 0; i--) {
            if (++digits[i] < 10) {
                resultNums[0] = 0;
                break;
            }
            digits[i] = 0;
            resultNums[i + 1] = digits[i];
            resultNums[i] = 1;
        }
        return resultNums[0] != 0 ? resultNums : digits;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 9};
        nums = new Solution27().plusOneBest(nums);
        System.out.println(Arrays.toString(nums));
    }
}