package strings;

import java.util.Arrays;

class Solution772 {
    public static void main(String[] args) {
        int[] nums = {2, 9, 9};
        int[] ints = new Solution772().plusOneBest(nums);
        System.out.println(Arrays.toString(ints));
    }

    public int[] plusOne(int[] digits) {
        return plusOne(digits, digits.length - 1);
    }

    public int[] plusOne(int[] digits, int index) {
        if (index == -1) {
            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            return ints;
        }
        if (digits[index] == 9) {
            digits[index] = 0;
            return plusOne(digits, index - 1);
        } else {
            digits[index] += 1;
            return digits;
        }
    }

    public int[] plusOneBest(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOneExt(int[] digits) {
        int sum = (digits[digits.length - 1] + 1);
        int carry = sum / 10;
        sum = sum % 10;


        digits[digits.length - 1] = sum;
        for (int i = digits.length - 2; i >= 0; i--) {
            sum = (digits[i] + carry);
            carry = sum / 10;
            sum = sum % 10;
            digits[i] = sum;

        }

        if (carry == 1) {

            int[] res = new int[digits.length + 1];
            res[0] = carry;
            for (int m = 1; m < res.length; m++) {
                res[m] = digits[m - 1];

            }
            return res;

        }
        return digits;
    }
}